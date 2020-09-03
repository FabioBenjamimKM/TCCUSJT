package com.usjt.tcc.model;

import java.io.Serializable;

import com.usjt.tcc.model.entity.Investimento;

public class Lucro implements Serializable{
	
	private static final long serialVersionUID = 1;
	
	private Investimento investimento;
	private float valor;
	
	public Investimento getInvestimento() {
		return investimento;
	}
	public void setInvestimento(Investimento investimento) {
		this.investimento = investimento;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
}
