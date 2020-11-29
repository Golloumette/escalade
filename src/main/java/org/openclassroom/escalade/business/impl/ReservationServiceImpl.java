package org.openclassroom.escalade.business.impl;


import java.util.List;

import javax.transaction.Transactional;

import org.openclassroom.escalade.business.ReservationService;
import org.openclassroom.escalade.dao.ReservationDao;
import org.openclassroom.escalade.enume.ValidEnum;
import org.openclassroom.escalade.model.ReservationBo;
import org.openclassroom.escalade.model.UtilisateurBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ReservationServiceImpl implements ReservationService {
	@Autowired
	private ReservationDao reservationDao;
	
	@Transactional
	@Override
	public ReservationBo insertion(ReservationBo reservationBo) {
		return reservationDao.insertion(reservationBo);
	}

	@Override
	public List<ReservationBo> liste() {
		// TODO Auto-generated method stub
		return reservationDao.liste();
	}

	@Override
	public ReservationBo update(ReservationBo reservationBo) {
		// TODO Auto-generated method stub
		return reservationDao.update(reservationBo);
	}

	@Override
	public ReservationBo getById(Integer id) {
		// TODO Auto-generated method stub
		return reservationDao.getById(id);
	}

	@Override
	public ReservationBo validerReservation (Integer topo_id) {
		List<ReservationBo> reservationBos = reservationDao.findByTopoAndValid(topo_id,ValidEnum.Waiting.getNum() );
		return reservationBos.get(0);
	}

	@Override
	public ReservationBo findByValider(Byte valider) {
	
		return reservationDao.findByValider(valider);
	}

	@Override
	public ReservationBo archiveReservation(Integer topo_id) {
		List<ReservationBo> reservationBos = reservationDao.findByTopoAndValid(topo_id, ValidEnum.Validate.getNum());
		return reservationBos.get(0);
	}

	@Override
	public List<ReservationBo> liste(UtilisateurBo utilisateurBo) {
		List<ReservationBo> reservationBos = reservationDao.liste(utilisateurBo);
		reservationBos.get(0);
		return reservationBos ;
	}

	
}
