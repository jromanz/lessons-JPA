package com.mycompany.demo.report;

public class DoctorByCachorroRaza {
	
	private String dniDoctor;
	private String nombreDoctor;
	private String razaCachorro;
	private String nombreCachorro;
	
	public DoctorByCachorroRaza() {
	}
	
	public DoctorByCachorroRaza(String dniDoctor, String nombreDoctor,
			String razaCachorro, String nombreCachorro) {
		super();
		this.dniDoctor = dniDoctor;
		this.nombreDoctor = nombreDoctor;
		this.razaCachorro = razaCachorro;
		this.nombreCachorro = nombreCachorro;
	}

	public String getDniDoctor() {
		return dniDoctor;
	}
	public void setDniDoctor(String dniDoctor) {
		this.dniDoctor = dniDoctor;
	}
	public String getNombreDoctor() {
		return nombreDoctor;
	}
	public void setNombreDoctor(String nombreDoctor) {
		this.nombreDoctor = nombreDoctor;
	}
	public String getRazaCachorro() {
		return razaCachorro;
	}
	public void setRazaCachorro(String razaCachorro) {
		this.razaCachorro = razaCachorro;
	}
	public String getNombreCachorro() {
		return nombreCachorro;
	}
	public void setNombreCachorro(String nombreCachorro) {
		this.nombreCachorro = nombreCachorro;
	}

	@Override
	public String toString() {
		return "DoctorByCachorroRaza [dniDoctor=" + dniDoctor
				+ ", nombreDoctor=" + nombreDoctor + ", razaCachorro="
				+ razaCachorro + ", nombreCachorro=" + nombreCachorro + "]";
	}
	
	
}
