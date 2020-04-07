package com.usjt.tcc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TipoInvestimento {
	
	@Id
	@Column(nullable = false)
	private int id;
	
	@Column(nullable = false)
	private String descricao;
}
