package com.usjt.tcc.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TB_DOLAR_REAL")
public class DolarReal implements Serializable{
	
	private static final long serialVersionUID = 1;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable = false)
	private long id;
	
	@Column(nullable = false)
	private float abertura;
	
	@Column(nullable = false)
	private float alta;
	
	@Column(nullable = false)
	private float baixa;
	
	@Column(nullable = false)
	private float fechamento;
	
	@Column(nullable = false)
	private Date data;
	
	@ManyToOne
	@JoinColumn(name="id_investimento", nullable = false)
	private Investimento investimento;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public float getAbertura() {
		return abertura;
	}

	public void setAbertura(float abertura) {
		this.abertura = abertura;
	}

	public float getAlta() {
		return alta;
	}

	public void setAlta(float alta) {
		this.alta = alta;
	}

	public float getBaixa() {
		return baixa;
	}

	public void setBaixa(float baixa) {
		this.baixa = baixa;
	}

	public float getFechamento() {
		return fechamento;
	}

	public void setFechamento(float fechamento) {
		this.fechamento = fechamento;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Investimento getInvestimento() {
		return investimento;
	}

	public void setInvestimento(Investimento investimento) {
		this.investimento = investimento;
	}
}
