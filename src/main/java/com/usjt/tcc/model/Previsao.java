package com.usjt.tcc.model;

import java.io.Serializable;

import javax.xml.crypto.Data;

public class Previsao implements Serializable{
	
	private static final long serialVersionUID = 1;
	
	private Data data;
	private float valor;
	
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
}
