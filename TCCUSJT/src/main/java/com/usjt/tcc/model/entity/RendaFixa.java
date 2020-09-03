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
@Table(name="TB_RENDA_FIXA")
public class RendaFixa implements Serializable{
	
	private static final long serialVersionUID = 1;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long id;
	
	@Column(nullable = false)
	private float rendimentoFixo;
	
	@Column(nullable = false)
	private Date dataVencimento;
	
	@Column(nullable = false)
	private Date data;
	
	@Column(nullable = true)
	private float valorMinimo;
	
	@ManyToOne
	@JoinColumn(name="id_rendimento_variavel")
	private RendimentoVariavel rendimentoVariavel;
	
	@ManyToOne
	@JoinColumn(name="id_investimento", nullable = false)
	private Investimento investimento;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public float getRendimentoFixo() {
		return rendimentoFixo;
	}

	public void setRendimentoFixo(float rendimentoFixo) {
		this.rendimentoFixo = rendimentoFixo;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public float getValorMinimo() {
		return valorMinimo;
	}

	public void setValorMinimo(float valorMinimo) {
		this.valorMinimo = valorMinimo;
	}
	
	public RendimentoVariavel getRendimentoVariavel() {
		return rendimentoVariavel;
	}

	public void setRendimentoVariavel(RendimentoVariavel rendimentoVariavel) {
		this.rendimentoVariavel = rendimentoVariavel;
	}

	public Investimento getInvestimento() {
		return investimento;
	}

	public void setInvestimento(Investimento investimento) {
		this.investimento = investimento;
	}
	
}
