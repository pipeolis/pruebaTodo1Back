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


import com.todo1.model.Producto;
import com.todo1.service.ProductoService;

@RestController
@RequestMapping("/producto")
public class ProductoRestController {
	
	@Autowired
	private ProductoService serv;
	
	@GetMapping
	public ResponseEntity<List<Producto>> listar(){
		return ResponseEntity.ok(serv.listar());
	}
	
	@PostMapping
	public ResponseEntity<Producto> insertar(@RequestBody Producto prod) {			
		return ResponseEntity.ok(serv.crear(prod));	
	}
	
	@PutMapping
	public ResponseEntity<Producto> modificar(@RequestBody Producto prod) {
		return ResponseEntity.ok(serv.modificar(prod));	
	}
	
	@DeleteMapping
	public void eliminar(@RequestBody Producto prod) {
		serv.eliminar(prod);		
	}
}
