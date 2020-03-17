package com.todo1;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.todo1.model.Origen;
import com.todo1.service.OrigenService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestOrigen {
	@Autowired
	private OrigenService serv;	
	private Origen norg;

	@Test
	public void crearOrigen() {
		Origen org = new Origen();
		org.setDescripcion("REVISTA");				
		norg = serv.crear(org);			
		assertEquals(org.getDescripcion(),norg.getDescripcion());	
	}
	
	@Test
	public void modificarOrigen() {
		Origen org = new Origen();
		org.setDescripcion("MATADOR");
		
		norg = serv.crear(org);
		norg.setDescripcion("modificado");
		
		Origen modtmov = new Origen();
		modtmov = serv.modificar(norg);
	    
		assertEquals(modtmov.getDescripcion(),norg.getDescripcion());
	}
	
	@After
	public void eliminarOrigen() {	
		serv.eliminar(norg);	
	}
}
