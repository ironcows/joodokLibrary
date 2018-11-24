package com.ironcows.joodok.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface ReservationControllerIf {
	
	/**
	 * 회원 본인의 예약 목록 조회하기
	 * @param req
	 * @param model
	 * @return
	 */
	public String getMyReservation(HttpServletRequest req, Model model);
	
}
