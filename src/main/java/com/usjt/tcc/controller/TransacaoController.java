package com.usjt.tcc.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usjt.tcc.model.Previsao;
import com.usjt.tcc.model.entity.Investimento;
import com.usjt.tcc.model.entity.Transacao;
import com.usjt.tcc.repository.TransacaoRepository;
import com.usjt.tcc.service.TransacaoService;

@RestController
@RequestMapping("/api")
public class TransacaoController {

	@Autowired
	private TransacaoService _service;
	
	@GetMapping("/transacoes")
	public List<Transacao> consultar() {
		return _service.consultar();
	}
	
	@GetMapping("/transacao/{id}")
	public Transacao consultar(@PathVariable(value="id") long id) {
		return _service.consultar(id);
	}
	
	@GetMapping("/transacao/prever/{id}&{data}")
	public Previsao prever(@PathVariable(value="id") long id, @PathVariable(value="data") Date data) {
		return _service.prever(id, data);
	}
	
	@DeleteMapping("/transacao")
	public void excluir(@RequestBody Transacao transacao) {
		_service.excluir(transacao);
	}
	
	@PostMapping("/transacao")
	public Transacao cadastrar(@RequestBody Transacao transacao) {
		return _service.salvar(transacao);
	}
	
	@PutMapping("/transacao")
	public Transacao atualizar(@RequestBody Transacao transacao) {
		return _service.salvar(transacao);
	}
}
