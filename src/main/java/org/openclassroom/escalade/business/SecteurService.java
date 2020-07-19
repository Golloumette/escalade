package org.openclassroom.escalade.business;

import java.util.List;

import org.openclassroom.escalade.model.SecteurBo;

public interface SecteurService {
	public List<SecteurBo> liste ();
	public List<SecteurBo>liste (Integer id);
	public SecteurBo insertion (SecteurBo secteurBo);
	public SecteurBo deleteById(Integer id);
	public SecteurBo getById(Integer id);
	public SecteurBo update(SecteurBo secteurBo);

}
