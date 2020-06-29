package com.wpcursos.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wpcursos.course.entities.User;
import com.wpcursos.course.repositories.UserRepository;

// REgistra classe como component

// @Repository pra registrar classe de  Repository, @Service pra registrar Serviços

@Service
public class UserService {

	// Gerencia a dependencia automaticamente
	@Autowired
	private UserRepository repository; // Dependencia

	public List<User> findAll() {

		return repository.findAll();

	}

	public User findById(Long id) {
		
		Optional<User> obj  = repository.findById(id);
		
		return obj.get();
	}
	
	public User insertUser(User obj) {
		
					
		return repository.save(obj);
	}

}
