package com.mycompany.demo.onetomany;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class RegionSimple {
	@Id
	@GeneratedValue
	private Long id;
	private String name;

	public RegionSimple() {
	}

	public RegionSimple(String name) {
		super();
		this.name = name;
	}

	public RegionSimple(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
