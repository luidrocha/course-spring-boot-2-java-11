package com.wpcursos.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wpcursos.course.entities.Product;
import com.wpcursos.course.services.ProductService;

// Classe que disponibiliza os recursos WEB da classe USER
// faz parte da camada de Controladores REST

@RestController
@RequestMapping(value = "/products")
@ResponseBody
public class ProductResource {

	@Autowired
	private ProductService service;

	@GetMapping
	public ResponseEntity<List<Product>> findAll() {

		List<Product> list = service.findAll();
		

		return ResponseEntity.ok().body(list);

	}

	// Permite passa o parametro para requisição, nesse caso o id.
	
	@GetMapping (value ="/{id}")
	public ResponseEntity<Product>	findById(@PathVariable long id){ // Essa anotação@PathVariable informa que o metodo vai receberum parametro por requisição
		
		Product obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
		
		
	}

}
