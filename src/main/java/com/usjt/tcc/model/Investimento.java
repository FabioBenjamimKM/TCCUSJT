package com.usjt.tcc.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Investimento {
	
	@Id
	@Column(nullable = false)
	private int id;
	
	@Column(nullable = false)
	private float valor;
	
	@Column(nullable = false)
	private Date dataInclusao;
	
	@Column(nullable = false)
	private int idTipoInvestimento;
}
