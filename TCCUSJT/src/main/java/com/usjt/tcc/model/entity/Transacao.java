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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.usjt.tcc.dto.TransacaoDTO;

@Entity
@Table(name="TB_TRANSACAO")
public class Transacao implements Serializable{
	
	private static final long serialVersionUID = 1;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable = false)
	private long id;
	
	@Column(nullable = false)
	private float valor;
	
	@Column(nullable = false)
	private Date data;
	
	@ManyToOne
	@JoinColumn(name="id_resgate")
	private Resgate resgate;
	
	@ManyToOne
	@JoinColumn(name="id_investimento", nullable = false)
	private Investimento investimento;
	
	@ManyToOne
    @JoinColumn(name="usuario_id", nullable=false)
    private Usuario usuario;

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

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Resgate getResgate() {
		return resgate;
	}

	public void setResgate(Resgate resgate) {
		this.resgate = resgate;
	}
	
	public Investimento getInvestimento() {
		return investimento;
	}

	public void setInvestimento(Investimento investimento) {
		this.investimento = investimento;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public TransacaoDTO converter(java.util.Date date, Float taxa, String nomeTaxa) {
		return new TransacaoDTO(this.id, this.valor, this.data, this.investimento, this.usuario, date, taxa, nomeTaxa);
	}
}
