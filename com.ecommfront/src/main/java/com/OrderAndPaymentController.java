package com;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.CartItem;
import com.dao.CartItemDAO;
import com.model.OrderDetail;
import com.dao.OrderDetailDAO;
@Controller
public class OrderAndPaymentController 
{
	@Autowired
	CartItemDAO cartItemDAO;
	
	@Autowired
	OrderDetailDAO orderDetailDAO;
	
	@RequestMapping("/payment")
	public String payment(Model m, HttpSession session)
	{
		String userName = (String)session.getAttribute("username");
		System.out.println("PP="+userName);
		List<CartItem> cartItems = cartItemDAO.showCartItems(userName);
		m.addAttribute("cartItems", cartItems);
		m.addAttribute("totalPurchaseAmount",cartItemDAO.calculateTotalPurchaseAmount(cartItems));
		
		return "Payment";
	}
	
	@RequestMapping(value="/paymentProcess",method=RequestMethod.POST )
	public String paymentProcess(@RequestParam("paymentType")String paymentType, Model m, HttpSession session)
	{
		String userName = (String)session.getAttribute("username");
		List<CartItem> cartItems = cartItemDAO.showCartItems(userName);
		m.addAttribute("cartItems", cartItems);
		int totalPurchaseAmount = cartItemDAO.calculateTotalPurchaseAmount(cartItems);
		m.addAttribute("totalPurchaseAmount",totalPurchaseAmount);
		
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setPaymentMode(paymentType);
		orderDetail.setUserName(userName);
		orderDetail.setTotalPurchaseAmount(totalPurchaseAmount);
		orderDetail.setOrderDate(new java.util.Date());
		
		orderDetailDAO.insertOrderDetail(orderDetail);
		cartItemDAO.updateCartItems(userName);
		m.addAttribute("orderDetail",orderDetail);
		return "Receipt";
	}
	
}
