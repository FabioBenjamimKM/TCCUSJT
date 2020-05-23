package com.usjt.tcc.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.usjt.tcc.factory.CalculadoraFactory;
import com.usjt.tcc.model.ComparadorTop;
import com.usjt.tcc.model.ICalculadora;
import com.usjt.tcc.model.Lucro;
import com.usjt.tcc.model.Previsao;
import com.usjt.tcc.model.Top;
import com.usjt.tcc.model.entity.Investimento;
import com.usjt.tcc.model.entity.Transacao;
import com.usjt.tcc.repository.TransacaoRepository;

@Service
public class TransacaoService {

	@Autowired
	private TransacaoRepository _repository;
	
	@Autowired
	private CalculadoraFactory _calculadoraFactory;
	
	public List<Transacao> consultar() {
		return _repository.findAll();
	}
	
	public List<Transacao> consultarPorUsuarioId(long usuarioId) {
		return _repository.findAllByUsuarioId(usuarioId);
	}
	
	public Transacao consultar(long transacaoId) {
		Optional<Transacao> transacao = _repository.findById(transacaoId);
		
		return transacao != null ? transacao.get() : null;
	}
	
	public Transacao salvar(Transacao transacao) {
		return _repository.save(transacao);
	}
	
	public void excluir(Transacao transacao) {
		_repository.delete(transacao);
	}
	
	public Previsao prever(long id, Date data) {
		Transacao transacao = consultar(id);
		Investimento investimento = transacao.getInvestimento();
		ICalculadora calculadora = _calculadoraFactory.fabricar(investimento.getTipoInvestimento().getId());
		
		return calculadora.prever(transacao, data);
	}
	
	public List<Lucro> calcularLucro(long idUsuario) {
		List<Transacao> transacoes = _repository.findAllByUsuarioId(idUsuario);
		List<Lucro> lucroList = new ArrayList<Lucro>();
		Date hoje = Calendar.getInstance().getTime();
		
		for (Transacao transacao : transacoes) {
			Previsao previsao = prever(transacao.getId(), hoje);
			float valorLucro = previsao.getValor() - transacao.getValor();
			
			Lucro lucro = new Lucro();
			lucro.setInvestimento(transacao.getInvestimento());
			lucro.setValor(valorLucro);
			
			lucroList.add(lucro);
		}
		
		return lucroList;
	}
	
	public List<Top> calcularTop(long idUsuario, int quantidade){
		List<Transacao> transacoes = _repository.findAllByUsuarioId(idUsuario);
		List<Top> topAuxList = new ArrayList<Top>();
		List<Top> topList = new ArrayList<Top>();
		Date hoje = Calendar.getInstance().getTime();
		
		for (Transacao transacao : transacoes) {
			Previsao previsao = prever(transacao.getId(), hoje);
			
			Top top = new Top();
			top.setInvestimento(transacao.getInvestimento());
			top.setValor(previsao.getValor());
			
			topAuxList.add(top);
		}
		
		Collections.sort(topAuxList, new ComparadorTop());
		
		for (int i = 0; i < quantidade && i < topAuxList.size(); i++) {
			topList.add(topAuxList.get(i));
		}
		
		return topList;
	}
}
