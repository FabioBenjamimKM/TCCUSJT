package com.usjt.tcc.controller.dto;

import javax.persistence.Column;

import com.usjt.tcc.model.Perfil;

public class PerfilDTO {
	
	public PerfilDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public PerfilDTO(Perfil perfil) {
		this.id = perfil.getId();
		this.cpf = perfil.getCpf();
		this.nome = perfil.getNome();
		this.endereco = perfil.getEndereco();
		this.idade = perfil.getIdade();
		this.sexo = perfil.getSexo();
		this.Estado = perfil.getEstado();
		this.telefone = perfil.getTelefone();
	}
	
	private Long id;
	
	private String cpf;

	private String nome;

	private String endereco;

	private Integer idade;

	private String telefone;

	private String sexo;
	
	private String Estado;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}

	public static PerfilDTO converter(Perfil perfil) {
		return new PerfilDTO(perfil);
	}
}
