package com.mycompany.automoviles.lesson.test;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.mycompany.demo.persist.Estilo;
import com.mycompany.demo.persist.Menu;
import com.mycompany.demo.persist.SubItem;
import com.mycompany.demo.persist.SubItem2;
import com.mycompany.demo.util.JPAUtil;

public class JPA11Test {

	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();

		// uso de JPA ENTITY PERSIST
		// uso de LAZY EAGER
		// Evitamos LazyInitializationException con patron
		// OpenSessionInView y en EJB con type=PersistenceContextType.EXTENDED

		SubItem subitem1 = new SubItem("Item con estilos",
				"Este subitem necesita cambios drasticos");
		SubItem2 subitem2 = new SubItem2("Item sin estilos");

		Estilo estilo1 = new Estilo("Estilo 1", "Estilo peruano renacentista");
		Estilo estilo2 = new Estilo("Estilo 2", "Estilo barroco frances");
		Estilo estilo3 = new Estilo("Estilo 3", "Estilo neoyorquino");
		List<Estilo> estilos1 = Arrays.asList(estilo1, estilo2, estilo3);
		subitem1.setEstilos(estilos1);

		Menu menu1 = new Menu("Menu Diverso");
		menu1.setSubItem(subitem1);
		menu1.setSubItem2(subitem2);

		try {
			em.getTransaction().begin();
			em.persist(menu1);
			em.getTransaction().commit();
			em.getTransaction().begin();
			Menu menuPersist = em.find(Menu.class, 1);
			Query query = em.createQuery("select s from SubItem s join fetch s.estilos e"
					+ " where e.titulo = :titulo");
			query.setParameter("titulo", "Estilo neoyorquino");
			List<SubItem> result = query.getResultList();
			System.out.println(result);
			// Aqui recien llama a los objetos marcados con FetchType.LAZY
			int num = menuPersist.getSubItem().getEstilos().size();
			System.out.println(num);
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
