package com.usjt.tcc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usjt.tcc.model.Usuario;

public interface Usuarios extends JpaRepository<Usuario, String>{

}