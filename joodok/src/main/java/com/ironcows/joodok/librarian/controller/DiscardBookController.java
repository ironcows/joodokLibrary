package com.ironcows.joodok.librarian.controller;

import java.util.ArrayList;
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

import com.ironcows.joodok.dto.BookDetail;
import com.ironcows.joodok.dto.DiscardBook;
import com.ironcows.joodok.service.BookDetailServiceIf;
import com.ironcows.joodok.service.DiscardBookServiceIf;

@Controller(value="libDiscardBookController")
@RequestMapping(value="/librarian")
public class DiscardBookController implements DiscardBookControllerIf {

	//필요한 service 들을 가져온다.
	
	/**
	 * com.ironcows.joodok.service 안의 클래스에서 Repository(Service) 로 등록한 것을 
	 * Resource에 명시함으로써 연결한다.
	 */
	
	@Resource(name="bookDetailService")
	private BookDetailServiceIf bookDetailSv;
	
	@Resource(name="discardBookService")
	private DiscardBookServiceIf discardBookSv;
	
	
	
	@Override
	@RequestMapping(value="/toDiscardBook", method=RequestMethod.GET)
	public String toDiscardBook(Model model) {
		//출력할 화면 설정
		model.addAttribute("content", "/WEB-INF/views/librarian/discardBook/discardBook.jsp");
		
		// compositeView pattern 을 사용할 것이므로 항상 main/index 로 리턴
		return "main/index";
	}//toDiscardBook end
	
	
	@Override
	@RequestMapping(value="/addDiscardBook", method=RequestMethod.POST)
	public String addDiscardBook(HttpServletRequest req
						       , @RequestParam("discardingBookDetailNo") String discardingBookDetailNo
						       , @RequestParam(value="bookDetailNo", required=false) List<String> bookDetailNos
							   , Model model) {
		
		/**
		 * 도서 폐기를 위해서
		 * 1. 이미 추가된 도서들은 discardBookInfos 에 먼저 추가
		 * 2. 같은 도서가 discardBookInfos 에 추가되어 있는지 먼저 검사!
		 * 3. 추가하려는 도서가 대출 상태인지 검사 
		 * 4. 추가하려는 도서가 이미 폐기된 도서인지 검사!
		 *  위 조건을 모두 만족할 때 폐기하려는 도서를 discardBookInfos 에 추가한다.
		 */
		
		
		// 추가한 폐기 도서 정보를 추가폼에서 유지하기 위한 변수
		List<Map<String, String>> discardBookInfos = new ArrayList<>();
		
		String[] titles = req.getParameterValues("title");
		String[] subTitles = req.getParameterValues("subTitle");
		String[] volumes = req.getParameterValues("volume");
		String[] applicationMarks = req.getParameterValues("applicationMark");
		
		//1. 이미 추가된 도서가 있으면 해당 도서들을 borrowInfos 변수에 추가한다.
		if(bookDetailNos != null && titles != null && subTitles != null
		   && volumes != null && applicationMarks != null) {
			for (int i = 0; i < bookDetailNos.size(); i++) {
				Map<String, String> discardBookInfo = new HashMap<>();
				discardBookInfo.put("bookDetailNo", bookDetailNos.get(i));
				discardBookInfo.put("title", titles[i]);
				discardBookInfo.put("subTitle", subTitles[i]);
				discardBookInfo.put("volume", volumes[i]);
				discardBookInfo.put("applicationMark", applicationMarks[i]);
				
				discardBookInfos.add(discardBookInfo);
			}
		}
		
		
		BookDetail checkExistBook = new BookDetail();
		checkExistBook.setBookDetailNo(discardingBookDetailNo);
		checkExistBook = bookDetailSv.getOneBookDetail(checkExistBook);
		if(checkExistBook == null) {
			//도서가 존재하지 않는 경우, 메시지 출력
			model.addAttribute("message", "없는 도서입니다.");
		}else {
			//도서가 존재하는 경우, 다음 단계 진행
			if(bookDetailNos != null 
			&& bookDetailNos.contains(String.format("%07d", new Integer(discardingBookDetailNo).intValue()))) {
				//2. 이미 추가된 도서를 추가하려는 경우, 메시지 출력
				model.addAttribute("message", "이미 추가된 도서입니다.");
			}else {
				//3. 추가하려는 도서가 대출 상태인지 검사한다.
				Map<String, String> bookInfo = bookDetailSv.getBookInfoWithDiscard(discardingBookDetailNo);
				if(bookInfo.get("BORROWSTATUS").contentEquals("N")) {
					//대출중인 경우, 메시지 출력
					model.addAttribute("message", "대출중인 도서는 폐기할 수 없습니다.");
				}else {
					//4. 대출가능인 경우, 이미 폐기된 도서인지를 검사한다.
					if(bookInfo.get("DISCARD") != null) {
						//이미 폐기된 도서인 경우, 메시지 출력
						model.addAttribute("message", "이미 폐기된 도서입니다.");
					}else {
						//대출상태가 아니고, 폐기가 되지 않은 도서인 경우, 도서를 discardBookInfos 에 추가
						Map<String, String> discardBookInfo = new HashMap<>();
						
						discardBookInfo.put("bookDetailNo", bookInfo.get("BOOKDETAILNO"));
						discardBookInfo.put("title", bookInfo.get("TITLE"));
						discardBookInfo.put("subTitle", bookInfo.get("SUBTITLE"));
						discardBookInfo.put("volume", bookInfo.get("VOLUME"));
						discardBookInfo.put("applicationMark", bookInfo.get("APPLICATIONMARK"));
						
						discardBookInfos.add(discardBookInfo);
					}// fourth if else end
				}// third if else end
			}// second if else end
		}// first if else end
		
		
		//추가한 폐기 도서 정보를 유지
		model.addAttribute("discardBookInfos", discardBookInfos);
		
		//출력할 화면 설정
		model.addAttribute("content", "/WEB-INF/views/librarian/discardBook/discardBook.jsp");
		
		// compositeView pattern 을 사용할 것이므로 항상 main/index 로 리턴
		return "main/index";
	}//addDiscardBook end
	
	
	
