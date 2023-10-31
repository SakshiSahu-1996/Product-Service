package com.learning.service;

import java.util.List;

import com.learning.entity.ProductEntity;
import com.learning.enums.Category;
import com.learning.enums.Status;

public interface ProductService {
	
	public Long createProduct(ProductEntity productEntity);
	
	public ProductEntity findById(Long id);
	
	public List<ProductEntity> findByCategory(Category category);
	
	public List<ProductEntity> getAll();
	
	public List<ProductEntity> findByName(String name);
	
	public Status updateById(Long id,ProductEntity productEntity);
	
	public Status deleteById(Long id);
}
