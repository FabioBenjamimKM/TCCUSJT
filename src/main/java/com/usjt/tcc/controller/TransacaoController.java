package com.usjt.tcc.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usjt.tcc.model.Lucro;
import com.usjt.tcc.model.Previsao;
import com.usjt.tcc.model.Top;
import com.usjt.tcc.model.entity.Transacao;
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
	
	@GetMapping("/transacoes/usuario/{id}")
	public List<Transacao> consultarPorUsuarioId(@PathVariable(value="id") long id) {
		return _service.consultarPorUsuarioId(id);
	}

	@GetMapping("/transacoes/lucro/{idUsuario}")
	public List<Lucro> calcularLucro(@PathVariable(value="idUsuario") long idUsuario) throws Exception {
		return _service.calcularLucro(idUsuario);
	}
	
	@GetMapping("/transacoes/top/{idUsuario}&{quantidade}")
	public List<Top> calcularTop(@PathVariable(value="idUsuario") long idUsuario, @PathVariable(value="quantidade") int quantidade) throws Exception {
		return _service.calcularTop(idUsuario, quantidade);
	}
	
	@GetMapping("/transacao/{id}")
	public Transacao consultar(@PathVariable(value="id") long id) {
		return _service.consultar(id);
	}
	
	@GetMapping("/transacao/prever/{id}&{data}")
	public Previsao prever(@PathVariable(value="id") long id, @PathVariable(value="data") String dataString) throws Exception {
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date data = null;
		
		try {
			data = formatter.parse(dataString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
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
