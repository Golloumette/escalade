package org.openclassroom.escalade.controller;




import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.openclassroom.escalade.business.LongueurService;
import org.openclassroom.escalade.business.SecteurService;
import org.openclassroom.escalade.business.SiteService;
import org.openclassroom.escalade.business.UtilisateurService;
import org.openclassroom.escalade.business.VoieService;
import org.openclassroom.escalade.model.LongueurBo;
import org.openclassroom.escalade.model.SecteurBo;
import org.openclassroom.escalade.model.SiteBo;
import org.openclassroom.escalade.model.UtilisateurBo;
import org.openclassroom.escalade.model.VoieBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/secteur")
public class SecteurController {

	@Autowired
	private SecteurService secteurService;
	
	@Autowired
	private SiteService siteService;
	
	@Autowired
	private LongueurService longueurService;
	
	@Autowired
	private VoieService voieService;
	
	@Autowired
	private UtilisateurService utilisateurService;

	@RequestMapping("/liste")
	public ModelAndView liste() {

		List<SecteurBo> secteurBos= secteurService.liste();//interroge le service
		ModelAndView mv = new ModelAndView("secteur/liste");// localisation du  jsp dossier+nom jsp
		mv.addObject("secteurBos", secteurBos);
		mv.addObject("secteur", "Bonjour , voici les secteurs");
		
		return mv;
	}

	@RequestMapping("/edit")
	public ModelAndView edit(@RequestParam(required=false) Integer id,@RequestParam(required=false) Integer site_id, HttpServletRequest request) {
		
		ModelAndView mv2 = new ModelAndView("secteur/edit");
		UtilisateurBo utilisateurBo = utilisateurService.findByPseudo(request.getUserPrincipal().getName());
		mv2.addObject("utilisateurBo", utilisateurBo);
		if(id!=null) {
			SecteurBo secteurBo = secteurService.getById(id);
			mv2.addObject("secteurBo",secteurBo);
		}
		List<SiteBo> siteBos = siteService.liste();
		mv2.addObject("siteBos",siteBos);
		if(site_id!=null) {
		SiteBo siteBo = siteService.getById(site_id);
		mv2.addObject("siteSelectedBo",siteBo);
		}
		
		return mv2;
		}

	

	@RequestMapping("/update")
	public String update(HttpServletRequest request) {
		String id = request.getParameter("id");
		String nom = request.getParameter("nom");
		String descriptif = request.getParameter("descriptif");
		String acces = request.getParameter("acces");

		if (id==null|| id.equals("")) {
			SecteurBo secteurBo = new SecteurBo();
			secteurBo.setNom(nom);
			secteurBo.setDescriptif(descriptif);
			secteurBo.setAcces(acces);
			secteurBo.setSiteBo(siteService.getById(Integer.parseInt(request.getParameter("site_id"))));


			secteurService.insertion(secteurBo);

		}else {
			SecteurBo secteurBo = secteurService.getById(Integer.parseInt(id));
			secteurBo.setNom(nom);
			secteurBo.setDescriptif(descriptif);
			secteurBo.setAcces(acces);
			secteurBo.setSiteBo(siteService.getById(Integer.parseInt(request.getParameter("site_id"))));
			secteurService.update(secteurBo);
		}


		return "redirect:/site/liste.html";
	}
		@RequestMapping("/delete")
		public String delete(@RequestParam(required=true)Integer id) {
			SecteurBo secteurBo = secteurService.getById(id);
				for(VoieBo voieBo : secteurBo.getVoieBos() ) {

					for(LongueurBo longueurBo : voieBo.getLongueurBos()) {
					
					longueurService.deleteById(longueurBo.getId());
					
				}
				voieService.deleteById(voieBo.getId());
				
			}
			
			secteurService.deleteById(id);
			
			return "redirect:/site/liste.html";
		}



	}

