package com.todo1;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.todo1.model.Producto;
import com.todo1.service.ProductoService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestProducto {
	@Autowired
	private ProductoService serv;
	private Producto nprod;
	
	@Test
	public void crearProducto() {
		Producto prod = new Producto();
		prod.setDescripcion("Nuevo producto 2");
		prod.setIdOrigen(9);
		prod.setIdTipo(22);
		prod.setPorcVenta(30.0);
		
		nprod = serv.crear(prod);		
		assertEquals(prod, nprod);
		
		assertEquals(prod.getDescripcion(),nprod.getDescripcion());
		assertEquals(prod.getIdOrigen(),nprod.getIdOrigen());
		assertEquals(prod.getIdTipo(),nprod.getIdTipo());
	}
	
	@Test
	public void modificarProducto() {
		Producto prod = new Producto();
		prod.setDescripcion("Otro producto 2");
		prod.setIdOrigen(10);
		prod.setIdTipo(23);
		prod.setPorcVenta(25.0);
		
		nprod = serv.crear(prod);
		nprod.setDescripcion("modificado 3");
		
		Producto modprod = new Producto();
		modprod = serv.modificar(nprod);
	    
		assertEquals(modprod.getDescripcion(),nprod.getDescripcion());
		assertEquals(modprod.getIdOrigen(),nprod.getIdOrigen());
		assertEquals(modprod.getIdTipo(),nprod.getIdTipo());
	}
	
	@After
	public void eliminar() {	
		serv.eliminar(nprod);	
	}
}
