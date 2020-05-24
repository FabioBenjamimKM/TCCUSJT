package com.usjt.tcc.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usjt.tcc.model.entity.DolarReal;
import com.usjt.tcc.repository.DolarRealRepository;

@Service
public class DolarRealService {

	@Autowired
	private DolarRealRepository _repository;
	
	public DolarReal consultar(Date data) {
		Optional<DolarReal> dolarRealOptional = _repository.findFirstByData(data);
		
		return dolarRealOptional != null ? dolarRealOptional.get() : null;
	}
}
