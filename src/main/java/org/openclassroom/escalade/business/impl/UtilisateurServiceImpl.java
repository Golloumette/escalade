package org.openclassroom.escalade.business.impl;


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
		return utilisateurDao.liste();
	}
	@Override
	@Transactional
	public UtilisateurBo insertion (UtilisateurBo utilisateurBo) {
		return utilisateurDao.insertion(utilisateurBo);
	}
	@Override
	@Transactional
	public UtilisateurBo update(UtilisateurBo utilisateurBo) {
		return utilisateurDao.update(utilisateurBo);

	}
	@Override
	@Transactional
	public UtilisateurBo getById(Integer id) {

		return utilisateurDao.getById (id);
	}
	@Override
	@Transactional
	public void deleteById(Integer id) {

		 utilisateurDao.deleteById(id);
	}
}
