package com.mycompany.demo.inheritance;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="t_hacienda")
public class Hacienda extends Inmueble{
	
	private double hectareas;

	public double getHectareas() {
		return hectareas;
	}

	public void setHectareas(double hectareas) {
		this.hectareas = hectareas;
	}
	
	
}
