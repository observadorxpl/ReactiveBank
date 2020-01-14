package com.finantial.app.business;

import com.finantial.app.models.Cliente;
import com.finantial.app.models.Movimiento;

import reactor.core.publisher.Flux;

public interface IMovimientoService extends ICRUD<Movimiento>{
	public Flux<Movimiento> listarMovimientosXCliente(Cliente cliente);
}
