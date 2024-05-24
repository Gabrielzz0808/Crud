package com.estudos.Crud.Repositorios;


import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudos.Crud.Modelos.VendedorModelo;

public interface VendedorRepositorio extends JpaRepository<VendedorModelo, UUID> {
    
}
