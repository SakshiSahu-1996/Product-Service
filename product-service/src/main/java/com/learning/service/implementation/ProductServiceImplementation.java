package com.learning.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.entity.ProductEntity;
import com.learning.enums.Category;
import com.learning.enums.Status;
import com.learning.repository.ProductRepository;
import com.learning.service.ProductService;

@Service
public class ProductServiceImplementation implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Long createProduct(ProductEntity productEntity) {
		ProductEntity entity = productRepository.save(productEntity);
		return entity.getId();
	}

	@Override
	public ProductEntity findById(Long id) {
		Optional<ProductEntity> entity = productRepository.findById(id);
		boolean isPresent = entity.isPresent();
		if (isPresent) {
			ProductEntity productGet = entity.get();
			return productGet;
		} else {
			return null;
		}
	}

	@Override
	public List<ProductEntity> findByCategory(Category category) {
		return productRepository.findByCategory(category);
	}

	@Override
	public List<ProductEntity> getAll() {
		return productRepository.findAll();
	}

	@Override
	public List<ProductEntity> findByName(String name) {	
		return productRepository.findByName(name);
	}

	@Override
	public Status updateById(Long id, ProductEntity productEntity) {
	ProductEntity entity = 	findById(id);
		if (entity != null) {
			entity.setCategory(productEntity.getCategory());
			entity.setDate(productEntity.getDate());
			entity.setName(productEntity.getName());
			entity.setTime(productEntity.getTime());
			productRepository.save(entity);
			return Status.SUCCESS;
		}else
		return Status.FAIL;
	}

	@Override
	public Status deleteById(Long id) {
	productRepository.deleteById(id);
		return Status.SUCCESS;
	}
}
