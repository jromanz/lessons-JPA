package com.mycompany.automoviles.lesson.test;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;

import com.mycompany.demo.persist.Estilo;
import com.mycompany.demo.persist.Menu;
import com.mycompany.demo.persist.SubItem;
import com.mycompany.demo.persist.SubItem2;
import com.mycompany.demo.util.JPAUtil;

public class JPA10Test {

	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();

		// uso de JPA ENTITY PERSIST
		// orphanRemoval = true se elimina los registros de la tabla hija
		// asociada
		// si hacemos null en la tabla padre
		// la entidad no debe contener otras entidades asociadas porque sino no
		// se eliminaran los registros de las tablas
		SubItem subitem1 = new SubItem("SubItem 1",
				"Este subitem es paradigmatico");
		SubItem2 subitem2 = new SubItem2("SubItem 2");

		Estilo estilo1 = new Estilo("Estilo 1", "Estilo traido de Italia");
		Estilo estilo2 = new Estilo("Estilo 2", "Estilo neoyorquino");
		List<Estilo> estilos1 = Arrays.asList(estilo1, estilo2);
		subitem1.setEstilos(estilos1);

		Menu menu1 = new Menu("Menu 1");
		menu1.setSubItem(subitem1);
		menu1.setSubItem2(subitem2);

		try {
			em.getTransaction().begin();
			em.persist(menu1);
			em.getTransaction().commit();
			em.getTransaction().begin();
			Menu menuPersist = em.find(Menu.class, 1);
			// OK
			menuPersist.setSubItem2(null);
			// Ejecuta pero orphanRemoval es ignorado, tiene entidades asociadas
			menuPersist.setSubItem2(null);
			em.getTransaction().commit();
		} catch (Exception e) {
			if (em.isOpen()) {
				em.getTransaction().rollback();
			}
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}

	}
}
