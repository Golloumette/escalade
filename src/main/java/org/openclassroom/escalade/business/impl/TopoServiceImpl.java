package org.openclassroom.escalade.business.impl;

import java.util.ArrayList;
import java.util.List;


import org.openclassroom.escalade.business.TopoService;
import org.openclassroom.escalade.model.TopoBo;
import org.springframework.stereotype.Service;
@Service
public class TopoServiceImpl implements TopoService {


	public List<TopoBo> liste() {
		// TODO Auto-generated method stub
		List<TopoBo> toposBos = new  ArrayList<TopoBo>();
		
		TopoBo topoBo = new TopoBo();
		topoBo.setId(1);
		topoBo.setNom("montblanc");
		topoBo.setLieu("alpes");
		topoBo.setDescription("escalade du mont blanc");
		topoBo.setDispo(true);
		toposBos.add(topoBo);
		
		return toposBos;
	}
	
	}


