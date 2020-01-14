package com.finantial.app.expose;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finantial.app.business.ICuentaBancaria;
import com.finantial.app.models.Cliente;
import com.finantial.app.models.CuentaBancaria;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/cuentas")
public class CuentaBancariaRestController {
	@Autowired
	private ICuentaBancaria cuentaService;
	
	@GetMapping
	public Flux<CuentaBancaria> listarCuentaXCliente(@RequestBody Cliente cliente) {
		System.out.println(cliente);
		return cuentaService.listarProductosXCliente(cliente);
	}
}
