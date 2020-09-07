package org.openclassroom.escalade.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.openclassroom.escalade.business.LongueurService;
import org.openclassroom.escalade.business.VoieService;
import org.openclassroom.escalade.model.LongueurBo;
import org.openclassroom.escalade.model.VoieBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/longueur")
public class LongueurController {
	
	@Autowired
	private LongueurService longueurService;
	
	@Autowired
	private VoieService voieService;
	
	@RequestMapping("/liste")
	public ModelAndView liste() {
		
		List<LongueurBo> longueurBos= longueurService.liste();
		ModelAndView mv = new ModelAndView("longueur/liste");
		mv.addObject("longueurBos",longueurBos);
		return mv;
	
		
	}
	
	@RequestMapping("/ajouter")
	public ModelAndView ajouter () {
		ModelAndView mv = new ModelAndView("longueur/ajouter");
		return mv;
	}

	@RequestMapping("/edit")
	public ModelAndView edit (@RequestParam(required=false) Integer id) {
		ModelAndView mv2 = new ModelAndView("longueur/edit");
		if(id!=null) {
			LongueurBo longueurBo = longueurService.getById(id);
			mv2.addObject("longueurBo",longueurBo);
			
		}
		List<VoieBo> voieBos = voieService.liste();		
		mv2.addObject("voieBos",voieBos);
		return mv2;
	}
	
	@RequestMapping("/update")
	public String update(HttpServletRequest request) {
		System.out.println("methode update controller longueur");
		String id = request.getParameter("id");
		String nom = request.getParameter("nom");
		String cotation = request.getParameter("cotation");
		String subdivision = request.getParameter("subdivision");
		String spit = request.getParameter("spit");
		
		if(id==null || id.equals("")) {
			LongueurBo longueurBo = new LongueurBo();
			longueurBo.setNom(nom);
			longueurBo.setCotation(cotation);
			longueurBo.setSubdivision(subdivision);
			longueurBo.setVoieBo(voieService.getById(Integer.parseInt(request.getParameter("voie_id"))));
			
			longueurService.insertion(longueurBo);
			
		}else {
			LongueurBo longueurBo = longueurService.getById(Integer.parseInt(id));
			longueurBo.setNom(nom);
			longueurBo.setCotation(cotation);
			longueurBo.setSubdivision(subdivision);
			longueurBo.setSpit(spit);
			longueurBo.setVoieBo(voieService.getById(Integer.parseInt(request.getParameter("voie_id"))));
			longueurService.update(longueurBo);
		}
		return "redirect:/site/liste.html";
	}
	
	
}
