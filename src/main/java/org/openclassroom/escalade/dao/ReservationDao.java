package org.openclassroom.escalade.dao;

import java.util.List;

import org.openclassroom.escalade.model.ReservationBo;

public interface ReservationDao {
	
public List<ReservationBo> liste ();
public ReservationBo insertion(ReservationBo reservationBo);
public ReservationBo update (ReservationBo reservationBo);
public ReservationBo getById(Integer id);

public ReservationBo findByValider(Byte valider);

List<ReservationBo> findByTopoAndValid(Integer topo_id, Byte valider);
}
