package com.example.lojas.saines.controller;

import com.example.lojas.saines.dto.ProdutoRequestDTO;
import com.example.lojas.saines.dto.ProdutoResponseDTO;
import com.example.lojas.saines.repository.ProdutoRepository;
import com.example.lojas.saines.services.ProdutoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.lojas.saines.entity.Product;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private ProdutoServices produtoServices;

    @PostMapping
    public ResponseEntity<ProdutoResponseDTO> save(@RequestBody ProdutoRequestDTO produtoRequestDTO){
        ProdutoResponseDTO produtoResponseDTO = produtoServices.cadastrarProduto(produtoRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoResponseDTO);
    }

    @GetMapping
    public List<ProdutoResponseDTO> getAll(){
        return produtoRepository.findAll().stream()
                .map(ProdutoResponseDTO::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> getById(@PathVariable Long id){
        return produtoRepository.findById(id)
                .map(product -> ResponseEntity.ok().body(toResponseDTO(product)))
                .orElse(ResponseEntity.notFound().build()); //Se nao encontrar Lanca Erro 404
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> update(@PathVariable Long id, @RequestBody ProdutoRequestDTO produtoRequestDTO){
        return produtoRepository.findById(id)
                .map(product -> {
                    product.setNome(produtoRequestDTO.nome());
                    product.setMarca(produtoRequestDTO.marca());
                    product.setTipo(produtoRequestDTO.tipo());
                    product.setImage(produtoRequestDTO.image());
                    product.setPrice(produtoRequestDTO.price());

                    Product product_update = produtoRepository.save(product);
                    return ResponseEntity.ok().body(toResponseDTO(product_update));
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        return produtoRepository.findById(id)
                .map(product -> {
                    produtoRepository.delete(product);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }


    private ProdutoResponseDTO toResponseDTO(Product product) {
        if (product == null) {
            return null;
        }
        return new ProdutoResponseDTO(product.getId(), product.getNome(), product.getMarca(), product.getImage(), product.getTipo(), product.getPrice());
    }

}
