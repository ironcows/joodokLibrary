package com.ironcows.joodok.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface SearchBookControllerIf {
	/**
	 * 회원이 도서 검색을 눌렀을 때 해당 페이지로 이동을 위한 메서드
	 * @param req
	 * @param model
	 * @return
	 */
	public String toSearchBook(HttpServletRequest req, Model model);
	
	/**
	 * 회원이 조건에 따라 도서 검색하기 위한 메서드
	 * @param req
	 * @param type
	 * @param value
	 * @param model
	 * @return
	 */
	public String searchBook(HttpServletRequest req, String type, String value, Model model);
	
	
	/**
	 * 회원이 검색 목록에서 제목을 클릭 했을 때 해당 도서의 상세정보 창으로 이동하기 위한 메서드
	 * @param req
	 * @param metaBookNo
	 * @param model
	 * @return
	 */
	public String seeBookDetail(HttpServletRequest req, String metaBookNo, Model model);
	
	
	/**
	 * 회원이 도서의 상세정보 창에서 [예약] 버튼을 눌렀을 때 내부적으로 처리하기 위한 메서드
	 * @param req
	 * @param model
	 * @return
	 */
	public String makeReservation(HttpServletRequest req, String metaBookNo, String bdNo, Model model);

}
