package com.usjt.tcc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usjt.tcc.model.Investimento;
import com.usjt.tcc.repository.InvestimentoRepository;

@Service
public class InvestimentoService {

	@Autowired
	private InvestimentoRepository _repository;
	
	public List<Investimento> consultar() {
		return _repository.findAll();
	}
	
	public Investimento consultar(long investimentoId) {
		Optional<Investimento> investimento = _repository.findById(investimentoId);
		
		return investimento != null ? investimento.get() : null;
	}
	
	public Investimento salvar(Investimento investimento) {
		return _repository.save(investimento);
	}
	
	public void excluir(long investimentoId) {
		_repository.deleteById(investimentoId);
	}
}
