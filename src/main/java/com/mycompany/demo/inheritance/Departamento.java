package com.mycompany.demo.inheritance;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Departamento {
	private String nombre;

	public abstract void calcularGastosMes();

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
