package com.usjt.tcc.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TB_TIPO_INVESTIMENTO")
public class TipoInvestimento implements Serializable{
	
	private static final long serialVersionUID = 1;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable = false)
	private long id;
	
	@Column(nullable = false)
	private String nome;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
