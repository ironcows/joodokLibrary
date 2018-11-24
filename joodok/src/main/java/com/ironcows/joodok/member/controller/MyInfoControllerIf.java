package com.ironcows.joodok.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface MyInfoControllerIf {
	
	/**
	 * 회원 본인의 회원 정보를 보기 위한 메서드
	 * @param req
	 * @param model
	 * @return
	 */
	public String getMyInfo(HttpServletRequest req, Model model);
	
}
