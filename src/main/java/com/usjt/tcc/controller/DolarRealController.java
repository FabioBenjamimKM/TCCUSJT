package com.usjt.tcc.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usjt.tcc.model.entity.DolarReal;
import com.usjt.tcc.service.DolarRealService;

@RestController
@RequestMapping("/api")
public class DolarRealController {

	@Autowired
	private DolarRealService _service;
	
	@GetMapping("/dolar/{data}")
	public DolarReal consultar(@PathVariable(value="data") String dataString) {
		
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
