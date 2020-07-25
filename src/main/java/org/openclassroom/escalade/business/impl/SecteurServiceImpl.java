package org.openclassroom.escalade.business.impl;

import java.util.List;

import javax.transaction.Transactional;



import org.openclassroom.escalade.business.SecteurService;
import org.openclassroom.escalade.dao.SecteurDao;
import org.openclassroom.escalade.model.SecteurBo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecteurServiceImpl implements SecteurService {
	@Autowired
	private SecteurDao secteurDao;
	
	@Transactional
	@Override
	public List<SecteurBo> liste() {
		// TODO Auto-generated method stub
		return secteurDao.liste();
	}
	@Transactional
	@Override
	public SecteurBo insertion(SecteurBo secteurBo) {
	
		return secteurDao.insertion(secteurBo);
	}
	public List<SecteurBo> liste(Integer id) {
		
		return secteurDao.liste(id);
	}
	
	@Override
	public SecteurBo deleteById(Integer id) {
		return secteurDao.deleteById(id);
	}
	@Override
	public SecteurBo getById(Integer id) {
		// TODO Auto-generated method stub
		return secteurDao.getById(id);
	}
	@Override
	public SecteurBo update(SecteurBo secteurBo) {
		// TODO Auto-generated method stub
		return secteurDao.update(secteurBo);
	}
	

}
