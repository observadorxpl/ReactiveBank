package com.finantial.app.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finantial.app.models.Cliente;
import com.finantial.app.models.Movimiento;
import com.finantial.app.repository.IMovimientoRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MovimientoServiceImpl implements IMovimientoService{
	
	@Autowired
	private IMovimientoRepository movimientoRepository;
	
	@Override
	public Flux<Movimiento> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Movimiento> finById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Movimiento> save(Movimiento t) {
		return movimientoRepository.save(t);
	}

	@Override
	public Mono<Void> delete(Movimiento t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Void> deleteById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flux<Movimiento> listarMovimientosXCliente(Cliente cliente) {
		return movimientoRepository.findByCliente(cliente);
	}

}
