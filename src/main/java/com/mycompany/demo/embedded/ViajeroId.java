package com.mycompany.demo.embedded;

import java.io.Serializable;

public class ViajeroId implements Serializable {

	private static final long serialVersionUID = -1969863619841421139L;
	private String dni;
	private String pasaporte;

	public ViajeroId() {
	}

	public ViajeroId(String dni, String pasaporte) {
		super();
		this.dni = dni;
		this.pasaporte = pasaporte;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getPasaporte() {
		return pasaporte;
	}

	public void setPasaporte(String pasaporte) {
		this.pasaporte = pasaporte;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		result = prime * result
				+ ((pasaporte == null) ? 0 : pasaporte.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ViajeroId other = (ViajeroId) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		if (pasaporte == null) {
			if (other.pasaporte != null)
				return false;
		} else if (!pasaporte.equals(other.pasaporte))
			return false;
		return true;
	}

}
