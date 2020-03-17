package com.todo1;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.todo1.model.TipoMovimiento;
import com.todo1.service.TipoMovimientoService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TestTipoMovimiento {
	@Autowired
	private TipoMovimientoService serv;	
	private TipoMovimiento ntmov;

	@Test
	public void crearTipoMovimiento() {
		TipoMovimiento tmov = new TipoMovimiento();
		tmov.setDescripcion("ALQUILER");
				
		ntmov = serv.crear(tmov);			
		assertEquals(ntmov.getDescripcion(),tmov.getDescripcion());
		
	}
	
	@Test
	public void modificarTipoMovimiento() {
		TipoMovimiento tmov = new TipoMovimiento();
		tmov.setDescripcion("HOLA");
		
		ntmov = serv.crear(tmov);
		ntmov.setDescripcion("modificado");
		
		TipoMovimiento modtmov = new TipoMovimiento();
		modtmov = serv.modificar(ntmov);
	    
		assertEquals(ntmov.getDescripcion(),modtmov.getDescripcion());
	}
	
	@After
	public void eliminarTipoMovimiento() {	
		serv.eliminar(ntmov);	
	}
}
