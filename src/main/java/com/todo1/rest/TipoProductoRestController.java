package com.todo1.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.todo1.model.TipoProducto;
import com.todo1.service.TipoProductoService;

@RestController
@RequestMapping("/tipoproducto")
public class TipoProductoRestController {
	
	@Autowired
	private TipoProductoService serv;
	
	@GetMapping
	public ResponseEntity<List<TipoProducto>> listar(){
		return ResponseEntity.ok(serv.listar());
	}
	
	@PostMapping
	public ResponseEntity<TipoProducto> insertar(@RequestBody TipoProducto tprod) {			
		return ResponseEntity.ok(serv.crear(tprod));	
	}
	
	@PutMapping
	public ResponseEntity<TipoProducto> modificar(@RequestBody TipoProducto tprod) {
		return ResponseEntity.ok(serv.modificar(tprod));	
	}
	
	@DeleteMapping
	public void eliminar(@RequestBody TipoProducto tprod) {
		serv.eliminar(tprod);		
	}
}
