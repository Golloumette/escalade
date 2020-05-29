package org.openclassroom.escalade.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class AccueilController {
	@RequestMapping("/accueil")
	public ModelAndView accueil() {
		ModelAndView mv = new ModelAndView("accueil");
		return mv;

}
}