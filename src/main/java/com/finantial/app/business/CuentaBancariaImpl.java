package com.finantial.app.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finantial.app.models.Cliente;
import com.finantial.app.models.CuentaBancaria;
import com.finantial.app.repository.IClienteRepository;
import com.finantial.app.repository.ICuentaBancariaRepo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
public class CuentaBancariaImpl implements ICuentaBancaria{	
	@Autowired
	private ICuentaBancariaRepo cuentaRepo;
	
	@Autowired
	private IClienteRepository clienteRepo;
	@Override
	public Flux<CuentaBancaria> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<CuentaBancaria> finById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public Mono<CuentaBancaria> save(CuentaBancaria cuenta) {
		cuenta.setNumeroCuenta(cuenta.generarNumeroCuenta("876", 10));
		cuenta.setClave(cuenta.getClave());
		cuenta.setSaldo(0.00);
		cuenta.setTipoCuenta("Basic");
		cuenta.setEstado(true);
		return cuentaRepo.save(cuenta);
	}

	@Override
	public Mono<Void> delete(CuentaBancaria t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Void> deleteById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flux<CuentaBancaria> listarProductosXCliente(Cliente cliente) {
		return cuentaRepo.findByCliente(cliente);
	}


}
