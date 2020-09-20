package com.usjt.tcc.model;

import java.io.Serializable;
import java.util.Date;

public class Previsao implements Serializable{
	
	private static final long serialVersionUID = 1;
	
	private Date data;
	private float valor;
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
}
