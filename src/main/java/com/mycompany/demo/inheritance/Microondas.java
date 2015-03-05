package com.mycompany.demo.inheritance;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="h_microondas")
public class Microondas extends Artefacto{
	private double watts;

	public double getWatts() {
		return watts;
	}

	public void setWatts(double watts) {
		this.watts = watts;
	}
	
	
}
