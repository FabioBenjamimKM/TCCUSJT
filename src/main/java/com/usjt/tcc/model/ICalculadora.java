package com.usjt.tcc.model;

import java.util.Date;

import com.usjt.tcc.model.entity.Transacao;

public interface ICalculadora {
	public Previsao prever(Transacao transacao, Date data);
}
