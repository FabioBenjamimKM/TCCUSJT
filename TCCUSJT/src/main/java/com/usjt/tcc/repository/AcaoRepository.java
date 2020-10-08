package com.usjt.tcc.repository;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.usjt.tcc.model.entity.Acao;

@Repository
public interface AcaoRepository extends JpaRepository<Acao, Long>{
	List<Acao> findByData(Date data);

	@Query(nativeQuery = true, value = "select * from tb_acao where id_investimento = :idInvestimento")
	List<Acao> findByTopSugestao(@Param("idInvestimento")long idInvestimento);

	@Query(nativeQuery = true, value = "select * from tb_acao where data LIKE '2020-05%' and id_investimento = :id")
	List<Acao> findByIdData(@Param("id")long id);
	
	@Query(nativeQuery = true, value = "select * from tb_acao where data = :data and id_investimento = :id")
	List<Acao> findByIdData(@Param("id")long id, @Param("data")String data);
	
	Optional<Acao> findFirstByInvestimentoIdAndData(long id, Calendar data);

	@Query(nativeQuery = true, value = "SELECT * FROM TB_ACAO GROUP BY ID_INVESTIMENTO HAVING MIN(DATA)")
	List<Acao> obterAbertura();
}
