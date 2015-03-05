package com.mycompany.demo.embedded;

import java.sql.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Funcionario {
	@Id
	@GeneratedValue
	private Long id;
	private String nombre;
	private Date fechaNacimiento;
	
	@Embedded
	private Documentacion documentacion;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="ciudad",column=@Column(name="v_ciudad")),
		@AttributeOverride(name="cp",column=@Column(name="v_cp")),
		@AttributeOverride(name="direccion",column=@Column(name="v_direccion")),
		@AttributeOverride(name="uf",column=@Column(name="v_uf"))
	})
	private Direccion direccion;
	
	@ManyToOne
	private Cargo cargo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Documentacion getDocumentacion() {
		return documentacion;
	}

	public void setDocumentacion(Documentacion documentacion) {
		this.documentacion = documentacion;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	
	
}
