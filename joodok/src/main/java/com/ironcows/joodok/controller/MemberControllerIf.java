package com.ironcows.joodok.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;



public interface MemberControllerIf {

	
	/**
	 * 회원 본인의 회원 정보를 보기 위한 메서드
	 * @param req
	 * @param model
	 * @return
	 */
	public String getMyInfo(HttpServletRequest req, Model model);
	
	/**
	 * 회원 본인의 예약 목록 조회하기
	 * @param req
	 * @param model
	 * @return
	 */
	public String getMyReservation(HttpServletRequest req, Model model);
	
	/**
	 * 회원 본인의 대출 목록을 조회하기 위한 메서드
	 * @param req
	 * @param model
	 * @return
	 */
	public String getMemberBorrow(HttpServletRequest req, Model model);
	
	
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
