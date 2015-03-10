package com.mycompany.demo.persist;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "persist_menu")
public class Menu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descripcion;
	@OneToOne(cascade = CascadeType.PERSIST, orphanRemoval = true)
	private SubItem subItem;

	@OneToOne(cascade = CascadeType.PERSIST, orphanRemoval = true)
	private SubItem2 subItem2;

	public Menu() {
	}

	public Menu(String descripcion) {
		super();
		this.descripcion = descripcion;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public SubItem getSubItem() {
		return subItem;
	}

	public void setSubItem(SubItem subItem) {
		this.subItem = subItem;
	}

	public SubItem2 getSubItem2() {
		return subItem2;
	}

	public void setSubItem2(SubItem2 subItem2) {
		this.subItem2 = subItem2;
	}

}
