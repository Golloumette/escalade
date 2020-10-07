package org.openclassroom.escalade.dao;

import java.util.List;

import org.openclassroom.escalade.model.TopoBo;
import org.openclassroom.escalade.model.UtilisateurBo;

public interface TopoDao {
	public List<TopoBo> liste();
	
	public TopoBo insertion (TopoBo topoBo);

	public TopoBo update(TopoBo topoBo);

	public TopoBo getById(Integer id);

	public void deleteById(Integer id);

	public List<TopoBo> liste(Integer id);

	public List<TopoBo> liste(UtilisateurBo utilisateurBo);
	

}
