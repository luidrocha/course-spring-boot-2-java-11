package com.wpcursos.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wpcursos.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
