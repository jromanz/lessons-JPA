package com.mycompany.automoviles.lesson.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.BeforeClass;
import org.junit.Test;

import com.mycompany.demo.metamodel.AlumnoPostGrado_;
import com.mycompany.demo.persist.AlumnoPostGrado;
import com.mycompany.demo.persist.CursoPostGrado;
import com.mycompany.demo.util.JPAUtil;

public class JPA19Test {

	// Uso de CRITERIA en tabla many-to-many

	@Test
	public void deberiaFuncionarCriteria() {
		
		EntityManager em = JPAUtil.getEntityManager();
		
		try {
			em.getTransaction().begin();

			CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
			
			CriteriaQuery<CursoPostGrado> cQuery1 = criteriaBuilder.createQuery(CursoPostGrado.class);
			Root<CursoPostGrado> rootCurso = cQuery1.from(CursoPostGrado.class);
			
			List<Predicate> condiciones = new ArrayList<Predicate>();
			
			String nombre = "%rqui%";
			if(nombre!=null){
				Path<String> atributoNombre = rootCurso.get("nombre");
				Predicate whereNombre = criteriaBuilder.like(atributoNombre, nombre);
				condiciones.add(whereNombre);
			}
			String codigo = "%001%";
			if(codigo!=null){
				Path<String> atributoCodigo = rootCurso.get("codigo");
				Predicate whereCodigo = criteriaBuilder.like(atributoCodigo, codigo);
				condiciones.add(whereCodigo);
			}
			
			Predicate[] condicionesComoArray = condiciones.toArray(new Predicate[condiciones.size()]);
			Predicate todasCondiciones = criteriaBuilder.or(condicionesComoArray);
			cQuery1.where(todasCondiciones);
			
			TypedQuery<CursoPostGrado> tquery1 = em.createQuery(cQuery1);
			List<CursoPostGrado> lquery1 = tquery1.getResultList();
			for (CursoPostGrado cursoPostGrado : lquery1) {
				System.out.println(cursoPostGrado);
			}
			
			
			assertNotNull(lquery1);
			assertEquals(lquery1.size(), 2);
			
			
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

	//Uso de MetaModel
	@Test
	public void deberiaFuncionarCriteriaUsandoMetaModel() {
		
		EntityManager em = JPAUtil.getEntityManager();
		
		try {
			em.getTransaction().begin();

			CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
			
			CriteriaQuery<AlumnoPostGrado> cQuery1 = criteriaBuilder.createQuery(AlumnoPostGrado.class);
			Root<AlumnoPostGrado> rootAlumno = cQuery1.from(AlumnoPostGrado.class);
			
			List<Predicate> condiciones = new ArrayList<Predicate>();
			
			String nombre = "%uli%";
			if(nombre!=null){
				Path<String> atributoNombre = rootAlumno.get(AlumnoPostGrado_.nombre);
				Predicate whereNombre = criteriaBuilder.like(atributoNombre, nombre);
				condiciones.add(whereNombre);
			}
			double peso = 70.5;
			if(peso>0){
				Path<Double> atributoPeso = rootAlumno.get(AlumnoPostGrado_.peso);
				Predicate wherePeso = criteriaBuilder.greaterThan(atributoPeso, peso);
				condiciones.add(wherePeso);
			}
			
			Predicate[] condicionesComoArray = condiciones.toArray(new Predicate[condiciones.size()]);
			Predicate todasCondiciones = criteriaBuilder.or(condicionesComoArray);
			cQuery1.where(todasCondiciones);
			
			TypedQuery<AlumnoPostGrado> tquery1 = em.createQuery(cQuery1);
			List<AlumnoPostGrado> lquery1 = tquery1.getResultList();
			for (AlumnoPostGrado alumnoPostGrado : lquery1) {
				System.out.println(alumnoPostGrado);
			}
			
			assertNotNull(lquery1);
			assertEquals(lquery1.size(), 6);
			
			
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
	
	@BeforeClass
	public static void testeandoCargaDeDatos() {

		EntityManager em = JPAUtil.getEntityManager();

		try {

			// Llenando entidades CursoPostGrado y AlumnoPostGrado
			AlumnoPostGrado alumno1 = new AlumnoPostGrado("41091712",
					"Julio Román", 82.3,
					new SimpleDateFormat("dd-MM-yyyy").parse("19-09-1978"));
			AlumnoPostGrado alumno2 = new AlumnoPostGrado("41091713",
					"Julieta Román", 59.0,
					new SimpleDateFormat("dd-MM-yyyy").parse("18-05-1988"));
			AlumnoPostGrado alumno3 = new AlumnoPostGrado("41091714",
					"Facundo Román", 60.5,
					new SimpleDateFormat("dd-MM-yyyy").parse("09-09-1985"));
			AlumnoPostGrado alumno4 = new AlumnoPostGrado("41091715",
					"Claudia Román", 55.9,
					new SimpleDateFormat("dd-MM-yyyy").parse("19-12-1990"));
			AlumnoPostGrado alumno5 = new AlumnoPostGrado("41091716",
					"Natalia Román", 61.8,
					new SimpleDateFormat("dd-MM-yyyy").parse("01-12-1992"));
			AlumnoPostGrado alumno6 = new AlumnoPostGrado("41091717",
					"Irene Román", 71.8,
					new SimpleDateFormat("dd-MM-yyyy").parse("31-12-1989"));
			AlumnoPostGrado alumno7 = new AlumnoPostGrado("41091718",
					"Mariane Román", 75.1,
					new SimpleDateFormat("dd-MM-yyyy").parse("15-08-1979"));
			AlumnoPostGrado alumno8 = new AlumnoPostGrado("41091719",
					"Federico Román", 67.5,
					new SimpleDateFormat("dd-MM-yyyy").parse("13-04-1982"));
			AlumnoPostGrado alumno9 = new AlumnoPostGrado("41091720",
					"Constantino Román", 63.8, new SimpleDateFormat(
							"dd-MM-yyyy").parse("19-09-1978"));
			AlumnoPostGrado alumno10 = new AlumnoPostGrado("41091721",
					"Mariane Veloso", 79.5,
					new SimpleDateFormat("dd-MM-yyyy").parse("27-10-1990"));
			AlumnoPostGrado alumno11 = new AlumnoPostGrado("41091722",
					"Irene Egler Aguiar", 80.6, new SimpleDateFormat(
							"dd-MM-yyyy").parse("22-02-1997"));

			CursoPostGrado curso1 = new CursoPostGrado("COD-001",
					"ALGORITMIA I", "Curso de 4 creditos");
			CursoPostGrado curso2 = new CursoPostGrado("COD-002",
					"ALGORITMIA II", "Curso de 3 creditos");
			CursoPostGrado curso3 = new CursoPostGrado("COD-003",
					"ALGORITMIA III", "Curso de 5 creditos");
			CursoPostGrado curso4 = new CursoPostGrado("COD-004",
					"Metodos Numericos I", "Curso de 2 creditos");
			CursoPostGrado curso5 = new CursoPostGrado("COD-005",
					"Arquitectura Computadores I", "Curso Especial Carrera");
			CursoPostGrado curso6 = new CursoPostGrado("COD-006",
					"Sistemas Distribuidos I", "Curso Especial Carrera");
			CursoPostGrado curso7 = new CursoPostGrado("COD-007",
					"Sistemas Distribuidos II", "Curso Especial Carrera");
			CursoPostGrado curso8 = new CursoPostGrado("COD-008",
					"Auditoria Informatica", "Curso de ultimo año");

			em.getTransaction().begin();

			List<AlumnoPostGrado> listaAlumnos1 = new ArrayList<AlumnoPostGrado>();
			listaAlumnos1.add(alumno1);
			listaAlumnos1.add(alumno2);
			listaAlumnos1.add(alumno3);
			listaAlumnos1.add(alumno5);
			listaAlumnos1.add(alumno7);
			listaAlumnos1.add(alumno9);

			curso1.setAlumnos(listaAlumnos1);

			List<AlumnoPostGrado> listaAlumnos2 = new ArrayList<AlumnoPostGrado>();
			listaAlumnos2.add(alumno2);
			listaAlumnos2.add(alumno4);
			listaAlumnos2.add(alumno6);
			listaAlumnos2.add(alumno8);
			listaAlumnos2.add(alumno10);

			curso2.setAlumnos(listaAlumnos2);

			List<AlumnoPostGrado> listaAlumnos3 = new ArrayList<AlumnoPostGrado>();
			listaAlumnos3.add(alumno1);
			listaAlumnos3.add(alumno2);
			listaAlumnos3.add(alumno3);
			listaAlumnos3.add(alumno4);
			listaAlumnos3.add(alumno5);
			listaAlumnos3.add(alumno6);
			listaAlumnos3.add(alumno7);
			listaAlumnos3.add(alumno8);
			listaAlumnos3.add(alumno9);
			listaAlumnos3.add(alumno10);
			listaAlumnos3.add(alumno11);

			curso3.setAlumnos(listaAlumnos3);

			List<AlumnoPostGrado> listaAlumnos4 = new ArrayList<AlumnoPostGrado>();
			listaAlumnos4.add(alumno2);
			listaAlumnos4.add(alumno3);
			listaAlumnos4.add(alumno6);
			listaAlumnos4.add(alumno7);
			listaAlumnos4.add(alumno9);
			listaAlumnos4.add(alumno11);

			curso4.setAlumnos(listaAlumnos4);

			List<AlumnoPostGrado> listaAlumnos5 = new ArrayList<AlumnoPostGrado>();
			listaAlumnos5.add(alumno1);
			listaAlumnos5.add(alumno2);
			listaAlumnos5.add(alumno8);
			listaAlumnos5.add(alumno9);
			listaAlumnos5.add(alumno10);
			listaAlumnos5.add(alumno11);

			curso5.setAlumnos(listaAlumnos5);

			List<AlumnoPostGrado> listaAlumnos6 = new ArrayList<AlumnoPostGrado>();
			listaAlumnos6.add(alumno2);
			listaAlumnos6.add(alumno3);
			listaAlumnos6.add(alumno4);
			listaAlumnos6.add(alumno5);
			listaAlumnos6.add(alumno6);
			listaAlumnos6.add(alumno8);
			listaAlumnos6.add(alumno9);

			curso6.setAlumnos(listaAlumnos6);

			List<AlumnoPostGrado> listaAlumnos7 = new ArrayList<AlumnoPostGrado>();
			listaAlumnos7.add(alumno1);
			listaAlumnos7.add(alumno3);
			listaAlumnos7.add(alumno4);
			listaAlumnos7.add(alumno5);
			listaAlumnos7.add(alumno6);
			listaAlumnos7.add(alumno8);
			listaAlumnos7.add(alumno9);
			listaAlumnos7.add(alumno10);
			listaAlumnos7.add(alumno11);

			curso7.setAlumnos(listaAlumnos7);

			//

			List<CursoPostGrado> listaCursos1 = new ArrayList<CursoPostGrado>();
			listaCursos1.add(curso1);
			listaCursos1.add(curso3);
			listaCursos1.add(curso5);
			listaCursos1.add(curso7);

			alumno1.setCursos(listaCursos1);

			List<CursoPostGrado> listaCursos2 = new ArrayList<CursoPostGrado>();
			listaCursos2.add(curso1);
			listaCursos2.add(curso2);
			listaCursos2.add(curso3);
			listaCursos2.add(curso4);
			listaCursos2.add(curso5);
			listaCursos2.add(curso6);

			alumno2.setCursos(listaCursos2);

			List<CursoPostGrado> listaCursos3 = new ArrayList<CursoPostGrado>();
			listaCursos3.add(curso1);
			listaCursos3.add(curso3);
			listaCursos3.add(curso4);
			listaCursos3.add(curso6);
			listaCursos3.add(curso7);

			alumno3.setCursos(listaCursos3);

			List<CursoPostGrado> listaCursos4 = new ArrayList<CursoPostGrado>();
			listaCursos4.add(curso2);
			listaCursos4.add(curso3);
			listaCursos4.add(curso6);
			listaCursos4.add(curso7);

			alumno4.setCursos(listaCursos4);

			List<CursoPostGrado> listaCursos5 = new ArrayList<CursoPostGrado>();
			listaCursos5.add(curso1);
			listaCursos5.add(curso3);
			listaCursos5.add(curso6);
			listaCursos5.add(curso7);

			alumno5.setCursos(listaCursos5);

			List<CursoPostGrado> listaCursos6 = new ArrayList<CursoPostGrado>();
			listaCursos6.add(curso2);
			listaCursos6.add(curso3);
			listaCursos6.add(curso4);
			listaCursos6.add(curso6);
			listaCursos6.add(curso7);

			alumno6.setCursos(listaCursos6);

			List<CursoPostGrado> listaCursos7 = new ArrayList<CursoPostGrado>();
			listaCursos7.add(curso1);
			listaCursos7.add(curso3);
			listaCursos7.add(curso4);

			alumno7.setCursos(listaCursos7);

			List<CursoPostGrado> listaCursos8 = new ArrayList<CursoPostGrado>();
			listaCursos8.add(curso2);
			listaCursos8.add(curso3);
			listaCursos8.add(curso5);
			listaCursos8.add(curso6);
			listaCursos8.add(curso7);

			alumno8.setCursos(listaCursos8);

			List<CursoPostGrado> listaCursos9 = new ArrayList<CursoPostGrado>();
			listaCursos9.add(curso1);
			listaCursos9.add(curso3);
			listaCursos9.add(curso4);
			listaCursos9.add(curso5);
			listaCursos9.add(curso6);
			listaCursos9.add(curso7);

			alumno9.setCursos(listaCursos9);

			List<CursoPostGrado> listaCursos10 = new ArrayList<CursoPostGrado>();
			listaCursos10.add(curso2);
			listaCursos10.add(curso3);
			listaCursos10.add(curso5);
			listaCursos10.add(curso7);

			alumno10.setCursos(listaCursos10);

			List<CursoPostGrado> listaCursos11 = new ArrayList<CursoPostGrado>();
			listaCursos11.add(curso3);
			listaCursos11.add(curso4);
			listaCursos11.add(curso5);
			listaCursos11.add(curso7);

			alumno11.setCursos(listaCursos11);

			em.persist(curso1);
			em.persist(curso2);
			em.persist(curso3);
			em.persist(curso4);
			em.persist(curso5);
			em.persist(curso6);
			em.persist(curso7);
			em.persist(curso8);

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
