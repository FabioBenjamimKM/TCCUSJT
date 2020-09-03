package com.usjt.tcc.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.usjt.tcc.model.entity.Acao;
import com.usjt.tcc.model.entity.Predicao;

@Repository
public interface PredicaoRepository extends JpaRepository<Predicao, Long>{

	@Query(nativeQuery = true, value = "select * from TB_ACAO_PREVISAO where data = :data and id_investimento = :id")
	List<Predicao> findByIdData(@Param("id")long id, @Param("data")String data);
}
