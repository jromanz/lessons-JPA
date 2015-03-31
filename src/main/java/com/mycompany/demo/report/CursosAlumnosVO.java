package com.mycompany.demo.report;

import com.mycompany.demo.persist.CursoPostGrado;

public class CursosAlumnosVO {
	
	private CursoPostGrado curso;
	private int total;
	
	public CursosAlumnosVO() {
	}

	public CursosAlumnosVO(CursoPostGrado curso, int total) {
		super();
		this.curso = curso;
		this.total = total;
	}

	public CursoPostGrado getCurso() {
		return curso;
	}

	public void setCurso(CursoPostGrado curso) {
		this.curso = curso;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	
}
