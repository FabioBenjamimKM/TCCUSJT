package com.usjt.tcc.model;

import java.io.Serializable;

import com.usjt.tcc.model.entity.Investimento;

public class SugestaoInvestimento implements Serializable {
	
    private static final long serialVersionUID = 1;
    
    private Investimento investimento;
    private float valor;
    private String risco;
    
    public Investimento getInvestimento(){
        return this.investimento;
    }

    public void setInvestimento(Investimento investimento){
        this.investimento = investimento;
    }

    public float getValor(){
        return this.valor;
    }

    public void setValor(float valor){
        this.valor = valor;
    }

    public String getRisco(){
        return this.risco;
    }

    public void setRisco(String risco){
        this.risco = risco;
    }
}
