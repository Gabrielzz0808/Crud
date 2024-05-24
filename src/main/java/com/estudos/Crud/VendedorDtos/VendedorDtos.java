package com.estudos.Crud.VendedorDtos;


import jakarta.validation.constraints.NotBlank;

public record VendedorDtos(@NotBlank String nome) {
    
}
