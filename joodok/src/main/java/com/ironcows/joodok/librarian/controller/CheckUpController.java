package com.ironcows.joodok.librarian.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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

import com.ironcows.joodok.dto.CheckUp;
import com.ironcows.joodok.dto.CheckUpList;
import com.ironcows.joodok.service.AcquisitionServiceIf;
import com.ironcows.joodok.service.CheckUpListServiceIf;
import com.ironcows.joodok.service.CheckUpServiceIf;

@Controller(value="libCheckUpController")
@RequestMapping(value="/librarian")
public class CheckUpController implements CheckUpControllerIf {

	//필요한 service 들을 가져온다.
	
	/**
	 * com.ironcows.joodok.service 안의 클래스에서 Repository(Service) 로 등록한 것을 
	 * Resource에 명시함으로써 연결한다.
	 */
	
	@Resource(name="acquisitionService")
	private AcquisitionServiceIf acquisitionSv;
	
	@Resource(name="checkUpService")
	private CheckUpServiceIf checkUpSv;
	
	@Resource(name="checkUpListService")
	private CheckUpListServiceIf checkUpListSv;
	
	@Override
	@RequestMapping(value="/toCheckUp", method=RequestMethod.GET)
	public String toCheckUp(Model model) {
		
		
		//대문자 표기 레코드셋
		List<Map<String, String>> capitalCheckUpList = acquisitionSv.getAcquisitionForCheckUp();
		
		//캐멀 노테이션 표기 레코드셋
		List<Map<String, String>> unCheckUpList = new ArrayList<>();
		
		//insertCheckUp.jsp 에서 사용될 el 에서 컬럼명을 대문자로 표기되는 것을
		//캐멀 노테이션을 적용한 레코드로 변경해준다.
		for (Map<String, String> capitalCheckUpOne : capitalCheckUpList) {
			Map<String, String> newOne = new HashMap<>();
			newOne.put("acquisitionNo", capitalCheckUpOne.get("ACQUISITIONNO"));
			newOne.put("registeredDate", capitalCheckUpOne.get("REGISTEREDDATE"));
			newOne.put("category", capitalCheckUpOne.get("CATEGORY"));
			newOne.put("acquisitionIsbn", capitalCheckUpOne.get("ACQUISITIONISBN"));
			
			unCheckUpList.add(newOne);
		}
		
		model.addAttribute("unCheckUpList", unCheckUpList);
		
		//출력할 화면 설정
		model.addAttribute("content", "/WEB-INF/views/librarian/checkUp/insertCheckUp.jsp");
		
		// compositeView pattern 을 사용할 것이므로 항상 main/index 로 리턴
		return "main/index";
	}//toCheckUp
	
	
	@Override
	@RequestMapping(value="/addCheckUpList", method=RequestMethod.POST)
	public String addCheckUpList(@RequestParam(value="checkedAcquisitionNo", required=false) List<String> checkedAcquisitionNos
							   , @RequestParam(value="checkedCount", required=false) List<Integer> checkedCounts
							   , @RequestParam(value="acquisitionNo", required=false) List<String> acquisitionNos
							   , @RequestParam(value="category", required=false) List<String> categorys
							   , @RequestParam(value="acquisitionIsbn", required=false) List<String> acquisitionIsbns
							   , @RequestParam(value="registeredDate", required=false) List<String> registeredDates
							   , @RequestParam(value="chAcquisitionNo", required=false) List<String> chAcquisitionNos
							   , @RequestParam(value="chCategory", required=false) List<String> chCategorys
							   , @RequestParam(value="chAcquisitionIsbn", required=false) List<String> chAcquisitionIsbns
							   , @RequestParam(value="chRegisteredDate", required=false) List<String> chRegisteredDates
							   , Model model) {
		
		/**
		 * 선택된 대상을 검수 목록에 추가하기 위해서 주의해야할 점
		 * 1. 이미 선택된 목록이 있으면 checkUpList 에 담는다.
		 * 2. 대상 목록에 있는 리스트를 모두 가져와서 unCheckUpList 변수에 담는다. 
		 * 3. 선택한 목록에 대한 정보 checkedAcquisitionNos 의 값들과 일치하는 아이템들을 unCheckUpList 에서 하나씩 제거한다.
		 * 4. 선택한 목록을 checkUpList 에 담는다.
		 */
		
		//대상 목록의 리스트를 유지할 변수
		List<Map<String, String>> unCheckUpList = new ArrayList<>();
		
		//선택 목록의 리스트를 유지할 변수
		List<Map<String, String>> checkUpList = new ArrayList<>();
		
		//1. 이미 선택된 목록이 있으면 checkUpList 에 담는다.
		if(chAcquisitionNos != null && chCategorys != null
		&& chAcquisitionIsbns != null && chRegisteredDates != null) {
			for (int i = 0; i < chAcquisitionNos.size(); i++) {
				Map<String, String> orderOne = new HashMap<>();
				orderOne.put("acquisitionNo", chAcquisitionNos.get(i));
				orderOne.put("category", chCategorys.get(i));
				orderOne.put("acquisitionIsbn", chAcquisitionIsbns.get(i));
				orderOne.put("registeredDate", chRegisteredDates.get(i));
				
				checkUpList.add(orderOne);
			}//for end
		}//if end
		
		
		//2. 대상 목록을 모두 가져와서 유지
		if(acquisitionNos != null && categorys != null
		&& acquisitionIsbns != null && registeredDates != null) {
			for (int i = 0; i < acquisitionNos.size(); i++) {
				Map<String, String> unCheckUpOne = new HashMap<>();
				unCheckUpOne.put("acquisitionNo", acquisitionNos.get(i));
				unCheckUpOne.put("category", categorys.get(i));
				unCheckUpOne.put("acquisitionIsbn", acquisitionIsbns.get(i));
				unCheckUpOne.put("registeredDate", registeredDates.get(i));
				
				unCheckUpList.add(unCheckUpOne);
			}//for end
		}//if end
		
		//3. 선택한 목록을 대상 목록에서 제외하기
		if(checkedAcquisitionNos != null) {
			int index = 0;
			
			for (Iterator<Map<String, String>> it = unCheckUpList.iterator(); it.hasNext();) {
				int count = checkedCounts.get(index);
				
				Map<String, String> unCheckUpOne = it.next();
				
				for (String checkedAcquisitionNo : checkedAcquisitionNos) {
					if(checkedAcquisitionNo.contentEquals(unCheckUpOne.get("acquisitionNo"))) {
						it.remove();
						//4. 선택한 목록을 checkUpList 에 추가한다.
						for (int i = 0; i < count; i++) {
							checkUpList.add(unCheckUpOne);							
						}
					}
				}//second for end
				index += 1;
			}//first for end
		}//if end
		
		//위에서 처리된(선택된 대상을 제외한) 대상 목록을 유지한다.
		model.addAttribute("unCheckUpList", unCheckUpList);
		
		//위에서 처리된 선택 목록을 유지한다.
		model.addAttribute("checkUpList", checkUpList);
		
		
		//출력할 화면 설정
		model.addAttribute("content", "/WEB-INF/views/librarian/checkUp/insertCheckUp.jsp");
		
		// compositeView pattern 을 사용할 것이므로 항상 main/index 로 리턴
		return "main/index";
	}//addCheckUpList end
	
	
	@Override
	@RequestMapping(value="/checkUp", method=RequestMethod.POST)
	public String checkUp(HttpServletRequest req
						, @RequestParam("acquisitionNo") List<String> acquisitionNos
						, @RequestParam("checkUpIsbn") List<String> checkUpIsbns
					 	, @RequestParam("checkUpResult") List<String> checkUpResults
					 	, @RequestParam("memo") List<String> memos
					 	, Model model) {
		
		//검수 건수를 표시하기 위한 변수
		int checkUpCnt = 0;
		
		int checkUpSuccessCnt = 0;
		
		//사서 정보 가져오기
		HttpSession session = req.getSession();
		String librarianNo = (String)session.getAttribute("librarianNo");
		
		//검수 정보 포장
		CheckUp checkUp = new CheckUp();
		checkUp.setLibrarianNo(librarianNo);
		
		//checkUp 테이블에 인서트
		checkUpSuccessCnt = checkUpSv.insertCheckUp(checkUp);
		
		String checkUpNo = checkUpSv.getCheckUpNo(librarianNo);
		
		if (checkUpSuccessCnt > 0) {
			for (int i = 0; i < acquisitionNos.size(); i++) {
				int successCnt = 0;
				
				CheckUpList checkUpList = new CheckUpList();
				
				checkUpList.setAcquisitionNo(acquisitionNos.get(i));
				checkUpList.setCheckUpIsbn(checkUpIsbns.get(i));
				checkUpList.setCheckUpResult(checkUpResults.get(i));;
				checkUpList.setMemo(memos.get(i));
				checkUpList.setCheckUpNo(checkUpNo);
				
				successCnt = checkUpListSv.insertCheckUpList(checkUpList);
				
				checkUpCnt += successCnt;
			}
			model.addAttribute("message", checkUpCnt + "건의 검수가 정상 처리되었습니다.");
		} else {			
			model.addAttribute("message", "검수에 실패했습니다.");
		}
		
		model.addAttribute("next", "/librarian/toCheckUp");
		
		//출력할 화면 설정
		model.addAttribute("content", "/WEB-INF/views/main/message.jsp");
		
		// compositeView pattern 을 사용할 것이므로 항상 main/index 로 리턴
		return "main/index";
	}//checkUp end

}
