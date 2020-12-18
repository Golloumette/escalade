package org.openclassroom.escalade.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
		
		if(site_id!=null){
		SiteBo siteBo = siteService.getById(site_id);
		if(siteBo!=null) {
		mv2.addObject("siteBo",siteBo);
		}	}
		
		return mv2;
		}

	
	
	@RequestMapping("/update")
	public String update (HttpServletRequest request) {
		String userLoged2=request.getUserPrincipal().getName();
		UtilisateurBo utilisateurBo2 = utilisateurService.findByPseudo(userLoged2);

		String id = request.getParameter("id");
		String text = request.getParameter("text");	
		String idSite = request.getParameter("site_id");
		String idSite2 = request.getParameter("idSite");
		
		if(id==null || id.equals("")) {
			
			
			CommentaireBo commentaireBo = new CommentaireBo();
			commentaireBo.setText(text);
			commentaireBo.setDt_comment(new Date());			
			commentaireBo.setUtilisateurBo(utilisateurBo2);			
			commentaireBo.setSiteBo(siteService.getById(Integer.parseInt(request.getParameter("site_id"))));
			
			commentaireService.insertion(commentaireBo);
			return "redirect:/site/edit.html?id="+idSite;
		} else {
			
			CommentaireBo commentaireBo = commentaireService.getById(Integer.parseInt(id));
			commentaireBo.setText(text);
			commentaireBo.setDt_comment(new Date());
			commentaireBo.setUtilisateurBo(utilisateurBo2);
			commentaireBo.setSiteBo(siteService.getById(Integer.parseInt(request.getParameter("idSite"))));
			
			commentaireService.update(commentaireBo);
			
		}
		
		return "redirect:/site/edit.html?id="+idSite2;
	}
	
	@RequestMapping("/delete")
	
	public String delete(@RequestParam(required=true)Integer id) {
	
		
		CommentaireBo commentaireBo = commentaireService.getById(id);
		
		Integer idSite = commentaireBo.getSiteBo().getId();
		
		commentaireService.deleteById(id);
		
		return "redirect:/site/edit.html?id="+idSite;
	}

}