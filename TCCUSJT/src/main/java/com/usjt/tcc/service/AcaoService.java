package com.usjt.tcc.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usjt.tcc.model.ComparadorTop;
import com.usjt.tcc.model.Lucro;
import com.usjt.tcc.model.Previsao;
import com.usjt.tcc.model.Top;
import com.usjt.tcc.model.Variacao;
import com.usjt.tcc.model.entity.Acao;
import com.usjt.tcc.model.entity.Investimento;
import com.usjt.tcc.model.entity.Sugestao;
import com.usjt.tcc.model.entity.TipoInvestimento;
import com.usjt.tcc.model.entity.Transacao;
import com.usjt.tcc.repository.AcaoRepository;

@Service
public class AcaoService {

	@Autowired
	private AcaoRepository _repository;
	
	private TransacaoService transacaoService = new TransacaoService();

	public List<Acao> consultar(Date data){
		return _repository.findByData(data);
	}
	
	public List<Acao> sugestao(long idInvestimento){
		return _repository.findByTopSugestao(idInvestimento);
	}

	public List<Acao> sugestaoManteve(Integer number){
		List<Acao> acoes = _repository.findAll();
		List<Acao> abertura = _repository.obterAbertura(); 
		TreeMap<Long, List<Acao>> map = new TreeMap<Long, List<Acao>>();
		List<Variacao> variacaoList = new ArrayList<Variacao>();

		for (Acao acao : acoes) {
			Long id = acao.getInvestimento().getId();

			if(map.containsKey(id)){
				map.get(id).add(acao);
			}
			else{
				map.put(id, new ArrayList<Acao>());
				map.get(id).add(acao);
			}	
		}

		for (Acao acao : abertura) {
			Long idInvestimento = acao.getInvestimento().getId();
			
			Double media = 0.0;
			List<Acao> acoesAgrupado = map.get(idInvestimento);
			
			for (Acao acaoAgrupado : acoesAgrupado) {
				media += acaoAgrupado.getFechamento();
			}

			media = media / acoesAgrupado.size();
			Double variacao = acao.getAbertura() - media;

			if(variacao < 0)
				variacao = variacao * -1;

			variacaoList.add(new Variacao(idInvestimento, variacao));
		}

		Collections.sort(variacaoList);
		int idInvestimento = variacaoList.get(number-1).idInvestimento.intValue();

		return _repository.findByTopSugestao(idInvestimento);
	}

	public List<Acao> consultarRentavel(long idUsuario) throws Exception {
		List<Top> top = transacaoService.consultarRentavel(idUsuario);
		List<Acao> listRentavel = new ArrayList<Acao>();
		for (Top top2 : top) {
			if(top2.getInvestimento().getTipoInvestimento().getId() == 2){
				listRentavel = _repository.findByIdData(top2.getInvestimento().getId());	
				break;
			}
		}
		
		return listRentavel;
	}
}
