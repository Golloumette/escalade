package org.openclassroom.escalade.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.openclassroom.escalade.business.SecteurService;
import org.openclassroom.escalade.business.SiteService;
import org.openclassroom.escalade.model.SecteurBo;
import org.openclassroom.escalade.model.SiteBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
// url 
@RequestMapping("/site")
public class SiteController {
	@Autowired 
	private SiteService siteService;
	@Autowired
	private SecteurService secteurService;

	//affiche la liste des sites
	@RequestMapping("/liste")
	public ModelAndView liste() {

		List<SiteBo> siteBos= siteService.liste();//interroge le service
		ModelAndView mv = new ModelAndView("site/liste");// localisation du  jsp dossier+nom jsp
		mv.addObject("siteBos", siteBos);//on la donne au jsp;
		mv.addObject("site", "Bonjour , voici les sites");
		return mv;
	}
	
	//modifier un site existant selectionner par ID et afficher les secteurs
	@RequestMapping("/edit")
	public ModelAndView edit(@RequestParam (required=false) Integer id) {
		ModelAndView mv2 = new ModelAndView("site/edit");
		if (id!= null) {
			SiteBo	siteBo = siteService.getById(id);
			mv2.addObject("siteBo", siteBo);
			List<SecteurBo> secteurBos= secteurService.liste(id);
			mv2.addObject("secteurBos", secteurBos);
		}
		
		mv2.addObject("secteur", "Bonjour , voici les secteurs");
		return mv2;
	}

	//ajouter un site si pas existant ou modifier un site existant
	@RequestMapping("/update")
	public String update(HttpServletRequest request) {
		String id = request.getParameter("id");
		String nom = request.getParameter("nom");
		String lieu = request.getParameter("lieu");

		if (id==null|| id.equals("")) {
			SiteBo siteBo = new SiteBo();
			siteBo.setNom(nom);
			siteBo.setLieu(lieu);


			siteService.insertion(siteBo);
			
		}else {
		SiteBo siteBo = siteService.getById(Integer.parseInt(id));
		siteBo.setNom(nom);
		siteBo.setLieu(lieu);
		
		siteService.update(siteBo);
		}
		

		return "redirect:/site/liste.html";
	}
}
