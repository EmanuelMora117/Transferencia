package com.tienda.productosElectronicos.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tbl_productos")
public class TBLProducto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prod_id", nullable = false)
	private Integer id;
	
	@Column(name = "prod_titulo", nullable = false, length=255)
	private String titulo;
	
	@Column(name = "prod_precio", nullable = false, length=255)
	private String precio;
	
	@ManyToOne
    @JoinColumn(name = "prod_marca", referencedColumnName = "marca_descripcion")
	private TblMarca marca;
	
	@Column(name = "prod_imagen_1", nullable = false)
	private byte[] image1;
	

	@Column(name = "prod_imagen_2", nullable = false)
	private byte[] image2;
	
	@Column(name = "prod_imagen_3", nullable = false)
	private byte[] image3;
	
	@Column(name = "adm_id_gestionador")
	private Integer idGestor;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public TblMarca getMarca() {
		return marca;
	}

	public void setMarca(TblMarca marca) {
		this.marca = marca;
	}

	public byte[] getImage1() {
		return image1;
	}

	public void setImage1(byte[] image1) {
		this.image1 = image1;
	}

	public byte[] getImage2() {
		return image2;
	}

	public void setImage2(byte[] image2) {
		this.image2 = image2;
	}

	public byte[] getImage3() {
		return image3;
	}

	public void setImage3(byte[] image3) {
		this.image3 = image3;
	}

	public Integer getIdGestor() {
		return idGestor;
	}

	public void setIdGestor(Integer idGestor) {
		this.idGestor = idGestor;
	}
	
	
}
