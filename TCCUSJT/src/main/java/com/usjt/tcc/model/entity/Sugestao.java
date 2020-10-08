package com.usjt.tcc.model.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TB_SUGESTAO")
public class Sugestao implements Serializable{
    
    private static final long serialVersionUID = 1;
    
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable = false)
	private long id;
    
    @Column(nullable = false)
    private Calendar data;
    
    @Column(nullable = false)
	private float valor;

	@ManyToOne
	@JoinColumn(name="id_tipo_sugestao", nullable = false)
    private TipoSugestao tipoSugestao;
    
    @ManyToOne
	@JoinColumn(name="id_investimento", nullable = false)
    private Investimento investimento;
    
    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public Calendar getData(){
        return data;
    }

    public void setData(Calendar data){
        this.data = data;
    }

    public float getValor(){
        return valor;
    }

    public void setValor(float valor){
        this.valor = valor;
    }

    public TipoSugestao getTipoSugestao(){
        return tipoSugestao;
    }

    public void setTipoSugestao(TipoSugestao tipoSugestao){
        this.tipoSugestao = tipoSugestao;
    }

    public void setInvestimento(Investimento investimento){
        this.investimento = investimento;
    }

    public Investimento getInvestimento(){
        return investimento;
    }
}
