package com.usjt.tcc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.usjt.tcc.model.entity.RendaFixa;
import com.usjt.tcc.repository.RendaFixaRepository;

public class RendaFixaService {

	@Autowired
	private RendaFixaRepository _repository;
	
	public List<RendaFixa> getVencimento(long id) {
		return _repository.findDataVencimento(id);
	}
	
}
