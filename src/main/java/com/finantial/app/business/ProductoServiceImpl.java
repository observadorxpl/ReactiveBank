package com.finantial.app.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finantial.app.models.Producto;
import com.finantial.app.repository.IProductoRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
public class ProductoServiceImpl implements IProductoService{

	@Autowired
	private IProductoRepository productoRepo;
	
	@Override
	public Flux<Producto> findAll() {
		return productoRepo.findAll();
	}

	@Override
	public Mono<Producto> finById(String id) {
		return productoRepo.findById(id);
	}

	@Override
	public Mono<Producto> save(Producto t) {
		return productoRepo.save(t);
	}

	@Override
	public Mono<Void> delete(Producto t) {
		return productoRepo.delete(t);
	}

	@Override
	public Mono<Void> deleteById(String id) {
		return productoRepo.deleteById(id);
	}
	
	
}