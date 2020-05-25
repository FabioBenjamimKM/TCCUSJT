package com.usjt.tcc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usjt.tcc.model.Sugestao;
import com.usjt.tcc.model.entity.Acao;
import com.usjt.tcc.service.AcaoService;

@RestController
@RequestMapping("/api")
public class AcaoController {

	@Autowired
	private AcaoService _service;
	
	@GetMapping("/acoes/crescimento/{quantidade}")
	public List<Sugestao> consultarPorCrescimento(@PathVariable(value="quantidade") int quantidade) {
		return _service.consultarPorCrescimento(quantidade);
	}
	
	@GetMapping("/acoes/regularidade/{quantidade}")
	public List<Sugestao> consultarPorRegularidade(@PathVariable(value="quantidade") int quantidade) {
		return _service.consultarPorRegularidade(quantidade);
	}
}
