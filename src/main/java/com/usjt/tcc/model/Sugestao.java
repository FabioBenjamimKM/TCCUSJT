package com.usjt.tcc.model;

import java.io.Serializable;

import com.usjt.tcc.model.entity.Investimento;

public class Sugestao implements Serializable{
	
	private static final long serialVersionUID = 1;
	
	private Investimento investimento;
	private float porcentagem;
	
	public Investimento getInvestimento() {
		return investimento;
	}
	public void setInvestimento(Investimento investimento) {
		this.investimento = investimento;
	}
	public float getPorcentagem() {
		return porcentagem;
	}
	public void setPorcentagem(float porcentagem) {
		this.porcentagem = porcentagem;
	}
}
