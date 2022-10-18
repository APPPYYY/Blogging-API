package com.esspl.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

	@RequestMapping(value={"/","/index"})
	public ModelAndView index(ModelMap model) {
		ModelAndView mv=new ModelAndView("masterpage");
		model.put("UserClickIndex", true);
		model.put("title","Index");
		return mv;
	}
	
	@RequestMapping("/home")
	public ModelAndView home(ModelMap model) {
		ModelAndView mv=new ModelAndView("masterpage");
		model.put("title","Home");
		model.put("UserClickHome", true);
		return mv;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
