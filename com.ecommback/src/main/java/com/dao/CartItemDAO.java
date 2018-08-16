package com.dao;

import java.util.List;

import com.model.CartItem;
public interface CartItemDAO 
{
	public boolean addCartItem(CartItem cartItem);
	public boolean updateCartItem(CartItem cartItem);
	public boolean deleteCartItem(CartItem cartItem);
	public CartItem getCartItem(int cartItemId);
	public List<CartItem> showCartItems(String userName);
}
