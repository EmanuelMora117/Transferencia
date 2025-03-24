package com.tienda.productosElectronicos.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_marca_productos")
public class TblMarca {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "marca_id", nullable = false)
	private Integer idMarca;
	
	@Column(name = "marca_descripcion", nullable = false, length=255)
	private String descripcionMarca;
	
	@Column(name = "categoria_id", nullable = false, length=255)
	private Integer idCategoria;

	public Integer getIdMarca() {
		return idMarca;
	}

	public void setIdMarca(Integer idMarca) {
		this.idMarca = idMarca;
	}

	public String getDescripcionMarca() {
		return descripcionMarca;
	}

	public void setDescripcionMarca(String descripcionMarca) {
		this.descripcionMarca = descripcionMarca;
	}

	public Integer getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}
}
