package com.usjt.tcc.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.usjt.tcc.model.Conta;
import com.usjt.tcc.util.JPAUtil;

public class LoginController {

	public void tentando(Conta conta2) {
		
//		Conta conta = new Conta();
//		conta.CreateConta("senha", "email");
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();

	    String jpql = "select m from Conta m where m.email = '"+conta2.getEmail()+"'";
	    Query query = em.createQuery(jpql);

	    List<Conta> resultados = query.getResultList();
	    
	    for (Conta conta : resultados) {
			System.out.println(conta.getEmail());
		}

	    em.getTransaction().commit();
	    em.close();
	}
}
