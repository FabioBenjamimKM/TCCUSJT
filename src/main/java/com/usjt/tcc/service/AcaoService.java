package com.usjt.tcc.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usjt.tcc.model.ComparadorTop;
import com.usjt.tcc.model.Lucro;
import com.usjt.tcc.model.Previsao;
import com.usjt.tcc.model.Sugestao;
import com.usjt.tcc.model.Top;
import com.usjt.tcc.model.entity.Acao;
import com.usjt.tcc.model.entity.Investimento;
import com.usjt.tcc.model.entity.TipoInvestimento;
import com.usjt.tcc.model.entity.Transacao;
import com.usjt.tcc.repository.AcaoRepository;

@Service
public class AcaoService {

	@Autowired
	private AcaoRepository _repository;
	
	private TransacaoService transacaoService = new TransacaoService();
	
	public List<Sugestao> consultarPorCrescimento(int quantidade) {
		TipoInvestimento tipoInvestimento = new TipoInvestimento();
		tipoInvestimento.setId((long) 1);
		tipoInvestimento.setNome("Tipo Investimento");
		
		Investimento investimento = new Investimento();
		investimento.setId((long) 1);
		investimento.setNome("Investimento");
		investimento.setTipoInvestimento(tipoInvestimento);
		
		Sugestao sugestao = new Sugestao();
		sugestao.setInvestimento(investimento);
		sugestao.setPorcentagem((float) 0.0);
		
		List<Sugestao> sugestaoList = new ArrayList<Sugestao>();
		sugestaoList.add(sugestao);
		sugestaoList.add(sugestao);
		sugestaoList.add(sugestao);
		
		return sugestaoList;
	}
	
	public List<Sugestao> consultarPorRegularidade(int quantidade) {
		TipoInvestimento tipoInvestimento = new TipoInvestimento();
		tipoInvestimento.setId((long) 1);
		tipoInvestimento.setNome("Tipo Investimento");
		
		Investimento investimento = new Investimento();
		investimento.setId((long) 1);
		investimento.setNome("Investimento");
		investimento.setTipoInvestimento(tipoInvestimento);
		
		Sugestao sugestao = new Sugestao();
		sugestao.setInvestimento(investimento);
		sugestao.setPorcentagem((float) 0.0);
		
		List<Sugestao> sugestaoList = new ArrayList<Sugestao>();
		sugestaoList.add(sugestao);
		sugestaoList.add(sugestao);
		sugestaoList.add(sugestao);
		
		return sugestaoList;
	}
	
	public List<Acao> consultar(Date data){
		return _repository.findByData(data);
	}
	
	public List<Acao> sugestao(Integer number){
		return _repository.findByTopSugestao(number);
	}

	public List<Acao> consultarRentavel(long idUsuario) throws Exception {
		List<Top> top = transacaoService.consultarRentavel(idUsuario);
		
		List<Acao> listRentavel = _repository.findByIdData(top.get(0).getInvestimento().getId());
		
		return listRentavel;
	}
}
