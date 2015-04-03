package com.mycompany.demo.metamodel;

import java.util.Collections;
import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.metamodel.PluralAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.mycompany.demo.persist.AlumnoPostGrado;
import com.mycompany.demo.persist.CursoPostGrado;

@Generated(value = "org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor")
@StaticMetamodel(AlumnoPostGrado.class)
public abstract class AlumnoPostGrado_ {

	public static volatile SingularAttribute<AlumnoPostGrado, Integer> id;
	public static volatile SingularAttribute<AlumnoPostGrado, String> dni;
	public static volatile SingularAttribute<AlumnoPostGrado, String> nombre;
	public static volatile SingularAttribute<AlumnoPostGrado, Double> peso;
	public static volatile SingularAttribute<AlumnoPostGrado, Date> fechaNac;
	public static volatile PluralAttribute<AlumnoPostGrado, Collections, CursoPostGrado> cursos;

}
