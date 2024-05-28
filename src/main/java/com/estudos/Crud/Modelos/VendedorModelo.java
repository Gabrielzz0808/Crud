package com.estudos.Crud.Modelos;


import java.io.Serializable;
import java.util.UUID;

import org.springframework.hateoas.RepresentationModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Vendedor")
public class VendedorModelo extends RepresentationModel<VendedorModelo> implements Serializable {

    public static final long serialVersionUID = 1l;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idVendedor;
    private String nome;
    private String tel;
    private double comissao;

    
    public UUID getIdVendedor() {
        return idVendedor;
    }
    public void setIdVendedor(UUID idVendedor) {
        this.idVendedor = idVendedor;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
    public double getComissao() {
        return comissao;
    }
    public void setComissao(double comissao) {
        this.comissao = comissao;
    }
    

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((idVendedor == null) ? 0 : idVendedor.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        VendedorModelo other = (VendedorModelo) obj;
        if (idVendedor == null) {
            if (other.idVendedor != null)
                return false;
        } else if (!idVendedor.equals(other.idVendedor))
            return false;
        return true;
    }



    
}
