package com.mycompany.automoviles.lesson.test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.EntityManager;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.mycompany.demo.persist.Cachorro;
import com.mycompany.demo.persist.Doctor;
import com.mycompany.demo.persist.Laptop;
import com.mycompany.demo.util.JPAUtil;

public class JPA12Test {

	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();

		// uso de JPA ENTITY PERSIST
		// Problemas recurrentes con FetchType
		// Relacion ONE-TO-MANY
		// Uso de Collections en entity dominante
		// 	@OneToMany(mappedBy = "doctorCachorro", cascade = CascadeType.PERSIST)
		//	@LazyCollection(LazyCollectionOption.FALSE)
		// Aqui en entity dominada (no olvidar poner en dominante @Column(name="doctor_id"))
		//	@JoinColumn(name = "doctor_id")
		//	private Doctor doctorCachorro
		
		try {
			em.getTransaction().begin();
			
			Doctor doctor1 = new Doctor("41091712", "Julio Román");
			Doctor doctor2 = new Doctor("41091713", "Julieta Román");
			
			Cachorro cachorro1 = new Cachorro("PITBUL", "Baby Sofia");
			Cachorro cachorro2 = new Cachorro("BULLTERRIER", "Britney");
			Cachorro cachorro3 = new Cachorro("SALCHICHA", "Gringo");

			List<Cachorro> listaCachorro1 = new ArrayList<Cachorro>();
			listaCachorro1.add(cachorro1);
			listaCachorro1.add(cachorro2);
			
			//Seteo de los elementos del Collection
			for (Cachorro cachorro : listaCachorro1) {
				cachorro.setDoctor(doctor1);
			}
			
			List<Cachorro> listaCachorro2 = new ArrayList<Cachorro>();
			listaCachorro2.add(cachorro3);
			
			//Seteo de los elementos del Collection			
			for (Cachorro cachorro : listaCachorro2) {
				cachorro.setDoctor(doctor2);
			}
			
			Laptop laptop1 = new Laptop("TOSHIBA", "Core i5 4 nucleos 2.5 ghz");
			Laptop laptop2 = new Laptop("DELL", "Core i7 2 nucleos 3.5 ghz");
			Laptop laptop3 = new Laptop("IBM", "Core i7 4 nucleos 1 terabyte");
			Laptop laptop4 = new Laptop("COMPAQ",
					"Core i7 4 nucleos 2 terabyte 4 gb. RAM");
			
			List<Laptop> listaLaptops1 = new ArrayList<Laptop>();
			listaLaptops1.add(laptop1);
			listaLaptops1.add(laptop2);
			
			//Seteo de los elementos del Collection			
			for (Laptop laptop : listaLaptops1) {
				laptop.setDoctor(doctor1);
			}
			
			List<Laptop> listaLaptops2 = new ArrayList<Laptop>();
			listaLaptops2.add(laptop3);
			listaLaptops2.add(laptop4);
			//Seteo de los elementos del Collection
			for (Laptop laptop : listaLaptops2) {
				laptop.setDoctor(doctor2);
			}
			
			doctor1.setCachorros(listaCachorro1);
			doctor1.setLaptops(listaLaptops1);
			doctor2.setCachorros(listaCachorro2);
			doctor2.setLaptops(listaLaptops2);

			em.persist(doctor1);
			em.getTransaction().commit();
			em.getTransaction().begin();
			em.persist(doctor2);
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
