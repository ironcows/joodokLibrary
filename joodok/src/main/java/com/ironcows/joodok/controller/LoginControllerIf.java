package com.ironcows.joodok.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface LoginControllerIf {

	/**
	 * 홈 화면에서 로그인 버튼을 눌렀을 때 로그인 화면으로 이동시켜준다.
	 * @param model
	 * @return
	 */
	public String toLogin(Model model);
	
	
	/**
	 * 로그인. member인지 librarian인지는 파라미터 role을 통해서 가른다.
	 * @param req
	 * @param id
	 * @param pw
	 * @param role
	 * @param model
	 * @return
	 */
	public String login(HttpServletRequest req, String id, String pw, String role, Model model);
	
	/**
	 * 로그아웃
	 * @param req
	 * @param model
	 * @return
	 */
	public String logout(HttpServletRequest req, Model model);
	
	
	
}
