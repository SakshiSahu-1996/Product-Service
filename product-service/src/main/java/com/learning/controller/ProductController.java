package com.learning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.entity.ProductEntity;
import com.learning.enums.Category;
import com.learning.enums.Status;
import com.learning.service.implementation.ProductServiceImplementation;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductServiceImplementation productService;

	@PostMapping
	public Long createProducts(@RequestBody ProductEntity productEntity) {
		return productService.createProduct(productEntity);
	}

	@GetMapping("/id/{id}")
	public ProductEntity findById(@PathVariable Long id) {
		return productService.findById(id);
	}

	@GetMapping("/all")
	public List<ProductEntity> getAll() {
		return productService.getAll();
	}

	@GetMapping("/name/{name}")
	public List<ProductEntity> findByName(@PathVariable String name) {
		return productService.findByName(name);
	}

	@GetMapping("/category/{category}")
	public List<ProductEntity> findByCategory(@PathVariable Category category) {
		return productService.findByCategory(category);
	}

	@PutMapping("/{id}")
	public Status updateById(@PathVariable Long id, @RequestBody ProductEntity productEntity) {
		return productService.updateById(id, productEntity);
	}

	@DeleteMapping
	public Status deleteById(@PathVariable Long id) {
		return productService.deleteById(id);
	}
}
