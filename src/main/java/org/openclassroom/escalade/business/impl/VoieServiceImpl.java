package org.openclassroom.escalade.business.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.openclassroom.escalade.business.VoieService;
import org.openclassroom.escalade.dao.VoieDao;
import org.openclassroom.escalade.model.VoieBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoieServiceImpl implements VoieService {
	@Autowired
	private VoieDao voieDao;
	
	@Transactional
	@Override
	public List<VoieBo>liste(){
		return voieDao.liste();
	}

	@Override
	public List<VoieBo> liste(Integer id) {
		// TODO Auto-generated method stub
		return voieDao.liste(id);
	}

	@Override
	public VoieBo insertion(VoieBo voieBo) {
		// TODO Auto-generated method stub
		return voieDao.insertion(voieBo);
	}

	@Override
	public VoieBo deleteById(Integer id) {
		// TODO Auto-generated method stub
		return voieDao.deleteById(id);
	}

	@Override
	public VoieBo getById(Integer id) {
		// TODO Auto-generated method stub
		return voieDao.getById(id);
		
	}

	@Override
	public VoieBo update(VoieBo voieBo) {
		// TODO Auto-generated method stub
		return voieDao.update(voieBo);
	}

}
