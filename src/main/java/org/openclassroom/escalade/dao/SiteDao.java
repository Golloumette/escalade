package org.openclassroom.escalade.dao;

import java.util.List;

import org.openclassroom.escalade.model.SiteBo;

public interface SiteDao {
	public List<SiteBo> liste();
	public List<SiteBo> liste(Integer id);
	public SiteBo insertion (SiteBo siteBo);
	public SiteBo update(SiteBo siteBo);
	public SiteBo getById(Integer id);
	public void deleteById(Integer id);
	
	
}
