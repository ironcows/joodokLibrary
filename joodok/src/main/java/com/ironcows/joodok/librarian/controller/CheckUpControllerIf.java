package com.ironcows.joodok.librarian.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface CheckUpControllerIf {
	/**
	 * 검수 화면으로 이동하기 위한 메서드
	 * @param model
	 * @return
	 */
	public String toCheckUp(Model model);
	
	
	/**
	 * 검수 화면에서 검수 대상을 선택해서 추가하는 메서드
	 * 선택된 대상 목록이 유지되어야 한다.
	 * @param checkedAcquisitionNos
	 * @param acquisitionNos
	 * @param categorys
	 * @param acquisitionIsbns
	 * @param registeredDates
	 * @param chAcquisitionNos
	 * @param chCategorys
	 * @param chAcquisitionIsbns
	 * @param chRegisteredDates
	 * @param model
	 * @return
	 */
	public String addCheckUpList(List<String> checkedAcquisitionNos
							   , List<Integer> checkedCounts
							   , List<String> acquisitionNos
							   , List<String> categorys
							   , List<String> acquisitionIsbns
							   , List<String> registeredDates
							   , List<String> chAcquisitionNos
							   , List<String> chCategorys
							   , List<String> chAcquisitionIsbns
							   , List<String> chRegisteredDates
							   , Model model);
	
	
	/**
	 * 검수를 최종적으로 진행하기 위한 메서드
	 * @param checkUpIsbns
	 * @param checkUpResults
	 * @param memos
	 * @param model
	 * @return
	 */
	public String checkUp(HttpServletRequest req
						, List<String> acquisitionNos
						, List<String> checkUpIsbns
						, List<String> checkUpResults
						, List<String> memos
						, Model model);

}
