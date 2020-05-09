package com.usjt.tcc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usjt.tcc.model.Investimento;
import com.usjt.tcc.repository.InvestimentoRepository;
import com.usjt.tcc.service.InvestimentoService;

@RestController
@RequestMapping("/api")
public class InvestimentoController {

	@Autowired
	private InvestimentoService _service;
	
	@GetMapping("/investimentos")
	public List<Investimento> consultar() {
		return _service.consultar();
	}
	
	@GetMapping("/investimento/{id}")
	public Investimento consultar(@PathVariable(value="id") long id) {
		return _service.consultar(id);
	}
	
	@GetMapping("/investimento/delete/{id}")
	public void excluir(@PathVariable(value="id") long id) {
		_service.excluir(id);
	}
	
	@PostMapping("/investimento")
	public Investimento salvar(@RequestBody Investimento investimento) {
		return _service.salvar(investimento);
	}
}
