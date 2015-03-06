package com.mycompany.demo.onetoone2;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="one_to_one_direccion")
public class Direccion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombreCalle;
	
	@OneToOne(mappedBy="direccion")	//entidad dominante en mappedBy
	private Policia policia;
	
	public Direccion(String nombreCalle) {
		super();
		this.nombreCalle = nombreCalle;
	}

	public Direccion(String nombreCalle, Policia empleado) {
		super();
		this.nombreCalle = nombreCalle;
		this.policia = empleado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreCalle() {
		return nombreCalle;
	}

	public void setNombreCalle(String nombreCalle) {
		this.nombreCalle = nombreCalle;
	}

	public Policia getPolicia() {
		return policia;
	}

	public void setPolicia(Policia policia) {
		this.policia = policia;
	}

	
	
	
}
