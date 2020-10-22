package org.openclassroom.escalade.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class AccueilController {
			@RequestMapping("/accueil")
			public ModelAndView accueil(HttpServletRequest request)
			{
			if (request.getUserPrincipal()!=null)

			System.out.println(request.getUserPrincipal().getName());

			ModelAndView mv = new ModelAndView("accueil");
			return mv;
			}	
	
			@RequestMapping("/login")
	
			public String login() {
			return "login";
	
			}
	
			@RequestMapping("/")
			public ModelAndView index(HttpServletRequest request) {
			ModelAndView mv = new ModelAndView("accueil");
			return mv;
			}


}