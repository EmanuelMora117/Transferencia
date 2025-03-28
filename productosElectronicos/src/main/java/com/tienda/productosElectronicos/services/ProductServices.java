package com.tienda.productosElectronicos.services;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.tienda.productosElectronicos.entities.TBLProducto;
import com.tienda.productosElectronicos.entities.TblMarca;
import com.tienda.productosElectronicos.helpers.ResponseHelper;
import com.tienda.productosElectronicos.models.DTOProducto;
import com.tienda.productosElectronicos.repositories.interfaces.RIProducto;
import com.tienda.productosElectronicos.repositories.interfaces.RIMarca;

@Service
public class ProductServices {

	@Autowired
	private RIProducto riProducto;

	@Autowired
	private RIMarca riMarca;

	@Autowired
	private ResponseHelper responseHelper;

	public List<TBLProducto> getAllProduct() {

		return this.riProducto.findAll();
	}

	public ResponseEntity<?> getProduct(Integer id) {

		Optional<TBLProducto> producto = this.riProducto.findById(id);
		if(producto.isPresent()) {
			TBLProducto tblProducto = producto.get();
			return ResponseEntity.ok(tblProducto);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"message\":\"Producto no encontrado\"}");
		}
		

	}

	public ResponseEntity<ObjectNode> insertProduct(DTOProducto dtoProducto) {

		String answer = "";

		Optional<TblMarca> marca = this.riMarca.findByDescripcionMarca(dtoProducto.getMarca());

		if (marca.isPresent()) {
			TBLProducto tblProducto = new TBLProducto();

			tblProducto.setTitulo(dtoProducto.getTitulo());
			tblProducto.setPrecio(dtoProducto.getPrecio());
			tblProducto.setMarca(marca.get());
			tblProducto.setImage1(Base64.getDecoder().decode(dtoProducto.getImage1()));
			tblProducto.setImage2(Base64.getDecoder().decode(dtoProducto.getImage2()));
			tblProducto.setImage3(Base64.getDecoder().decode(dtoProducto.getImage3()));
			tblProducto.setIdGestor(dtoProducto.getIdGestor());

			try {
				this.riProducto.save(tblProducto);
				answer = "Producto insertado correctamente.";

			} catch (Exception e) {
				System.out.println("Error al insertar un producto: " + e);
				answer = "Error al insertar un producto.";
			}
		} else {
			System.out.println("Marca del producto no existente");
			answer = "Marca del producto no existente.";
		}

		return this.responseHelper.returnLogProcess(answer);
	}

	public ResponseEntity<ObjectNode> updateProduct(Integer id, DTOProducto dtoProducto) {

		String answer = "";

		Optional<TblMarca> marca = this.riMarca.findByDescripcionMarca(dtoProducto.getMarca());

		if (marca.isPresent()) {

			Optional<TBLProducto> producto = this.riProducto.findById(id);
			if (producto.isPresent()) {

				TBLProducto tblProducto = producto.get();
				tblProducto.setTitulo(dtoProducto.getTitulo());
				tblProducto.setPrecio(dtoProducto.getPrecio());
				tblProducto.setMarca(marca.get());
				tblProducto.setImage1(Base64.getDecoder().decode(dtoProducto.getImage1()));
				tblProducto.setImage2(Base64.getDecoder().decode(dtoProducto.getImage2()));
				tblProducto.setImage3(Base64.getDecoder().decode(dtoProducto.getImage3()));
				tblProducto.setIdGestor(dtoProducto.getIdGestor());

				try {

					this.riProducto.save(tblProducto);
					answer = "Producto actualizado correctamente.";

				} catch (Exception e) {

					System.out.println("Error al actualizar el producto: " + e);
					answer = "Error al actualizar el producto.";

				}

			} else {
				answer = "Producto no existente.";
			}
		}else {
			System.out.println("Marca del producto no existente");
			answer = "Marca del producto no existente.";
		}

		return this.responseHelper.returnLogProcess(answer);
	}

	public ResponseEntity<ObjectNode> deleteProduct(Integer id) {
		
		System.out.println(id);
		String answer = "";

		Optional<TBLProducto> producto = this.riProducto.findById(id);

		if (producto.isPresent()) {

			try {
				this.riProducto.deleteById(id);
				answer = "Producto eliminado correctamente.";
			} catch (Exception e) {
				System.out.println("Error al intentar eliminar el producto: " + e);
				answer = "Error al intentar eliminar el producto";
			}

		} else {
			answer = "Producto no existente.";
		}

		return this.responseHelper.returnLogProcess(answer);
	}
}
