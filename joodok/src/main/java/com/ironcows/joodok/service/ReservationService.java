package com.ironcows.joodok.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ironcows.joodok.dao.ReservationDaoIf;
import com.ironcows.joodok.dto.Member;
import com.ironcows.joodok.dto.Reservation;


@Service(value="reservationService")
public class ReservationService implements ReservationServiceIf {

	
	/**
	 * ReservationDaoMybatisImpl 에서 Repository 로 등록한 것을 
	 * Resource에 명시함으로써 연결한다.
	 */
	@Resource(name="reservationDao")
	private ReservationDaoIf dao;
	
	
	@Override
	public Map<String, String> checkReservation(String value) {
		return dao.checkReservation(value);
	}
	
	
	@Override
	public List<Map<String, String>> getMyReservation(Member member) {
		return dao.getMyReservation(member);
	}

	@Override
	public Reservation getOneReservation(Reservation reservation) {
		return dao.getOneReservation(reservation);
	}

	@Override
	public int insertReservation(Reservation reservation) {
		return dao.insertReservation(reservation);
	}

	@Override
	public int updateReservation(Reservation reservation) {
		int successCnt = 0;
		
		if(getOneReservation(reservation) != null) {
			successCnt = dao.updateReservation(reservation);
		}
		return successCnt;
	}

}
