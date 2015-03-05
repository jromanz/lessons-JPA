package com.mycompany.demo.manytomany;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name = "Usuario.findById", query = "SELECT u from Usuario u WHERE u.id = :id"),
	@NamedQuery(name = "Usuario.findAll", query = "SELECT u from Usuario u")
})
public class Usuario {
	@Id
	@GeneratedValue
	private Integer id;
	@ManyToMany(mappedBy = "usuarios")
	private List<Rol> roles;
}
