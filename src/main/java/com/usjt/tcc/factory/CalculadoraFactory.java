package com.usjt.tcc.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.usjt.tcc.model.ICalculadora;
import com.usjt.tcc.model.RendaFixaCalculadora;

@Component
public class CalculadoraFactory {
	
	@Autowired
	private RendaFixaCalculadora _rendaFixa;
	
	public ICalculadora fabricar(long idTipoInvestimento) {
		
		switch((int)idTipoInvestimento) {
		  case 1:
		    return _rendaFixa;
		}
		
		return null;
	}
}
