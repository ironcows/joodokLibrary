package com.ironcows.joodok.librarian.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ironcows.joodok.dto.BookDetail;
import com.ironcows.joodok.dto.CheckUpList;
import com.ironcows.joodok.dto.MetaBook;
import com.ironcows.joodok.service.BookDetailServiceIf;
import com.ironcows.joodok.service.CheckUpListServiceIf;
import com.ironcows.joodok.service.DetailLocationServiceIf;
import com.ironcows.joodok.service.LocationServiceIf;
import com.ironcows.joodok.service.MetaBookServiceIf;


@Controller(value="libRegisterBookDetailController")
@RequestMapping(value="/librarian")
public class RegisterBookDetailController implements RegisterBookDetailControllerIf {

	//필요한 service 들을 가져온다.
	
	/**
	 * com.ironcows.joodok.service 안의 클래스에서 Repository(Service) 로 등록한 것을 
	 * Resource에 명시함으로써 연결한다.
	 */
	@Resource(name="bookDetailService")
	private BookDetailServiceIf bookDetailSv;
	
	@Resource(name="checkUpListService")
	private CheckUpListServiceIf checkUpListSv;
	
	@Resource(name="metaBookService")
	private MetaBookServiceIf metaBookSv;
	
	@Resource(name="locationService")
	private LocationServiceIf locationSv;
	
	@Resource(name="detailLocationService")
	private DetailLocationServiceIf detailLocationSv;
	
	
	
