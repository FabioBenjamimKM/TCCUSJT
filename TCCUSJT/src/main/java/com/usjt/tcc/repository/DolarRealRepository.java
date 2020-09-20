package com.usjt.tcc.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.usjt.tcc.model.entity.DolarReal;

@Repository
public interface DolarRealRepository extends JpaRepository<DolarReal, Long>{
	
	@Query(nativeQuery = true, value = "select * from tb_dolar_real where data LIKE '2020-05%'")
	List<DolarReal> findFirstByData();
	
}
