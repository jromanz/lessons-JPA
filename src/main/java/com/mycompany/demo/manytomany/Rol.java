package com.mycompany.demo.manytomany;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
		@NamedQuery(name = "Rol.findById", query = "SELECT r FROM Rol r where r.id = :id"),
		@NamedQuery(name = "Rol.findAll", query = "SELECT r FROM Rol r") })
public class Rol {
	@Id
	@GeneratedValue
	private Integer id;
	@ManyToMany
	@JoinTable(name = "t_usuario_rol", joinColumns = @JoinColumn(name = "idusuario"), inverseJoinColumns = @JoinColumn(name = "idrol"))
	private List<Usuario> usuarios;
}
