package com;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController 
{
	@RequestMapping(value="/RegisterUser",method=RequestMethod.POST)
	public String insertUser()
	{
		return "index";
	}
}
