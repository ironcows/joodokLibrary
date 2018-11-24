package com.ironcows.joodok.librarian.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface BorrowControllerIf {
	
	/**
	 * 도서 대출 화면으로 이동하기 위한 메서드
	 * @param model
	 * @return
	 */
	public String toBorrow(Model model);
	
	
	/**
	 * 대출 화면에서 회원을 검색하기 위한 메서드
	 * @param memberNo
	 * @param model
	 * @return
	 */
	public String searchMemberForBorrow(String memberId, Model model);
	
	
	/**
	 * 대출 화면에서 도서를 검색하기 위한 메서드
	 * 위 searchMemberForBorrow 메서드에서 검색한 회원 정보와 도서를 검색한 결과를 동시에 유지해야 한다.
	 * @param searchBookDetailNo
	 * @param memberNo
	 * @param memberId
	 * @param memberName
	 * @param possibleBorrowDay
	 * @param bookDetailNos
	 * @param model
	 * @return
	 */
	public String searchBookForBorrow(HttpServletRequest req
									, String searchBookDetailNo
								    , String memberNo
									, String memberId
									, String memberName
			                        , String dueDate
			                        , List<String> bookDetailNos
			                        , List<String> applicationMarks
			                        , Model model);
	
	/**
	 * 도서 대출을 최종적으로 진행하기 위한 메서드
	 * @param memberNo
	 * @param dueDate
	 * @param bookDetailNos
	 * @param model
	 * @return
	 */
	public String insertBorrow(HttpServletRequest req
							 , String memberNo
							 , String dueDate
							 , List<String> bookDetailNos
							 , Model model);
	
}
