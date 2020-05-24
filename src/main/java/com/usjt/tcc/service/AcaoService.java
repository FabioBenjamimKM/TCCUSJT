package com.usjt.tcc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usjt.tcc.model.entity.Acao;
import com.usjt.tcc.repository.AcaoRepository;

@Service
public class AcaoService {

	@Autowired
	private AcaoRepository _repository;
	
	public List<Acao> consultarPorCrescimento(int quantidade) {
		return null;
	}
	
	public List<Acao> consultarPorRegularidade(int quantidade) {
		return null;
	}
}
