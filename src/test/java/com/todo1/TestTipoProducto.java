package com.todo1;

import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.todo1.model.TipoProducto;
import com.todo1.service.TipoProductoService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestTipoProducto {
	@Autowired
	private TipoProductoService tpServ;	
	private TipoProducto ntprod;

	@Test
	public void crearTipoProducto() {
		TipoProducto tprod = new TipoProducto();		
		tprod.setDescripcion("COMICS");
		tprod.setEstado("A");		
		ntprod = tpServ.crear(tprod);			
		assertEquals(ntprod.getDescripcion(),tprod.getDescripcion());
		
	}
	
	@Test
	public void modificarTipoProducto() {
		TipoProducto tprod = new TipoProducto();		
		tprod.setDescripcion("HOLA");
		tprod.setEstado("A");
		ntprod = tpServ.crear(tprod);
		ntprod.setDescripcion("modificado");
		
		TipoProducto mdprod = new TipoProducto();
		mdprod = tpServ.modificar(ntprod);
	    
		assertEquals(mdprod.getDescripcion(),ntprod.getDescripcion());
		
	}
	
	@After
	public void eliminarTipoProductoRepo() {	
	    tpServ.eliminar(ntprod);	
	}
	
	

}
