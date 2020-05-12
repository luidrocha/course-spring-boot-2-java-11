package com.wpcursos.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.wpcursos.course.entities.Order;
import com.wpcursos.course.entities.User;
import com.wpcursos.course.entities.enums.OrderStatus;
import com.wpcursos.course.repositories.OrderRepository;
import com.wpcursos.course.repositories.UserRepository;

// Informa ao Spring que a classe é de Configuração

@Configuration
@Profile("test") // profile criado no aplication.properties
public class TestConfig implements CommandLineRunner { // CommandLineRunner executa ao iniciar a aplicação.

	@Autowired // Habilita a injeção d Dependencia automatica
	private UserRepository userRepository;
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {

		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		User u3 = new User(null, "Marco Azerra", "Marco@gmail.com", "977777777", "123456");

		userRepository.saveAll(Arrays.asList(u1, u2, u3));

		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"),OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"),OrderStatus.CANCELED, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT,u1);
		Order o4 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u3);

		orderRepository.saveAll(Arrays.asList(o1, o2, o3, o4));

	}

}
