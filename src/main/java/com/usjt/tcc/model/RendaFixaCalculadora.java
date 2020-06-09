package com.usjt.tcc.model;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.usjt.tcc.model.entity.RendaFixa;
import com.usjt.tcc.model.entity.RendimentoVariavel;
import com.usjt.tcc.model.entity.Transacao;
import com.usjt.tcc.repository.RendaFixaRepository;

@Component
public class RendaFixaCalculadora implements ICalculadora {

	@Autowired
	private RendaFixaRepository _repositoryRendaFixa;
	
	@Override
	public Previsao prever(Transacao transacao, Date data) throws Exception {
		Previsao previsao = new Previsao();
		previsao.setData(data);
		
		long idInvestimento = transacao.getInvestimento().getId();
		Optional<RendaFixa> rendaFixaOptional = _repositoryRendaFixa.findFirstByInvestimentoId(idInvestimento);
		RendimentoVariavel rendimentoVariavel = null;
		
		if(rendaFixaOptional != null) {
			RendaFixa rendaFixa = rendaFixaOptional.get();
			
			if(data.getTime() <= rendaFixaOptional.get().getDataVencimento().getTime())
			{
				if(rendaFixa.getRendimentoVariavel() != null){
					rendimentoVariavel =  rendaFixa.getRendimentoVariavel();
				}
				
				float rendeDiarioFixa = rendimentoAnualParaDiario(rendaFixa.getRendimentoFixo());
				
				float rendeDiarioVariavel = 0;
				if(rendimentoVariavel != null)
					rendeDiarioVariavel = rendimentoAnualParaDiario(rendimentoVariavel.getValor());
				
				float qtdDias = diferencaEmDia(data, transacao.getData());
				
				float rendimento = 1 + (qtdDias * ((rendeDiarioFixa + rendeDiarioVariavel)/100));
				
				float valor = transacao.getValor() * rendimento;
				
				previsao.setValor(valor);
			}
			else {
				throw new Exception("Data solicitada é maior que a data de vencimento!");	
			}
		}
		else {
			throw new Exception("Não foi encontrado os dados atuais do investimento!");
		}
		
		return previsao;
	}
	
	private float rendimentoAnualParaDiario(float rendimentoAnual) {
		return rendimentoAnual / 365;
	}
	
	private float diferencaEmDia(Date a, Date b) {
		return (a.getTime() - b.getTime()) / 86400000;
	}
}
