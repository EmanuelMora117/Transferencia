package com.tienda.productosElectronicos.models;

public class DTOProducto {
	
	private Integer id;
	
	private String titulo;
	
	private String precio;
	
	private String marca;
	
	private String image1;
	
	private String image2;
	
	private String image3;
	
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
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getImage1() {
		return image1;
	}
	public void setImage1(String image1) {
		this.image1 = image1;
	}
	public String getImage2() {
		return image2;
	}
	public void setImage2(String image2) {
		this.image2 = image2;
	}
	public String getImage3() {
		return image3;
	}
	public void setImage3(String image3) {
		this.image3 = image3;
	}
	public Integer getIdGestor() {
		return idGestor;
	}
	public void setIdGestor(Integer idGestor) {
		this.idGestor = idGestor;
	}
	
	
}
