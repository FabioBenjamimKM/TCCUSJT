package com.usjt.tcc.repository;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import com.usjt.tcc.model.entity.Sugestao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SugestaoRepository extends JpaRepository<Sugestao, Long> {
    @Query(value = "SELECT s FROM Sugestao s WHERE s.tipoSugestao.id = :id AND s.data LIKE CONCAT('%',:data,'%') ORDER BY s.valor ASC")
    List<Sugestao> find(@Param("id")long id,  @Param("data")String data);

    @Query(value = "SELECT s FROM Sugestao s WHERE s.tipoSugestao.id = :id AND s.data LIKE CONCAT('%',:data,'%') AND s.investimento.tipoInvestimento.id IN :idTipoInvestimentoList ORDER BY s.valor DESC")
    List<Sugestao> buscarPorTipoInvestimento(@Param("id")long id,  @Param("data")String data,  @Param("idTipoInvestimentoList")List<Long> idTipoInvestimentoList);
}