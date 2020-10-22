package org.openclassroom.escalade.business;

import java.util.List;

import org.openclassroom.escalade.model.ReservationBo;
import org.openclassroom.escalade.model.TopoBo;
import org.openclassroom.escalade.model.UtilisateurBo;

public interface TopoService {
	public List<TopoBo> liste();
	public List <TopoBo> liste(Integer id);
	public TopoBo getById(Integer id);
	public TopoBo insertion (TopoBo topoBo);
	public TopoBo update (TopoBo topoBo);
	public void deleteById(Integer id);
	public ReservationBo insertion(ReservationBo reservationBo);
	
	public List<TopoBo> liste(UtilisateurBo utilisateurBo);
	
}
