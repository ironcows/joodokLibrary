package com.ironcows.joodok.librarian.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface RequestBookControllerIf {
	
	/**
	 * 도서 요청 목록 조회 화면으로 이동하기 위한 메서드
	 * @param model
	 * @return
	 */
	public String toRequestBookList(HttpServletRequest req, Model model);
	
	/**
	 * 도서신청목록에서 제목을 눌렀을 때 해당 게시물 페이지로 이동시키기 위한 메서드
	 * @param requestBookNo
	 * @param model
	 * @return
	 */
	public String seeRequestBook(String requestBookNo, Model model);
	
}
