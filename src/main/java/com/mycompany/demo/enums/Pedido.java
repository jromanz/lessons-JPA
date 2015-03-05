package com.mycompany.demo.enums;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name="t_pedido")
public class Pedido {
	
	@Enumerated
	private RolUsuario rolUsuario;
	
	@Enumerated(EnumType.STRING)
	private StatusCompra statusCompra;
}
