package com.ufc.trabalho.trabalhofinal.Domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Produto implements Serializable {

    Integer id;
    String nome;
    Integer imageId;
    BigDecimal preco;

    public Produto() {

    }

    public Produto(Integer id, String nome,Integer imageId, BigDecimal preco) {
        this.id = id;
        this.nome = nome;
        this.imageId = imageId;
        this.preco = preco;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
}
