package org.openclassroom.escalade.business.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.openclassroom.escalade.business.TopoService;
import org.openclassroom.escalade.dao.TopoDao;
import org.openclassroom.escalade.model.ReservationBo;
import org.openclassroom.escalade.model.TopoBo;
import org.openclassroom.escalade.model.UtilisateurBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopoServiceImpl implements TopoService {
@Autowired
private TopoDao topoDao;

		@Transactional
		@Override
	public List<TopoBo> liste() {
		
		return topoDao.liste();
		
	
	}
	@Transactional
	@Override
	public TopoBo insertion (TopoBo topoBo) {
		return topoDao.insertion(topoBo);
	}
	@Override
	@Transactional
	public TopoBo update(TopoBo topoBo) {
		return topoDao.update(topoBo);

	}
	@Override
	public void deleteById(Integer id) {
		topoDao.deleteById(id);
		
		
	}
	@Override
	public TopoBo getById(Integer id) {
		
		return topoDao.getById(id);
	}
	@Override
	public List<TopoBo> liste(Integer id) {
		return topoDao.liste(id);
		
		
	}
	@Override
	public List<TopoBo> liste(UtilisateurBo utilisateurBo) {
		// TODO Auto-generated method stub
		return topoDao.liste(utilisateurBo);
	}
	
	
	}


