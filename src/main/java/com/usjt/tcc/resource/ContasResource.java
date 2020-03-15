package com.usjt.tcc.resource;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usjt.tcc.model.Conta;
import com.usjt.tcc.repository.Contas;

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
