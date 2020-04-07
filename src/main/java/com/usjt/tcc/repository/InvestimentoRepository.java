package com.usjt.tcc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usjt.tcc.model.Conta;

public interface InvestimentoRepository extends JpaRepository<Conta, String>{

}
