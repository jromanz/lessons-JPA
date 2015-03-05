package com.mycompany.demo.onetomany;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
public class Region {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	@OneToMany
	@LazyCollection(LazyCollectionOption.EXTRA)
	private List<Department> department;
	
	public Region() {
	}
	
	public Region(String name) {
		super();
		this.name = name;
	}
	public Region(Long id, String name) {
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

	public List<Department> getDepartment() {
		return department;
	}

	public void setDepartment(List<Department> department) {
		this.department = department;
	}
	
	
}
