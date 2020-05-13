package com.wpcursos.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wpcursos.course.entities.Product;

// JpaRepositor possui uma série de metodos prontos para trabalhar com a base de dados.

public interface ProductRepository extends JpaRepository<Product, Long>{

}
