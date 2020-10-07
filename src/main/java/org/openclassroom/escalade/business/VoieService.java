package org.openclassroom.escalade.business;

import java.util.List;

import org.openclassroom.escalade.model.VoieBo;


public interface VoieService {

	public List<VoieBo> liste();
	public List<VoieBo> liste(Integer id);
	public VoieBo insertion(VoieBo voieBo);
	public void deleteById(Integer id);
	public VoieBo getById(Integer id);
	public VoieBo update(VoieBo voieBo);

}
