package org.openclassroom.escalade.controller;

import java.util.List;

import org.openclassroom.escalade.business.SiteService;
import org.openclassroom.escalade.model.SiteBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
// url 
@RequestMapping("/site")
public class SiteController {
	@Autowired 
	private SiteService siteService;
	
	@RequestMapping("/liste")
	public ModelAndView liste() {
		
		List<SiteBo> siteBos= siteService.liste();//interroge le service
		ModelAndView mv = new ModelAndView("site/liste");// localisation du  jsp dossier+nom jsp
		mv.addObject("siteBos", siteBos);//on la donne au jsp;
		mv.addObject("site", "Bonjour , voici les sites");
		return mv;

	}
}
