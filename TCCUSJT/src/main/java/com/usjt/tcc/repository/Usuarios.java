package com.usjt.tcc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usjt.tcc.model.entity.Usuario;

public interface Usuarios extends JpaRepository<Usuario, Long>{

	Optional<Usuario> findByEmail(String email);

}
