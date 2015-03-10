package com.mycompany.automoviles.lesson.test;

import javax.persistence.EntityManager;

import com.mycompany.demo.persist.Motor;
import com.mycompany.demo.persist.Omnibus;
import com.mycompany.demo.util.JPAUtil;

public class JPA09Test {

	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		
		// uso de JPA ENTITY PERSIST
		// Cuando cascade=CascadeType.PERSIST esta en entidad dominante
		// y despues se setean los datos desde la entidad dominante,
		// se realiza el persist en dominante con entityManager.persist(Object)
		Motor motor1 = new Motor("Motor 15F-226 Ferrari");
		Omnibus omnibus1 = new Omnibus("LINEA 73 SAC");
		omnibus1.setMotor(motor1);
		try {
			em.getTransaction().begin();
			em.persist(omnibus1);
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
