package com.ironcows.joodok.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ironcows.joodok.dto.Member;
import com.ironcows.joodok.dto.Reservation;
import com.ironcows.joodok.mapper.ReservationMapper;

@Repository(value="reservationDao")
public class ReservationDaoMybatisImpl implements ReservationDaoIf {

	
	/* 내부적으로 사용하는 factory 변수
	 * mybatis-context.xml 에서 id="factory" 로 생성된 빈 객체를 변수이름이 똑같은
	 * 아래의 factory 변수에 자동 연결한다.
	 */
	@Autowired
    private	SqlSessionFactory factory;
	
	// 기본 생성자
	public ReservationDaoMybatisImpl() {}
	
	
	@Override
	public Map<String, String> checkReservation(String value) {
		SqlSession session = factory.openSession();
		ReservationMapper mapper = session.getMapper(ReservationMapper.class);
		Map<String, String>	resultSet;
		
		try {
			resultSet = mapper.checkReservation(value);
		}finally {
			session.close();
		}
		return resultSet;
	}
	
	
	@Override
	public List<Map<String, String>> getMyReservation(Member member) {
		SqlSession session = factory.openSession();
		ReservationMapper mapper = session.getMapper(ReservationMapper.class);
		
		List<Map<String, String>> resultSet;
		
		try {
			resultSet = mapper.getMyReservation(member);
		} finally {
			session.close();
		}
		
		return resultSet;
	}

	@Override
	public Reservation getOneReservation(Reservation reservation) {
		SqlSession session = factory.openSession();
		ReservationMapper mapper = session.getMapper(ReservationMapper.class);
		
		try {
			reservation = mapper.getOneReservation(reservation);
		} finally {
			session.close();
		}
		return reservation;
	}

	@Override
	public int insertReservation(Reservation reservation) {
		SqlSession session = factory.openSession(true);
		ReservationMapper mapper = session.getMapper(ReservationMapper.class);
		
		int successCnt;
		
		try {
			successCnt = mapper.insertReservation(reservation);
		} finally {
			session.close();
		}
		return successCnt;
	}

	@Override
	public int updateReservation(Reservation reservation) {
		SqlSession session = factory.openSession(true);
		ReservationMapper mapper = session.getMapper(ReservationMapper.class);
		
		int successCnt;
		
		try {
			successCnt = mapper.updateReservation(reservation);
		} finally {
			session.close();
		}
		return successCnt;
	}

}
