package com.finantial.app.expose;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finantial.app.business.IMovimientoService;
import com.finantial.app.models.Cliente;
import com.finantial.app.models.Movimiento;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/movimientos")
public class MovimientoRestController {
	
	@Autowired
	private IMovimientoService movimientoService;
	
	@GetMapping
	public Flux<Movimiento> listarCuentaXCliente(@RequestBody Cliente cliente) {
		System.out.println(cliente);
		return movimientoService.listarMovimientosXCliente(cliente);
	}
}
