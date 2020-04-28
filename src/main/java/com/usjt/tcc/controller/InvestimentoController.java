package com.usjt.tcc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usjt.tcc.model.Investimento;
import com.usjt.tcc.repository.InvestimentoRepository;

@RestController
@RequestMapping("/investimento")
public class InvestimentoController {

	@Autowired
	private InvestimentoRepository _repository;
	
	@PostMapping("/cadastrar")
	public void Cadastrar(Investimento investimento) {
		_repository.save(investimento);
	}
}
