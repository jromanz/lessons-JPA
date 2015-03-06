package com.mycompany.automoviles.lesson.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;

import com.mycompany.demo.collections.Master;
import com.mycompany.demo.collections.RolUsuario;
import com.mycompany.demo.util.JPAUtil;

public class JPAHibernate4Test {
	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		
		//Uso de collections @ElementCollection y @CollectionTable
		// 	tabla master
		//	id, descripcion
		//	tabla persona_tiene_emails
		//	id, email
		Set<String> emails1 = new HashSet<String>();
		emails1.add("jromanz@kalerguiz.com");
		emails1.add("jromanz@github.com");
		emails1.add("kalerguiz@gmail.com");
		List<RolUsuario> roles = new ArrayList<RolUsuario>();
		roles.add(RolUsuario.ADMIN);
		roles.add(RolUsuario.MANAGER);
		Master master1 = new Master("Nuevo Master 1", emails1, roles);
		
		try {
			em.getTransaction().begin();
			em.persist(master1);
			em.getTransaction().commit();
		} catch (Exception e) {
			if(em.isOpen()){
				em.getTransaction().rollback();
			}
		} finally{
			if(em.isOpen()){
				em.close();
			}
		}
	}
}
