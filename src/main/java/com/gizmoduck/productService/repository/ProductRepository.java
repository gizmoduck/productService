package com.gizmoduck.productService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gizmoduck.productService.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
