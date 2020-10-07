package org.openclassroom.escalade.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.openclassroom.escalade.business.SecteurService;
import org.openclassroom.escalade.business.VoieService;
import org.openclassroom.escalade.model.SecteurBo;
import org.openclassroom.escalade.model.VoieBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/voie")
public class VoieController {
	
	@Autowired
	private VoieService voieService;
	
	@Autowired
	private SecteurService secteurService;
	
	
	@RequestMapping("/liste")
	public ModelAndView liste() {
		List<VoieBo> voieBos= voieService.liste();//interroge le service
		ModelAndView mv = new ModelAndView("voie/liste");// localisation du  jsp dossier+nom jsp
		mv.addObject("voieBos", voieBos);
		mv.addObject("voie", "Bonjour , voici les voies");
		return mv;
	}
	
	@RequestMapping("/edit")
	public ModelAndView edit (@RequestParam(required=false) Integer id) {
		ModelAndView mv2 = new ModelAndView("voie/edit");
		if(id!=null) {
			VoieBo voieBo = voieService.getById(id);
			mv2.addObject("voieBo",voieBo);
			
		}
		List<SecteurBo> secteurBos = secteurService.liste();
		mv2.addObject("secteurBos",secteurBos);
		return mv2;
		
	}
	@RequestMapping("/update")
	
	public String update(HttpServletRequest request) {
		System.out.println("methode update controller voie");
		String id = request.getParameter("id");
		String nom = request.getParameter("nom");
		String cotation = request.getParameter("cotation");
		String subdivision = request.getParameter("subdivision");
		Boolean equipe = Boolean.parseBoolean(request.getParameter("equipe"));
		
		

		if (id==null|| id.equals("")) {
			VoieBo voieBo = new VoieBo();
			voieBo.setNom(nom);
			voieBo.setCotation(Integer.parseInt(cotation));
			voieBo.setSubdivision(subdivision);
			voieBo.setEquipe(equipe);
		    voieBo.setSecteurBo(secteurService.getById(Integer.parseInt(request.getParameter("secteur_id"))));
		


			voieService.insertion(voieBo);

		}else {
			VoieBo voieBo = voieService.getById(Integer.parseInt(id));
			voieBo.setNom(nom);
			voieBo.setCotation(Integer.parseInt(cotation));
			voieBo.setSubdivision(subdivision);
			voieBo.setEquipe(equipe);
		
			voieBo.setSecteurBo(secteurService.getById(Integer.parseInt(request.getParameter("secteur_id"))));
			voieService.update(voieBo);
		}


		return "redirect:/site/liste.html";

}
	@RequestMapping("/delete")
	public String delete(@RequestParam(required=true) Integer id) {	
			voieService.deleteById(id);
		
		
		return "redirect:/site/liste.html";
}
	@RequestMapping("/maj")
	public String maj(){
		System.out.println("maj ok");
		return null;
	}
}