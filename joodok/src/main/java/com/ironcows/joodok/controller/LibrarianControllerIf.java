package com.ironcows.joodok.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.ironcows.joodok.dto.BookDetail;
import com.ironcows.joodok.dto.MetaBook;

public interface LibrarianControllerIf {

	
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
	
	/**
	 * 소장도서 등록 화면으로 이동하기 위한 메서드
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
	
	
	/**
	 * 거래처 목록 조회 하면으로 이동하기 위한 메서드
	 * @param model
	 * @return
	 */
	public String toTradeEnterprise(Model model);
	
	
	/**
	 * 예산 목록 조회 화면으로 이동하기 위한 메서드
	 * @param model
	 * @return
	 */
	public String toBudget(Model model);
	
	
	/**
	 * 연체 목록 조회 화면으로 이동하기 위한 메서드
	 * @param model
	 * @return
	 */
	public String toDelayedBookList(Model model);
	
	/**
	 * 도서 요청 목록 조회 화면으로 이동하기 위한 메서드
	 * @param model
	 * @return
	 */
	public String toRequestBookList(HttpServletRequest req, Model model);
	
	/**
	 * 도서신청목록에서 제목을 눌렀을 때 해당 게시물 페이지로 이동시키기 위한 메서드
	 * @param requestBookNo
	 * @param model
	 * @return
	 */
	public String seeRequestBook(String requestBookNo, Model model);
	
}
