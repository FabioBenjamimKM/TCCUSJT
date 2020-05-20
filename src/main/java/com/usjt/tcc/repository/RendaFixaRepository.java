package com.usjt.tcc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.usjt.tcc.model.entity.RendaFixa;

@Repository
public interface RendaFixaRepository extends JpaRepository<RendaFixa, Long>{
	
	@Query("SELECT r FROM RendaFixa r WHERE r.investimento.id = ?1")
	RendaFixa buscarRendaFixaPorIdInvestimento(long idInvestimento);
}
