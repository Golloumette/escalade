package org.openclassroom.escalade.dao;

import java.util.List;

import org.openclassroom.escalade.model.LongueurBo;

public interface LongueurDao {
	public List<LongueurBo> liste();
	public LongueurBo insertion (LongueurBo longueurBo);
	public LongueurBo update(LongueurBo longueurBo);
	public LongueurBo getById(Integer id);
	public void deleteById(Integer id);
	public List<LongueurBo> liste(Integer id);
	public List<LongueurBo> liste(String cotation);

}
