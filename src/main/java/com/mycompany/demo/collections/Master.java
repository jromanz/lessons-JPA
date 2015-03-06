package com.mycompany.demo.collections;

import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_master")
public class Master {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descripcion;

	@ElementCollection
	@CollectionTable(name = "t_persona_tiene_emails")
	Set<String> emails;

	@ElementCollection(targetClass = RolUsuario.class)
	@Enumerated(EnumType.STRING)
	List<RolUsuario> roles;
	
	public Master() {
	}
	
	public Master(String descripcion, Set<String> emails, List<RolUsuario> roles) {
		super();
		this.descripcion = descripcion;
		this.emails = emails;
		this.roles = roles;
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

	public Set<String> getEmails() {
		return emails;
	}

	public void setEmails(Set<String> emails) {
		this.emails = emails;
	}

	public List<RolUsuario> getRoles() {
		return roles;
	}

	public void setRoles(List<RolUsuario> roles) {
		this.roles = roles;
	}

}
