package com.usjt.tcc.dto;

import com.usjt.tcc.model.entity.PerfilInvestidor;

public class AtualizaPerfilInvestidorDTO {

	private String cpf;
	private PerfilInvestidor perfil_investidor;
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public PerfilInvestidor getPerfil_investidor() {
		return perfil_investidor;
	}
	
	public void setPerfil_investidor(PerfilInvestidor perfil_investidor) {
		this.perfil_investidor = perfil_investidor;
	}

}
