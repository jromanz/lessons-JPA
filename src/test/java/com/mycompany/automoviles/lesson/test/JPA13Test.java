package com.mycompany.automoviles.lesson.test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.mycompany.demo.persist.Canal;
import com.mycompany.demo.persist.Televisor;
import com.mycompany.demo.util.JPAUtil;

public class JPA13Test {

	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();

		// uso de JPA ENTITY PERSIST
		// uso de Collection en MANY-TO-MANY
		// Este en el entity dominante
		// @ManyToMany(cascade = CascadeType.MERGE)
		// @JoinTable(name = "persist_manytomany_televisor_canal",
		// joinColumns = {@JoinColumn(name="cana_id")},
		// inverseJoinColumns = {@JoinColumn(name="tele_id")})
		// Este en el entity no-dominante
		// @ManyToMany(mappedBy = "canales", cascade = CascadeType.MERGE)
		// private Collection<Televisor> televisores;

		Canal canal1 = new Canal("CANAL 2", "FRECUENCIA LATINA", "LIMA");
		Canal canal2 = new Canal("CANAL 5", "PANAMERICANA TELEVISION", "LIMA");
		Canal canal3 = new Canal("CANAL 4", "AMERICA TELEVISION", "LIMA");
		Canal canal4 = new Canal("CANAL CMD", "CABLE MAGICO", "TRUJILLO");

		Televisor tele1 = new Televisor("TV SAMSUNG 19 pp", "SMG-2014",
				"SAMSUNG", "156-446-RRZ");
		Televisor tele2 = new Televisor("TV LG 22 pp", "MV-2015", "LG",
				"000-500-RAR");
		Televisor tele3 = new Televisor("PANASONIC 52 pp", "PN-2014",
				"PANASONIC", "650-001-560-789");
		Televisor tele4 = new Televisor("TV FLATRON 19 pp", "FLT-2012",
				"FLATRON", "GRD-001-000-RRS");
		Televisor tele5 = new Televisor("TV MONITOR SAMSUNG 32 pp", "SMG-2014",
				"SAMSUNG", "5000-5200-RRZ-990");

		List<Televisor> listaTele1 = new ArrayList<Televisor>();
		listaTele1.add(tele1);
		listaTele1.add(tele3);
		listaTele1.add(tele4);
		canal1.setTelevisores(listaTele1);
		List<Televisor> listaTele2 = new ArrayList<Televisor>();
		listaTele2.add(tele1);
		listaTele2.add(tele2);
		listaTele2.add(tele3);
		listaTele2.add(tele4);
		canal2.setTelevisores(listaTele2);
		List<Televisor> listaTele3 = new ArrayList<Televisor>();
		listaTele3.add(tele4);
		listaTele3.add(tele5);
		canal3.setTelevisores(listaTele3);
		List<Televisor> listaTele4 = new ArrayList<Televisor>();
		listaTele4.add(tele5);
		canal4.setTelevisores(listaTele4);
		
		try {
			em.getTransaction().begin();
			em.persist(canal1);
			em.persist(canal2);
			em.persist(canal3);
			em.persist(canal4);
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
