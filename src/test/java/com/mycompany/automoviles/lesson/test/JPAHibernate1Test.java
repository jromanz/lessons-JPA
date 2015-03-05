package com.mycompany.automoviles.lesson.test;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.mycompany.demo.keycomposite.Alumno;
import com.mycompany.demo.keycomposite.AlumnoPK;
import com.mycompany.demo.onetomany.DepartmentBi;
import com.mycompany.demo.onetomany.RegionBi;
import com.mycompany.demo.onetoone.DetalleMarcaBiVariant;
import com.mycompany.demo.onetoone.Marca;
import com.mycompany.demo.onetoone.MarcaBiVariant;
import com.mycompany.demo.util.JPAUtil;

public class JPAHibernate1Test {
	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		Query query = em.createQuery("select m from Marca m",Marca.class);
		List<Marca> marcas = query.getResultList();
		for (Marca marca : marcas) {
			System.out.println(marca);
		}
		
		//Persistir el lado debil
		DetalleMarcaBiVariant detalleMarca = new DetalleMarcaBiVariant("Descripcion");
		MarcaBiVariant marca = new MarcaBiVariant(2015,"David Motolla","ALEMANIA");
		detalleMarca.setMarcaBiVariant(marca);
		marca.setDetalleMarcaBiVariant(detalleMarca);
		
		//Persistir el lado fuerte
		DetalleMarcaBiVariant detalleMarca2 = new DetalleMarcaBiVariant("Descripcion posterior");
		MarcaBiVariant marca2 = new MarcaBiVariant(2013,"Akiro Toriyama","TAIWAN");
		marca2.setDetalleMarcaBiVariant(detalleMarca2);
		
		//Habilitado la opción CascadeType.ALL
		try {
			em.getTransaction().begin();
			em.persist(detalleMarca);
			em.persist(marca2);
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

		em = JPAUtil.getEntityManager();
		MarcaBiVariant marca3 = em.find(MarcaBiVariant.class, 1L);
		System.out.println(marca3);
		
		
		//Persistir OneToMany con CascadeType.ALL
		DepartmentBi dept1 = new DepartmentBi("RR.HH.");
		DepartmentBi dept2 = new DepartmentBi("Contabilidad");
		DepartmentBi dept3 = new DepartmentBi("Logistica");
		DepartmentBi dept4 = new DepartmentBi("Operaciones");
		DepartmentBi dept5 = new DepartmentBi("Informatica");
		DepartmentBi dept6 = new DepartmentBi("Planeamiento");
		RegionBi region1 = new RegionBi("Lima");
		RegionBi region2 = new RegionBi("Trujillo");
		List<DepartmentBi> departments1 = Arrays.asList(dept1,dept2,dept3,dept4,dept5,dept6);
		List<DepartmentBi> departments2 = Arrays.asList(dept1,dept2,dept3,dept4,dept5);
		region1.setDepartmentBi(departments1);
		region2.setDepartmentBi(departments2);
		
		try {
			em.getTransaction().begin();
			em.persist(region1);
			em.persist(region2);
			em.getTransaction().commit();
		} catch (Exception e) {
			if(em.isOpen()){
				em.getTransaction().rollback();
			}
		}finally{
			if(em.isOpen()){
				em.close();
			}
		}
		
		//Persistiendo llave compuesta
		em = JPAUtil.getEntityManager();
		java.util.Date date = new java.util.Date();
		Alumno alumno01 = new Alumno("Julio Román","41091712","Alumno Ejemplar");
		Alumno alumno02 = new Alumno("Julieta Román","41091713","Alumna conflictiva");
		Alumno alumno03 = new Alumno("Mariane Veloso","41091714","Alumna con muchas habilidades");
		try {
			em.getTransaction().begin();
			em.persist(alumno01);
			em.persist(alumno02);
			em.persist(alumno03);
			AlumnoPK alumnoId = new AlumnoPK("Julieta Román", "41091713");
			Alumno alumnoFound = em.find(Alumno.class, alumnoId);
			System.out.println(alumnoFound);
			em.getTransaction().commit();
		} catch (Exception e) {
			if(em.isOpen()){
				em.getTransaction().rollback();
			}
		}finally{
			if(em.isOpen()){
				em.close();
			}
		}
		
		
	}
}
