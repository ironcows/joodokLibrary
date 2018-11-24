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
import com.ironcows.joodok.dto.Reservation;
import com.ironcows.joodok.service.BookDetailServiceIf;
import com.ironcows.joodok.service.BorrowServiceIf;
import com.ironcows.joodok.service.MemberServiceIf;
import com.ironcows.joodok.service.ReservationServiceIf;

@Controller(value="libBorrowController")
@RequestMapping(value="/librarian")
public class BorrowController implements BorrowControllerIf {

	//필요한 service 들을 가져온다.
	
	/**
	 * com.ironcows.joodok.service 안의 클래스에서 Repository(Service) 로 등록한 것을 
	 * Resource에 명시함으로써 연결한다.
	 */
	@Resource(name="bookDetailService")
	private BookDetailServiceIf bookDetailSv;
	
	@Resource(name="reservationService")
	private ReservationServiceIf reservationSv;	
	
	@Resource(name="borrowService")
	private BorrowServiceIf borrowSv;
	
	@Resource(name="memberService")
	private MemberServiceIf memberSv;
	
	@Override
	@RequestMapping(value="/toBorrow", method=RequestMethod.GET)
	public String toBorrow(Model model) {
		//출력할 화면 설정
		model.addAttribute("content", "/WEB-INF/views/librarian/borrow/insertBorrow.jsp");
		
		// compositeView pattern 을 사용할 것이므로 항상 main/index 로 리턴
		return "main/index";
	}//toBorrow end
	
	
	@Override
	@RequestMapping(value="/searchMemberForBorrow", method=RequestMethod.POST)
	public String searchMemberForBorrow(@RequestParam("memberId") String memberId
						     		  , Model model) {
		
		Map<String, String> memberInfo = memberSv.searchMember(memberId);
		
		
		if(memberInfo != null) {
			//1. 회원 검색 결과가 있을 경우
			/**
			 * 회원이 연체중인 도서가 있을 경우 대출을 금지하고
			 * 연체중인 도서의 정보와 함께 반납하도록 메시지를 출력한다.
			 */
			Member member = new Member();
			member.setMemberNo(memberInfo.get("MEMBERNO"));
			List<Map<String, String>> memberBorrows = borrowSv.getMemberBorrow(member);
			
			if(memberBorrows != null) {
				// foreach 를 돌면서 연체가 있는 경우에만 false 로 바꿔줄 것이므로 true 로 초기화
				boolean possibleBorrow = true;
				// 연체가 있는 경우에 메시지 출력을 위한 변수
				String warningMessage = " 건의 도서 연체로 대출할 수 없습니다.";
				// 연체 도서의 개수를 카운트하기 위한 변수
				int delayCnt = 0;
				
				// (1) 회원의 도서 대출 내역이 있는 경우
				for (Map<String, String> memberBorrow : memberBorrows) {
					if(memberBorrow.get("STATUS").contentEquals("연체")) {
						possibleBorrow = false;
						delayCnt++;
					}
				}
				if(possibleBorrow) {
					// <1> 연체가 없는 경우, 회원 정보를 모델에 추가
					model.addAttribute("memberNo", memberInfo.get("MEMBERNO"));
					model.addAttribute("memberId", memberInfo.get("ID"));
					model.addAttribute("memberName", memberInfo.get("NAME"));
					model.addAttribute("dueDate", memberInfo.get("DUEDATE"));
					
					//변수의 값이 제대로 설정되었는지 검사하기 위한 콘솔 출력
//				System.out.println(memberInfo.get("MEMBERNO") + memberInfo.get("ID") + memberInfo.get("NAME") + memberInfo.get("DUEDATE"));
				}else {
					// <2> 연체가 있는 경우, 메시지를 추가
					model.addAttribute("message", "회원님의 " + delayCnt + warningMessage);
					
				}
			}else {
				// (2) 대출 내역이 아에 없을 경우, 회원 정보를 모델에 추가
				model.addAttribute("memberNo", memberInfo.get("MEMBERNO"));
				model.addAttribute("memberId", memberInfo.get("ID"));
				model.addAttribute("memberName", memberInfo.get("NAME"));
				model.addAttribute("dueDate", memberInfo.get("DUEDATE"));
			}
		}else {
			//2. 회원 검색 결과가 없을 경우
			model.addAttribute("message", "없는 회원입니다.");
		}
		
		//출력할 화면 설정
		model.addAttribute("content", "/WEB-INF/views/librarian/borrow/insertBorrow.jsp");
		
		// compositeView pattern 을 사용할 것이므로 항상 main/index 로 리턴
		return "main/index";
	}//searchMemberForBorrow end
	
