package com.usjt.tcc.model.entity;

import java.io.Serializable;

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
	private long id;
	
	@Column(nullable = false)
	private float rendimentoFixo;
	
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
