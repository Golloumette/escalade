package org.openclassroom.escalade.controller;
import java.util.List;

import org.openclassroom.escalade.business.TopoService;
import org.openclassroom.escalade.model.TopoBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/site")
	public class TopoController {
@Autowired
private TopoService topoService;

@RequestMapping("/topo")
		public ModelAndView liste() {
	
	List<TopoBo> topoBos = topoService.liste();
			ModelAndView mv = new ModelAndView("site/topo");
			mv.addObject("topoBos", topoBos);
			mv.addObject("topo", "Voici les topos");
			return mv;

	}
	}


