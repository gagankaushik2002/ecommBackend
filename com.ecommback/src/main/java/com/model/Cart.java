package com.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.*;

@Entity
@Table
public class Cart 
{
	@Id
	@GeneratedValue
	int cartId;
	
	float cartTotal;
	
	Date orderDate;
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public float getCartTotal() {
		return cartTotal;
	}
	public void setCartTotal(float cartTotal) {
		this.cartTotal = cartTotal;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
}
