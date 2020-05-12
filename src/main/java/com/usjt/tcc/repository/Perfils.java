package com.usjt.tcc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usjt.tcc.model.entity.Perfil;
import com.usjt.tcc.model.entity.Usuario;

public interface Perfils extends JpaRepository<Perfil, String>{

}
