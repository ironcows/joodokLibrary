package com.ironcows.joodok.librarian.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface OrderControllerIf {
	/**
	 * 주문 화면으로 이동하기 위한 메서드
	 * @param model
	 * @return
	 */
	public String toOrder(Model model);
	
	
	/**
	 * 주문 화면에서 주문 대상을 선택해서 추가하는 메서드
	 * @param checkedAcquisitionNos
	 * @param acquisitionNos
	 * @param categorys
	 * @param acquisitionIsbns
	 * @param registeredDates
	 * @param orAcquisitionNos
	 * @param orCategorys
	 * @param orAcquisitionIsbns
	 * @param orRegisteredDates
	 * @param model
	 * @return
	 */
	public String addOrderList(List<String> checkedAcquisitionNos
							 , List<String> acquisitionNos
							 , List<String> categorys
							 , List<String> acquisitionIsbns
							 , List<String> registeredDates
							 , List<String> orAcquisitionNos
							 , List<String> orCategorys
							 , List<String> orAcquisitionIsbns
							 , List<String> orRegisteredDates
							 , Model model);
	
	
	/**
	 * 주문을 최종적으로 진행하기 위한 메서드
	 * @param req
	 * @param tradeEnterpriseInfo
	 * @param orderIsbns
	 * @param orderCounts
	 * @param model
	 * @return
	 */
	public String order(HttpServletRequest req
					  , String tradeEnterpriseInfo
			 		  , List<String> orderIsbns
			 		  , List<String> orderCounts
					  , Model model);
	
}
