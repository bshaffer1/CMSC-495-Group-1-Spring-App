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
public class InitialPageController {

	@RequestMapping(value = "/initial-page", method = RequestMethod.GET)
	public String initialPage(HttpServletRequest request, Model model){
		return "Initial-Page";
	}
}
