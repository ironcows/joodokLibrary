package com.ironcows.joodok.librarian.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface AcquisitionControllerIf {
	/**
	 * 수서 화면으로 이동하기 위한 메서드
	 * @param model
	 * @return
	 */
	public String toAcquisition(Model model);
	
	/**
	 * 수서하려는 도서를 추가하는 메서드
	 * 이 메서드에서 추가한 정보를 유지해야한다.
	 * @param addIsbn
	 * @param addCategory
	 * @param acquisitionIsbns
	 * @param categorys
	 * @param model
	 * @return
	 */
	public String addAcquisition(String addIsbn
							   , String addCategory
							   , List<String> acquisitionIsbns
							   , List<String> categorys
							   , Model model);
	
	/**
	 * 수서를 최종적으로 진행하기 위한 메서드
	 * @param req
	 * @param acquisitionIsbns
	 * @param categorys
	 * @param model
	 * @return
	 */
	public String acquisition(HttpServletRequest req
					 	    , List<String> acquisitionIsbns
						    , List<String> categorys
							, Model model);

}
