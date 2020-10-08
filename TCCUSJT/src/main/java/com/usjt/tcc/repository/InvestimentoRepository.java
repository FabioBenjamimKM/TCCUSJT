package com.usjt.tcc.repository;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usjt.tcc.model.entity.Acao;
import com.usjt.tcc.model.entity.Investimento;
import com.usjt.tcc.model.entity.RendaFixa;

public interface InvestimentoRepository extends JpaRepository<Investimento, Long> {
}
