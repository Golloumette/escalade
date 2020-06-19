package org.openclassroom.escalade.business.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.openclassroom.escalade.business.TopoService;
import org.openclassroom.escalade.dao.TopoDao;

import org.openclassroom.escalade.model.TopoBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopoServiceImpl implements TopoService {
@Autowired
private TopoDao topoDao;

	public List<TopoBo> liste() {
		
		return topoDao.liste();
		
	
	}
	@Transactional
	public TopoBo insertion (TopoBo topoBo) {
		return topoDao.insertion(topoBo);
	}
	
	}


