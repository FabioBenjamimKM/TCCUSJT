package com.usjt.tcc.model.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.usjt.tcc.dto.InvestimentoDTO;

@Entity
@Table(name="TB_INVESTIMENTO")
public class Investimento implements Serializable{
	
	private static final long serialVersionUID = 1;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable = false)
	private long id;
	
	@Column(nullable = false)
	private String nome;
	
	@ManyToOne
	@JoinColumn(name="id_tipo_investimento", nullable = false)
	private TipoInvestimento tipoInvestimento;

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
	
	public InvestimentoDTO converter(float valorMinimo) {
		return new InvestimentoDTO(this.id, this.nome, this.tipoInvestimento, valorMinimo);
	}
}
