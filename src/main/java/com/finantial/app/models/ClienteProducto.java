package com.finantial.app.models;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ClienteProducto {
	@Id
	private String clienteProductosId;
	@NotNull
	private Cliente cliente;
	@NotNull
	private Producto producto;

	public ClienteProducto(@NotNull Cliente cliente, @NotNull Producto producto) {
		super();
		this.cliente = cliente;
		this.producto = producto;
	}

}
