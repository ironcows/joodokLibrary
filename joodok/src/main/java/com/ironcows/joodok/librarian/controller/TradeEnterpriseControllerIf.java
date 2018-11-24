package com.ironcows.joodok.librarian.controller;

import org.springframework.ui.Model;

public interface TradeEnterpriseControllerIf {
	
	/**
	 * 거래처 목록 조회 하면으로 이동하기 위한 메서드
	 * @param model
	 * @return
	 */
	public String toTradeEnterprise(Model model);
}
