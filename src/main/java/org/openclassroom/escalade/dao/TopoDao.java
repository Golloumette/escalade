package org.openclassroom.escalade.dao;

import java.util.List;

import org.openclassroom.escalade.model.TopoBo;

public interface TopoDao {
	public List<TopoBo> liste();
	
	public TopoBo insertion (TopoBo topoBo);

}
