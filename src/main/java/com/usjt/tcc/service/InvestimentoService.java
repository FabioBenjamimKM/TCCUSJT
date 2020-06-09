package com.usjt.tcc.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usjt.tcc.dto.InvestimentoDTO;
import com.usjt.tcc.model.entity.Acao;
import com.usjt.tcc.model.entity.Investimento;
import com.usjt.tcc.model.entity.RendaFixa;
import com.usjt.tcc.repository.AcaoRepository;
import com.usjt.tcc.repository.InvestimentoRepository;
import com.usjt.tcc.repository.RendaFixaRepository;

@Service
public class InvestimentoService {

	@Autowired
	private InvestimentoRepository _investimentoRepository;
	
	@Autowired
	private RendaFixaRepository _rendaFixaRepository;
	
	@Autowired
	private AcaoRepository _acaoRepository;
	
	public List<InvestimentoDTO> consultar(){
		
		List<Investimento> investimentos = _investimentoRepository.findAll(); 
		List<InvestimentoDTO> investimentoDTOs = new ArrayList<InvestimentoDTO>();
		
		for(Investimento investimento : investimentos){
			
			Calendar dataAtual = new GregorianCalendar();
			dataAtual.set(GregorianCalendar.HOUR_OF_DAY, 0);
			dataAtual.set(GregorianCalendar.MINUTE, 0);
			dataAtual.set(GregorianCalendar.SECOND, 0);
			dataAtual.set(GregorianCalendar.MILLISECOND, 0);
			
			long idTipoInvestimento = investimento.getTipoInvestimento().getId();
			float valorMinimo = 0;
			
			switch((int)idTipoInvestimento) {
			  case 1:
				  
				  Optional<RendaFixa> rendaFixaOptional = _rendaFixaRepository.findFirstByInvestimentoId(investimento.getId());
				  
				  if(rendaFixaOptional.orElse(null) != null) {
					  RendaFixa rendaFixa = rendaFixaOptional.get();
					  valorMinimo = rendaFixa.getValorMinimo();
				  }
				  
				  break;
			  case 2:
				  
				  Optional<Acao> acaoOptional = _acaoRepository.findFirstByInvestimentoIdAndData(investimento.getId(), dataAtual);
				  
				  if(acaoOptional.orElse(null) != null) {
					  Acao acao = acaoOptional.get();
					  valorMinimo = acao.getFechamento();
				  }
				  
				  break;
			}
			
			investimentoDTOs.add(investimento.converter(valorMinimo));
		}
		
		return investimentoDTOs;
	}
}
