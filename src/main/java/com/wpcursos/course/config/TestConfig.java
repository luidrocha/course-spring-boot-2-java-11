package com.wpcursos.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.wpcursos.course.entities.User;
import com.wpcursos.course.repositories.UserRepository;

// Informa ao Spring que a classe é de Configuração

@Configuration
@Profile ("test") // profile criado no aplication.properties
public class TestConfig implements CommandLineRunner{ // CommandLineRunner executa ao iniciar a aplicação.

	@Autowired // Habilita a injeção d Dependencia automatica
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		userRepository.saveAll(Arrays.asList(u1,u2));
		
	}
	
	
}
