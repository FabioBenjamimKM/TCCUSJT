package com.usjt.tcc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping("/consultar")
	public List<Investimento> consultar() {
		return _repository.findAll();
	}
	
	@PostMapping("/salvar")
	public void salvar(Investimento investimento) {
		_repository.save(investimento);
	}
	
	@PostMapping("/excluir")
	public void excluir(Investimento investimento) {
		_repository.delete(investimento);
	}
}