	@Override
	@RequestMapping(value="/searchBookForBorrow", method=RequestMethod.POST)
	public String searchBookForBorrow(HttpServletRequest req
									, @RequestParam("searchBookDetailNo") String searchBookDetailNo
									, @RequestParam("memberNo") String memberNo
								    , @RequestParam("memberId") String memberId
								    , @RequestParam("memberName") String memberName
								    , @RequestParam("dueDate") String dueDate
								    , @RequestParam(value="bookDetailNo", required=false) List<String> bookDetailNos
			                        , @RequestParam(value="applicationMark", required=false) List<String> applicationMarks
								    , Model model) {
		
		/**
		 * 도서 대출을 위해서
		 * 1. 이미 추가된 도서들은 bookInfos 에 먼저 추가
		 * 2. 같은 도서가 bookInfos 에 추가되어 있는지 먼저 검사!
		 * 3. 그 다음 검색한 도서가 예약된 도서인지 검사한다!
		 *  (1)예약된 도서라면 ? 예약한 회원과 대출하려는 회원이 같은지에 따른 분기 
		 *      * 예약된 도서는 대출가능 상태가 전제이기 때문에 대출 상태에 따른 분기를 생략한다.
		 * 	       같은 회원 : 도서를 추가
		 *       다른 회원 : [다른 회원이 예약한 도서입니다.] 메시지 출력과 해당 도서를 추가 안함
		 *  (2)예약되지 않은 도서라면? 도서의 대출 상태에 따른 분기
		 * 	       대출중 : [이미 대출 된 도서입니다.] 메시지 출력과 해당 도서를 추가 안함
		 *       대출가능 : 도서를 추가
		 */

		// 검색한 도서를 검색폼에서 유지하기 위한 변수
		List<Map<String, String>> bookInfos = new ArrayList<>();
		
		//아래의 변수들을 파라미터 List<String> 타입으로 받을 경우에 생기는 문제를 보완하기 위해, String[] 으로 받는다.
		// (1) title 에 comma 가 있을 경우 comma 를 기점으로 하나의 값이 두개로 분리되는 문제
		// (2) subTitle 과 volume 에 " " 로 공백 문자가 들어가는 것을 인식하지 못하는 문제
		String[] titles = req.getParameterValues("title");
		String[] subTitles = req.getParameterValues("subTitle");
		String[] volumes = req.getParameterValues("volume");
		
		// 1. 이미 추가된 도서가 있으면 해당 도서들을 bookInfos 변수에 추가한다.
		if(bookDetailNos != null && titles != null & subTitles != null
		&& volumes != null && applicationMarks != null) {
			for (int i = 0; i < bookDetailNos.size(); i++) {
				//bookInfos 에 추가
				Map<String, String> bookInfo = new HashMap<String, String>();
				bookInfo.put("bookDetailNo", bookDetailNos.get(i));
				bookInfo.put("title", titles[i]);
				bookInfo.put("subTitle", subTitles[i]);
				bookInfo.put("volume", volumes[i]);
				bookInfo.put("applicationMark", applicationMarks.get(i));
				
				bookInfos.add(bookInfo);
			}
		}
		
		
		BookDetail checkExistBook = new BookDetail();
		checkExistBook.setBookDetailNo(searchBookDetailNo);
		checkExistBook = bookDetailSv.getOneBookDetail(checkExistBook);
		if(checkExistBook == null) {
			//존재하지 않는 도서의 경우, 메시지 출력
			model.addAttribute("message", "없는 도서입니다.");
		}else {
			//존재하는 도서일 경우, 다음 단계 진행
			if(bookDetailNos != null 
			&& bookDetailNos.contains(String.format("%07d", new Integer(searchBookDetailNo).intValue()))) {
				// 2. 같은 도서를 추가하려는 경우, 메시지를 출력
				model.addAttribute("message", "이미 추가된 도서입니다.");
			} else {
				// 3. 도서가 예약된 도서인지 검사한다.
				Map<String, String> checkReservation = reservationSv.checkReservation(searchBookDetailNo);
				if(checkReservation != null) {
					// (1) 예약된 도서일 경우, 대출하려는 회원이 예약한 회원과 같은지 검사한다
					if(memberNo.contentEquals(checkReservation.get("MEMBERNO"))) {
						// 회원이 같은 경우, 도서를 추가
						Map<String, String> info = bookDetailSv.getBookForBorrow(searchBookDetailNo);
						
						Map<String, String> bookInfo = new HashMap<String, String>();
						bookInfo.put("bookDetailNo", info.get("BOOKDETAILNO"));
						bookInfo.put("title", info.get("TITLE"));
						bookInfo.put("subTitle", info.get("SUBTITLE"));
						bookInfo.put("volume", info.get("VOLUME"));
						bookInfo.put("applicationMark", info.get("APPLICATIONMARK"));
						
						bookInfos.add(bookInfo);
					} else {
						// 회원이 다른 경우, 메시지를 출력
						model.addAttribute("message", "다른 회원이 예약한 도서입니다.");
					}
				}else {
					// (2) 예약되지 않은 도서일 경우, 도서가 대출 상태인지를 검사한다.
					// 검색용 bookDetail 포장
					BookDetail bookDetail = new BookDetail();
					bookDetail.setBookDetailNo(searchBookDetailNo);
					
					//bookDetailSv 로 조회
					bookDetail = bookDetailSv.getOneBookDetail(bookDetail);
					
					
					if(bookDetail.getBorrowStatus().contentEquals("Y")) {
						//대출가능 상태인 경우, 도서를 추가
						Map<String, String> info = bookDetailSv.getBookForBorrow(searchBookDetailNo);
						
						Map<String, String> bookInfo = new HashMap<String, String>();
						bookInfo.put("bookDetailNo", info.get("BOOKDETAILNO"));
						bookInfo.put("title", info.get("TITLE"));
						bookInfo.put("subTitle", info.get("SUBTITLE"));
						bookInfo.put("volume", info.get("VOLUME"));
						bookInfo.put("applicationMark", info.get("APPLICATIONMARK"));
						
						bookInfos.add(bookInfo);
					}else {
						//대출중 상태인 경우, 메시지를 출력
						model.addAttribute("message", "이미 대출된 도서입니다.");
					}
				} // inside if else end
			} // outside if else end
		}// first if else end
		
		
		//회원 정보를 유지
		model.addAttribute("memberNo", memberNo);
		model.addAttribute("memberId", memberId);
		model.addAttribute("memberName", memberName);
		model.addAttribute("dueDate", dueDate);
		
		//검색한 도서 정보를 유지
		model.addAttribute("bookInfos", bookInfos);
		
		//출력할 화면 설정
		model.addAttribute("content", "/WEB-INF/views/librarian/borrow/insertBorrow.jsp");
		
		// compositeView pattern 을 사용할 것이므로 항상 main/index 로 리턴
		return "main/index";
	}//searchBookForBorrow end
	
