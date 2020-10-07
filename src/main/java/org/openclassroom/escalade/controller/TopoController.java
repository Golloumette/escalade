package org.openclassroom.escalade.controller;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.openclassroom.escalade.business.TopoService;
import org.openclassroom.escalade.business.UtilisateurService;
import org.openclassroom.escalade.model.SecteurBo;
import org.openclassroom.escalade.model.TopoBo;
import org.openclassroom.escalade.model.UtilisateurBo;
import org.openclassroom.escalade.model.VoieBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/topo")
	public class TopoController {
@Autowired
private TopoService topoService;

@Autowired
private UtilisateurService utilisateurService;

@RequestMapping("/liste")
		public ModelAndView liste() {
	
	List<TopoBo> topoBos = topoService.liste();
			ModelAndView mv = new ModelAndView("topo/liste");
			mv.addObject("topoBos", topoBos);
			mv.addObject("topo", "Bonjour, voici les topos");
			return mv;

	}

@RequestMapping("/mestopos")
	public ModelAndView mestopos(HttpServletRequest request) {
	String userLoged=request.getUserPrincipal().getName();
	
	UtilisateurBo utilisateurBo = utilisateurService.findByPseudo(userLoged) ;
	
	ModelAndView mv = new ModelAndView("topo/mestopos");
	
		
		List<TopoBo> topoBos = topoService.liste(utilisateurBo);
		//TopoBo topoBo = topoService.getById(id);
		mv.addObject("topoBos",topoBos);	

	return mv;
}


@RequestMapping("/edit")
public ModelAndView edit (@RequestParam (required=false) Integer id) {
	ModelAndView mv2 = new ModelAndView("topo/edit");
	if(id!=null) {
	TopoBo topoBo = topoService.getById(id);
		mv2.addObject("topoBo",topoBo);
	}
	mv2.addObject("topo","liste de mes topos");
	return mv2;
	}

@RequestMapping("/update")

public String update(HttpServletRequest request) {
	
	
	String userLoged2=request.getUserPrincipal().getName();
	
	UtilisateurBo utilisateurBo2 = utilisateurService.findByPseudo(userLoged2) ;
	
	
	String id = request.getParameter("id");
	String nom = request.getParameter("nom");
	String description= request.getParameter("description");
	String lieu = request.getParameter("lieu");
	String dt_parution = request.getParameter("dt_parution");
	Boolean disponible = Boolean.parseBoolean(request.getParameter("disponible"));
	
	
	if (id==null|| id.equals("")) {
		
		System.out.println("topoinsertion"+id);
		
	TopoBo topoBo = new TopoBo();
	topoBo.setNom(nom);
	topoBo.setDescription(description);
	topoBo.setLieu(lieu);
	 SimpleDateFormat  sdf = new SimpleDateFormat("yyyy-MM-dd");
	try {
		topoBo.setDt_parution(sdf.parse(dt_parution));
	} catch (ParseException e) {
		topoBo.setDt_parution(null);
	}
	
	topoBo.setDisponible(disponible);
	topoBo.setUtilisateurBo(utilisateurBo2);
	
	
	topoService.insertion(topoBo);
	
	} else {
		
		TopoBo topoBo = topoService.getById(Integer.parseInt(id));
		topoBo.setNom(nom);
		topoBo.setDescription(description);
		topoBo.setLieu(lieu);
		 SimpleDateFormat  sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				topoBo.setDt_parution(sdf.parse(dt_parution));
			} catch (ParseException e) {
				topoBo.setDt_parution(null);
				
			}
		topoBo.setDisponible(disponible);
		
		
		topoService.update(topoBo);
		
	}
		
		
	return "redirect:/topo/liste.html";
}

@RequestMapping("/delete")

public String delete(@RequestParam(required=true)Integer id) {

	topoService.deleteById(id);
	
	
	return "redirect:/topo/mestopos.html";
}

}