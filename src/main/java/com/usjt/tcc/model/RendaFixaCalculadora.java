package com.usjt.tcc.model;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.usjt.tcc.model.entity.RendaFixa;
import com.usjt.tcc.model.entity.RendimentoVariavel;
import com.usjt.tcc.model.entity.Transacao;
import com.usjt.tcc.repository.RendaFixaRepository;
import com.usjt.tcc.repository.RendimentoVariavelRepository;

@Component
public class RendaFixaCalculadora implements ICalculadora {

	@Autowired
	private RendaFixaRepository _repositoryRendaFixa;
	
	@Autowired
	private RendimentoVariavelRepository _repositoryRendimentoVariavel;
	
	@Override
	public Previsao prever(Transacao transacao, Date data) {
		Previsao previsao = new Previsao();
		previsao.setData(data);
		
		long idInvestimento = transacao.getInvestimento().getId();
		Optional<RendaFixa> rendaFixaOptional = _repositoryRendaFixa.findFirstByInvestimentoId(idInvestimento);
		RendimentoVariavel rendimentoVariavel = null;
		
		if(rendaFixaOptional != null) {
			RendaFixa rendaFixa = rendaFixaOptional.get();
			
			if(rendaFixa.getRendimentoVariavel() != null){
				rendimentoVariavel =  rendaFixa.getRendimentoVariavel();
			}
			
			if(rendimentoVariavel != null){
				float rendeDiarioFixa = rendaFixa.getRendimentoFixo() / 365;
				float rendeDiarioVariavel = rendimentoVariavel.getValor() / 365;
				float qtdDias = ( data.getTime() - transacao.getData().getTime()) / 86400000;
				
				float rendimento = 1 + (qtdDias * (rendeDiarioFixa + rendeDiarioVariavel));
				
				float valor = transacao.getValor() * rendimento;
				
				previsao.setValor(valor);
			}
			else{
				float rendeDiarioFixa = rendaFixa.getRendimentoFixo() / 365;
				
				float qtdDias = (data.getTime() - transacao.getData().getTime()) / 86400000;
				
				float rendimento = 1 + (qtdDias * rendeDiarioFixa);
				
				float valor = transacao.getValor() * rendimento;
				
				previsao.setValor(valor);
			}
		}
		
		return previsao;
	}

}
