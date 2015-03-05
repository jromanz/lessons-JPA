package com.mycompany.demo.inheritance;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="t_edificio")
public class Edificio extends Inmueble{
	
	private Integer pisos;

	public Integer getPisos() {
		return pisos;
	}

	public void setPisos(Integer pisos) {
		this.pisos = pisos;
	}
	
}
