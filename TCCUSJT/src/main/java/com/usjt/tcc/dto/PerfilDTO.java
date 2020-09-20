package com.usjt.tcc.dto;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;

import com.usjt.tcc.model.entity.Perfil;
import com.usjt.tcc.model.entity.PerfilInvestidor;

public class PerfilDTO {
	

	public PerfilDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public PerfilDTO(Perfil perfil) {
		this.id = perfil.getId();
		this.nome = perfil.getNome();
		this.cpf = perfil.getCpf();
		this.endereco = perfil.getEndereco();
		this.idade = perfil.getIdade();
		this.telefone = perfil.getTelefone();
		this.sexo = perfil.getSexo();
		this.Estado = perfil.getEstado();
		this.perfil_investidor = perfil.getPerfil_investidor();
	}
	
	private Long id;
	
	private String nome;
	
	private String cpf;
	
	private String endereco;

	private Integer idade;

	private String telefone;

	private String sexo;

	private String Estado;
	
	private PerfilInvestidor perfil_investidor;
	
	public PerfilInvestidor getPerfilInvestidor() {
		return perfil_investidor;
	}
	
	public void setPerfilInvestidor(PerfilInvestidor perfilInvestidor) {
		this.perfil_investidor = perfilInvestidor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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
	
	public static List<PerfilDTO> converter(List<Perfil> perfil) {
		return perfil.stream().map(PerfilDTO::new).collect(Collectors.toList());
	}
	
	public static PerfilDTO converterUnico(Perfil perfil) {
		return new PerfilDTO(perfil);
	}
}
