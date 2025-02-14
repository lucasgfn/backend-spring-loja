package com.example.lojas.saines.repository;

import com.example.lojas.saines.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Product, Long> {
}
