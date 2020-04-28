package com.usjt.tcc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usjt.tcc.model.Investimento;

@Repository
public interface InvestimentoRepository extends JpaRepository<Investimento, Long>{

}
