package com.wpcursos.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.wpcursos.course.entities.Category;
import com.wpcursos.course.entities.Order;
import com.wpcursos.course.entities.Product;
import com.wpcursos.course.entities.User;
import com.wpcursos.course.entities.enums.OrderStatus;
import com.wpcursos.course.repositories.CategoryRepository;
import com.wpcursos.course.repositories.OrderRepository;
import com.wpcursos.course.repositories.ProductRepository;
import com.wpcursos.course.repositories.UserRepository;

// Informa ao Spring que a classe é de Configuração

@Configuration
@Profile("test") // profile criado no aplication.properties
public class TestConfig implements CommandLineRunner { // CommandLineRunner executa ao iniciar a aplicação.

	@Autowired // Habilita a injeção d Dependencia automatica
	private UserRepository userRepository;
	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {

		// Instancia usuário
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		User u3 = new User(null, "Marco Azerra", "Marco@gmail.com", "977777777", "123456");
		
		// Instancia Categoria

		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		Category cat4 = new Category(null, "Developer");
		
		// Instancia Produto 

		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5,"Http://");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "Http://");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "Http://");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "Http://");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99,"Http://");
		
		// Salva as instancias

		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		userRepository.saveAll(Arrays.asList(u1, u2, u3));

		// instancia Pedido
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.CANCELED, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);
		Order o4 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u3);

		// Grava o pedido
		
		orderRepository.saveAll(Arrays.asList(o1, o2, o3, o4));

	}

}
