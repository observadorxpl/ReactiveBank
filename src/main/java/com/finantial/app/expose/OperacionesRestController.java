package com.finantial.app.expose;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finantial.app.business.IOperacionesService;
import com.finantial.app.models.CuentaBancaria;
import com.finantial.app.models.OperacionBancariaDTO;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/operaciones")
public class OperacionesRestController {
	@Autowired
	private IOperacionesService operacionesService;
	
	@PostMapping(value = "/deposito")
	public Mono<CuentaBancaria> deposito(@RequestBody @Valid OperacionBancariaDTO dto){
		return operacionesService.deposito(dto);
	}
	
	@PostMapping(value = "/retiro")
	public Mono<CuentaBancaria> retiro(@RequestBody @Valid OperacionBancariaDTO dto){
		return operacionesService.retiro(dto);
	}
}
