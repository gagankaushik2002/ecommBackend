package com;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dao.CartItemDAO;
import com.dao.ProductDAO;
import com.model.CartItem;
import com.model.Product;

@Controller
public class CartAndCartItemController 
{
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	CartItemDAO cartItemDAO;
	
	@RequestMapping(value="/cartDisplay")
	public String goToCart(HttpSession session, Model m)
	{
		String userName = (String) session.getAttribute("username");
		List<CartItem> cartItems = cartItemDAO.showCartItems(userName);
		m.addAttribute("cartItems",cartItems);
		m.addAttribute("totalPurchaseAmount",this.calculateTotalPurchaseAmount(cartItems));
		return "Cart";
	}
	
	@RequestMapping(value="/addToCart/{productId}")
	public String addCartItem(@RequestParam("quantity") int quantity,@PathVariable("productId") int productId,HttpSession session, Model m)
	{
		System.out.println("in add cart 1");
		Product product = productDAO.getProduct(productId);
		String userName = (String) session.getAttribute("username");
		
		CartItem cartItem = new CartItem();
		cartItem.setProductId(product.getProductId());
		cartItem.setProductName(product.getProductName());
		cartItem.setQuantity(quantity);
		cartItem.setUsername(userName);
		cartItem.setPrice(product.getPrice());
		cartItem.setStatus("NA");
		
		System.out.println("in add cart 2");
		
		cartItemDAO.addCartItem(cartItem);
	
		
		System.out.println("in add cart 3=");
		
		List<CartItem> cartItems = cartItemDAO.showCartItems(userName);
		m.addAttribute("cartItems",cartItems);
		m.addAttribute("totalPurchaseAmount",this.calculateTotalPurchaseAmount(cartItems));
		System.out.println("in add cart 4");
		return "Cart";
	}
	
	@RequestMapping(value="/updateCartItem/{cartItemId}")
	public String updateCartItem(@RequestParam("quantity") int quantity,@PathVariable("cartItemId") int cartItemId,HttpSession session, Model m)
	{
		CartItem cartItem = cartItemDAO.getCartItem(cartItemId);
		String userName = (String) session.getAttribute("username");
		
		cartItem.setQuantity(quantity);
		cartItemDAO.updateCartItem(cartItem);
		
		List<CartItem> cartItems = cartItemDAO.showCartItems(userName);
		m.addAttribute("cartItems",cartItems);
		m.addAttribute("totalPurchaseAmount",this.calculateTotalPurchaseAmount(cartItems));
		
		return "Cart";
	}
	

	@RequestMapping(value="/deleteCartItem/{cartItemId}")
	public String deleteCartItem(@PathVariable("cartItemId") int cartItemId,HttpSession session, Model m)
	{
		CartItem cartItem = cartItemDAO.getCartItem(cartItemId);
		cartItemDAO.deleteCartItem(cartItem);
		String userName = (String) session.getAttribute("username");
		List<CartItem> cartItems = cartItemDAO.showCartItems(userName);
		m.addAttribute("cartItems",cartItems);
		m.addAttribute("totalPurchaseAmount",this.calculateTotalPurchaseAmount(cartItems));
		
		return "Cart";
	}
	
	@RequestMapping(value="/continueShopping")
	public String continueShopping(Model m)
	{
		m.addAttribute("productList",productDAO.listProducts());
		return "ProductDisplay";
	}
	
	@RequestMapping(value="/checkOut")
	public String checkOut()
	{
		
		return "index";
	}
	
	public int calculateTotalPurchaseAmount(List<CartItem> cartItems)
	{
		int totalPurchaseAmount = 0;
		int count = 0;
		
		while(count<cartItems.size())
		{
			CartItem cartItem = cartItems.get(count);
			totalPurchaseAmount = totalPurchaseAmount+(cartItem.getQuantity()*cartItem.getPrice());
			count++;
		}
		return totalPurchaseAmount;
	}
}
