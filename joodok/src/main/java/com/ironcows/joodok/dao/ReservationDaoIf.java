package com.ironcows.joodok.dao;

import java.util.List;
import java.util.Map;

import com.ironcows.joodok.dto.Member;
import com.ironcows.joodok.dto.Reservation;

public interface ReservationDaoIf {
	
	
	/**
	 * 예약된 도서인지 여부를 판단하기 위한 메서드
	 * @param value
	 * @return
	 */
	public abstract Map<String, String> checkReservation(String value);
	
	
	/**
	 * 회원 본인의 예약 목록 조회하기
	 * @param member
	 * @return 
	 */
	public abstract List<Map<String, String>> getMyReservation(Member member);
	
	
	/**
	 * 예약 1개 가져오기
	 * @param reservation
	 * @return Reservation type
	 */
	public abstract Reservation getOneReservation(Reservation reservation);
	
	
	/**
	 * 예약 1개 등록하기
	 * @param reservation
	 * @return 예약 등록에 성공한 갯수 1 or 0
	 */
	public abstract int insertReservation(Reservation reservation);
	
	
	/**
	 * 예약 1개 수정하기
	 * @param reservation
	 * @return 예약 수정에 성공한 갯수 1 or 0
	 */
	public abstract int updateReservation(Reservation reservation);
}
