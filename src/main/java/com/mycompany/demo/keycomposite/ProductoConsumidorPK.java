package com.mycompany.demo.keycomposite;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Embeddable;

@Embeddable
public class ProductoConsumidorPK implements Serializable {

	private static final long serialVersionUID = -6487536952348412763L;
	
	private Integer consumidorId;
	private Integer productoId;
	private Date fecha;
	private String observacion;
	
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Integer getConsumidorId() {
		return consumidorId;
	}

	public void setConsumidorId(Integer consumidorId) {
		this.consumidorId = consumidorId;
	}

	public Integer getProductoId() {
		return productoId;
	}

	public void setProductoId(Integer productoId) {
		this.productoId = productoId;
	}

}
