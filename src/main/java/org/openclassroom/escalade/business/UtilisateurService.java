package org.openclassroom.escalade.business;

import java.util.List;

import org.openclassroom.escalade.model.UtilisateurBo;

public interface UtilisateurService {
	public List<UtilisateurBo> liste ();
	public UtilisateurBo insertion (UtilisateurBo utilisateurBo);
	public UtilisateurBo update (UtilisateurBo utilisateurBo);
		
		
		
	}

	

