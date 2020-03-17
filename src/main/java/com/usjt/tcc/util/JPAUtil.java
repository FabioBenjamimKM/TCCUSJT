package com.usjt.tcc.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory("projetoTCC");

	public EntityManager getEntityManager() {
		return entityManagerFactory.createEntityManager();
	}

}
