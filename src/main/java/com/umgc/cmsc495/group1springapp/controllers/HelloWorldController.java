package com.umgc.cmsc495.group1springapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Author: Brandon Shaffer
 * Date: 11/13/2021
 */
@Controller
public class HelloWorldController {

	@RequestMapping(value = "/hello-world", method = RequestMethod.GET)
	public String helloWorld(HttpServletRequest request, Model model){
		String name = request.getParameter("name");

		if(name == null || name.isEmpty()){
			name = "World";
		}

		model.addAttribute("message", "Hello, " + name + "!");

		return "hello-world";
	}
}
