package com.usjt.tcc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usjt.tcc.model.entity.Investimento;
import com.usjt.tcc.model.entity.Transacao;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long>{
	
}
