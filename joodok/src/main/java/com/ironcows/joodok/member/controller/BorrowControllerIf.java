package com.ironcows.joodok.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface BorrowControllerIf {
	
	/**
	 * 회원 본인의 대출 목록을 조회하기 위한 메서드
	 * @param req
	 * @param model
	 * @return
	 */
	public String getMemberBorrow(HttpServletRequest req, Model model);
	
}
