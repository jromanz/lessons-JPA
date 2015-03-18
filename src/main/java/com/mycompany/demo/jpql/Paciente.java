package com.mycompany.demo.jpql;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

@Entity
@Table(name = "jpql_paciente")
public class Paciente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "ID_PACI")
	private Integer id;
	@Column(name = "NOMBRE_PACI")
	private String nombrePaci;
	@Size(max = 45)
	@Column(name = "APEPATERNO_PACI")
	private String apepaternoPaci;
	@Size(max = 45)
	@Column(name = "APEMATERNO_PACI")
	private String apematernoPaci;
	@Column(name = "FECHAING_PACI")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaingPaci;
	@Size(max = 100)
	@Column(name = "DIRECCION_PACI")
	private String direccionPaci;
	@Size(max = 20)
	@Column(name = "NUMEROTEL_PACI")
	private String numerotelPaci;

	public Paciente(String nombrePaci, String apepaternoPaci,
			String apematernoPaci, Date fechaingPaci, String direccionPaci,
			String numerotelPaci) {
		super();
		this.nombrePaci = nombrePaci;
		this.apepaternoPaci = apepaternoPaci;
		this.apematernoPaci = apematernoPaci;
		this.fechaingPaci = fechaingPaci;
		this.direccionPaci = direccionPaci;
		this.numerotelPaci = numerotelPaci;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombrePaci() {
		return nombrePaci;
	}

	public void setNombrePaci(String nombrePaci) {
		this.nombrePaci = nombrePaci;
	}

	public String getApepaternoPaci() {
		return apepaternoPaci;
	}

	public void setApepaternoPaci(String apepaternoPaci) {
		this.apepaternoPaci = apepaternoPaci;
	}

	public String getApematernoPaci() {
		return apematernoPaci;
	}

	public void setApematernoPaci(String apematernoPaci) {
		this.apematernoPaci = apematernoPaci;
	}

	public Date getFechaingPaci() {
		return fechaingPaci;
	}

	public void setFechaingPaci(Date fechaingPaci) {
		this.fechaingPaci = fechaingPaci;
	}

	public String getDireccionPaci() {
		return direccionPaci;
	}

	public void setDireccionPaci(String direccionPaci) {
		this.direccionPaci = direccionPaci;
	}

	public String getNumerotelPaci() {
		return numerotelPaci;
	}

	public void setNumerotelPaci(String numerotelPaci) {
		this.numerotelPaci = numerotelPaci;
	}

	@Override
	public String toString() {
		return "Paciente [id=" + id + ", nombrePaci=" + nombrePaci
				+ ", apepaternoPaci=" + apepaternoPaci + ", apematernoPaci="
				+ apematernoPaci + ", fechaingPaci=" + fechaingPaci
				+ ", direccionPaci=" + direccionPaci + ", numerotelPaci="
				+ numerotelPaci + "]";
	}
}
