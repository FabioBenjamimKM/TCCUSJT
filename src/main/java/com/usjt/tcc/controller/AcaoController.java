package com.usjt.tcc.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
	
	@GetMapping("/acoes/{data}")
	public List<Acao> consultar(@PathVariable(value="data") String dataString){
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date data = null;
		
		try {
			data = formatter.parse(dataString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return _service.consultar(data);
	}
}
