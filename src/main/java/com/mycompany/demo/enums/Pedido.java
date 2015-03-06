package com.mycompany.demo.enums;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class Pedido {
	
	@Enumerated	//	EnumType.ORDINAL
	private RolUsuario rolUsuario;
	
	@Enumerated(EnumType.STRING)
	private StatusCompra statusCompra;
}
