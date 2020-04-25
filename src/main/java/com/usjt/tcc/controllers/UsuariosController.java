package com.usjt.tcc.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usjt.tcc.model.Usuario;
import com.usjt.tcc.repository.Perfils;
import com.usjt.tcc.repository.Usuarios;

@RestController
@RequestMapping("/login")
public class UsuariosController {
	
	@Autowired
	private Usuarios usuarios;
	
	@Autowired
	private Perfils perfils;
	
	@PostMapping
	public Usuario createConta(@RequestBody Usuario usuario) {
		perfils.save(usuario.getPerfil());
		return usuarios.save(usuario);
	}
	
	@PostMapping("/{Autentica}")
	public ResponseEntity<Boolean> Login(@RequestBody Usuario usuarioRequest) {
		Optional<Usuario> usuario = usuarios.findById(usuarioRequest.getEmail());
		
		if (usuario != null && usuario.get().getSenha().equals(usuarioRequest.getSenha())) {
			return ResponseEntity.ok(true);	
		} else {
			return (ResponseEntity<Boolean>) ResponseEntity.badRequest();
		}
	}

}