	@Override
	@RequestMapping(value="/discardBook", method=RequestMethod.POST)
	public String discardBook(HttpServletRequest req
							, @RequestParam("bookDetailNo") List<String> bookDetailNos
							, @RequestParam("discardReason") List<String> discardReasons
							, Model model) {
		
		
		//폐기 건수를 표시하기 위한 변수 
		int discardCnt = 0;
		
		HttpSession session = req.getSession();
		String librarianNo = (String)session.getAttribute("librarianNo");
		
		
		/**
		 * foreach를 돌며 
		 * (1) discardBook 에 하나하나 insert를 하고,
		 * (2) 해당 도서의 discard 상태를 Y 로 수정한다.
		 */
		for (int i = 0; i < bookDetailNos.size(); i++) {
			//(1)
			int successCnt = 0;
			DiscardBook discardBook = new DiscardBook();
			discardBook.setBookDetailNo(bookDetailNos.get(i));
			discardBook.setDiscardReason(discardReasons.get(i));
			discardBook.setLibrarianNo(librarianNo);
			
			successCnt = discardBookSv.insertDiscardBook(discardBook);
			
			//(2)
			if(successCnt > 0) {
				BookDetail bookDetail = new BookDetail();
				bookDetail.setBookDetailNo(bookDetailNos.get(i));
				bookDetail.setDiscard("Y");
				bookDetail.setDuplicate("NULL");
				bookDetail.setApplicationMark("NULL");
				bookDetailSv.updateBookDetail(bookDetail);				
				
				//(2) 까지 실행이 될 때 discardCnt 를 증가시킨다.
				discardCnt += successCnt;
			}
		}
		
		//discarCnt 를 통해 정상 처리 결과 판단
		if (discardCnt > 0) {
			model.addAttribute("message", discardCnt + " 건의 도서가 폐기되었습니다.");
		}else {
			model.addAttribute("message", "도서 폐기에 실패했습니다.");
		}
		
		//출력할 화면 설정
		model.addAttribute("content", "/WEB-INF/views/librarian/discardBook/discardBook.jsp");
		
		// compositeView pattern 을 사용할 것이므로 항상 main/index 로 리턴
		return "main/index";
	}//discardBook end


}
