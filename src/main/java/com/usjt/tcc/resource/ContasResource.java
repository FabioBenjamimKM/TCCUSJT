package com.usjt.tcc.resource;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usjt.tcc.controller.LoginController;
import com.usjt.tcc.model.Conta;
import com.usjt.tcc.repository.Contas;
import com.usjt.tcc.util.JPAUtil;

@RestController
@RequestMapping("/login")
public class ContasResource {
	
	@Autowired
	private Contas contas;
	
	@PostMapping
	public Conta createConta(@RequestBody Conta conta) {
		return contas.save(conta);
	}
	
	@PostMapping("/{Autentica}")
	public ResponseEntity<Boolean> Login(@RequestBody Conta contaRequest) {
		Optional<Conta> conta = contas.findById(contaRequest.getEmail());
		
		if (conta != null && conta.get().getSenha().equals(contaRequest.getSenha())) {
			return ResponseEntity.ok(true);	
		} else {
			return (ResponseEntity<Boolean>) ResponseEntity.badRequest();
		}
	}

}
