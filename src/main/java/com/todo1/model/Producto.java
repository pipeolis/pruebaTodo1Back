package com.todo1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity	
public class Producto {
	@GeneratedValue
	@Id
	private int idProducto;
	
	@Column(name="id_tipo")
	private int idTipo;
	
	@Column(name="id_origen")	
	private int idOrigen;	
	
	@Column(name = "descripcion", length = 50)
	private String descripcion;
		
	@Column(name="porc_venta")
	private Double porcVenta;
	
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public int getIdTipo() {
		return idTipo;
	}
	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Double getPorcVenta() {
		return porcVenta;
	}
	public void setPorcVenta(Double porcVenta) {
		this.porcVenta = porcVenta;
	}
	
	public int getIdOrigen() {
		return idOrigen;
	}
	public void setIdOrigen(int idOrigen) {
		this.idOrigen = idOrigen;
	}
	
	
}
