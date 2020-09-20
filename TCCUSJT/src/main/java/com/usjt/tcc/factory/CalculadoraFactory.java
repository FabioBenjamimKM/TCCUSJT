package com.usjt.tcc.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.usjt.tcc.model.ICalculadora;
import com.usjt.tcc.model.RendaFixaCalculadora;
import com.usjt.tcc.model.RendaVariavelCalculadora;

@Component
public class CalculadoraFactory {
	
	@Autowired
	private RendaFixaCalculadora _rendaFixa;
	
	@Autowired
	private RendaVariavelCalculadora _rendaVariavel;
	
	public ICalculadora fabricar(long idTipoInvestimento) {
		
		switch((int)idTipoInvestimento) {
		  case 1:
		    return _rendaFixa;
		  case 2:
			return _rendaVariavel;
		}
		
		return null;
	}
}
