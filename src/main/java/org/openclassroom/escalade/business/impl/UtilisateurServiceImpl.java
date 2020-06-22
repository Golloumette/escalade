package org.openclassroom.escalade.business.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.openclassroom.escalade.business.UtilisateurService;
import org.openclassroom.escalade.dao.UtilisateurDao;
import org.openclassroom.escalade.model.UtilisateurBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UtilisateurServiceImpl implements UtilisateurService {
	@Autowired
	private UtilisateurDao utilisateurDao;
	
	public List<UtilisateurBo> liste() {
		List<UtilisateurBo> utilisateurBos = new ArrayList<UtilisateurBo>();
	
		UtilisateurBo utilisateurBo = new UtilisateurBo();
		utilisateurBo.setId(1);
		utilisateurBo.setNom("nom");
		utilisateurBo.setPrenom("prenom");
		utilisateurBo.setPseudo("pseudo");
		utilisateurBo.setMdp("mdp");
		utilisateurBo.setAdresse("adresse");
		utilisateurBo.setPostal("postal");
		utilisateurBo.setVille("ville");
		utilisateurBo.setMail("mail");
		utilisateurBo.setTel("tel");
		utilisateurBo.setLicencie(true);
		utilisateurBos.add(utilisateurBo);
		
		return utilisateurBos;
		
	}
@Transactional
public UtilisateurBo insertion (UtilisateurBo utilisateurBo) {
	return utilisateurDao.insertion(utilisateurBo);
}
@Override
@Transactional
public UtilisateurBo update(UtilisateurBo utilisateurBo) {
	return utilisateurDao.update(utilisateurBo);
	
	
}
}
