package com.tienda.productosElectronicos.repositories.interfaces;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tienda.productosElectronicos.entities.TblMarca;

@Repository
public interface RIMarca extends JpaRepository<TblMarca, Integer>{
	
	Optional<TblMarca> findByDescripcionMarca(String descripcionMarca);
}
