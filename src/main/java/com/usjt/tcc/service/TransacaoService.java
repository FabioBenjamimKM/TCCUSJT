package com.usjt.tcc.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usjt.tcc.factory.CalculadoraFactory;
import com.usjt.tcc.model.ICalculadora;
import com.usjt.tcc.model.Previsao;
import com.usjt.tcc.model.entity.Investimento;
import com.usjt.tcc.model.entity.Transacao;
import com.usjt.tcc.repository.TransacaoRepository;

@Service
public class TransacaoService {

	@Autowired
	private TransacaoRepository _repository;
	
	public List<Transacao> consultar() {
		return _repository.findAll();
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
		ICalculadora calculadora = CalculadoraFactory.fabricar(transacao.getInvestimento().getId());
		
		return calculadora.prever(transacao, data);
	}
}
