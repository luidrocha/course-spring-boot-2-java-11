package com.wpcursos.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wpcursos.course.entities.User;

// Classe que disponibiliza os recursos WEB da classe USER
// faz parte da camada de Controladores REST

@RestController
@RequestMapping (value = "/users")
@ResponseBody
public class UserResource {

	@GetMapping
	public ResponseEntity<User> findAll() {
		
		User user = new User(10L, "Jose luis","luidrocha@gmail.com","21-99254-2563","Brasil2020");
		
		return ResponseEntity.ok().body(user);

		
	}
}
