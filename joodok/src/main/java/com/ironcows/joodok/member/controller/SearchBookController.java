package com.ironcows.joodok.member.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ironcows.joodok.dto.MetaBook;
import com.ironcows.joodok.dto.Reservation;
import com.ironcows.joodok.service.BookDetailServiceIf;
import com.ironcows.joodok.service.MetaBookServiceIf;
import com.ironcows.joodok.service.ReservationServiceIf;


@Controller(value="memberSearchBookController")
@RequestMapping(value="/member")
public class SearchBookController implements SearchBookControllerIf {
	
	//필요한 service 들을 가져온다.
	
	/**
	 * com.ironcows.joodok.service 안의 클래스에서 Repository(Service) 로 등록한 것을 
	 * Resource에 명시함으로써 연결한다.
	 */
	
	@Resource(name="reservationService")
	private ReservationServiceIf reservationSv;
	
	@Resource(name="metaBookService")
	private MetaBookServiceIf metaBookSv;
	
	@Resource(name="bookDetailService")
	private BookDetailServiceIf bookDetailSv;
	
	
	
	
	@Override
	@RequestMapping(value="/toSearchBook", method=RequestMethod.GET)
	public String toSearchBook(HttpServletRequest req, Model model) {
		model.addAttribute("content", "/WEB-INF/views/member/searchBook/searchBook.jsp");
	
		// compositeView pattern 을 사용할 것이므로 항상 main/index 로 리턴
		return "main/index";
	}//toSearchBook end
	
	@Override
	@RequestMapping(value="/searchBook", method=RequestMethod.GET)
	public String searchBook(HttpServletRequest req
							, @RequestParam("type") String type
							, @RequestParam("value") String value
							, Model model) {
		
		//검색 결과를 담을 리스트
		List<Map<String, String>> searchList = null;
		
		if(type.contentEquals("title")) {
			//서명 검색
//			System.out.println("서명 검색 확인");
			searchList = metaBookSv.searchAsTitle(value);
			
		}
		if(type.contentEquals("author")) {
			//저자 검색
//			System.out.println("저자 검색 확인");
			searchList = metaBookSv.searchAsAuthor(value);
			
		}
		if(type.contentEquals("publisher")) {
			//출판사 검색
//			System.out.println("출판사 검색 확인");
			searchList = metaBookSv.searchAsPublisher(value);
		}
		
		//검색 결과를 모델에 등록
		model.addAttribute("searchList", searchList);
		//컨텐츠에 할당할 페이지 설정
		model.addAttribute("content", "/WEB-INF/views/member/searchBook/searchBook.jsp");
		
		// compositeView pattern 을 사용할 것이므로 항상 main/index 로 리턴
		return "main/index";
	}//searchBook end
	
	
	@Override
	@RequestMapping(value="/seeBookDetail", method=RequestMethod.GET)
	public String seeBookDetail(HttpServletRequest req
							  , @RequestParam("metaBookNo") String metaBookNo
							  , Model model) {
		
		//도서 공통 정보 불러오기 및 설정
		MetaBook metaInfo = new MetaBook();
		metaInfo.setMetaBookNo(metaBookNo);
		metaInfo = metaBookSv.getOneMetaBook(metaInfo);
		model.addAttribute("metaInfo", metaInfo);
		
		//해당 도서의 상세 정보 불러오기 및 설정
		List<Map<String, String>> bookDetails = bookDetailSv.seeBookDetail(metaBookNo);
		model.addAttribute("bookDetails", bookDetails);
		
		//컨텐츠 화면 설정
		model.addAttribute("content", "/WEB-INF/views/member/searchBook/seeBookDetail.jsp");
		
		// compositeView pattern 을 사용할 것이므로 항상 main/index 로 리턴
		return "main/index";
	}//seeBookDetail end
	
	
	@Override
	@RequestMapping(value="/makeReservation", method=RequestMethod.POST)
	public String makeReservation(HttpServletRequest req
			  					 , @RequestParam("metaBookNo") String metaBookNo
								 , @RequestParam("bookDetailNo")String bdNo
								 , Model model) {

		HttpSession session = req.getSession();
		
		boolean possibleReservation = false;
		int successCnt = 0;
		
		String memberNo = (String)session.getAttribute("memberNo");
		String bookDetailNo = bdNo;
		
		System.out.println(memberNo);
		System.out.println(bookDetailNo);
		
		//해당 도서가 예약이 가능한 지부터 판단한다.
		if(reservationSv.checkReservation(bdNo) != null) {
			//이미 다른 회원이 예약한 상태, 즉 예약 불가능
			possibleReservation = false;
		} else {
			//예약 가능
			possibleReservation = true;
		}
		
		if(possibleReservation) {
			//예약 절차 진행
			
			//필요한 데이터 포장
			Reservation reservation = new Reservation();
			reservation.setMemberNo(memberNo);
			reservation.setBookDetailNo(bookDetailNo);
			
			//reservationSv 로 인서트 
			successCnt = reservationSv.insertReservation(reservation);
			
			if(successCnt == 1) {
				model.addAttribute("message", "예약이 정상 처리되었습니다.");
			} else {
				model.addAttribute("message", "예약에 실패 했습니다..");
			}
		}else {
			//예약 실패에 따른 절차 실행
			model.addAttribute("message", "다른 회원이 예약한 도서입니다.");
		}

		//메시지 설정
		//메시지 출력 이후 이동할 페이지로 로그인 화면 설정
		model.addAttribute("next", "/member/seeBookDetail?metaBookNo=" + metaBookNo);
		
		//컨텐츠 화면 설정
		model.addAttribute("content", "/WEB-INF/views/main/message.jsp");
		
		// compositeView pattern 을 사용할 것이므로 항상 main/index 로 리턴
		return "main/index";
	}//makeReservation end
	
	
}
