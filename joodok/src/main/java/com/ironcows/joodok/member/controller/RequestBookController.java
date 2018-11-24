package com.ironcows.joodok.member.controller;

import java.util.HashMap;
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

import com.ironcows.joodok.dto.RequestBook;
import com.ironcows.joodok.service.RequestBookServiceIf;
import com.ironcows.joodok.util.Paging;


@Controller(value="memberRequestBookController")
@RequestMapping(value="/member")
public class RequestBookController implements RequestBookControllerIf {

	//필요한 service 들을 가져온다.
	
	/**
	 * com.ironcows.joodok.service 안의 클래스에서 Repository(Service) 로 등록한 것을 
	 * Resource에 명시함으로써 연결한다.
	 */
	
	@Resource(name="requestBookService")
	private RequestBookServiceIf requestBookSv;
	
	
	
	
	
	@Override
	@RequestMapping(value="/toRequestBook")
	public String toRequestBook(HttpServletRequest req, Model model) {
		HttpSession session = req.getSession();
		
		
		/**
		 * (1) 페이지 기초 설정
		 */
		//현재 페이지를 1로, 한 페이지당 표시할 최대 게시물 갯수를 10개로 초기화
		int currentPageNo = 1;
		int maxPost = 10;
		
		//pages는 각각의 페이지를 의미하는 변수
		if(req.getParameter("pages") != null) {
			currentPageNo = Integer.parseInt(req.getParameter("pages"));
		}
		
		Paging paging = new Paging(currentPageNo, maxPost);
		
		//쿼리에서 몇번째 게시물부터 조회할 것인지 설정하기 위한 값
		//예를 들어 현재 페이지가 2페이지라면?
		//페이지당 10개의 게시물을 출력할 것이므로, 2페이지에서는
		//쿼리로 게시물을 정렬 했을 때 11번째부터 20번째까지의 게시물만 가져와서 2페이지에 보여주어야 함.
		//이 때 11이라는 값이 offset 이 된다.
		//그럼 20번째의 값은 어떻게? 쿼리에서 offset + 10 으로 설정하고(21) 대소 구분은 < 을 이용해서 20까지만 검색하도록 
		int offset = (paging.getCurrentPageNo() - 1) * paging.getMaxPost() + 1;
		
		/**
		 * (2) 검색 설정
		 */
		Map<String, Object> queryValue = new HashMap<String, Object>();
		// session 으로부터 회원의 memberNo 를 가져온다. 
		String memberNo = (String)session.getAttribute("memberNo");
		
		
		// memberNo 와 offset 의 값을 queryValue 에 설정
		queryValue.put("memberNo", memberNo);
		queryValue.put("offset", offset);
		
		
		/**
		 * (3) 회원의 페이지에 맞는 게시물 조회하기
		 */
		// service로 회원의 페이지별 요청도서 목록과 요청도서 총 갯수를 가져온다.
		List<Map<String, String>> myRequestList = requestBookSv.getMemberRequestList(queryValue);
		int totalCnt = requestBookSv.getMemberRequestListNum(memberNo);
		
		
		// (4) paging 설정 및 만들어내기
		paging.setNumberOfRecords(totalCnt);
		paging.makePaging();
		
		
		// 페이지당 결과셋을 모델에 붙인다.
		model.addAttribute("myRequestList", myRequestList);
		// paging 을 모델에 붙인다.
		model.addAttribute("paging", paging);
		
		//컨텐츠 화면 설정
		model.addAttribute("content", "/WEB-INF/views/member/requestBook/list.jsp");
		
		// compositeView pattern 을 사용할 것이므로 항상 main/index 로 리턴
		return "main/index";
	}//toRequestBook end
	
	
	@Override
	@RequestMapping(value="/seeRequestBook", method=RequestMethod.GET)
	public String seeRequestBook(@RequestParam("requestBookNo") String requestBookNo
							   , Model model) {
		
		//검색용 RequestBook 객체 생성 및 검색 설정
		RequestBook oneRequest = new RequestBook();
		oneRequest.setRequestBookNo(requestBookNo);
		
		//결과를 받을 변수 resultSet 설정 및 service로 가져오기
		Map<String, String> resultSet = requestBookSv.getOneRequestBook_CLOB(oneRequest);
		
		//해당 글을 모델에 추가하기
		model.addAttribute("resultSet", resultSet);
		
		//컨텐츠 화면 설정
		model.addAttribute("content", "/WEB-INF/views/member/requestBook/seeRequestBook.jsp");
		
		// compositeView pattern 을 사용할 것이므로 항상 main/index 로 리턴
		return "main/index";
	}//seeRequestBook end
	
