package com.mycompany.demo.onetoone2;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="one_to_one_computador")
public class Computador {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descripcion;
	
	@OneToOne
	@JoinColumn(name="teclado_llave_direccion")
	private Teclado teclado;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Computador(String descripcion, Teclado teclado) {
		super();
		this.descripcion = descripcion;
		this.teclado = teclado;
	}
	public Computador(Long id, String descripcion, Teclado teclado) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.teclado = teclado;
	}
	
	
	
}
