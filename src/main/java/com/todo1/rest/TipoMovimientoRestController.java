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


import com.todo1.model.TipoMovimiento;
import com.todo1.service.DataBaseService;
import com.todo1.service.TipoMovimientoService;

@RestController
@RequestMapping("/tipomovimiento")
public class TipoMovimientoRestController {
	
	@Autowired
	private TipoMovimientoService serv;
	
	@Autowired
	private DataBaseService dbserv;	
	
	@GetMapping
	public ResponseEntity<List<TipoMovimiento>> listar(){
		dbserv.validarAccesoDataBase();
		return ResponseEntity.ok(serv.listar());
	}
	
	@PostMapping
	public ResponseEntity<TipoMovimiento> insertar(@RequestBody TipoMovimiento tmov) {
		dbserv.validarAccesoDataBase();
		return ResponseEntity.ok(serv.crear(tmov));	
	}
	
	@PutMapping
	public ResponseEntity<TipoMovimiento> modificar(@RequestBody TipoMovimiento tmov) {
		dbserv.validarAccesoDataBase();
		return ResponseEntity.ok(serv.modificar(tmov));	
	}
	
	@DeleteMapping
	public void eliminar(@RequestBody TipoMovimiento tmov) {
		dbserv.validarAccesoDataBase();
		serv.eliminar(tmov);		
	}
}
