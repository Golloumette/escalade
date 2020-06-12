package org.openclassroom.escalade.dao;

import java.util.List;

import org.openclassroom.escalade.model.SiteBo;

public interface SiteDao {
	public List<SiteBo> liste();

	public SiteBo insertion (SiteBo siteBo);
	
	
}
