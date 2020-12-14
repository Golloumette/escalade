package org.openclassroom.escalade.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.openclassroom.escalade.business.CommentaireService;
import org.openclassroom.escalade.business.LongueurService;
import org.openclassroom.escalade.business.SecteurService;
import org.openclassroom.escalade.business.SiteService;
import org.openclassroom.escalade.business.UtilisateurService;
import org.openclassroom.escalade.business.VoieService;
import org.openclassroom.escalade.enume.RoleEnum;
import org.openclassroom.escalade.model.CommentaireBo;
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
// url 
@RequestMapping("/site")
public class SiteController {
	@Autowired 
	private SiteService siteService;
	@Autowired
	private SecteurService secteurService;
	@Autowired
	private VoieService voieService;
	@Autowired
	private LongueurService longueurService;
	@Autowired
	private CommentaireService commentaireService;
	@Autowired
	private UtilisateurService utilisateurService;

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
	public ModelAndView edit(@RequestParam (required=false) Integer id,HttpServletRequest request) {
		ModelAndView mv2 = new ModelAndView("site/edit");
		if (id!= null) {
			SiteBo	siteBo = siteService.getById(id);
			mv2.addObject("siteBo", siteBo);

			List<SecteurBo> secteurBos= secteurService.liste(id);
			mv2.addObject("secteurBos", secteurBos);

			List<VoieBo> voieBos= voieService.liste(id);
			mv2.addObject("voieBos", voieBos);

			List<LongueurBo> longueurBos= longueurService.liste(id);
			mv2.addObject("longeurBos",longueurBos);
			
			List<CommentaireBo> commentaireBos= commentaireService.liste(id);
			mv2.addObject("commentaireBos", commentaireBos);
			
			UtilisateurBo utilisateurBo = utilisateurService.findByPseudo(request.getUserPrincipal().getName());
			mv2.addObject("utilisateurBo", utilisateurBo);
		}

		mv2.addObject("secteur", "Détail du site secteur,voie et longueur");
		return mv2;
	}

	//ajouter un site si pas existant ou modifier un site existant
	@RequestMapping("/update")
	public String update(HttpServletRequest request)throws Exception {
		String id = request.getParameter("id");
		String nom = request.getParameter("nom");
		String lieu = request.getParameter("lieu");
		Boolean officiel = Boolean.parseBoolean(request.getParameter("officiel"));
		UtilisateurBo utilisateurBo = utilisateurService.findByPseudo(request.getUserPrincipal().getName());

		if(!utilisateurBo.getRole().equals(RoleEnum.ROLE_ASSO.getNum())&& officiel) {
			throw new Exception("Vous n'avez pas les droits requis");
		}
		if (id==null|| id.contentEquals("")) {
			SiteBo siteBo = new SiteBo();
			siteBo.setNom(nom);
			siteBo.setLieu(lieu);
			siteBo.setOfficiel(officiel);


			siteService.insertion(siteBo);

		}else {
			SiteBo siteBo = siteService.getById(Integer.parseInt(id));
			siteBo.setNom(nom);
			siteBo.setLieu(lieu);
			siteBo.setOfficiel(officiel);
			
			

			siteService.update(siteBo);
		}


		return "redirect:/site/liste.html";
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam(required=true)Integer id) {
		SiteBo siteBo = siteService.getById(id);
		for (SecteurBo secteurBo : siteBo.getSecteurBos() ) {

			for(VoieBo voieBo : secteurBo.getVoieBos() ) {

				for(LongueurBo longueurBo : voieBo.getLongueurBos()) {
					
					longueurService.deleteById(longueurBo.getId());
					
				}
				voieService.deleteById(voieBo.getId());
				
			}
			secteurService.deleteById(secteurBo.getId());
		}

		siteService.deleteById(id);

		return "redirect:/site/liste.html";
	}

	@RequestMapping("/search")
	
	public ModelAndView search(String nom) {
		System.out.println("entré methode search"+nom);
		List<SiteBo> siteBos= siteService.liste(nom);
		ModelAndView mv = new ModelAndView("site/liste");
		
		mv.addObject("siteBos", siteBos);
	
		return mv;
	
		
}
	@RequestMapping("/advanced")
	public ModelAndView advanced(@RequestParam(required = false)String lieu,@RequestParam(required = false)Integer nbSecteur ,@RequestParam(required = false)Byte cotation) {
		
		List<SiteBo> siteBos= siteService.liste(lieu,nbSecteur,cotation);
		ModelAndView mv = new ModelAndView("site/liste");
		mv.addObject("siteBos",siteBos);
	
		return mv;
	}
	}