	@Override
	@RequestMapping(value="/insertBorrow", method=RequestMethod.POST)
	public String insertBorrow(HttpServletRequest req
							 , @RequestParam("memberNo") String memberNo
							 , @RequestParam("dueDate") String dueDate
							 , @RequestParam("bookDetailNo") List<String> bookDetailNos
							 , Model model) {	
		
		/**
		 * 도서 대출을 하면서 고려해야할 점
		 * (1) bookDetail 테이블의 도서의 borrowStatus 를 'N' 로 수정 
		 * (2) 회원이 예약했던 도서를 대출하는 경우!
		 *     ~ reservation 테이블의 해당 레코드의 상태를 '완료' 로 수정
		 */
		
		//대출 도서의 권수를 사서에게 보여주기 위한 변수
		int borrowCnt = 0;
		
		// 한번의 대출로 여러 권의 도서를 대출하는 경우를 고려해서
		// bookDetailNo 를 제외한 memberNo 와 dueDate 만 설정하고 포장
		Borrow insertBorrow = new Borrow();
		insertBorrow.setMemberNo(memberNo);
		insertBorrow.setDueDate(dueDate);
		
		
		for (String bookDetailNo : bookDetailNos) {
			int successCnt = 0;
			insertBorrow.setBookDetailNo(bookDetailNo);
			
			//bookDetailNo까지 설정이 되면 borrowSv 를 통해서 insert 요청
			successCnt = borrowSv.insertBorrow(insertBorrow);
			if(successCnt > 0) {
				//대출이 정상 처리된 경우
				//(1) 도서의 대출 상태를 '대출중' 으로 수정
				BookDetail modifyBookDetail = new BookDetail();
				modifyBookDetail.setBookDetailNo(bookDetailNo);
				modifyBookDetail.setBorrowStatus("N");
				bookDetailSv.updateBookDetail(modifyBookDetail);
				
				//(2) 회원이 예약한 도서인 경우, reservationSv를 통해서 예약 테이블의 해당 레코드의 상태를 '완료' 로 수정
				Map<String, String> checkReservation = reservationSv.checkReservation(bookDetailNo);
				if(checkReservation != null) {
					Reservation modifyReservation = new Reservation();
					modifyReservation.setReservationNo(checkReservation.get("RESERVATIONNO"));
					modifyReservation.setStatus("완료");
					reservationSv.updateReservation(modifyReservation);
				}// inside if else end
				borrowCnt += successCnt;
			}// outside if else end
		}// foreach end
		
		
		//borrowCnt 변수를 통해 대출이 정상 처리된 경우와 아닌 경우에 따른 메시지 출력
		if(borrowCnt > 0) {
			//정상 처리된 경우
			model.addAttribute("message", String.format("%02d", borrowCnt) + " 건의 대출이 정상 처리되었습니다.");
		} else {
			//정상 처리되지 않은 경우
			model.addAttribute("message", "대출에 실패했습니다.");
		}
		
		
		//출력할 화면 설정
		model.addAttribute("content", "/WEB-INF/views/librarian/borrow/insertBorrow.jsp");
		
		// compositeView pattern 을 사용할 것이므로 항상 main/index 로 리턴
		return "main/index";
	}//insertBorrow end

}
