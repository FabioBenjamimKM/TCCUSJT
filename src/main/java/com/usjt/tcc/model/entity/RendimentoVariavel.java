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
@Table(name="TB_RENDIMENTO_VARIAVEL")
public class RendimentoVariavel implements Serializable{
	
	private static final long serialVersionUID = 1;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable = false)
	private long id;

	@Column(nullable = false)
	private float valor;
	
	@ManyToOne
	@JoinColumn(name="id_tipo_rendimento_variavel", nullable = false)
	private TipoRendimentoVariavel tipoRendimentoVariavel;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public TipoRendimentoVariavel getTipoRendimentoVariavel() {
		return tipoRendimentoVariavel;
	}

	public void setTipoRendimentoVariavel(TipoRendimentoVariavel tipoRendimentoVariavel) {
		this.tipoRendimentoVariavel = tipoRendimentoVariavel;
	}
}
