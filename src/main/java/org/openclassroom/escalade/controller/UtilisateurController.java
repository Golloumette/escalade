package org.openclassroom.escalade.controller;


import java.util.List;

import org.openclassroom.escalade.business.UtilisateurService;
import org.openclassroom.escalade.model.UtilisateurBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/site")
public class UtilisateurController {
	
	@Autowired
	private UtilisateurService utilisateurService;
	
	@RequestMapping("/inscription")
	public ModelAndView liste() {
		
		List<UtilisateurBo> utilisateurBos= utilisateurService.liste();
		ModelAndView mv = new ModelAndView("site/utilisateur");
		mv.addObject("utilisateurBos", utilisateurBos);
		return mv;
	}
}
