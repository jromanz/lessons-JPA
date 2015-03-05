package com.mycompany.demo.manytomany;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Camion {
	@Id
	@GeneratedValue
	private Integer id;
	@ManyToMany
	@JoinTable(	name = "T_CAMION_OPCIONAL",
				joinColumns=@JoinColumn(name="CAMION_ID"),
				inverseJoinColumns=@JoinColumn(name="OPCIONAL_ID")
				
			)
	private List<Opcional> opcionales;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Opcional> getOpcionales() {
		return opcionales;
	}

	public void setOpcionales(List<Opcional> opcionales) {
		this.opcionales = opcionales;
	}

}
