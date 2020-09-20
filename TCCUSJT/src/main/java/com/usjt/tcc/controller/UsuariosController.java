package com.usjt.tcc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.usjt.tcc.model.entity.Usuario;
import com.usjt.tcc.dto.PerfilDTO;
import com.usjt.tcc.model.entity.Perfil;
import com.usjt.tcc.model.entity.Usuario;
import com.usjt.tcc.repository.Perfils;
import com.usjt.tcc.repository.Usuarios;

@RestController
@RequestMapping("/login")
public class UsuariosController {
	
	@Autowired
	private Usuarios usuarios;
	
	@Autowired
	private Perfils perfils;
	
	@GetMapping
	public PerfilDTO getPerfil(String email) {
		Optional<Usuario> usuario = usuarios.findByEmail(email);
		Perfil perfil = usuario.get().getPerfil();
		return PerfilDTO.converterUnico(perfil);
	}
	
	@PostMapping
	public ResponseEntity createConta(@RequestBody Usuario usuario) {
		if(usuario.getEmail().matches(".*@.*") && usuario.getPerfil().getCpf().length() == 11) {
			perfils.save(usuario.getPerfil());
			return new ResponseEntity(HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
	}
	
	@PutMapping
	public ResponseEntity atualizarPerfil(@RequestBody Usuario usuario) {
		if(usuario.getEmail().matches(".*@.*") && usuario.getPerfil().getCpf().length() == 11) {
			Perfil perfil = perfils.findByCpf(usuario.getPerfil().getCpf());
			if(usuario.getPerfil().getPerfil_investidor() != null) {
				perfil.setPerfil_investidor(usuario.getPerfil().getPerfil_investidor());
				perfils.save(perfil);
				return new ResponseEntity(HttpStatus.OK);
			}
		}
		return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
	}
	
	@PostMapping("/{Autentica}")
	public ResponseEntity<Boolean> Login(@RequestBody Usuario usuarioRequest) {
		Optional<Usuario> usuario = usuarios.findByEmail(usuarioRequest.getEmail());
		if (usuario != null && usuario.get().getSenha().equals(usuarioRequest.getSenha())) {
			return ResponseEntity.ok(true);	
		} else {
			return (ResponseEntity<Boolean>) ResponseEntity.badRequest();
		}
	}

}