	@Override
	@RequestMapping(value="/toRegisterBookDetail", method=RequestMethod.GET)
	public String toRegisterBookDetail(Model model) {
		
		//대문자 표기 레코드셋
		List<Map<String, String>> capitalBookList = checkUpListSv.getUnRegisteredBookList();
		
		//캐멀 노테이션 표기 레코드셋
		List<Map<String, String>> unRegisteredBookList = new ArrayList<>();
		
		//registerBookDetail.jsp 에서 사용될 el 에서 컬럼명을 대문자로 표기되는 것을
		//캐멀 노테이션을 적용한 레코드로 변경해준다.
		for (Map<String, String> capitalBookOne : capitalBookList) {
			Map<String, String> newOne = new HashMap<>();
			newOne.put("num", capitalBookOne.get("NUM"));
			newOne.put("checkUpIsbn", capitalBookOne.get("CHECKUPISBN"));
			newOne.put("title", capitalBookOne.get("TITLE"));
			newOne.put("author", capitalBookOne.get("AUTHOR"));
			newOne.put("publisher", capitalBookOne.get("PUBLISHER"));
			
			unRegisteredBookList.add(newOne);
		}
		
		model.addAttribute("unRegisteredBookList", unRegisteredBookList);
		
		//출력할 화면 설정
		model.addAttribute("content", "/WEB-INF/views/librarian/registerBook/registerBookDetail.jsp");
		
		// compositeView pattern 을 사용할 것이므로 항상 main/index 로 리턴
		return "main/index";
	}//toRegisterBookDetail end
	
	
	@Override
	@RequestMapping(value="/selectUnRegisterBookDetail", method=RequestMethod.POST)
	public String selectUnRegisterBookDetail(@RequestParam("checkedIsbn") String checkedIsbn
										   , @RequestParam("num") List<String> nums
										   , @RequestParam("checkUpIsbn") List<String> checkUpIsbns
										   , @RequestParam("title") List<String> titles
										   , @RequestParam("author") List<String> authors
										   , @RequestParam("publisher") List<String> publishers
										   , @RequestParam(value="chNum", required=false) String chNum
										   , @RequestParam(value="chCheckUpIsbn", required=false) String chCheckUpIsbn
										   , @RequestParam(value="chTitle", required=false) String chTitle
										   , @RequestParam(value="chAuthor", required=false) String chAuthor
										   , @RequestParam(value="chPublisher", required=false) String chPublisher
										   , Model model) {    

		/**
		 * 선택된 대상을 등록 화면에 추가하기 위해서 주의해야할 점
		 * 1. 이미 선택된 대상이 있으면 checkedRegisterOne 변수에 담는다. unRegisteredBookList 에 담는다.
		 * 2. 대상 목록에 있는 리스트를 모두 가져와서 unRegisteredBookList 변수에 담는다. 
		 * 3. 선택한 도서에 대한 정보 checkedIsbn 의 값과 일치하는 아이템을 unRegisteredBookList 에서 제거한다.
		 * 4. 3 에서 제거한(선택한) 아이템을 checkedRegisterOne 변수에 담는다.
		 * 5. checkedIsbn 와 일치하는 데이터들을 검수 테이블에서 가져와 preRegisterDetailList 에 담는다.
		 */
		
		//대상 목록의 리스트를 유지할 변수
		List<Map<String, String>> unRegisteredBookList = new ArrayList<>();
		
		//선택 대상을 유지할 변수
		Map<String, String> checkedUnRegisterOne = new HashMap<>();
		
		//선택된 대상의 등록 대기 목록(검수 결과 목록)을 보여줄 변수
		List<Map<String, String>> preRegisterDetailList = new ArrayList<>();
		

		//1. 이미 선택된 대상이 있으면 checkedMetaBook 변수에 담는다.
		if(chNum != null && chCheckUpIsbn != null
		&& chTitle != null && chAuthor != null && chPublisher != null) {
			checkedUnRegisterOne.put("num", chNum);
			checkedUnRegisterOne.put("checkUpIsbn", chCheckUpIsbn);
			checkedUnRegisterOne.put("title", chTitle);
			checkedUnRegisterOne.put("author", chAuthor);
			checkedUnRegisterOne.put("publisher", chPublisher);
			
			/**
			 * 주의! 
			 * 등록되지 않은 대상 목록은 한 개의 대상이 선택되어 목록에서 안보이더라도 등록이 완전히 이루어지기 전까지
			 * 유지가 되어야 하므로, 이미 선택된 대상을 미리 추가해놓음으로써 전체 목록을 유지할 수 있게 된다.
			 */
			unRegisteredBookList.add(checkedUnRegisterOne);
		}
		
		//2. 대상 목록을 모두 가져와서 유지
		if(nums != null && checkUpIsbns != null
		&& titles != null && authors != null && publishers != null) {
			for (int i = 0; i < checkUpIsbns.size(); i++) {
				Map<String, String> unRegisteredOne = new HashMap<>();
				unRegisteredOne.put("num", nums.get(i));
				unRegisteredOne.put("checkUpIsbn", checkUpIsbns.get(i));
				unRegisteredOne.put("title", titles.get(i));
				unRegisteredOne.put("author", authors.get(i));
				unRegisteredOne.put("publisher", publishers.get(i));
				
				unRegisteredBookList.add(unRegisteredOne);
			}//for end
		}//if end
		
		//3. 선택한 대상을 대상 목록에서 제외하기
		if(checkedIsbn != null) {
			for (Iterator<Map<String, String>> it = unRegisteredBookList.iterator(); it.hasNext();) {
				Map<String, String> unRegisteredOne = it.next();
				
				if(checkedIsbn.contentEquals(unRegisteredOne.get("checkUpIsbn"))) {
					it.remove();
					
					//4. 선택된 것을 모델에 추가
					checkedUnRegisterOne = unRegisteredOne;
					model.addAttribute("checkedUnRegisterOne", checkedUnRegisterOne);
				}
			}//first for end
			
			
			//5. checkedIsbn 와 일치하는 데이터들을 검수 테이블에서 가져와 preRegisterDetailList 에 담는다.
			List<Map<String, String>> capitalPreRegisterList = checkUpListSv.getPreRegisterDetailList(checkedIsbn);
			
			//registerBookDetail.jsp 에서 사용될 el 에서 컬럼명을 대문자로 표기되는 것을
			//캐멀 노테이션을 적용한 레코드로 변경해준다.
			for (Map<String, String> capitalPreOne : capitalPreRegisterList) {
				Map<String, String> newOne = new HashMap<>();
				newOne.put("checkUpListNo", capitalPreOne.get("CHECKUPLISTNO"));
				newOne.put("checkUpIsbn", capitalPreOne.get("CHECKUPISBN"));
				newOne.put("title", capitalPreOne.get("TITLE"));
				newOne.put("author", capitalPreOne.get("AUTHOR"));
				newOne.put("publisher", capitalPreOne.get("PUBLISHER"));
				newOne.put("checkUpResult", capitalPreOne.get("CHECKUPRESULT"));
				newOne.put("metaBookNo", capitalPreOne.get("METABOOKNO"));
				
				preRegisterDetailList.add(newOne);
			}
			model.addAttribute("preRegisterDetailList", preRegisterDetailList);
		}//if end
		
		
		model.addAttribute("preRegisterDetailList", preRegisterDetailList);
		
		model.addAttribute("unRegisteredBookList", unRegisteredBookList);
		
		//출력할 화면 설정
		model.addAttribute("content", "/WEB-INF/views/librarian/registerBook/registerBookDetail.jsp");
		
		// compositeView pattern 을 사용할 것이므로 항상 main/index 로 리턴
		return "main/index";
	}//selectUnRegisterBookDetail end
	
	
	
