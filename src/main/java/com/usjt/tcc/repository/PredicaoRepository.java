package com.usjt.tcc.repository;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usjt.tcc.model.entity.Predicao;

@Repository
public interface PredicaoRepository extends JpaRepository<Predicao, Long>{

	Optional<Predicao> findFirstByInvestimentoIdAndData(long id, Date data);
}
