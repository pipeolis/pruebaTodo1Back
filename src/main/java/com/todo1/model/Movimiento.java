package com.todo1.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Movimiento {
	@GeneratedValue
	@Id
	private int idMovimiento;
	
	@Column (name = "id_tipo_mov")
	private int idTipoMovimiento;
	
	@Column (name = "id_producto")
	private int idProducto;
	
	@Column (name = "cantidad")
	private int cantidad;
	
	@Column (name = "valor_unitario")
	private Double valorUnitario;
	
	@Column (name = "valor_total")
	private Double valorTotal;
	
	@Column (name = "fec_mov")
	private Date fecMovimiento;	
	
	public Double getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	public Double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	public int getIdMovimiento() {
		return idMovimiento;
	}
	public void setIdMovimiento(int idMovimiento) {
		this.idMovimiento = idMovimiento;
	}
	public int getIdTipoMovimiento() {
		return idTipoMovimiento;
	}
	public void setIdTipoMovimiento(int idTipoMovimiento) {
		this.idTipoMovimiento = idTipoMovimiento;
	}
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Date getFecMovimiento() {
		return fecMovimiento;
	}
	public void setFecMovimiento(Date fecMovimiento) {
		this.fecMovimiento = fecMovimiento;
	}
	
	
}
