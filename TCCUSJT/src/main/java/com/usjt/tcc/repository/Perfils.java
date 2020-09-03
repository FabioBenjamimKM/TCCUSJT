package com.usjt.tcc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usjt.tcc.model.entity.Perfil;
import com.usjt.tcc.model.entity.Usuario;

public interface Perfils extends JpaRepository<Perfil, Long>{

	List<Perfil> findByCpf(String cpf);

}
