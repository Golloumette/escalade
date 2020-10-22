package org.openclassroom.escalade.business;

import java.util.List;

import org.openclassroom.escalade.model.ReservationBo;

public interface ReservationService {
	public ReservationBo insertion (ReservationBo reservationBo);
	public List<ReservationBo> liste();
	public ReservationBo validation (ReservationBo reservationBo);

	
}
