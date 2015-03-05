package com.mycompany.demo.onetomany;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Department {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	@ManyToOne
	@JoinColumn(name="region_id_fk")
	private Region region;
	
	
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
	public Region getRegion() {
		return region;
	}
	public void setRegion(Region region) {
		this.region = region;
	}
	public Department() {
	}
	public Department(String name, Region region) {
		super();
		this.name = name;
		this.region = region;
	}


	public Department(Long id, String name, Region region) {
		super();
		this.id = id;
		this.name = name;
		this.region = region;
	}
	
}
