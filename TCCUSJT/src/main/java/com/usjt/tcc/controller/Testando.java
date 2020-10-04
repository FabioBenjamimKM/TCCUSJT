package com.usjt.tcc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teste")
public class Testando {

	@GetMapping
	public String getTamburu() {
		return "Tamburu Comedor de casada";
	}
	
	
}
