package com.usjt.tcc.model.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "FATO_ACAO")
//@IdClass(FatoAcaoID.class)
public class FatoAcao implements Serializable {
    @Id
    @PrimaryKeyJoinColumn
    @ManyToOne
    @JoinColumn(name = "id_investimento", nullable = false)
    private Investimento investimento;

    @Id
    @PrimaryKeyJoinColumn
    @ManyToOne
    @JoinColumn(name = "id_tempo", nullable = false)
    private DimTempo tempo;

    @Column(nullable = false)
    private float crescimento;

    @Column(nullable = false)
    private float crescimento_porcentagem;

    public Investimento getInvestimento() {
        return investimento;
    }

    public void setInvestimento(Investimento investimento) {
        this.investimento = investimento;
    }

    public float getCrescimento() {
        return crescimento;
    }

    public void setCrescimento(float crescimento) {
        this.crescimento = crescimento;
    }

    public float getCrescimento_porcentagem() {
        return crescimento_porcentagem;
    }

    public void setCrescimento_porcentagem(float crescimento_porcentagem) {
        this.crescimento_porcentagem = crescimento_porcentagem;
    }

    public DimTempo getTempo() {
        return tempo;
    }

    public void setTempo(DimTempo tempo) {
        this.tempo = tempo;
    }
}
