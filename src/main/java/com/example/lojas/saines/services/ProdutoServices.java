package com.example.lojas.saines.services;

import com.example.lojas.saines.dto.ProdutoRequestDTO;
import com.example.lojas.saines.dto.ProdutoResponseDTO;
import com.example.lojas.saines.entity.Product;
import com.example.lojas.saines.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class ProdutoServices {

    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoResponseDTO cadastrarProduto(@Valid ProdutoRequestDTO produtoRequestDTO){
        if(produtoRequestDTO.nome()==null || produtoRequestDTO.nome().isEmpty()) {
            throw new IllegalArgumentException("Nome do produto é obrigatório");
        }if(produtoRequestDTO.price()==null || produtoRequestDTO.price() <= 0) {
            throw new IllegalArgumentException("Preço deve ser um valor válido");
        }

        Product newProduct = new Product();
        newProduct.setNome(produtoRequestDTO.nome());
        newProduct.setTipo(produtoRequestDTO.tipo());
        newProduct.setMarca(produtoRequestDTO.marca());
        newProduct.setImage(produtoRequestDTO.image());
        newProduct.setPrice(produtoRequestDTO.price());

       return new ProdutoResponseDTO(produtoRepository.save(newProduct));
    }


}
