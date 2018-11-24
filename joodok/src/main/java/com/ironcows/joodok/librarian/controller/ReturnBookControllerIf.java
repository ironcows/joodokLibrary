package com.ironcows.joodok.librarian.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface ReturnBookControllerIf {
	
	/**
	 * 도서 반납 화면으로 이동하기 위한 메서드
	 * @param model
	 * @return
	 */
	public String toReturnBook(Model model);
	
	
	/**
	 * 반납 도서를 추가하기 위한 메서드
	 * 이 메서드에서 추가한 대출 정보를 유지해야 한다.
	 * @param req
	 * @param returningBookDetailNo
	 * @param bookDetailNos
	 * @param model
	 * @return
	 */
	public String addReturnBook(HttpServletRequest req
			 				  , String returningBookDetailNo
			 				  , List<String> bookDetailNos
			 				  , Model model);
	
	/**
	 * 도서 반납을 최종적으로 진행하기 위한 메서드
	 * @param bookDetailNos
	 * @param borrowNos
	 * @param model
	 * @return
	 */
	public String returnBook(List<String> bookDetailNos
				           , List<String> borrowNos
				           , Model model);

}
