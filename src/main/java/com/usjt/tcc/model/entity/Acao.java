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
@Table(name="TB_ACAO")
public class Acao implements Serializable{
	
	private static final long serialVersionUID = 1;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
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
	private float fechamentoAjustado;
	
	@Column(nullable = false)
	private float volume;
	
	@Column(nullable = false)
	private float dividendo;
	
	@Column(nullable = false)
	private float coeficienteDivisao;
	
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

	public float getFechamentoAjustado() {
		return fechamentoAjustado;
	}

	public void setFechamentoAjustado(float fechamentoAjustado) {
		this.fechamentoAjustado = fechamentoAjustado;
	}

	public float getVolume() {
		return volume;
	}

	public void setVolume(float volume) {
		this.volume = volume;
	}

	public float getDividendo() {
		return dividendo;
	}

	public void setDividendo(float dividendo) {
		this.dividendo = dividendo;
	}

	public float getCoeficienteDivisao() {
		return coeficienteDivisao;
	}

	public void setCoeficienteDivisao(float coeficienteDivisao) {
		this.coeficienteDivisao = coeficienteDivisao;
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
