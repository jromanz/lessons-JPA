package com.mycompany.automoviles.lesson.test;

import javax.persistence.EntityManager;

import com.mycompany.demo.onetoone2.Computador;
import com.mycompany.demo.onetoone2.Direccion;
import com.mycompany.demo.onetoone2.Policia;
import com.mycompany.demo.onetoone2.Teclado;
import com.mycompany.demo.util.JPAUtil;

public class JPAHibernate5Test {
	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		
		//	Uso de OneToOne
		//	Aun en OneToOne debe existir relacion dominante
		// 	Tabla COMPUTADOR
		//	id, descripcion, teclado_id
		//	Tabla TECLADO
		//	id, ano, marca, modelo
		Teclado teclado1 = new Teclado("HALION", "HS-102", 2015);
		Computador computador1 = new Computador("CPU CORE i7", teclado1);
		
		//	Uso de OneToOne
		//	bidireccional con entidad dominante (mappedBy = "entity dominant")
		//	en bidireccional necesitas setear de los dos lados
		Direccion direccion1 = new Direccion("Av. Juan Velasco 1340 Lima 42");
		Policia policia1 = new Policia("Sargento Pimienta");
		policia1.setDireccion(direccion1);
		direccion1.setPolicia(policia1);
		
		try {
			em.getTransaction().begin();
			em.persist(teclado1);
			em.persist(computador1);
			em.persist(direccion1);
			em.persist(policia1);
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
