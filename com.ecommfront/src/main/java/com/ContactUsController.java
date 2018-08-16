package com;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ContactUsController 
{
	@RequestMapping(value="/ContactInsert",method=RequestMethod.POST)
	public String insertProduct()
	{
		return "index";
	}
}
