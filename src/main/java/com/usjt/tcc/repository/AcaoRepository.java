package com.usjt.tcc.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usjt.tcc.model.entity.Acao;

@Repository
public interface AcaoRepository extends JpaRepository<Acao, Long>{
	List<Acao> findByData(Date data);
}
