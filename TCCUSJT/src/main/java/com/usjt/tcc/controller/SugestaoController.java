package com.usjt.tcc.controller;

import java.util.List;

import com.usjt.tcc.model.SugestaoInvestimento;
import com.usjt.tcc.model.entity.Sugestao;
import com.usjt.tcc.service.SugestaoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SugestaoController {

    @Autowired
	private SugestaoService _service;
    
    @GetMapping("/sugestao/{idUsuario}&{posicao}")
	public SugestaoInvestimento sugestao(@PathVariable(value="idUsuario") int idUsuario, @PathVariable(value="posicao") int posicao) {
		return _service.sugestaoPorUsuario(3, idUsuario).get(posicao);
	}
}
