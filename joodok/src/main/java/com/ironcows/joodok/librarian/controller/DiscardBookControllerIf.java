package com.ironcows.joodok.librarian.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface DiscardBookControllerIf {
	
	/**
	 * 도서 폐기 화면으로 이동하기 위한 메서드
	 * @param model
	 * @return
	 */
	public String toDiscardBook(Model model);
	
	/**
	 * 폐기 도서를 추가하기 위한 메서드
	 * 이 메서드에서 추가한 폐기 도서 정보를 유지해야 한다.
	 * @param req
	 * @param discardingBookDetailNo
	 * @param bookDetailNos
	 * @param model
	 * @return
	 */
	public String addDiscardBook(HttpServletRequest req
							   , String discardingBookDetailNo
							   , List<String> bookDetailNos
							   , Model model);
	
	/**
	 * 도서 폐기를 최종적으로 진행하기 위한 메서드
	 * @param bookDetailNos
	 * @param model
	 * @return
	 */
	public String discardBook(HttpServletRequest req
			   				, List<String> bookDetailNos
							, List<String> discardReasons
							, Model model);

}
