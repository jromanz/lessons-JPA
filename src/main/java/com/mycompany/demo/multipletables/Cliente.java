package com.mycompany.demo.multipletables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;

@Entity
@Table(name = "t_cliente")
@SecondaryTables({
		@SecondaryTable(name = "t_cliente_contacts", pkJoinColumns = { @PrimaryKeyJoinColumn(name = "idCliente") }),
		@SecondaryTable(name = "t_cliente_email", pkJoinColumns = { @PrimaryKeyJoinColumn(name = "idCliente") }) })
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCliente;
	private String nombre;
	@Column(name = "cli_direccion", table = "t_cliente_contacts")
	private String direccion;
	@Column(name = "cli_telefono", table = "t_cliente_contacts")
	private String telefono;
	@Column(name = "cli_email1", table = "t_cliente_email")
	private String email1;
	@Column(name = "cli_email2", table = "t_cliente_email")
	private String email2;

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail1() {
		return email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

}
