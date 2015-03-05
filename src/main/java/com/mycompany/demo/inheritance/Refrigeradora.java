package com.mycompany.demo.inheritance;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "h_refrigeradora")
public class Refrigeradora extends Artefacto {
	private double altura;
	private Integer puertas;

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public Integer getPuertas() {
		return puertas;
	}

	public void setPuertas(Integer puertas) {
		this.puertas = puertas;
	}

}
