package org.openclassroom.escalade.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.openclassroom.escalade.business.UtilisateurService;
import org.openclassroom.escalade.model.UtilisateurBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/utilisateur")
public class UtilisateurController {

	@Autowired
	private UtilisateurService utilisateurService;

	@RequestMapping("/liste")
	public ModelAndView liste() {

		List<UtilisateurBo> utilisateurBos= utilisateurService.liste();
		ModelAndView mv = new ModelAndView("utilisateur/liste");
		mv.addObject("utilisateurBos", utilisateurBos);
		return mv;
	}

	@RequestMapping("/ajouter")
	public ModelAndView ajouter() {
		ModelAndView mv = new ModelAndView("utilisateur/ajouter");
		return mv;
		}


	@RequestMapping("/edit")
	public ModelAndView edit(@RequestParam(required=false) Integer id) {
		ModelAndView mv2 = new ModelAndView("utilisateur/edit");
		if(id!=null) {
			UtilisateurBo utilisateurBo = utilisateurService.getById(id);
			mv2.addObject("utilisateurBo",utilisateurBo);
		}
		List<UtilisateurBo> utilisateurBos = utilisateurService.liste();

		mv2.addObject("utilisateurBos",utilisateurBos);
		return mv2;
	}
	@RequestMapping("/update")
	public String update(HttpServletRequest request) {
		String id = request.getParameter("id");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String pseudo = request.getParameter("pseudo");
		String mdp = request.getParameter("mdp");
		String adresse = request.getParameter("adresse");
		String postal = request.getParameter("postal");
		String ville = request.getParameter("ville");
		String mail = request.getParameter("mail");
		String tel = request.getParameter("tel");
		Byte role = Byte.parseByte(request.getParameter("role"));
		
		if (id==null||id.equals("")) {

		UtilisateurBo utilisateurBo = new UtilisateurBo();
		utilisateurBo.setNom(nom);
		utilisateurBo.setPrenom(prenom);
		utilisateurBo.setPseudo(pseudo);
		utilisateurBo.setMdp(mdp);
		utilisateurBo.setAdresse(adresse);
		utilisateurBo.setPostal(postal);
		utilisateurBo.setVille(ville);
		utilisateurBo.setMail(mail);
		utilisateurBo.setTel(tel);
		utilisateurBo.setRole(role);


		utilisateurService.insertion(utilisateurBo);
		
		}else {
			UtilisateurBo utilisateurBo = utilisateurService.getById(Integer.parseInt(id));
			utilisateurBo.setNom(nom);
			utilisateurBo.setPrenom(prenom);
			utilisateurBo.setPseudo(pseudo);
			utilisateurBo.setMdp(mdp);
			utilisateurBo.setAdresse(adresse);
			utilisateurBo.setPostal(postal);
			utilisateurBo.setVille(ville);
			utilisateurBo.setMail(mail);
			utilisateurBo.setTel(tel);
			utilisateurBo.setRole(role);
			
			utilisateurService.update(utilisateurBo);
		}
		

		return "redirect:/utilisateur/liste.html";
	
	
	
}
	@RequestMapping("/delete")
	public String delete(@RequestParam (required=true) Integer id) {
		
		
			utilisateurService.deleteById(id);
		
		
		return "redirect:/utilisateur/liste.html";
	
}
}

