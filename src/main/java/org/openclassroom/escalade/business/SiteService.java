package org.openclassroom.escalade.business;

import java.util.List;

import org.openclassroom.escalade.model.SiteBo;


public interface SiteService {
	public List<SiteBo> liste ();
	public List<SiteBo> liste(Integer id);
	public SiteBo insertion (SiteBo siteBo);
	public SiteBo update (SiteBo siteBo);
	public SiteBo getById (Integer id);
	public void deleteById(Integer id);
	public List<SiteBo> liste(String nom);
	public List<SiteBo> liste(String lieu, Integer nbSecteur, Byte cotation);

}
    