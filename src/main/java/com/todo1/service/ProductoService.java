package com.todo1.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo1.exception.Excepcion;
import com.todo1.model.Movimiento;
import com.todo1.model.Producto;
import com.todo1.repo.IMovimientoRepo;
import com.todo1.repo.IOrigenRepo;
import com.todo1.repo.IProductoRepo;
import com.todo1.repo.ITipoProductoRepo;

@Service
public class ProductoService {
	@Autowired
	private IProductoRepo repoProducto;
	
	@Autowired
	private IOrigenRepo repoOrigen;
	
	@Autowired
	private ITipoProductoRepo repoTproducto;
	
	@Autowired
	private IMovimientoRepo repoMov;

	Logger log = LoggerFactory.getLogger(ProductoService.class);

	/**
	 * Método que permite crear un producto
	 * 
	 * @param prod
	 * @return Producto
	 */
	public Producto crear(Producto prod) {
		if (existeProducto(prod.getDescripcion())) {
			log.error("El producto ya existe");
			throw new Excepcion(ProductoService.class.getName() + "-CREAR_YA_EXISTE");
		}
		
		if(!existeOrigen(prod.getIdOrigen())) {
			log.error("El origen no existe");
			throw new Excepcion(ProductoService.class.getName() + "-ORIGEN_NO_EXISTE");
		}
		
		if(!existeTipoProducto(prod.getIdTipo())) {
			log.error("El tipo producto no existe");
			throw new Excepcion(ProductoService.class.getName() + "-TIPO_PRODUCTO_NO_EXISTE");
		}		
		
		return repoProducto.save(prod);
	}

	/**
	 * Validar por la descripcion si existe un producto
	 * 
	 * @param descripcion
	 * @return boolean
	 */
	public boolean existeProducto(String descripcion) {
		return repoProducto.findAll().stream().anyMatch(t -> t.getDescripcion().equals(descripcion));
	}
	
	/**
	 * Método que permite validar si el origen existe
	 * 
	 * @param idOrigen
	 * @return boolean
	 */
	private boolean existeOrigen(int idOrigen) {
		if (repoOrigen.findById(idOrigen).get() != null) {
			return true;
		}
		return false;
	}
	
	/**
	 * Método que permite validar si existe el tipo de prodcuto
	 * 
	 * @param idTprod
	 * @return boolean
	 */
	private boolean existeTipoProducto(int idTprod) {
		if(repoTproducto.findById(idTprod).get() != null) {
			return true;
		}
		return false;
	}

	/**
	 * Método que permite listar todos los producto
	 * 
	 * @return List<Producto>
	 */
	public List<Producto> listar() {
		return repoProducto.findAll();
	}

	/**
	 * Método que permite modificar un producto
	 * 
	 * @param prod
	 * @return Producto
	 */
	public Producto modificar(Producto prod) {
		if (existeProducto(prod.getDescripcion())) {
			log.error("El producto ya existe");
			throw new Excepcion(ProductoService.class.getCanonicalName() + "-MODIFICAR_YA_EXISTE");
		}
		return repoProducto.save(prod);
	}

	/**
	 * Método que permite eliminar un producto
	 * 
	 * @param prod
	 */
	public void eliminar(Producto prod) {
		if (!existeProducto(prod.getDescripcion())) {
			log.error("El producto no existe");
			throw new Excepcion(ProductoService.class.getName() + "-ELIMINAR_NO_EXISTE");
		}
		repoProducto.deleteById(prod.getIdProducto());
	}
	
	/**
	 * Método que permite validar si existe un producto por su id
	 * 
	 * @param idProducto
	 * @return boolean
	 */
	public boolean existeProductoById(int idProducto) {
		return repoProducto.existsById(idProducto);		
	}
	
	public Producto productoById(int idProducto) {
		return repoProducto.getOne(idProducto);
	}
	
	/**
	 * Método que permite caluclar el precio de venta de un producto
	 * Toma el promedio del valor unitario de las compras
	 * 
	 * @param idProducto
	 * @return Double
	 */
	public Double precioProducto(int idProducto) {
		
		Double vlrPromCompra = repoMov.findAll().stream().filter(m -> (m.getIdProducto() == idProducto && m.getIdTipoMovimiento() == 2)).mapToDouble(Movimiento::getValorUnitario)
				.average().getAsDouble();
		
		Double porcIncremento = vlrPromCompra * productoById(idProducto).getPorcVenta()/100;		
		
		return  vlrPromCompra + porcIncremento;
	}

}
