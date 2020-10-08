package com.usjt.tcc.model;

public class Variacao implements Comparable<Variacao>{
    public Long idInvestimento;
    public Double variacao;

    public Variacao(Long idInvestimento, Double variacao) {
        this.idInvestimento = idInvestimento;
        this.variacao = variacao;
    }

    @Override
    public int compareTo(Variacao o) {
        variacao = variacao * 100;
        return (int)Math.round(variacao);
    }
}
