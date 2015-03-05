package com.mycompany.demo.onetomany;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class DepartmentSimple {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	@ManyToOne
	@JoinColumn(name="region_id_fk")
	private RegionSimple regionSimple;
	
	
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
	public RegionSimple getRegionSimple() {
		return regionSimple;
	}
	public void setRegion(RegionSimple regionSimple) {
		this.regionSimple = regionSimple;
	}
	public DepartmentSimple() {
	}
	public DepartmentSimple(String name, RegionSimple regionSimple) {
		super();
		this.name = name;
		this.regionSimple = regionSimple;
	}


	public DepartmentSimple(Long id, String name, RegionSimple regionSimple) {
		super();
		this.id = id;
		this.name = name;
		this.regionSimple = regionSimple;
	}
	
}
