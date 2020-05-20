package com.usjt.tcc.model;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.usjt.tcc.model.entity.RendaFixa;
import com.usjt.tcc.model.entity.RendimentoVariavel;
import com.usjt.tcc.model.entity.Transacao;
import com.usjt.tcc.repository.RendaFixaRepository;
import com.usjt.tcc.repository.RendimentoVariavelRepository;

public class RendaFixaCalculadora implements ICalculadora {

	@Autowired
	private RendaFixaRepository _repositoryRendaFixa;
	
	@Autowired
	private RendimentoVariavelRepository _repositoryRendimentoVariavel;
	
	@Override
	public Previsao prever(Transacao transacao, Date data) {
		Previsao previsao = new Previsao();
		previsao.setData(data);
		
		RendaFixa rendaFixa = _repositoryRendaFixa.buscarRendaFixaPorIdInvestimento(transacao.getInvestimento().getId());
		RendimentoVariavel rendimentoVariavel = null;
		
		if(rendaFixa.getRendimentoVariavel() != null)
		{
			Optional<RendimentoVariavel> optional = _repositoryRendimentoVariavel.findById(rendaFixa.getId());
			
			rendimentoVariavel =  optional != null ? optional.get() : null;
		}
		
		if(rendimentoVariavel != null)
		{
			float rendeDiarioFixa = rendaFixa.getRendimentoFixo() / 365;
			float rendeDiarioVariavel = rendimentoVariavel.getValor() / 365;
			float qtdDias = (data.getTime() - Calendar.getInstance().getTime().getTime()) / 86400000;
			
			float rendimento = 1 + (qtdDias * (rendeDiarioFixa + rendeDiarioVariavel));
			
			float valor = transacao.getValor() * rendimento;
			
			previsao.setValor(valor);
		}
		else
		{
			float rendeDiarioFixa = rendaFixa.getRendimentoFixo() / 365;
			
			float qtdDias = (data.getTime() - Calendar.getInstance().getTime().getTime()) / 86400000;
			
			float rendimento = 1 + (qtdDias * rendeDiarioFixa);
			
			float valor = transacao.getValor() * rendimento;
			
			previsao.setValor(valor);
		}
		
		return previsao;
	}

}
