package com.usjt.tcc.repository;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usjt.tcc.model.entity.RendaFixa;

@Repository
public interface RendaFixaRepository extends JpaRepository<RendaFixa, Long>{
	
	Optional<RendaFixa> findFirstByInvestimentoIdAndData(long id, Date data);
}
