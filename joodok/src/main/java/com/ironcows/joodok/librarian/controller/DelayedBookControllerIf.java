package com.ironcows.joodok.librarian.controller;

import org.springframework.ui.Model;

public interface DelayedBookControllerIf {

	/**
	 * 연체 목록 조회 화면으로 이동하기 위한 메서드
	 * @param model
	 * @return
	 */
	public String toDelayedBookList(Model model);
	
}
