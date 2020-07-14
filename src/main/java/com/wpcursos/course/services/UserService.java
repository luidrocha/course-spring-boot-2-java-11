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

		Optional<User> obj = repository.findById(id);

		return obj.get();
	}

	public User insertUser(User obj) {

		return repository.save(obj);
	}

	// Deleta Usuário 
	public void deleteUser(Long id) {

		repository.deleteById(id);

	}

	// Atualiza o usuário 
	
	public User updateUser(Long id, User obj) {

		User entity = repository.getOne(id); // prepara o obj monitorado para depois executar uma ação, não vai no banco
												// de dados.
		updateData(entity, obj);
		return repository.save(entity);
	}

	// Atualiza usuário
	private void updateData(User entity, User obj) {
		
	 entity.setName(obj.getName());
	 entity.setEmail(obj.getEmail());
	 entity.setPhone(obj.getPhone());
		
	}

}