	@Override
	@RequestMapping(value="/toWriteRequest", method=RequestMethod.GET)
	public String toWriteRequest(Model model) {
		
		//컨텐츠 화면 설정
		model.addAttribute("content", "/WEB-INF/views/member/requestBook/writeRequest.jsp");
		
		// compositeView pattern 을 사용할 것이므로 항상 main/index 로 리턴
		return "main/index";
	}//toWriteRequest end
	
	@Override
	@RequestMapping(value="/saveRequestBook", method=RequestMethod.POST)
	public String saveRequestBook(HttpServletRequest req
								 , @RequestParam("subject") String subject
								 , @RequestParam("content") String content
								 , @RequestParam("requestIsbn") String requestIsbn
								 , Model model) {
		HttpSession session = req.getSession();
		
		//저장하기 위한 requestBook 객체 생성
		RequestBook requestBook = new RequestBook();
		
		//저장 성공 여부 판단
		int successCnt = 0;
		
		//저장할 값들을 requestBook 객체에 세팅
		requestBook.setMemberNo((String)session.getAttribute("memberNo"));
		requestBook.setSubject(subject);
		requestBook.setContent(content);
		requestBook.setRequestIsbn(requestIsbn);
		
		successCnt = requestBookSv.insertRequestBook(requestBook);
		
		if(successCnt > 0) {
			//성공
			//성공 화면에 대한 설정(메시지 출력 이후 목록 화면으로 이동시킨다.)
			model.addAttribute("message", "신청되었습니다.");
			model.addAttribute("next", "/member/toRequestBook");
			
		} else {
			//실패
			//실패 화면에 대한 설정(메시지 출력 이후 목록 화면으로 이동시킨다.)
			model.addAttribute("message", "도서 신청에 실패했습니다.");
			model.addAttribute("next", "/member/toRequestBook");
		}
		
		//content 에 할당할 페이지 설정
		model.addAttribute("content", "/WEB-INF/views/main/message.jsp");
		
		// compositeView pattern 을 사용할 것이므로 항상 main/index 로 리턴
		return "main/index";
	}//saveRequestBook end
	
	
	@Override
	@RequestMapping(value="/toModifyRequest", method=RequestMethod.GET)
	public String toModifyRequest(@RequestParam("requestBookNo") String requestBookNo
							     , Model model) {

		//검색용 RequestBook 객체 생성 및 검색 설정
		RequestBook oneRequest = new RequestBook();
		oneRequest.setRequestBookNo(requestBookNo);
		
		//결과를 받을 변수 resultSet 설정 및 service로 가져오기
		Map<String, String> resultSet = requestBookSv.getOneRequestBook_CLOB(oneRequest);
		
		//해당 글을 모델에 추가하기
		model.addAttribute("resultSet", resultSet);
		
		//컨텐츠 화면 설정
		model.addAttribute("content", "/WEB-INF/views/member/requestBook/modifyRequestBook.jsp");
		
		
		// compositeView pattern 을 사용할 것이므로 항상 main/index 로 리턴
		return "main/index";
	}//toModifyRequest end
	
	
	@Override
	@RequestMapping(value="/modifyRequest", method=RequestMethod.POST)
	public String modifyRequestBook(HttpServletRequest req
								   ,@RequestParam("requestBookNo")String requestBookNo
								   ,@RequestParam("content")String content
								   ,@RequestParam("requestIsbn")String requestIsbn
								   ,Model model) {
		
		//저장하기 위한 requestBook 객체 생성
		RequestBook requestBook = new RequestBook();
		
		//저장 성공 여부 판단
		int successCnt = 0;
		
		//저장할 값들을 requestBook 객체에 세팅
		requestBook.setRequestBookNo(requestBookNo);
		requestBook.setContent(content);
		if(requestIsbn.length() != 0) {			
			requestBook.setRequestIsbn(requestIsbn);
		}
		
		successCnt = requestBookSv.updateRequestBook(requestBook);
		
		if(successCnt > 0) {
			//성공
			//성공 화면에 대한 설정(메시지 출력 이후 목록 화면으로 이동시킨다.)
			model.addAttribute("message", "수정되었습니다.");
			model.addAttribute("next", "/member/toRequestBook");
			
		} else {
			//실패
			//실패 화면에 대한 설정(메시지 출력 이후 목록 화면으로 이동시킨다.)
			model.addAttribute("message", "수정에 실패했습니다.");
			model.addAttribute("next", "/member/toRequestBook");
		}
		
		//content 에 할당할 페이지 설정
		model.addAttribute("content", "/WEB-INF/views/main/message.jsp");
		
		// compositeView pattern 을 사용할 것이므로 항상 main/index 로 리턴
		return "main/index";
	}//modifyRequest end
}
