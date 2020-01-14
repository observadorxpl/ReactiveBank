package com.finantial.app.business;

import com.finantial.app.models.CuentaBancaria;
import com.finantial.app.models.OperacionBancariaDTO;

import reactor.core.publisher.Mono;

public interface IOperacionesService{
	public Mono<CuentaBancaria> retiro (OperacionBancariaDTO dto);
	public Mono<CuentaBancaria> deposito (OperacionBancariaDTO dto);
}
