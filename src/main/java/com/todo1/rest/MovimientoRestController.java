package com.todo1.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo1.model.Movimiento;
import com.todo1.service.DataBaseService;
import com.todo1.service.MovimientoService;

@RestController
@RequestMapping("/movimiento")
public class MovimientoRestController {
	Logger log = LoggerFactory.getLogger(MovimientoRestController.class);
	
	@Autowired
	private MovimientoService serv;	
	
	@Autowired
	private DataBaseService dbserv;
	
	@GetMapping
	public ResponseEntity<List<Movimiento>> listar(){
		dbserv.validarAccesoDataBase();
		return ResponseEntity.ok(serv.listar());
	} 
	
	@PostMapping
	public ResponseEntity<Movimiento> insertar(@RequestBody Movimiento mov){		
		dbserv.validarAccesoDataBase();
		return ResponseEntity.ok(serv.crear(mov));		
	}
}
