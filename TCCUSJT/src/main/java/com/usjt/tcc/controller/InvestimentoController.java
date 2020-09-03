package com.usjt.tcc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usjt.tcc.dto.InvestimentoDTO;
import com.usjt.tcc.model.Sugestao;
import com.usjt.tcc.model.entity.Investimento;
import com.usjt.tcc.repository.InvestimentoRepository;
import com.usjt.tcc.service.AcaoService;
import com.usjt.tcc.service.InvestimentoService;

@RestController
@RequestMapping("/api")
public class InvestimentoController {
	
	@Autowired
	private InvestimentoService _service;
	
	@GetMapping("/investimento")
	public List<InvestimentoDTO> consultar() {
		return _service.consultar();
	}
}
