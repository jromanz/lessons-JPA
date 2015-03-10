package com.mycompany.automoviles.lesson.test;

import javax.persistence.EntityManager;

import com.mycompany.demo.inheritance.Edificio;
import com.mycompany.demo.inheritance.Hacienda;
import com.mycompany.demo.inheritance.Microondas;
import com.mycompany.demo.inheritance.PersonaJuridica;
import com.mycompany.demo.inheritance.PersonaNatural;
import com.mycompany.demo.inheritance.Refrigeradora;
import com.mycompany.demo.multipletables.Cliente;
import com.mycompany.demo.util.JPAUtil;

public class JPA02Test {
	public static void main(String[] args) {
		
		//Persistiendo con @SecondaryTables
		EntityManager em = JPAUtil.getEntityManager();
		Cliente cliente = new Cliente();
		cliente.setNombre("Julio Román");
		cliente.setDireccion("Av. Juan Velasco 1340 Lima 42");
		cliente.setTelefono("5112598966");
		cliente.setEmail1("kalerguiz@gmail.com");
		cliente.setEmail2("jromanz@kalerguiz.com");
		try {
			em.getTransaction().begin();
			em.persist(cliente);
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
		
		//Usando herencia
		PersonaNatural natural = new PersonaNatural();
		natural.setNombre("Daniel Osvaldo");
		natural.setDni("41001414");
		
		PersonaJuridica juridica = new PersonaJuridica();
		juridica.setNombre("IMPORTACIONES CARRERA SRL");
		juridica.setRuc("191-26616704-0-58");
		//Graba datos en t_herenc_empleado
		// PersonaNatural   1 Daniel Osvaldo            NULL              41001414
		//PersonaJuridica  	2 IMPORTACIONES CARRERA SRL 191-26616704-0-58 NULL
		
		
		//Usando herencia Joined (Se crean 3 tablas)
		Edificio edificio = new Edificio();
		Hacienda hacienda = new Hacienda();
		edificio.setDireccion("Av. Tomas Marsano 1230 Surco");
		edificio.setPisos(12);
		hacienda.setDireccion("Av. Panamericana Sur S/N Km. 150");
		hacienda.setHectareas(550.5);
		// tabla inmueble
		//  1 Av. Tomas Marsano 1230 Surco
		//  2 Av. Panamericana Sur S/N Km. 150
		// tabla edificio	12		1
		// tabla hacienda   550.5  	2

		
		//Usando Herencia Inheritance.TABLE_PER_CLASS
		Microondas microondas = new Microondas();
		microondas.setDescripcion("Microondas SAMSUNG");
		microondas.setWatts(200.0);
		Refrigeradora refrigeradora = new Refrigeradora();
		refrigeradora.setAltura(1.80);
		refrigeradora.setDescripcion("Friolera COLDEX");
		refrigeradora.setPuertas(2);
		// Se crean dos tablas y Id debe ser GenerationType.TABLE
		// tabla microondas  	1 Microondas SAMSUNG 200.0
		// tabla refrigeradora  2 Friolera COLDEX    1.8       2

		em = JPAUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(natural);
			em.persist(juridica);
			em.persist(edificio);
			em.persist(hacienda);
			em.persist(microondas);
			em.persist(refrigeradora);
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
