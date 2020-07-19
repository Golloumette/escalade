package org.openclassroom.escalade.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.openclassroom.escalade.business.TopoService;
import org.openclassroom.escalade.model.TopoBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/topo")
	public class TopoController {
@Autowired
private TopoService topoService;

@RequestMapping("/liste")
		public ModelAndView liste() {
	
	List<TopoBo> topoBos = topoService.liste();
			ModelAndView mv = new ModelAndView("topo/liste");
			mv.addObject("topoBos", topoBos);
		
			return mv;

	}
@RequestMapping("/edit")
public ModelAndView liste2() {

List<TopoBo> topoBos = topoService.liste();
	ModelAndView mv = new ModelAndView("topo/edit");
	mv.addObject("topoBos", topoBos);

	return mv;


	}
@RequestMapping("/update")
public String update(HttpServletRequest request) {
	String nom = request.getParameter("nom");
	String description= request.getParameter("description");
	String lieu = request.getParameter("lieu");
	String dt_parution = request.getParameter("dt_parution");
	
	
	
	TopoBo topoBo = new TopoBo();
	topoBo.setNom(nom);
	topoBo.setDescription(description);
	topoBo.setLieu(lieu);
	topoBo.setDt_parution(dt_parution);

	
	
	topoService.insertion(topoBo);
	
	return "redirect:/topo/liste.html";
}
}


