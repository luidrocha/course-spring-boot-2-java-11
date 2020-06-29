package com.wpcursos.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.wpcursos.course.entities.User;
import com.wpcursos.course.services.UserService;

// Classe que disponibiliza os recursos WEB da classe USER
// faz parte da camada de Controladores REST

@RestController
@RequestMapping(value = "/users")
@ResponseBody
public class UserResource {

	@Autowired
	private UserService service;

	@GetMapping
	public ResponseEntity<List<User>> findAll() {

		List<User> list = service.findAll();
		

		return ResponseEntity.ok().body(list);

	}

	// Permite passa o parametro para requisição, nesse caso o id.
	
	@GetMapping (value ="/{id}")
	public ResponseEntity<User>	findById(@PathVariable long id){ // Essa anotação@PathVariable informa que o metodo vai receberum parametro por requisição
		
		User obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
			
	}
	
	
	// Insere um recurso (dados) no banco de dados
	@PostMapping // Define que a solicitação vai receber uma requisição POST do metodo HTTP
				 // @RequestBody para descerializar
	public ResponseEntity<User> insertUser(@RequestBody User obj){ 
		
		obj = service.insertUser(obj);
		
		// Pega o caminho do objeto JSON e transforma em um omj do tipo Uri.
		URI uri =  ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).body(obj);		
		
	}
	
	@DeleteMapping (value = "/{id}")
	public ResponseEntity<Void> deleteUser (@PathVariable Long id) {
		
		
		service.deleteUser(id);
		
		return ResponseEntity.noContent().build(); // Resposta vazia, sem corpo. 204.
				
		
	}

}
