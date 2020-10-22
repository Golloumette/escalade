package org.openclassroom.escalade.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.openclassroom.escalade.business.ReservationService;
import org.openclassroom.escalade.business.TopoService;
import org.openclassroom.escalade.business.UtilisateurService;
import org.openclassroom.escalade.model.ReservationBo;
import org.openclassroom.escalade.model.TopoBo;
import org.openclassroom.escalade.model.UtilisateurBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/reservation")
public class ReservationController {

	@Autowired	
private ReservationService reservationService;
	
	@Autowired
	private UtilisateurService utilisateurService;
	
	@Autowired
	private TopoService topoService;
	
	@RequestMapping("/liste")
	public ModelAndView liste() {
		List<ReservationBo> reservationBos = reservationService.liste();
		ModelAndView mv = new ModelAndView("reservation/liste");
		mv.addObject("reservationBos", reservationBos);
		return mv;
	}
	@RequestMapping("/reservation")
	public ModelAndView liste2() {
		
		List<TopoBo> topoBos = topoService.liste();
				ModelAndView mv = new ModelAndView("topo/reservation");
				mv.addObject("topoBos", topoBos);
				mv.addObject("topo", "Voici les topos disponibles");
				
				return mv;


	}
	
	@RequestMapping("/waiting")
	public String waiting(HttpServletRequest request) {
		
		
		
		String userLoged2=request.getUserPrincipal().getName();
		
		UtilisateurBo utilisateurBo = utilisateurService.findByPseudo(userLoged2) ;
		
		Byte valider = 0;
		Byte disponible = 1;
		
		ReservationBo reservationBo = new ReservationBo();
		
		reservationBo.setUtilisateurBo(utilisateurBo);
		reservationBo.setValider(valider);
		reservationBo.setDt_reservation(new Date());
		reservationBo.setTopoBo(topoService.getById(Integer.parseInt(request.getParameter("topo_id"))));
		
		reservationService.insertion(reservationBo);
		TopoBo topoBo = topoService.getById(Integer.parseInt(request.getParameter("topo_id")));
		topoBo.setDisponible(disponible);
		topoService.update(topoBo);
		return "redirect:/topo/liste.html";
		
	}
	@RequestMapping("/validation")
	public String validation(HttpServletRequest request) {
		
		ReservationBo reservationBo = new ReservationBo();
		reservationService.validation(reservationBo);
		
		
		return "redirect:/topo/liste.html";
		
	}
}
