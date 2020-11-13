package org.openclassroom.escalade.business.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.openclassroom.escalade.business.LongueurService;
import org.openclassroom.escalade.dao.LongueurDao;
import org.openclassroom.escalade.model.LongueurBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LongueurServiceImpl implements LongueurService {

	@Autowired
	private LongueurDao longueurDao;
	
	
	@Transactional
	@Override
	public List<LongueurBo> liste() {
		return longueurDao.liste();
	}
	@Transactional
	@Override
	public LongueurBo insertion(LongueurBo longueurBo) {
		return longueurDao.insertion(longueurBo);
	}

	@Override
	public LongueurBo update(LongueurBo longueurBo) {
		return longueurDao.update(longueurBo);
	}

	@Override
	public LongueurBo getById(Integer id) {
		return longueurDao.getById(id);
	}

	@Override
	public void deleteById(Integer id) {
		longueurDao.deleteById(id);
		
	}
	@Override
	public List<LongueurBo> liste(Integer id) {
		// TODO Auto-generated method stub
		return longueurDao.liste(id);
	}
	@Override
	public List<LongueurBo> liste(String cotation) {
	
		return longueurDao.liste(cotation);
	}

}
