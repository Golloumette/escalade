package org.openclassroom.escalade.business;

import java.util.List;


import org.openclassroom.escalade.model.TopoBo;

public interface TopoService {
	public List<TopoBo> liste();
	public TopoBo insertion (TopoBo topoBo);
	public TopoBo update (TopoBo topoBo);
}
