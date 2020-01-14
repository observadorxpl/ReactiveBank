package com.finantial.app.models;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@ToString
public class Producto {
	@Id
	private String idProducto;
	
	@NotEmpty
	private String descripcion;
	
	@NotEmpty
	private Integer codigoProducto;
	@Valid
	private TipoProducto tipoProducto;

	public Producto(@NotEmpty String descripcion, @Valid TipoProducto tipoProducto, @NotEmpty Integer codigoProducto) {
		super();
		this.descripcion = descripcion;
		this.tipoProducto = tipoProducto;
		this.codigoProducto = codigoProducto;
	}
	
}
