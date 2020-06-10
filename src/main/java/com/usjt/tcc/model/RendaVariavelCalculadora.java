package com.usjt.tcc.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.usjt.tcc.model.entity.Acao;
import com.usjt.tcc.model.entity.Predicao;
import com.usjt.tcc.model.entity.Transacao;
import com.usjt.tcc.repository.AcaoRepository;
import com.usjt.tcc.repository.PredicaoRepository;

@Component
public class RendaVariavelCalculadora implements ICalculadora {

	@Autowired
	private PredicaoRepository _repositoryPredicao;
	
	@Autowired
	private AcaoRepository _repositoryAcao;
	
	@Override
	public Previsao prever(Transacao transacao, Date data) throws Exception {
		Previsao previsao = new Previsao();
		previsao.setData(data);
		
		Calendar dataTransacao = Calendar.getInstance();
		dataTransacao.setTime(transacao.getData());
		
		long idInvestimento = transacao.getInvestimento().getId();
		
		Optional<Predicao> predicaoOptional = _repositoryPredicao.findFirstByInvestimentoIdAndData(idInvestimento, data);
		Optional<Acao> acaoOptional = _repositoryAcao.findFirstByInvestimentoIdAndData(idInvestimento, dataTransacao);
		
		if(predicaoOptional.orElse(null) != null && acaoOptional.orElse(null) != null)
		{
			Predicao predicao = predicaoOptional.get();
			Acao acao = acaoOptional.get();
			
			float qtdAcao = transacao.getValor() / acao.getFechamento();
			
			previsao.setValor(predicao.getValor() * qtdAcao);
		}
		
		return previsao;
	}

}
