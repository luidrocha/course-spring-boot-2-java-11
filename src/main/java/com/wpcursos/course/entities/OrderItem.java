package com.wpcursos.course.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wpcursos.course.entities.pk.OrderItemPK;

@Entity
@Table(name="tb_order_item")
public class OrderItem implements Serializable{

	private static final long serialVersionUID = 1L;

	@EmbeddedId //criar uma classe interna/aninhada e incluir uma referência a ela na classe original.
	private OrderItemPK id = new OrderItemPK(); // classe Id composto

	private Integer quantity;

	private Double price;

	public OrderItem() {

	}

	public OrderItem(Order order, Product product, Integer quantity, Double price) {
		super();
		id.setOrder(order);
		id.setProduct(product);
		this.quantity = quantity;
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	// Na plataforma java interprise o que vale é o GET, onde deve ser colocado o JSONIGNORE pra associação de mão dupla.
	@JsonIgnore
	public Order getOrder() {
		
		return id.getOrder();
	}
	
	public void setOrder(Order order) {
		
		id.setOrder(order);
	}
	
	//@JsonIgnore
	public Product getProduct() {
		
		return id.getProduct();
	}
	
	public void setProduct(Product product) {
		
		id.setProduct(product);
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
