package org.openclassroom.escalade.controller;

import java.util.List;


import org.openclassroom.escalade.business.VoieService;
import org.openclassroom.escalade.model.VoieBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/voie")
public class VoieController {
	
	@Autowired
	private VoieService voieService;
	
	
	@RequestMapping("/liste")
	public ModelAndView liste() {
		List<VoieBo> voieBos= voieService.liste();//interroge le service
		ModelAndView mv = new ModelAndView("voie/liste");// localisation du  jsp dossier+nom jsp
		mv.addObject("voieBos", voieBos);
		mv.addObject("voie", "Bonjour , voici les voies");
		return mv;
	}

}