	@Override
	@RequestMapping(value="/addPreRegisterBookDetail", method=RequestMethod.POST)
	public String addPreRegisterBookDetail(HttpServletRequest req
										 , @RequestParam("checkedNo") String checkedNo
										 , @RequestParam("checkUpListNo") List<String> checkUpListNos
										 , @RequestParam("checkUpIsbn") List<String> checkUpIsbns
										 , @RequestParam("title") List<String> titles
										 , @RequestParam("author") List<String> authors
										 , @RequestParam("publisher") List<String> publishers
										 , @RequestParam("checkUpResult") List<String> checkUpResults
										 , @RequestParam("metaBookNo") List<String> metaBookNos
										 , @RequestParam(value="chCheckUpListNo", required=false) String chCheckUpListNo
										 , @RequestParam(value="chCheckUpIsbn", required=false) String chCheckUpIsbn
										 , @RequestParam(value="chTitle", required=false) String chTitle
										 , @RequestParam(value="chAuthor", required=false) String chAuthor
										 , @RequestParam(value="chPublisher", required=false) String chPublisher
										 , @RequestParam(value="chCheckUpResult", required=false) String chCheckUpResult
										 , @RequestParam(value="chMetaBookNo", required=false) String chMetaBookNo
										 , Model model) {
		/**
		 * registerBookDetail.jsp 에서 1번 폼에 표시될 값들을 유지하기
		 * 참고 : 메서드의 파라미터로 받아도 가능하지만, 
		 *      메서드 파라미터는 메서드의 본 기능에 집중적으로 쓰이도록 한다.
		 *      이전 폼의 값을 유지하기 위해 쓰이는 것은 req 에서 가져오기로 한다.
		 */
		// 선택 대상 목록 유지
		List<Map<String, String>> unRegisteredBookList = new ArrayList<>();
		
		String[] formOneNums = req.getParameterValues("formOneNum");
		String[] formOneCheckUpIsbns = req.getParameterValues("formOneCheckUpIsbn");
		String[] formOneTitles = req.getParameterValues("formOneTitle");
		String[] formOneAuthors = req.getParameterValues("formOneAuthor");
		String[] formOnePublishers = req.getParameterValues("formOnePublisher");
		
		if(formOneNums != null && formOneCheckUpIsbns != null
		&& formOneTitles != null && formOneAuthors != null
		&& formOnePublishers != null) {
			for (int i = 0; i < formOneNums.length; i++) {
				Map<String, String> formOneInfo = new HashMap<>();
				formOneInfo.put("num", formOneNums[i]);
				formOneInfo.put("checkUpIsbn", formOneCheckUpIsbns[i]);
				formOneInfo.put("title", formOneTitles[i]);
				formOneInfo.put("author", formOneAuthors[i]);
				formOneInfo.put("publisher", formOnePublishers[i]);
				
				unRegisteredBookList.add(formOneInfo);
			}
		}
		model.addAttribute("unRegisteredBookList", unRegisteredBookList);
		
		// 선택된 대상 유지
		Map<String, String> checkedUnRegisterOne = new HashMap<>();
		checkedUnRegisterOne.put("num", req.getParameter("formOneChNum"));
		checkedUnRegisterOne.put("checkUpIsbn", req.getParameter("formOneChCheckUpIsbn"));
		checkedUnRegisterOne.put("title", req.getParameter("formOneChTitle"));
		checkedUnRegisterOne.put("author", req.getParameter("formOneChAuthor"));
		checkedUnRegisterOne.put("publisher", req.getParameter("formOneChPublisher"));
		model.addAttribute("checkedUnRegisterOne", checkedUnRegisterOne);
		
		
		/**
		 * 선택된 대상을 등록 화면에 추가하기 위해서 주의해야할 점
		 * 1. 이미 선택된 대상이 있으면 checkedPreRegisterOne 변수에 담는다. preRegisterDetailList 에 담는다.
		 * 2. 대상 목록에 있는 리스트를 모두 가져와서 preRegisterDetailList 변수에 담는다. 
		 * 3. 선택한 도서에 대한 정보 checkedNo 의 값과 일치하는 아이템을 preRegisterDetailList 에서 제거한다.
		 * 4. 3 에서 제거한(선택한) 아이템을 checkedPreRegisterOne 변수에 담는다.
		 * 5. checkedNo 와 일치하는 데이터에서 'metaBookNo' 를 metaBookNo 변수에 담는다.
		 * 6. metaBookNo 값으로 도서 공통정보는 metaInfo 변수에 도서 상세정보는 bookDetails 변수에 담는다.
		 * 7. 등록된 도서 상세정보가 있을 경우 applicationMark(청구기호)와 duplicate(복본)을 자동 증가시키고
		 *    				  없을 경우 applicationMark 는 빈칸, duplicate 는 '01' 으로 초기화 시켜준다.
		 */
		
		//대상 목록의 리스트를 유지할 변수
		List<Map<String, String>> preRegisterDetailList = new ArrayList<>();
		
		//선택 대상을 유지할 변수
		Map<String, String> checkedPreRegisterOne = new HashMap<>();
	
		String metaBookNo = null;
		
		
		//1. 이미 선택된 대상이 있으면 checkedMetaBook 변수에 담는다.
		if(chCheckUpListNo != null && chCheckUpIsbn != null
		&& chTitle != null && chAuthor != null && chPublisher != null
		&& chCheckUpResult != null && chMetaBookNo != null) {
			checkedPreRegisterOne.put("checkUpListNo", chCheckUpListNo);
			checkedPreRegisterOne.put("checkUpIsbn", chCheckUpIsbn);
			checkedPreRegisterOne.put("title", chTitle);
			checkedPreRegisterOne.put("author", chAuthor);
			checkedPreRegisterOne.put("publisher", chPublisher);
			checkedPreRegisterOne.put("checkUpResult", chCheckUpResult);
			checkedPreRegisterOne.put("metaBookNo", chMetaBookNo);
			
			/**
			 * 주의! 
			 * 등록되지 않은 대상 목록은 한 개의 대상이 선택되어 목록에서 안보이더라도 등록이 완전히 이루어지기 전까지
			 * 유지가 되어야 하므로, 이미 선택된 대상을 미리 추가해놓음으로써 전체 목록을 유지할 수 있게 된다.
			 */
			preRegisterDetailList.add(checkedPreRegisterOne);
		}
		
		//2. 대상 목록을 모두 가져와서 유지
		if(checkUpListNos != null && checkUpIsbns != null
		&& titles != null && authors != null && publishers != null
		&& checkUpResults != null && metaBookNos != null) {
			for (int i = 0; i < checkUpIsbns.size(); i++) {
				Map<String, String> preRegisteredOne = new HashMap<>();
				preRegisteredOne.put("checkUpListNo", checkUpListNos.get(i));
				preRegisteredOne.put("checkUpIsbn", checkUpIsbns.get(i));
				preRegisteredOne.put("title", titles.get(i));
				preRegisteredOne.put("author", authors.get(i));
				preRegisteredOne.put("publisher", publishers.get(i));
				preRegisteredOne.put("checkUpResult", checkUpResults.get(i));
				preRegisteredOne.put("metaBookNo", metaBookNos.get(i));
				
				preRegisterDetailList.add(preRegisteredOne);
			}//for end
		}//if end
		
		//3. 선택한 대상을 대상 목록에서 제외하기
		if(checkedNo != null) {
			for (Iterator<Map<String, String>> it = preRegisterDetailList.iterator(); it.hasNext();) {
				Map<String, String> preRegisteredOne = it.next();
				
				if(checkedNo.contentEquals(preRegisteredOne.get("checkUpListNo"))) {
					it.remove();
					
					//4. 선택된 것을 모델에 추가
					checkedPreRegisterOne = preRegisteredOne;
					model.addAttribute("checkedPreRegisterOne", checkedPreRegisterOne);
					
					//5. checkedNo 와 일치하는 데이터에서 'metaBookNo' 를 metaBookNo 변수에 담는다.
					metaBookNo = checkedPreRegisterOne.get("metaBookNo");
				}
			}//first for end
		}//if end
		model.addAttribute("preRegisterDetailList", preRegisterDetailList);
		
 
		//등록하려는 도서의 청구기호, 복본을 registerBookDetail.jsp 의 인풋 태그에 자동으로 입력하기 위한 변수
		Map<String, String> regBookDetail = new HashMap<>();
		String regApplicationMark = "";
		String regDuplicate = "1";
		
		//6. 도서 공통정보는 metaInfo 변수에 도서 상세정보는 bookDetails 변수에 담는다.
		if (metaBookNo != null) {
			MetaBook metaBook = new MetaBook();
			metaBook.setMetaBookNo(metaBookNo);			
			metaBook = metaBookSv.getOneMetaBook(metaBook);
			
			model.addAttribute("metaInfo", metaBook);
			
			List<Map<String, String>> bookDetails = bookDetailSv.seeBookDetail(metaBookNo);
			
			//7. applicationMark(청구기호)와 duplicate(복본)을 자동 증가 시키기 위해 값 추출
			if(bookDetails != null) {
				for (Map<String, String> bookDetail : bookDetails) {
					int dupl = Integer.parseInt(bookDetail.get("DUPLICATE")) + 1;
					regDuplicate = String.format("%d", dupl);

					String applicationMark = bookDetail.get("APPLICATIONMARK");
					int length = applicationMark.length();
					
					if(applicationMark.substring(length - 3, length).contains("c")) {
						regApplicationMark = applicationMark + (Integer.parseInt(applicationMark.substring(length-1))+1);
					}else {
						regApplicationMark += applicationMark + " c.2";
					}
				}
			}
			model.addAttribute("bookDetails", bookDetails);
		}
		regBookDetail.put("regApplicationMark", regApplicationMark);
		regBookDetail.put("regDuplicate", regDuplicate);
		model.addAttribute("regBookDetail", regBookDetail);
		
		//도서 상세정보 등록할 때 도서의 소장 위치를 선택할 때 필요한 정보 추가
		model.addAttribute("locationInfo", locationSv.getAllLocation());
		model.addAttribute("detailLocationInfo", detailLocationSv.getAllDetailLocation());
		
		//출력할 화면 설정
		model.addAttribute("content", "/WEB-INF/views/librarian/registerBook/registerBookDetail.jsp");
		
		// compositeView pattern 을 사용할 것이므로 항상 main/index 로 리턴
		return "main/index";
	}//addPreRegisterBookDetail end
	
	
	
	
	
