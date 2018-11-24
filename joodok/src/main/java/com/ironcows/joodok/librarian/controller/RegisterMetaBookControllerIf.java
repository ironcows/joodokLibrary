package com.ironcows.joodok.librarian.controller;

import java.util.List;

import org.springframework.ui.Model;

import com.ironcows.joodok.dto.MetaBook;

public interface RegisterMetaBookControllerIf {
	/**
	 * 도서 공통정보 등록 화면으로 이동하기 위한 메서드
	 * @param model
	 * @return
	 */
	public String toRegisterBook(Model model);
	
	/**
	 * 도서 공통정보 등록 화면에서 등록 대상을 1개 선택해서 추가하는 메서드
	 * @param checkedAcquisitionNos
	 * @param acquisitionNos
	 * @param categorys
	 * @param acquisitionIsbns
	 * @param registeredDates
	 * @param model
	 * @return
	 */
	public String addMetaBook(String checkedAcquisitionNo
						    , List<String> acquisitionNos
						    , List<String> categorys
						    , List<String> acquisitionIsbns
						    , List<String> registeredDates
						    , String chAcquisitionNo
						    , String chCategory
						    , String chAcquisitionIsbn
						    , String chRegisteredDate
						    , Model model);
	
	
	/**
	 * 도서 공통정보 등록을 최종적으로 진행하기 위한 메서드
	 * @param metaBook
	 * @param model
	 * @return
	 */
	public String registerMetaBook(MetaBook metaBook
								 , Model model);
	

}
