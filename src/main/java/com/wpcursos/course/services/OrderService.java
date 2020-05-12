package com.wpcursos.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wpcursos.course.entities.Order;
import com.wpcursos.course.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	public OrderRepository repository;

	public List<Order> FindAll() {

		return repository.findAll();

	}

	public Order findById(Long id) {

		Optional<Order> obj = repository.findById(id);

		return obj.get();
	}

}
