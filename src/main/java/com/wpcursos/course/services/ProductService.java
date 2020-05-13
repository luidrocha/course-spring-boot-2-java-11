package com.wpcursos.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wpcursos.course.entities.Product;
import com.wpcursos.course.repositories.ProductRepository;

// REgistra classe como component

// @Repository pra registrar classe de  Repository, @Service pra registrar Serviços

@Service
public class ProductService {

	// Gerencia a dependencia automaticamente
	@Autowired
	private ProductRepository repository; // Dependencia

	public List<Product> findAll() {

		return repository.findAll();

	}

	public Product findById(Long id) {
		
		Optional<Product> obj  = repository.findById(id);
		
		return obj.get();
	}

}
