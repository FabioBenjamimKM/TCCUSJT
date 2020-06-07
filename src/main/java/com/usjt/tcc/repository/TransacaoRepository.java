package com.usjt.tcc.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.usjt.tcc.model.entity.Transacao;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long>{
	
	@Query(nativeQuery = true, value = "select * from tb_transacao where usuario_id = 12")
	List<Transacao> findAllByUsuarioId(long id);
}
