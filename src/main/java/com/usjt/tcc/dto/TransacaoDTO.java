package com.usjt.tcc.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.usjt.tcc.model.entity.Investimento;
import com.usjt.tcc.model.entity.RendaFixa;
import com.usjt.tcc.model.entity.Resgate;
import com.usjt.tcc.model.entity.Usuario;
import com.usjt.tcc.service.RendaFixaService;

public class TransacaoDTO {
	
	private static final long serialVersionUID = 1;
	
	private RendaFixaService rendaFixaService = new RendaFixaService();

	public TransacaoDTO(long id, float valor, Date data, Investimento investimento, Usuario usuario,
			Date dataVencimento, Float taxaPorcentagem, String nomeTipoTaxa) {
		
		this.id = id;
		this.valor = valor;
		this.data = data;
		this.investimento = investimento;
		this.usuario = usuario;
		this.dataVencimento = dataVencimento;
		this.taxaPorcentagem = taxaPorcentagem;
		this.nomeTipoTaxa = nomeTipoTaxa;
			
	}
	
	private long id;
	
	private float valor;
	
	private Date data;
	
	private Resgate resgate;

	private Investimento investimento;

    private Usuario usuario;
    
    private Date dataVencimento;
    
    private Float taxaPorcentagem;
    
    private String nomeTipoTaxa;
    
    public Float getTaxaPorcentagem() {
		return taxaPorcentagem;
	}
    
    public void setTaxaPorcentagem(Float taxaPorcentagem) {
		this.taxaPorcentagem = taxaPorcentagem;
	}
    
    public void setNomeTipoTaxa(String nomeTipoTaxa) {
		this.nomeTipoTaxa = nomeTipoTaxa;
	}
    
    public String getNomeTipoTaxa() {
		return nomeTipoTaxa;
	}
    
    public Date getDataVencimento() {
		return dataVencimento;
	}
    
    public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
