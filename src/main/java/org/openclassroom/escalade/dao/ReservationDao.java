package org.openclassroom.escalade.dao;

import java.util.List;

import org.openclassroom.escalade.model.ReservationBo;

public interface ReservationDao {
	
public List<ReservationBo> liste ();
public ReservationBo insertion(ReservationBo reservationBo);
public ReservationBo validation (ReservationBo reservationBo);
}
