package com.estudos.Crud.Controles;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.estudos.Crud.Modelos.VendedorModelo;
import com.estudos.Crud.Repositorios.VendedorRepositorio;
import com.estudos.Crud.VendedorDtos.VendedorDtos;

import jakarta.validation.Valid;

@RestController
public class VendedorControle {

    @Autowired
    private VendedorRepositorio vendedorRepositorio;

    @PostMapping("/Vendedor")
    public ResponseEntity<VendedorModelo> AddVendedor(@RequestBody @Valid VendedorDtos vendedorDtos){
        var vendedorModelo = new VendedorModelo(null, null, 0);
        BeanUtils.copyProperties(vendedorDtos, vendedorModelo);
        return ResponseEntity.status(HttpStatus.OK).body(vendedorRepositorio.save(vendedorModelo));
    }
    
}
