package com.ironcows.joodok.librarian.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ironcows.joodok.dto.BookDetail;
import com.ironcows.joodok.dto.Borrow;
import com.ironcows.joodok.dto.Member;
import com.ironcows.joodok.service.BookDetailServiceIf;
import com.ironcows.joodok.service.BorrowServiceIf;
import com.ironcows.joodok.service.MemberServiceIf;

@Controller(value="libReturnBookController")
@RequestMapping(value="/librarian")
public class ReturnBookController implements ReturnBookControllerIf {

	//필요한 service 들을 가져온다.
	
	/**
	 * com.ironcows.joodok.service 안의 클래스에서 Repository(Service) 로 등록한 것을 
	 * Resource에 명시함으로써 연결한다.
	 */
	@Resource(name="memberService")
	private MemberServiceIf memberSv;
	
	@Resource(name="bookDetailService")
	private BookDetailServiceIf bookDetailSv;
	
	@Resource(name="borrowService")
	private BorrowServiceIf borrowSv;
	
	
	@Override
	@RequestMapping(value="/toReturnBook", method=RequestMethod.GET)
	public String toReturnBook(Model model) {
		//출력할 화면 설정
		model.addAttribute("content", "/WEB-INF/views/librarian/returnBook/returnBook.jsp");
		// compositeView pattern 을 사용할 것이므로 항상 main/index 로 리턴
		return "main/index";
	}//toReturnBook end
	
	
	
