package org.openclassroom.escalade.dao;

import java.util.List;

import org.openclassroom.escalade.model.UtilisateurBo;

public interface UtilisateurDao {
	public List<UtilisateurBo> liste();
	
	public UtilisateurBo insertion ( UtilisateurBo utilisateurBo);

}