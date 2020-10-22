package org.openclassroom.escalade.business.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.openclassroom.escalade.business.ReservationService;
import org.openclassroom.escalade.dao.ReservationDao;
import org.openclassroom.escalade.model.ReservationBo;
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
	public ReservationBo validation(ReservationBo reservationBo) {
		// TODO Auto-generated method stub
		return reservationDao.validation(reservationBo);
	}

}
