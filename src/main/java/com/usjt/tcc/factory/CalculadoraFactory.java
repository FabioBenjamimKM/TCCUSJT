package com.usjt.tcc.factory;

import com.usjt.tcc.model.ICalculadora;
import com.usjt.tcc.model.RendaFixaCalculadora;

public class CalculadoraFactory {
	
	public static ICalculadora fabricar(long idTipoInvestimento) {
		
		switch((int)idTipoInvestimento) {
		  case 1:
		    return new RendaFixaCalculadora();
		}
		
		return null;
	}
}
