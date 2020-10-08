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

import com.usjt.tcc.model.entity.Acao;
import com.usjt.tcc.model.entity.Sugestao;
import com.usjt.tcc.service.AcaoService;
import com.usjt.tcc.service.SugestaoService;

@RestController
@RequestMapping("/api")
public class AcaoController {

	@Autowired
	private AcaoService _service;

	@Autowired
	private SugestaoService _serviceSugestao;
	
	@GetMapping("/acoes/sugestao/{idTipoSugestao}&{posicao}")
	public List<Acao> sugestao(@PathVariable(value="idTipoSugestao") int idTipoSugestao, @PathVariable(value="posicao") int posicao) {
		Sugestao sugestao = _serviceSugestao.consultar(idTipoSugestao, posicao);
		
		return _service.sugestao(sugestao.getInvestimento().getId());
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

	@GetMapping("/acoes/rentavel/{idUsuario}")
	public List<Acao> consultarRentavel(@PathVariable(value="idUsuario") long idUsuario) throws Exception {
		return _service.consultarRentavel(idUsuario);
	}
}
