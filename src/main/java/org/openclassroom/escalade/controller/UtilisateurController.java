package org.openclassroom.escalade.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.openclassroom.escalade.business.UtilisateurService;
import org.openclassroom.escalade.model.UtilisateurBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/utilisateur")
public class UtilisateurController {
	
	@Autowired
	private UtilisateurService utilisateurService;
	
	@RequestMapping("/liste")
	public ModelAndView liste() {
		
		List<UtilisateurBo> utilisateurBos= utilisateurService.liste();
		ModelAndView mv = new ModelAndView("site/utilisateur");
		mv.addObject("utilisateurBos", utilisateurBos);
		return mv;
		
		
	}
	@RequestMapping("/update")
	public String update(HttpServletRequest request) {
		String nom = request.getParameter("nom");
		
		 UtilisateurBo utilisateurBo = new UtilisateurBo();
		 utilisateurBo.setNom(nom);
		 
		
		utilisateurService.insertion(utilisateurBo);
		
		return "redirect:/utilisateur/liste.html";
	}
	
	
}

