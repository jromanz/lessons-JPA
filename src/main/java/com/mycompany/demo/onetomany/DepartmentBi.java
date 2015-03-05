package com.mycompany.demo.onetomany;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class DepartmentBi {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	@ManyToOne
	private RegionBi regionBi;
	
	public DepartmentBi() {
	}
	
	public DepartmentBi(String name) {
		super();
		this.name = name;
	}



	public DepartmentBi(String name, RegionBi regionBi) {
		super();
		this.name = name;
		this.regionBi = regionBi;
	}



	public DepartmentBi(Long id, String name, RegionBi regionBi) {
		super();
		this.id = id;
		this.name = name;
		this.regionBi = regionBi;
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

	public RegionBi getRegionBi() {
		return regionBi;
	}

	public void setRegionBi(RegionBi regionBi) {
		this.regionBi = regionBi;
	}

	@Override
	public String toString() {
		return "DepartmentBi [id=" + id + ", name=" + name + ", regionBi="
				+ regionBi + "]";
	}
	
	
}
