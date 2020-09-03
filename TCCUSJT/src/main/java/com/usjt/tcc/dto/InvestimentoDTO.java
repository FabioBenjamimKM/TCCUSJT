package com.usjt.tcc.dto;

import com.usjt.tcc.model.entity.TipoInvestimento;

public class InvestimentoDTO {
	
	private static final long serialVersionUID = 1;
	private long id;
	private String nome;
	private TipoInvestimento tipoInvestimento;
	private float valorMinimo;
	
	public InvestimentoDTO (long id, String nome, TipoInvestimento tipoInvestimento, float valorMinimo) {
		this.id = id;
		this.nome = nome;
		this.tipoInvestimento = tipoInvestimento;
		this.valorMinimo = valorMinimo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoInvestimento getTipoInvestimento() {
		return tipoInvestimento;
	}

	public void setTipoInvestimento(TipoInvestimento tipoInvestimento) {
		this.tipoInvestimento = tipoInvestimento;
	}

	public float getValorMinimo() {
		return valorMinimo;
	}

	public void setValorMinimo(float valorMinimo) {
		this.valorMinimo = valorMinimo;
	}
}
