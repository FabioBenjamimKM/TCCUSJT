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

@Entity
@Table(name="TB_INVESTIMENTO")
public class Investimento implements Serializable{
	
	private static final long serialVersionUID = 1;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(nullable = false)
	private long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private Long idTipoInvestimento;
	
	@ManyToOne
    @JoinColumn(name="usuario_id", nullable=false)
    private Usuario usuario;

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

	public Long getIdTipoInvestimento() {
		return idTipoInvestimento;
	}

	public void setIdTipoInvestimento(Long idTipoInvestimento) {
		this.idTipoInvestimento = idTipoInvestimento;
	}
}
