package com.tienda.productosElectronicos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.tienda.productosElectronicos.entities.TBLProducto;
import com.tienda.productosElectronicos.models.DTOProducto;
import com.tienda.productosElectronicos.services.ProductServices;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductServices productServices;
	
	@GetMapping("/getAllProducts")
	public List<TBLProducto> getAllProducts() {
		return this.productServices.getAllProduct();
	}
	
	@GetMapping("/getProduct/{id}")
	public ResponseEntity<?> getProduct(@PathVariable Integer id) {
		return this.productServices.getProduct(id);
	}
	
	@PostMapping("/insertProduct")
	public ResponseEntity<ObjectNode> insertProduct(@RequestBody DTOProducto dtoProducto) {
		return this.productServices.insertProduct(dtoProducto);
	}
	
	@PutMapping("/updateProduct/{id}")
	public ResponseEntity<ObjectNode> updateProduct(@PathVariable Integer id, @RequestBody DTOProducto dtoProducto) {
		return this.productServices.updateProduct(id, dtoProducto);
	}
	
	@DeleteMapping("/deleteProduct/{id}")
	public ResponseEntity<ObjectNode> deleteProduct(@PathVariable Integer id) {
		return this.productServices.deleteProduct(id);
	}
	
	
	
}
