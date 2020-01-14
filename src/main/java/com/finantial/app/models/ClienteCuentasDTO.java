package com.finantial.app.models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ClienteCuentasDTO {
	private Cliente cliente;
	private List<Producto> productos;
	
}