	@Override
	@RequestMapping(value="/addReturnBook", method=RequestMethod.POST)
	public String addReturnBook(HttpServletRequest req
							  , @RequestParam("returningBookDetailNo") String returningBookDetailNo
							  , @RequestParam(value="bookDetailNo", required=false) List<String> bookDetailNos
							  , Model model) {
		/**
		 * 도서 반납을 위해서
		 * 1. 이미 추가된 도서들은 borrowInfos 에 먼저 추가
		 * 2. 같은 도서가 borrowInfos 에 추가되어 있는지 먼저 검사!
		 * 3. 추가하려는 도서가 이미 반납된 도서인지 검사!
		 */

		
		// 추가한 대출 정보를 추가폼에서 유지하기 위한 변수
		List<Map<String, String>> borrowInfos = new ArrayList<>();
		
		//아래의 변수들을 파라미터 List<String> 타입으로 받을 경우에 생기는 문제를 보완하기 위해, String[] 으로 받는다.
		// (1) title 에 comma 가 있을 경우 comma 를 기점으로 하나의 값이 두개로 분리되는 문제
		// (2) subTitle 과 volume 에 " " 로 공백 문자가 들어가는 것을 인식하지 못하는 문제
		//  @  도서 대출에서는 필요에 따라서 String[] 로 받았지만 
		//     여기서는 bookDetailNos 만 제외하고 String[] 으로 받아서 구현
		//     bookDetailNos 는 2. 조건을 확인하기 위해서 .contains() 함수를 쓸 것이므로
		String[] borrowNos = req.getParameterValues("borrowNo");
		String[] titles = req.getParameterValues("title");
		String[] subTitles = req.getParameterValues("subTitle");
		String[] volumes = req.getParameterValues("volume");
		String[] applicationMarks = req.getParameterValues("applicationMark");
		String[] borrowDays = req.getParameterValues("borrowDay");
		String[] memberNos = req.getParameterValues("memberNo");
		String[] memberIds = req.getParameterValues("memberId");
		String[] memberNames = req.getParameterValues("memberName");
		
		
		//1. 이미 추가된 도서가 있으면 해당 도서들을 borrowInfos 변수에 추가한다.
		if(bookDetailNos != null && borrowNos != null && titles != null && subTitles != null 
		   && volumes != null && applicationMarks != null && borrowDays != null
		   && memberNos != null && memberIds != null && memberNames != null) {
			for (int i = 0; i < bookDetailNos.size(); i++) {
				Map<String, String> borrowInfo = new HashMap<>();
				borrowInfo.put("bookDetailNo", bookDetailNos.get(i));
				borrowInfo.put("borrowNo", borrowNos[i]);
				borrowInfo.put("title", titles[i]);
				borrowInfo.put("subTitle", subTitles[i]);
				borrowInfo.put("volume", volumes[i]);
				borrowInfo.put("applicationMark", applicationMarks[i]);
				borrowInfo.put("borrowDay", borrowDays[i]);
				borrowInfo.put("memberNo", memberNos[i]);
				borrowInfo.put("memberId", memberIds[i]);
				borrowInfo.put("memberName", memberNames[i]);
				
				borrowInfos.add(borrowInfo);
			}
		}
		
		BookDetail checkExistBook = new BookDetail();
		checkExistBook.setBookDetailNo(returningBookDetailNo);
		checkExistBook = bookDetailSv.getOneBookDetail(checkExistBook);
		if(checkExistBook == null){
			//도서가 존재하지 않는 경우, 메시지 출력
			model.addAttribute("message", "없는 도서입니다.");
		}else {
			//도서가 존재하는 경우, 다음 단계 진행
			if(bookDetailNos != null 
			&& bookDetailNos.contains(String.format("%07d", new Integer(returningBookDetailNo).intValue()))) {
				//2. 이미 추가된 도서를 추가하려는 경우, 메시지 출력
				model.addAttribute("message", "이미 추가된 도서입니다.");
			}else {
				// 대출 정보를 추가한다.
				Map<String, String> searchInfo = borrowSv.getBorrowInfo(returningBookDetailNo);
				if(searchInfo == null) {
					//3. 도서가 이미 반납 된 경우, 메시지 출력
					model.addAttribute("message", "이미 반납된 도서입니다.");
				}else {
					//도서가 반납되지 않은 경우, 대출 정보를 추가
					//(1) 도서 정보 추가
					Map<String, String> borrowInfo = new HashMap<>();
					borrowInfo.put("bookDetailNo", searchInfo.get("BOOKDETAILNO"));
					borrowInfo.put("borrowNo", searchInfo.get("BORROWNO"));
					borrowInfo.put("title", searchInfo.get("TITLE"));
					borrowInfo.put("subTitle", searchInfo.get("SUBTITLE"));
					borrowInfo.put("volume", searchInfo.get("VOLUME"));
					borrowInfo.put("applicationMark", searchInfo.get("APPLICATIONMARK"));
					borrowInfo.put("borrowDay", searchInfo.get("BORROWDAY"));
					
					//(2) 회원 정보 추가
					Member member = new Member();
					member.setMemberNo(searchInfo.get("MEMBERNO"));
					member = memberSv.getOneMember(member);
					
					borrowInfo.put("memberNo", member.getMemberNo());
					borrowInfo.put("memberId", member.getId());
					borrowInfo.put("memberName", member.getName());
					borrowInfos.add(borrowInfo);
				}//third if else end
			}//second if else end
		}//first if else end
		
		//추가한 대출 정보를 유지
		model.addAttribute("borrowInfos", borrowInfos);
		
		
		//출력할 화면 설정
		model.addAttribute("content", "/WEB-INF/views/librarian/returnBook/returnBook.jsp");
		
		// compositeView pattern 을 사용할 것이므로 항상 main/index 로 리턴
		return "main/index";
	}//addReturnBook end
	
	
	@Override
	@RequestMapping(value="/returnBook", method=RequestMethod.POST)
	public String returnBook(@RequestParam("bookDetailNo") List<String> bookDetailNos
			               , @RequestParam("borrowNo") List<String> borrowNos
						   , Model model) {
		
		//반납 건수를 표시하기 위한 변수
		int returnCnt = 0; 
		
		for (String borrowNo : borrowNos) {
			int successCnt = 0;
			Borrow borrow = new Borrow();
			borrow.setBorrowNo(borrowNo);
			borrow.setStatus("반납");
			borrow.setReturnedDate("today");
			successCnt = borrowSv.updateBorrow(borrow);
			
			returnCnt += successCnt;
		}
		for (String bookDetailNo : bookDetailNos) {
			BookDetail bookDetail = new BookDetail();
			bookDetail.setBookDetailNo(bookDetailNo);
			bookDetail.setBorrowStatus("Y");
			bookDetailSv.updateBookDetail(bookDetail);
		}
		
		//returnCnt 를 통해 정상 처리를 판단하여 메시지 출력
		if(returnCnt > 0) {
			model.addAttribute("message", returnCnt + " 건의 반납이 정상 처리되었습니다.");			
		}else {
			model.addAttribute("message", "도서 반납에 실패했습니다.");
		}
		
		//출력할 화면 설정
		model.addAttribute("content", "/WEB-INF/views/librarian/returnBook/returnBook.jsp");
		
		// compositeView pattern 을 사용할 것이므로 항상 main/index 로 리턴
		return "main/index";
	}//returnBook end

}
