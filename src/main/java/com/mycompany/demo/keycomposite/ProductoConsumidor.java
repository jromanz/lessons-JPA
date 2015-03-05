package com.mycompany.demo.keycomposite;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class ProductoConsumidor {
	@EmbeddedId
	private ProductoConsumidorPK id;
}