	@Override
	@RequestMapping(value="/registerBookDetail", method=RequestMethod.POST)
	public String registerBookDetail(HttpServletRequest req
								   , @ModelAttribute BookDetail regBookDetail
								   , Model model) {

		/**
		 * 도서상세 등록 처리와 결과에 따른 메시지 출력 설정
		 */
		
		//등록 성공 여부를 판단할 변수
		int successCnt = 0;
		
		successCnt = bookDetailSv.insertBookDetail(regBookDetail);
		
		if(successCnt > 0 ) {
			model.addAttribute("message", "도서 상세정보가 등록되었습니다.");
			
			// checkUpList 테이블의 해당 레코드의 registeredOrNot 속성을 'Y' 로 수정해준다.
			CheckUpList checkUpList = new CheckUpList();
			checkUpList.setCheckUpListNo(req.getParameter("formTwoChCheckUpListNo"));
			checkUpList.setRegisteredOrNot("Y");
			checkUpListSv.updateCheckUpList(checkUpList);
			
			
			
			
			
			/**
			 * registerBookDetail.jsp 에서 1번 폼과 2번 폼 표시될 값들을 유지하기
			 * 참고 : 메서드의 파라미터로 받아도 가능하지만, 
			 *      메서드 파라미터는 메서드의 본 기능에 집중적으로 쓰이도록 한다.
			 *      이전 폼의 값을 유지하기 위해 쓰이는 것은 req 에서 가져오기로 한다.
			 */
			
			/**
			 * 1번 폼의 값을 유지하기 위한 처리
			 */
			// 추가 대상 목록 유지
			List<Map<String, String>> unRegisteredBookList = new ArrayList<>();
			
			String[] formOneNums = req.getParameterValues("formOneNum");
			String[] formOneCheckUpIsbns = req.getParameterValues("formOneCheckUpIsbn");
			String[] formOneTitles = req.getParameterValues("formOneTitle");
			String[] formOneAuthors = req.getParameterValues("formOneAuthor");
			String[] formOnePublishers = req.getParameterValues("formOnePublisher");
			
			if(formOneNums != null && formOneCheckUpIsbns != null
			&& formOneTitles != null && formOneAuthors != null
			&& formOnePublishers != null) {
				for (int i = 0; i < formOneNums.length; i++) {
					Map<String, String> formOneInfo = new HashMap<>();
					formOneInfo.put("num", formOneNums[i]);
					formOneInfo.put("checkUpIsbn", formOneCheckUpIsbns[i]);
					formOneInfo.put("title", formOneTitles[i]);
					formOneInfo.put("author", formOneAuthors[i]);
					formOneInfo.put("publisher", formOnePublishers[i]);
					
					unRegisteredBookList.add(formOneInfo);
				}
			}
			model.addAttribute("unRegisteredBookList", unRegisteredBookList);
			
			// 추가된 대상 유지
			Map<String, String> checkedUnRegisterOne = new HashMap<>();
			//도서가 등록이 되면 대기 권수가 1권 줄어야 하므로, -1 을 해준다.
			int num = Integer.parseInt(req.getParameter("formOneChNum")) - 1;
			if(num > 0) {
				// 대기 권수가 0권일 경우엔 목록에 나타나선 안돼므로 1권 이상일 때만 대상을 유지하도록 한다.
				checkedUnRegisterOne.put("num", String.format("%d", num));
				checkedUnRegisterOne.put("checkUpIsbn", req.getParameter("formOneChCheckUpIsbn"));
				checkedUnRegisterOne.put("title", req.getParameter("formOneChTitle"));
				checkedUnRegisterOne.put("author", req.getParameter("formOneChAuthor"));
				checkedUnRegisterOne.put("publisher", req.getParameter("formOneChPublisher"));
				model.addAttribute("checkedUnRegisterOne", checkedUnRegisterOne);				
			}
			
			
			
			/**
			 * 2번 폼의 값을 유지하기 위한 처리
			 */
			// 선택 대상 목록 유지
			List<Map<String, String>> preRegisterDetailList = new ArrayList<>();
			
			String[] formTwoCheckUpListNos = req.getParameterValues("formTwoCheckUpListNo");
			String[] formTwoCheckUpIsbns = req.getParameterValues("formTwoCheckUpIsbn");
			String[] formTwoTitles = req.getParameterValues("formTwoTitle");
			String[] formTwoAuthors = req.getParameterValues("formTwoAuthor");
			String[] formTwoPublishers = req.getParameterValues("formTwoPublisher");
			String[] formTwoCheckUpResults = req.getParameterValues("formTwoCheckUpResult");
			String[] formTwoMetaBookNos = req.getParameterValues("formTwoMetaBookNo");
			
			if(formTwoCheckUpListNos != null && formTwoCheckUpIsbns != null
			&& formTwoTitles != null && formTwoAuthors != null
			&& formTwoPublishers != null && formTwoCheckUpResults != null
			&& formTwoMetaBookNos != null) {
				for (int i = 0; i < formTwoCheckUpListNos.length; i++) {
					Map<String, String> formTwoInfo = new HashMap<>();
					formTwoInfo.put("checkUpListNo", formTwoCheckUpListNos[i]);
					formTwoInfo.put("checkUpIsbn", formTwoCheckUpIsbns[i]);
					formTwoInfo.put("title", formTwoTitles[i]);
					formTwoInfo.put("author", formTwoAuthors[i]);
					formTwoInfo.put("publisher", formTwoPublishers[i]);
					formTwoInfo.put("checkUpResult", formTwoCheckUpResults[i]);
					formTwoInfo.put("metaBookNo", formTwoMetaBookNos[i]);
					
					preRegisterDetailList.add(formTwoInfo);
				}
			}
			model.addAttribute("preRegisterDetailList", preRegisterDetailList);
			
			
			
		}else {
			model.addAttribute("message", "도서 상세정보 등록에 실패했습니다.");
		}
		
		//출력할 화면 설정
		model.addAttribute("content", "/WEB-INF/views/librarian/registerBook/registerBookDetail.jsp");
		
		// compositeView pattern 을 사용할 것이므로 항상 main/index 로 리턴
		return "main/index";
	}//registerBookDetail end
	


}
