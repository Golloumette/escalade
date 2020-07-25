package org.openclassroom.escalade.dao;

import java.util.List;

import org.openclassroom.escalade.model.VoieBo;

public interface VoieDao {
	public List<VoieBo> liste();
	public VoieBo insertion(VoieBo voieBo);
	public List<VoieBo> liste(Integer id);
	public VoieBo deleteById(Integer id);
	public VoieBo update(VoieBo voieBo);
	public VoieBo getById(Integer id);

}
