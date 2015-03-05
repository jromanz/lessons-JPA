package com.mycompany.automoviles.lesson.test;

import javax.persistence.EntityManager;

import com.mycompany.demo.embedded.Cargo;
import com.mycompany.demo.embedded.Direccion;
import com.mycompany.demo.embedded.Documentacion;
import com.mycompany.demo.embedded.Funcionario;
import com.mycompany.demo.util.JPAUtil;

public class JPAHibernate3Test {
	
	public static void main(String[] args) {
		java.util.Date date = new java.util.Date(1978,9,18);
		java.sql.Date fechaNac = new java.sql.Date(date.getTime());
		
		EntityManager em = JPAUtil.getEntityManager();
		
		//Uso de @Embedded y @Embeddable
		//Uso de @AttributeOverride
		Direccion direccion = new Direccion();
		direccion.setCiudad("LIMA");
		direccion.setCp("511");
		direccion.setDireccion("Av. Los Portales 1120 Lima 11");
		direccion.setUf("UF-01");
		Cargo cargo = new Cargo("Gerente de Operaciones");
		Documentacion documentacion = new Documentacion("rg-001", "ord-001", "Gerencia Finanzas", "LIMA", "PERUANA");
		Funcionario funcionario = new Funcionario();
		funcionario.setNombre("Julio Román");
		funcionario.setDireccion(direccion);
		funcionario.setFechaNacimiento(fechaNac);
		funcionario.setDocumentacion(documentacion);
		
		try {
			em.getTransaction().begin();
			em.persist(cargo);
			funcionario.setCargo(cargo);
			em.persist(funcionario);
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
