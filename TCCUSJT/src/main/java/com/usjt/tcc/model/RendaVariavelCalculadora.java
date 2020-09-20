package com.usjt.tcc.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
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
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		Previsao previsao = new Previsao();
		previsao.setData(data);
		
		Calendar dataCalendar = Calendar.getInstance();
		dataCalendar.setTime(transacao.getData());
		String dataCalendarString = format.format(data);
		
		Calendar dataTransacao = Calendar.getInstance();
		dataTransacao.setTime(transacao.getData());
		String dataTransacaoString = format.format(dataTransacao.getTime());
		
		long idInvestimento = transacao.getInvestimento().getId();
		
		List<Predicao> predicaoOptional = _repositoryPredicao.findByIdData(idInvestimento, dataCalendarString);
		List<Acao> acaoOptional = _repositoryAcao.findByIdData(idInvestimento, dataTransacaoString);
		
		if(predicaoOptional.size() > 0 && acaoOptional.size() > 0)
		{
			Predicao predicao = predicaoOptional.get(0);
			Acao acao = acaoOptional.get(0);
			
			float qtdAcao = transacao.getValor() / acao.getFechamento();
			
			previsao.setValor(predicao.getValor() * qtdAcao);
		}
		
		return previsao;
	}

}
