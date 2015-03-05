package com.mycompany.demo.onetomany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
public class RegionBi {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	@OneToMany(mappedBy = "regionBi", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.EXTRA)
	private List<DepartmentBi> departmentBi;

	public RegionBi() {
	}

	public RegionBi(String name, List<DepartmentBi> departmentBi) {
		super();
		this.name = name;
		this.departmentBi = departmentBi;
	}

	public RegionBi(String name) {
		super();
		this.name = name;
	}

	public RegionBi(Long id, String name, List<DepartmentBi> departmentBi) {
		super();
		this.id = id;
		this.name = name;
		this.departmentBi = departmentBi;
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

	public List<DepartmentBi> getDepartmentBi() {
		return departmentBi;
	}

	public void setDepartmentBi(List<DepartmentBi> departmentBi) {
		this.departmentBi = departmentBi;
	}

}
