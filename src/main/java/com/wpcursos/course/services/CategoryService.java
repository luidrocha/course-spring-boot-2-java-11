package com.wpcursos.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wpcursos.course.entities.Category;
import com.wpcursos.course.repositories.CategoryRepository;

// REgistra classe como component

// @Repository pra registrar classe de  Repository, @Service pra registrar Serviços

@Service
public class CategoryService {

	// Gerencia a dependencia automaticamente
	@Autowired
	private CategoryRepository repository; // Dependencia

	public List<Category> findAll() {

		return repository.findAll();

	}

	public Category findById(Long id) {
		
		Optional<Category> obj  = repository.findById(id);
		
		return obj.get();
	}

}
