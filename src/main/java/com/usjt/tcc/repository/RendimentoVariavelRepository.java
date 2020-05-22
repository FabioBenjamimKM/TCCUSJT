package com.usjt.tcc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usjt.tcc.model.entity.RendimentoVariavel;

@Repository
public interface RendimentoVariavelRepository extends JpaRepository<RendimentoVariavel, Long>{

}
