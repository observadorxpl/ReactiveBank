package com.finantial.app.models;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
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
public class Movimiento {
	@Id
	private String IdMovimiento;
	
	@NotNull
	private CuentaBancaria cuentaBancaria;
	
	@NotEmpty
	private double monto;
	
	@NotEmpty
	private String tipoMovimiento;
	
	@NotEmpty
	private Date fechaMovimiento;

	public Movimiento(@NotNull CuentaBancaria cuentaBancaria, @NotEmpty double monto, @NotEmpty String tipoMovimiento,
			@NotEmpty Date fechaMovimiento) {
		super();
		this.cuentaBancaria = cuentaBancaria;
		this.monto = monto;
		this.tipoMovimiento = tipoMovimiento;
		this.fechaMovimiento = fechaMovimiento;
	}

	
}
