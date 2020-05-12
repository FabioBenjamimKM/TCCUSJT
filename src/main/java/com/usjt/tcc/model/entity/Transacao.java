package com.usjt.tcc.model.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TB_TRANSACAO")
public class Transacao implements Serializable{
	
	private static final long serialVersionUID = 1;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(nullable = false)
	private long id;
	
	@Column(nullable = false)
	private float valor;
	
	@Column(nullable = false)
	private Date data;
	
	@Column(nullable = false)
	private Boolean resgatado;
	
	@Column(nullable = false)
	private Long idInvestimento;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Boolean getResgatado() {
		return resgatado;
	}

	public void setResgatado(Boolean resgatado) {
		this.resgatado = resgatado;
	}

	public Long getIdInvestimento() {
		return idInvestimento;
	}

	public void setIdInvestimento(Long idInvestimento) {
		this.idInvestimento = idInvestimento;
	}
}
