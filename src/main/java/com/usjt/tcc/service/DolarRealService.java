package com.usjt.tcc.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.usjt.tcc.model.entity.DolarReal;
import com.usjt.tcc.repository.DolarRealRepository;

@Service
public class DolarRealService {

	@Autowired
	private DolarRealRepository _repository;

	public List<DolarReal> consultar() {
		List<DolarReal> dolarRealOptional = _repository.findFirstByData();
		
		return dolarRealOptional;
	}
}
