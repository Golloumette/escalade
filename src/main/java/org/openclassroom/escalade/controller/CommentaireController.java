package org.openclassroom.escalade.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.openclassroom.escalade.business.CommentaireService;
import org.openclassroom.escalade.business.SiteService;
import org.openclassroom.escalade.business.UtilisateurService;
import org.openclassroom.escalade.model.CommentaireBo;
import org.openclassroom.escalade.model.SiteBo;
import org.openclassroom.escalade.model.UtilisateurBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/commentaire")
public class CommentaireController {
	
	@Autowired
	private CommentaireService commentaireService;
	
	@Autowired
	private SiteService siteService;
	
	@Autowired
	private UtilisateurService utilisateurService;
	
	@RequestMapping("/edit")
	
	public ModelAndView edit(@RequestParam (required=false)Integer id,@RequestParam(required=false) Integer site_id) {
		System.out.println("controller edit");
		ModelAndView mv2 = new ModelAndView("commentaire/edit");
		if(id!=null) {
			CommentaireBo commentaireBo = commentaireService.getById(id);
			mv2.addObject("commentaireBo",commentaireBo);
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
	public String update (HttpServletRequest request) {
		String userLoged2=request.getUserPrincipal().getName();
		UtilisateurBo utilisateurBo2 = utilisateurService.findByPseudo(userLoged2);
		
		
		String id = request.getParameter("id");
		String text = request.getParameter("text");
		String dt_comment = request.getParameter("dt_comment");
		
		if(id==null || id.equals("")) {
			
			CommentaireBo commentaireBo = new CommentaireBo();
			commentaireBo.setText(text);
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			try {
			commentaireBo.setDt_comment(sdf.parse(dt_comment));
			} catch (ParseException e) {
				commentaireBo.setDt_comment(null);
			}
			//commentaireBo.setUtilisateurBos(utilisateurBo2);
			//commentaireBo.setSiteBo(siteService.getById(Integer.parseInt(request.getParameter("site_id"))));
			
		} else {
			
			CommentaireBo commentaireBo = commentaireService.getById(Integer.parseInt(id));
			commentaireBo.setText(text);
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			try {
			commentaireBo.setDt_comment(sdf.parse(dt_comment));
			} catch (ParseException e) {
				commentaireBo.setDt_comment(null);
			}
			//commentaireBo.setUtilisateurBos(utilisateurBo2);
			//commentaireBo.setSiteBo(siteService.getById(Integer.parseInt(request.getParameter("site_id"))));
			
			commentaireService.update(commentaireBo);
			
		}
		
		return "redirect:/site/liste.html";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam(required=true)Integer id) {
		commentaireService.deleteById(id);
		
		return "redirect:/site/liste.html";
	}

}