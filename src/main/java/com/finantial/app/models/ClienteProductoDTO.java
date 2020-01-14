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
public class ClienteProductoDTO {
	private Cliente cliente;
	private List<Producto> productos;
	
	public void addProducto(Producto producto) {
		productos.add(producto);
	}
}
