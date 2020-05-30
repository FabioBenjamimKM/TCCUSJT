package com.usjt.tcc.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.usjt.tcc.model.entity.RendaFixa;

@Repository
public interface RendaFixaRepository extends JpaRepository<RendaFixa, Long>{
	
	Optional<RendaFixa> findFirstByInvestimentoIdAndData(long id, Date data);

	@Query(nativeQuery = true, value = "select * from tb_renda_fixa where id_investimento = :id")
	List<RendaFixa> findDataVencimento(@Param(value = "id")long id);
	
}
