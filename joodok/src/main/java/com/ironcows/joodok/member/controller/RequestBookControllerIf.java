package com.ironcows.joodok.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface RequestBookControllerIf {
	/**
	 * 회원이 도서신청목록을 눌렀을 때 해당 페이지로 이동시키기 위한 메서드
	 * @param model
	 * @return
	 */
	public String toRequestBook(HttpServletRequest req, Model model);
	
	/**
	 * 도서신청목록에서 제목을 눌렀을 때 해당 게시물 페이지로 이동시키기 위한 메서드
	 * @param requestBookNo
	 * @param model
	 * @return
	 */
	public String seeRequestBook(String requestBookNo, Model model);
	
	/**
	 * 도서신청목록에서 신청하기 버튼을 눌렀을 때 게시글 작성 페이지로 이동시키기 위한 메서드
	 * @param model
	 * @return
	 */
	public String toWriteRequest(Model model);
	
	/**
	 * 도서신청을 처리하기 위한 메서드
	 * @param req
	 * @param subject
	 * @param content
	 * @param requestIsbn
	 * @param model
	 * @return
	 */
	public String saveRequestBook(HttpServletRequest req, String subject, String content, String requestIsbn, Model model);
	
	
	/**
	 * 도서신청에서 수정을 눌렀을 때 수정 화면으로 이동시키기 위한 메서드
	 * @param requestBookNo
	 * @param model
	 * @return
	 */
	public String toModifyRequest(String requestBookNo, Model model);
	
	
	/**
	 * 도서신청 수정을 처리하기 위한 메서드
	 * @param req
	 * @param subject
	 * @param content
	 * @param requestIsbn
	 * @param model
	 * @return
	 */
	public String modifyRequestBook(HttpServletRequest req, String requestBookNo, String content, String requestIsbn, Model model);
	
}
