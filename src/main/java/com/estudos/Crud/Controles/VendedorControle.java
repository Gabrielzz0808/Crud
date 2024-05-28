package com.estudos.Crud.Controles;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        var vendedorModelo = new VendedorModelo();
        BeanUtils.copyProperties(vendedorDtos, vendedorModelo);
        return ResponseEntity.status(HttpStatus.OK).body(vendedorRepositorio.save(vendedorModelo));
    }

    @GetMapping("/Vendedor")
    public ResponseEntity<List<VendedorModelo>> BuscarVendedor(){
        return ResponseEntity.status(HttpStatus.OK).body(vendedorRepositorio.findAll());
    }

    @GetMapping("/Vendedor/{id}")
    public ResponseEntity<Object> BuscarPorId(@PathVariable (value="id") UUID id){
        Optional<VendedorModelo> vendedorId = vendedorRepositorio.findById(id);
        if(vendedorId.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vendedor não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(vendedorId.get());
    }
    
}
