package org.openclassroom.escalade.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
// url 
@RequestMapping("/test")
public class TestController {
	@RequestMapping("/hello")
	public ModelAndView showMessage() {

		ModelAndView mv = new ModelAndView("helloworld");// nom du jsp 
		mv.addObject("topos", "Bonjour , voici les topos");
		return mv;

	}
}
