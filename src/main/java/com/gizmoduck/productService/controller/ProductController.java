package com.gizmoduck.productService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gizmoduck.productService.domain.Product;
import com.gizmoduck.productService.repository.ProductRepository;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired 
	ProductRepository productRepository;
	
	@GetMapping("/products")
	public List<Product> getProducts() {
		return productRepository.findAll();
	}
	
	@PostMapping("/products")
	public Product save(@RequestBody Product product) {
		return productRepository.save(product);
	}
	
	 @GetMapping("/products/{id}")
	    public Product getProduct(@PathVariable("id") Long id) {
	        return productRepository.findById(id).orElse(null);
	    }
}
