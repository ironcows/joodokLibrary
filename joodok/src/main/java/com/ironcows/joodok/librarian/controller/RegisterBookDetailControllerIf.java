package com.ironcows.joodok.librarian.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.ironcows.joodok.dto.BookDetail;

public interface RegisterBookDetailControllerIf {
	
	/**
	 * 도서 상세정보 등록 화면으로 이동하기 위한 메서드
	 * @param model
	 * @return
	 */
	public String toRegisterBookDetail(Model model);
	
	
	
	/**
	 * 도서 상세정보 등록 화면에서 등록 대상을 선택해서 추가하는 메서드
	 * 선택된 대상이 유지되어야 한다.
	 * @param checkedIsbn
	 * @param nums
	 * @param checkUpIsbns
	 * @param titles
	 * @param authors
	 * @param publishersList
	 * @param chNums
	 * @param chCheckUpIsbns
	 * @param chTitles
	 * @param chAuthors
	 * @param chPublishers
	 * @param model
	 * @return
	 */
	public String selectUnRegisterBookDetail(String checkedIsbn
									  , List<String> nums
									  , List<String> checkUpIsbns
									  , List<String> titles
									  , List<String> authors
									  , List<String> publishers
									  , String chNum
									  , String chCheckUpIsbn
									  , String chTitle
									  , String chAuthor
									  , String chPublisher
									  , Model model);
	
	/**
	 * 위 메서드에서 선택되어 보여진 목록 중에서 1개의 아이템을 선택하여
	 * 입력할 수 있는 등록 화면을 보여준다.
	 * 이전에 선택된 대상이 유지되어야 한다.
	 * @param req
	 * @param checkedNo
	 * @param checkUpListNos
	 * @param checkUpIsbns
	 * @param titles
	 * @param authors
	 * @param publishers
	 * @param checkUpResults
	 * @param metaBookNos
	 * @param chCheckUpListNo
	 * @param chCheckUpIsbn
	 * @param chTitle
	 * @param chAuthor
	 * @param chPublisher
	 * @param chCheckUpResult
	 * @param chMetaBookNo
	 * @param model
	 * @return
	 */
	public String addPreRegisterBookDetail(HttpServletRequest req
										 , String checkedNo
										 , List<String> checkUpListNos
										 , List<String> checkUpIsbns
										 , List<String> titles
										 , List<String> authors
										 , List<String> publishers
										 , List<String> checkUpResults
										 , List<String> metaBookNos
										 , String chCheckUpListNo
										 , String chCheckUpIsbn
										 , String chTitle
										 , String chAuthor
										 , String chPublisher
										 , String chCheckUpResult
										 , String chMetaBookNo
										 , Model model);
	
	
	/**
	 * 도서 등록을 최종적으로 진행하기 위한 메서드
	 * @param regBookDetail
	 * @param model
	 * @return
	 */
	public String registerBookDetail( HttpServletRequest req
									, BookDetail regBookDetail
									, Model model);

}
