package org.openclassroom.escalade.business;

import java.util.List;

import org.openclassroom.escalade.model.ReservationBo;

public interface ReservationService {
	public ReservationBo insertion (ReservationBo reservationBo);
	public List<ReservationBo> liste();
	public ReservationBo update (ReservationBo reservationBo);
	
	public ReservationBo getById(Integer id);
	public ReservationBo findByValider(Byte valider);
	ReservationBo validerReservation(Integer topo_id);
	ReservationBo archiveReservation(Integer topo_id);
	
}
