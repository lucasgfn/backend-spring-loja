package com.example.lojas.saines.dto;

import com.example.lojas.saines.entity.Product;

public record ProdutoResponseDTO(Long id, String nome, String marca, String tipo, String image, Double price) {

    public ProdutoResponseDTO(Product product) {
        this(product.getId(), product.getNome(), product.getMarca(), product.getTipo(), product.getImage(), product.getPrice());
    }
}
