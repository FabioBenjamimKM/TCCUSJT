package com.usjt.tcc.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Investimento {
	
	@Id
	@Column(nullable = false)
	private Long id;
	
	@Column(nullable = false)
	private float valor;
	
	@Column(nullable = false)
	private Date dataInclusao;
	
	@Column(nullable = false)
	private Long idTipoInvestimento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public Date getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public Long getIdTipoInvestimento() {
		return idTipoInvestimento;
	}

	public void setIdTipoInvestimento(Long idTipoInvestimento) {
		this.idTipoInvestimento = idTipoInvestimento;
	}
}
