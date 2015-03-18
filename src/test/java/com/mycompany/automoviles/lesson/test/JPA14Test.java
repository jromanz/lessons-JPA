package com.mycompany.automoviles.lesson.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.mycompany.demo.jpql.Paciente;
import com.mycompany.demo.util.JPAUtil;

public class JPA14Test {

	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();

		// uso de JPA ENTITY PERSIST
		// uso de JPQL
		// uso de TypedQuery y uso de setParameter(arg,arg) para evitar
		// problemas de seguridad como SQL Injection
		Date fecha1 = Calendar.getInstance().getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date fecha = null;
		try {
			fecha = sdf.parse("1978-09-18");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		Paciente paciente1 = new Paciente("Julio Cesar", "Román", "Zapata",
				fecha, "Av. Juan Velasco 1340 Lima 42", "2870501");
		Paciente paciente2 = new Paciente("Mariane", "Veloso", "Riera",
				fecha, "Jr. Los Portales 340 Lima 11", "2870500");
		Paciente paciente3 = new Paciente("Irene", "Aguiar", "Lorent",
				fecha, "Av. Los Platinos 1110 Lima 5", "2870502");
		Paciente paciente4 = new Paciente("Gilda Licet", "Salguero", "Colleti",
				fecha, "Calle Las Begonias 443 Lima 32", "2590511");
		Paciente paciente5 = new Paciente("Gina", "Pancorbo", "Baltazar",
				fecha, "Av. Javier Prado 330 Lima 20", "4463486");
		Paciente paciente6 = new Paciente("Morgana Oriana", "Viterbo", "Fernandez",
				fecha, "Jr. Quilca 600 Lima 17", "2586464");
		Paciente paciente7 = new Paciente("David Adrian", "Luque", "Macedonio",
				fecha, "Calle Loret De Mola 556 Lima 5", "2719254");
		Paciente paciente8 = new Paciente("Daniella Eliana", "Anbogaldo", "Luna",
				fecha, "Jr. Zorritos 440 Lima 1", "2807979");

		try {
			em.getTransaction().begin();
			em.persist(paciente1);
			em.persist(paciente2);
			em.persist(paciente3);
			em.persist(paciente4);
			em.persist(paciente5);
			em.persist(paciente6);
			em.persist(paciente7);
			em.persist(paciente8);
			em.getTransaction().commit();
			
			//	Uso de JPQL
			// 	Uso de TypedQuery<Class>
			String consulta = "select p from Paciente p where p.nombrePaci = :nombre";
			em.getTransaction().begin();
			TypedQuery<Paciente> query = em.createQuery(consulta, Paciente.class);
			query.setParameter("nombre", "Julio Cesar");
			query.setMaxResults(100);
			em.getTransaction().commit();
			
			List<Paciente> lista = query.getResultList();
			for (Paciente paciente : lista) {
				System.out.println(paciente);
			}
			
			
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
