package org.openclassroom.escalade.dao;

import java.util.List;

import org.openclassroom.escalade.model.SecteurBo;

public interface SecteurDao {
	public List<SecteurBo> liste();
	public List<SecteurBo> liste(Integer id);
	public SecteurBo insertion (SecteurBo secteurBo);
	public void deleteById(Integer id);
	public SecteurBo update(SecteurBo secteurBo);
	public SecteurBo getById(Integer id);
	
	

}
