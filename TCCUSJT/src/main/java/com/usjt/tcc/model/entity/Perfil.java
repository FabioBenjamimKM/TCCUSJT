package com.usjt.tcc.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TB_PERFIL")
public class Perfil implements Serializable{
	
	public void atualizaPerfil(Perfil perfil) {
		this.nome = perfil.getNome();
		this.endereco = perfil.getEndereco();
		this.Estado = perfil.getEstado();
		this.telefone = perfil.getTelefone();
		this.idade = perfil.getIdade();
		this.sexo = perfil.getSexo();
	}
	
	private static final long serialVersionUID = 1;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false, unique = true)
	private String cpf;
	
	@Column(nullable = false)
	private String endereco;
	
	@Column(nullable = false)
	private Integer idade;
	
	@Column(nullable = false)
	private String telefone;
	
	@Column(nullable = false)
	private String sexo;
	
	@Column(nullable = false)
	private String Estado;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "perfil_investidor", nullable = true)
	private PerfilInvestidor perfil_investidor;
	
	public PerfilInvestidor getPerfil_investidor() {
		return perfil_investidor;
	}
	
	public void setPerfil_investidor(PerfilInvestidor perfil_investidor) {
		this.perfil_investidor = perfil_investidor;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
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
}
