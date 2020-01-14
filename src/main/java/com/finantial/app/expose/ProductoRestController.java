package com.finantial.app.expose;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finantial.app.business.IProductoService;
import com.finantial.app.models.Producto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/productos")
public class ProductoRestController {
	@Autowired
	private IProductoService productoService;

	@GetMapping
	public Flux<Producto> listarAllClientes() {
		return productoService.findAll();
	}

	@GetMapping("/{id}")
	public Mono<Producto> buscarCliente(@PathVariable String id) {
		return productoService.finById(id);
	}

	@PostMapping
	public Mono<Producto> registrarCliente(@RequestBody Producto producto) {
		return productoService.save(producto);
	}

	@PutMapping
	public Mono<Producto> actualizarCliente(@RequestBody Producto producto) {
		return productoService.save(producto);
	}

	@DeleteMapping("/{id}")
	public Mono<Void> eliminarCliente(@PathVariable String id){
		return productoService.deleteById(id);
	}
}
