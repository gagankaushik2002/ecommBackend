package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dao.UserDAO;
import com.model.Product;
import com.model.UserDetail;


@Controller
public class RegisterController 
{
	@Autowired
	UserDAO userDAO;
	
	
	@RequestMapping(value="/register")
	public String showRegisterPage(Model m)
	{
		UserDetail userDetail = new UserDetail();
		m.addAttribute(userDetail);
		return "Register";
	}
	
	@RequestMapping(value="/RegisterUser",method=RequestMethod.POST)
	public String insertUser(@ModelAttribute("userDetail")UserDetail userDetail,Model m)
	{
		UserDetail userDetail1 = userDAO.getUserDetail(userDetail.getUserName());
		String page = "Login";
		if( userDetail1 == null )
		{
			userDAO.registerUser(userDetail);
		}
		else 
		{
			m.addAttribute("userAlreadyExists", "1");
			page = "Register";
		}
		
		return page;
	}
}
