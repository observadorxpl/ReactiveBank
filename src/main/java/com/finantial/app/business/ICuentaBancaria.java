package com.finantial.app.business;

import com.finantial.app.models.Cliente;
import com.finantial.app.models.CuentaBancaria;

import reactor.core.publisher.Flux;

public interface ICuentaBancaria extends ICRUD<CuentaBancaria>{
	public Flux<CuentaBancaria> listarProductosXCliente(Cliente cliente);

}
