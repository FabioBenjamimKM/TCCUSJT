package com.usjt.tcc.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TB_INVESTIMENTO")
public class Investimento implements Serializable{
	
	private static final long serialVersionUID = 1;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(nullable = false)
	private long id;
	
	@Column(nullable = false)
	private float valorInicial;
	
	@Column(nullable = false)
	private float valorMensal;
	
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

	public float getValorInicial() {
		return valorInicial;
	}

	public void setValorInicial(float valorInicial) {
		this.valorInicial = valorInicial;
	}

	public float getValorMensal() {
		return valorMensal;
	}

	public void setValorMensal(float valorMensal) {
		this.valorMensal = valorMensal;
	}
}
