package com.mycompany.automoviles.lesson.test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.mycompany.demo.persist.Cachorro;
import com.mycompany.demo.persist.Doctor;
import com.mycompany.demo.persist.Laptop;
import com.mycompany.demo.util.JPAUtil;

public class JPA15Test {
	public static void main(String[] args) {

		EntityManager em = JPAUtil.getEntityManager();

		// uso de JPQL Parte II (en relaciones one-to-many)
		// uso de fetch join (evita lazyinitialization exception)

		String consultaJoinFetch = "select d, l from Doctor d "
				+ "join fetch d.laptops l "
				+ "where l.marca= :marca";
		
		String consultaJoin = "SELECT d.nombre, c.raza, c.nombre "
				+ "FROM Doctor d, Cachorro c "
				+ "WHERE d.id = c.doctorCachorro.id "
				+ "AND c.raza= :raza";
		try {

			// Llenando entidades Doctor, Cachorro, Laptop
			Doctor doctor1 = new Doctor("41091712", "Julio Román");
			Doctor doctor2 = new Doctor("41091713", "Julieta Román");
			Doctor doctor3 = new Doctor("41091714", "Facundo Román");
			Doctor doctor4 = new Doctor("41091715", "Claudia Román");

			Cachorro cachorro1 = new Cachorro("PITBUL", "Baby Sofia");
			Cachorro cachorro2 = new Cachorro("BULLTERRIER", "Britney");
			Cachorro cachorro3 = new Cachorro("SALCHICHA", "Gringo");
			Cachorro cachorro4 = new Cachorro("PEKINES", "Apache");
			Cachorro cachorro5 = new Cachorro("PITBUL", "Lobita");
			Cachorro cachorro6 = new Cachorro("BULLTERRIER", "Sofia");
			Cachorro cachorro7 = new Cachorro("SALCHICHA", "Charango");
			Cachorro cachorro8 = new Cachorro("PEKINES", "Tarzan");
			Cachorro cachorro9 = new Cachorro("PITBUL", "Josefina");
			Cachorro cachorro10 = new Cachorro("BULLTERRIER", "Coco");
			Cachorro cachorro11 = new Cachorro("PEKINES", "Martha");
			Cachorro cachorro12 = new Cachorro("PEKINES", "Cocorocus");
			Cachorro cachorro13 = new Cachorro("SALCHICHA", "Ernesto");
			Cachorro cachorro14 = new Cachorro("PEKINES", "Eliana");

			List<Cachorro> listaCachorro1 = new ArrayList<Cachorro>();
			listaCachorro1.add(cachorro1);
			listaCachorro1.add(cachorro2);
			listaCachorro1.add(cachorro4);

			// Seteo de los elementos del Collection
			for (Cachorro cachorro : listaCachorro1) {
				cachorro.setDoctor(doctor1);
			}

			List<Cachorro> listaCachorro2 = new ArrayList<Cachorro>();
			listaCachorro2.add(cachorro5);
			listaCachorro2.add(cachorro6);
			listaCachorro2.add(cachorro8);

			// Seteo de los elementos del Collection
			for (Cachorro cachorro : listaCachorro2) {
				cachorro.setDoctor(doctor2);
			}

			List<Cachorro> listaCachorro3 = new ArrayList<Cachorro>();
			listaCachorro3.add(cachorro7);
			listaCachorro3.add(cachorro9);
			listaCachorro3.add(cachorro10);
			listaCachorro3.add(cachorro11);

			// Seteo de los elementos del Collection
			for (Cachorro cachorro : listaCachorro3) {
				cachorro.setDoctor(doctor3);
			}

			List<Cachorro> listaCachorro4 = new ArrayList<Cachorro>();
			listaCachorro4.add(cachorro3);
			listaCachorro4.add(cachorro12);
			listaCachorro4.add(cachorro13);
			listaCachorro4.add(cachorro14);

			// Seteo de los elementos del Collection
			for (Cachorro cachorro : listaCachorro4) {
				cachorro.setDoctor(doctor4);
			}

			Laptop laptop1 = new Laptop("TOSHIBA", "Core i5 4 nucleos 2.5 ghz");
			Laptop laptop2 = new Laptop("DELL",
					"Inspiron 15 I5547 I7 4ta Gen 8gb 1tb Bluetooth 4.0");
			Laptop laptop3 = new Laptop("IBM", "Core i7 4 nucleos 1 terabyte");
			Laptop laptop4 = new Laptop("COMPAQ",
					"Core i7 4 nucleos 2 terabyte 4 gb. RAM");
			Laptop laptop5 = new Laptop("TOSHIBA", "Core i7 8 nucleos 4.5 ghz");
			Laptop laptop6 = new Laptop("LENOVO", "AMD 3.0 Ghz 6 nucleos");
			Laptop laptop7 = new Laptop("TOSHIBA",
					"P75-a7100 De 17 Full Hd Win 8.1 Ram 8gb");
			Laptop laptop8 = new Laptop("INTEL", "AMD 3.0 Ghz 6 nucleos");
			Laptop laptop9 = new Laptop("ACER", "Core i7 4 nucleos 6.5 ghz");
			Laptop laptop10 = new Laptop("LG", "AMD 3.0 Ghz 6 nucleos");
			Laptop laptop11 = new Laptop("HP", "Core i5 6 nucleos 7.5 ghz");
			Laptop laptop12 = new Laptop("ASUS",
					"AMD 3.0 Ghz TOUCHSCREEN 6 nucleos");
			Laptop laptop13 = new Laptop("HP", "Core i7 8 nucleos 8.5 ghz");
			Laptop laptop14 = new Laptop("LENOVO", "AMD 3.0 Ghz 6 nucleos");
			Laptop laptop15 = new Laptop("MSI",
					"Ge70 2oe-017us I7 Full Hd Video 2gb Blue-ray");
			Laptop laptop16 = new Laptop("LENOVO", "AMD 3.0 Ghz 6 nucleos");
			Laptop laptop17 = new Laptop("MSI", "Core i8 12 nucleos 9.5 ghz");
			Laptop laptop18 = new Laptop("HP",
					"Hp Pavilion 14-v006la, 14 Led, Amd Quad-core A8-64");

			List<Laptop> listaLaptops1 = new ArrayList<Laptop>();
			listaLaptops1.add(laptop1);
			listaLaptops1.add(laptop2);
			listaLaptops1.add(laptop3);
			listaLaptops1.add(laptop5);

			// Seteo de los elementos del Collection
			for (Laptop laptop : listaLaptops1) {
				laptop.setDoctor(doctor1);
			}

			List<Laptop> listaLaptops2 = new ArrayList<Laptop>();
			listaLaptops2.add(laptop4);
			listaLaptops2.add(laptop6);
			listaLaptops2.add(laptop8);

			// Seteo de los elementos del Collection
			for (Laptop laptop : listaLaptops2) {
				laptop.setDoctor(doctor2);
			}

			List<Laptop> listaLaptops3 = new ArrayList<Laptop>();
			listaLaptops3.add(laptop7);
			listaLaptops3.add(laptop9);
			listaLaptops3.add(laptop12);
			listaLaptops3.add(laptop13);
			listaLaptops3.add(laptop14);
			listaLaptops3.add(laptop15);

			// Seteo de los elementos del Collection
			for (Laptop laptop : listaLaptops3) {
				laptop.setDoctor(doctor3);
			}

			List<Laptop> listaLaptops4 = new ArrayList<Laptop>();
			listaLaptops4.add(laptop10);
			listaLaptops4.add(laptop11);
			listaLaptops4.add(laptop16);
			listaLaptops4.add(laptop17);
			listaLaptops4.add(laptop18);

			// Seteo de los elementos del Collection
			for (Laptop laptop : listaLaptops4) {
				laptop.setDoctor(doctor4);
			}

			doctor1.setCachorros(listaCachorro1);
			doctor1.setLaptops(listaLaptops1);
			doctor2.setCachorros(listaCachorro2);
			doctor2.setLaptops(listaLaptops2);
			doctor3.setCachorros(listaCachorro3);
			doctor3.setLaptops(listaLaptops3);
			doctor4.setCachorros(listaCachorro4);
			doctor4.setLaptops(listaLaptops4);

			// Aqui se persisten todas las entidades
			em.getTransaction().begin();
			em.persist(doctor1);
			em.persist(doctor2);
			em.persist(doctor3);
			em.persist(doctor4);
			em.getTransaction().commit();

			// Aqui comienza JPA
			// USO DE JOIN FETCH 
			em.getTransaction().begin();
			TypedQuery query = (TypedQuery) em.createQuery(consultaJoinFetch);
			query.setParameter("marca", "TOSHIBA");
			List lista = query.getResultList();
			for (Object object : lista) {
				System.out.println(object);
			}
			
			// USO DE QUERY AND JOIN (consulta se basa en dominante)
			Query queryJoin = em.createQuery(consultaJoin);
			queryJoin.setParameter("raza", "PEKINES");
			List<Object[]> listaJoin = queryJoin.getResultList();
			for (Object[] objectJoin : listaJoin) {
				System.out.println(objectJoin[0]+", "+objectJoin[1]+", "+objectJoin[2]);
			}
			
			//USO DE CRITERIABUILDER Y CRITERIAQUERY
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery cq = cb.createQuery();
			Root doctorRoot = cq.from(Doctor.class);
			
			
			
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
