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


import com.todo1.model.Origen;
import com.todo1.service.DataBaseService;
import com.todo1.service.OrigenService;

@RestController
@RequestMapping("/origen")
public class OrigenRestController {
	
	@Autowired
	private OrigenService serv;
	
	@Autowired
	private DataBaseService dbserv;
	
	
	
	@GetMapping
	public ResponseEntity<List<Origen>> listar(){
		dbserv.validarAccesoDataBase();
		return ResponseEntity.ok(serv.listar());
	}
	
	@PostMapping
	public ResponseEntity<Origen> insertar(@RequestBody Origen org) {	
		dbserv.validarAccesoDataBase();
		return ResponseEntity.ok(serv.crear(org));	
	}
	
	@PutMapping
	public ResponseEntity<Origen> modificar(@RequestBody Origen org) {
		dbserv.validarAccesoDataBase();
		return ResponseEntity.ok(serv.modificar(org));	
	}
	
	@DeleteMapping
	public void eliminar(@RequestBody Origen org) {
		dbserv.validarAccesoDataBase();
		serv.eliminar(org);		
	}
}
