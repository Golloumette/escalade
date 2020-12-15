package org.openclassroom.escalade.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.openclassroom.escalade.business.UtilisateurService;
import org.openclassroom.escalade.model.UtilisateurBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class CustomSuccessHandler implements AuthenticationSuccessHandler {
	@Autowired
	UtilisateurService utilisateurService;
	

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		String userLoged = request.getUserPrincipal().getName();
		UtilisateurBo utilisateurBo=utilisateurService.findByPseudo(userLoged);
		
		  HttpSession session = request.getSession();

	        session.setAttribute("utilisateurBo", utilisateurBo);
	       
	     
		

		
		
	}
	
	
	
	

}
