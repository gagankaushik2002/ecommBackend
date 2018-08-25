package com;

import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dao.ProductDAO;
import com.dao.CategoryDAO;
import com.dao.SupplierDAO;
import com.model.Product;

@Controller
public class LoginController 
{
	@Autowired
	ProductDAO productDAO;
	@Autowired
	CategoryDAO categoryDAO;
	@Autowired
	SupplierDAO supplierDAO;
	
	@RequestMapping("/logout")
	public Boolean testLogout()
	{
		System.out.println("testing logout");
		return true;
	}
	
	@RequestMapping(value="/loginpage")
	public String showLoginPage()
	{
		return "Login";
	}
	
	//@RequestMapping("/perform_Login")
	@RequestMapping("/login_success")
	public String loginSuccess(Model m,HttpSession session )
	{	
		System.out.println("login_success 1");
		String page = "";
		boolean loggedIn = false;
		
		SecurityContext securityContext=SecurityContextHolder.getContext();
		Authentication authentication = securityContext.getAuthentication();
		
		String username = authentication.getName();
		System.out.println("login_success 2=user="+username);
		
		Collection<GrantedAuthority> roles =(Collection<GrantedAuthority>)authentication.getAuthorities();
		for(GrantedAuthority role:roles)
		{
			session.setAttribute("role", role.getAuthority());
			System.out.println("role loop="+role.getAuthority());
			if (role.getAuthority().equals("ROLE_USER"))
			{
				loggedIn = true;
				page = "ProductDisplay";
				m.addAttribute("productList",productDAO.listProducts());
				//session.setAttribute("loggedIn",loggedIn);
				//session.setAttribute("username",username);
			}
			else
			{
				loggedIn = true;
				page = "ManageProduct";
				Product product = new Product();
				m.addAttribute(product);
				
				m.addAttribute("categoryList",categoryDAO.getCategories());
				m.addAttribute("supplierList",supplierDAO.getSuppliers());
				
				m.addAttribute("productList",productDAO.listProducts());
				//session.setAttribute("loggedIn",loggedIn);
				//session.setAttribute("username",username);
			}
			session.setAttribute("loggedIn",loggedIn);
			session.setAttribute("username",username);
		}
		System.out.println("login_success 3 page="+page);
		return page;
	}
	
	/*
	@RequestMapping("/loginFromPage")
	public String loginFromPage(Model m,HttpSession session )
	{	
		System.out.println("loginFromPage 1");
		String page = "";
		boolean loggedIn = false;
		
		SecurityContext securityContext=SecurityContextHolder.getContext();
		Authentication authentication = securityContext.getAuthentication();
		
		String username = authentication.getName();
		System.out.println("loginFromPage 2=user="+username);
		
		Collection<GrantedAuthority> roles =(Collection<GrantedAuthority>)authentication.getAuthorities();
		for(GrantedAuthority role:roles)
		{
			session.setAttribute("role", role.getAuthority());
			System.out.println("role loop="+role.getAuthority());
			if (role.getAuthority().equals("Role_User"))
			{
				loggedIn = true;
				page = "ProductDisplay";
				m.addAttribute("productList",productDAO.listProducts());
				//session.setAttribute("loggedIn",loggedIn);
				//session.setAttribute("username",username);
			}
			else
			{
				loggedIn = true;
				page = "ManageProduct";
				Product product = new Product();
				m.addAttribute(product);
				
				m.addAttribute("categoryList",categoryDAO.getCategories());
				m.addAttribute("supplierList",supplierDAO.getSuppliers());
				
				m.addAttribute("productList",productDAO.listProducts());
				//session.setAttribute("loggedIn",loggedIn);
				//session.setAttribute("username",username);
			}
			session.setAttribute("loggedIn",loggedIn);
			session.setAttribute("username",username);
		}
		System.out.println("loginFromPage 3 page="+page);
		return page;
	}
	*/
}
