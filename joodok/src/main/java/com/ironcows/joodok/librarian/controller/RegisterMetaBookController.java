package com.ironcows.joodok.librarian.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ironcows.joodok.dto.MetaBook;
import com.ironcows.joodok.service.AcquisitionServiceIf;
import com.ironcows.joodok.service.MetaBookServiceIf;


@Controller(value="librRegisterMetaBookController")
@RequestMapping(value="/librarian")
public class RegisterMetaBookController implements RegisterMetaBookControllerIf {

	//필요한 service 들을 가져온다.
	
	/**
	 * com.ironcows.joodok.service 안의 클래스에서 Repository(Service) 로 등록한 것을 
	 * Resource에 명시함으로써 연결한다.
	 */
	
	@Resource(name="acquisitionService")
	private AcquisitionServiceIf acquisitionSv;
	
	@Resource(name="metaBookService")
	private MetaBookServiceIf metaBookSv;
	
	
	@Override
	@RequestMapping(value="/toRegisterMetaBook", method=RequestMethod.GET)
	public String toRegisterBook(Model model) {
		
		//대문자 표기 레코드셋
		List<Map<String, String>> capitalMetaBook = acquisitionSv.getAcquisitionForMetaBook();
		
		//캐멀 노테이션 표기 레코드셋
		List<Map<String, String>> unRegisteredMetaBook = new ArrayList<>();
		
		//insertCheckUp.jsp 에서 사용될 el 에서 컬럼명을 대문자로 표기되는 것을
		//캐멀 노테이션을 적용한 레코드로 변경해준다.
		for (Map<String, String> capitalMetaBookOne : capitalMetaBook) {
			Map<String, String> newOne = new HashMap<>();
			newOne.put("acquisitionNo", capitalMetaBookOne.get("ACQUISITIONNO"));
			newOne.put("registeredDate", capitalMetaBookOne.get("REGISTEREDDATE"));
			newOne.put("category", capitalMetaBookOne.get("CATEGORY"));
			newOne.put("acquisitionIsbn", capitalMetaBookOne.get("ACQUISITIONISBN"));
			
			unRegisteredMetaBook.add(newOne);
		}
		
		model.addAttribute("unRegisteredMetaBook", unRegisteredMetaBook);
		
		//출력할 화면 설정
		model.addAttribute("content", "/WEB-INF/views/librarian/registerBook/registerMetaBook.jsp");
		
		// compositeView pattern 을 사용할 것이므로 항상 main/index 로 리턴
		return "main/index";
	}//toRegisterBook end
	
	
	@Override
	@RequestMapping(value="/addMetaBook", method=RequestMethod.POST)
	public String addMetaBook(@RequestParam(value="checkedAcquisitionNo", required=false) String checkedAcquisitionNo
							, @RequestParam("acquisitionNo") List<String> acquisitionNos
							, @RequestParam("category") List<String> categorys
							, @RequestParam("acquisitionIsbn") List<String> acquisitionIsbns
							, @RequestParam("registeredDate") List<String> registeredDates
						    , @RequestParam(value="chAcquisitionNo", required=false) String chAcquisitionNo
						    , @RequestParam(value="chCategory", required=false) String chCategory
						    , @RequestParam(value="chAcquisitionIsbn", required=false) String chAcquisitionIsbn
						    , @RequestParam(value="chRegisteredDate", required=false) String chRegisteredDate
							, Model model) {
		
		/**
		 * 선택된 대상을 등록 화면에 추가하기 위해서 주의해야할 점
		 * 1. 이미 선택된 대상이 있으면 checkedMetaBook 변수에 담는다.
		 * 2. 대상 목록에 있는 리스트를 모두 가져와서 unRegisteredMetaBook 변수에 담는다. 
		 * 3. 선택한 도서에 대한 정보 checkedAcquisitionNo 의 값과 일치하는 아이템을 unRegisteredMetaBook 에서 제거한다.
		 * 4. 3 에서 제거한(선택한) 아이템을 checkedRegisterOne 변수에 담는다.
		 */
		
		
		//대상 목록의 리스트를 유지할 변수
		List<Map<String, String>> unRegisteredMetaBook = new ArrayList<>();
		
		//선택 대상을 유지할 변수
		Map<String, String> checkedMetaBook = new HashMap<>();
		
		
		//1. 이미 선택된 대상이 있으면 checkedMetaBook 변수에 담는다.
		if(chAcquisitionNo != null && chCategory != null
		&& chAcquisitionIsbn != null && chRegisteredDate != null) {
			checkedMetaBook.put("acquisitionNo", chAcquisitionNo);
			checkedMetaBook.put("category", chCategory);
			checkedMetaBook.put("acquisitionIsbn", chAcquisitionIsbn);
			checkedMetaBook.put("registeredDate", chRegisteredDate);
			
			/**
			 * 주의! 
			 * 등록되지 않은 대상 목록은 한 개의 대상이 선택되어 목록에서 안보이더라도 등록이 완전히 이루어지기 전까지
			 * 유지가 되어야 하므로, 이미 선택된 대상을 미리 추가해놓음으로써 전체 목록을 유지할 수 있게 된다.
			 */
			unRegisteredMetaBook.add(checkedMetaBook);
		}
		
		//2. 대상 목록을 모두 가져와서 유지
		if(acquisitionNos != null && categorys != null
		&& acquisitionIsbns != null && registeredDates != null) {
			for (int i = 0; i < acquisitionNos.size(); i++) {
				Map<String, String> unRegisteredOne = new HashMap<>();
				unRegisteredOne.put("acquisitionNo", acquisitionNos.get(i));
				unRegisteredOne.put("category", categorys.get(i));
				unRegisteredOne.put("acquisitionIsbn", acquisitionIsbns.get(i));
				unRegisteredOne.put("registeredDate", registeredDates.get(i));
				
				unRegisteredMetaBook.add(unRegisteredOne);
			}//for end
		}//if end
		
		//3. 선택한 대상을 대상 목록에서 제외하기
		if(checkedAcquisitionNo != null) {
			for (Iterator<Map<String, String>> it = unRegisteredMetaBook.iterator(); it.hasNext();) {
				Map<String, String> unRegisteredOne = it.next();
				
				if(checkedAcquisitionNo.contentEquals(unRegisteredOne.get("acquisitionNo"))) {
					it.remove();
					
					//4. 
					checkedMetaBook = unRegisteredOne;
					
					model.addAttribute("checkedMetaBook", checkedMetaBook);
				}
			}//first for end
		}//if end
		
		
		model.addAttribute("unRegisteredMetaBook", unRegisteredMetaBook);
		
		//출력할 화면 설정
		model.addAttribute("content", "/WEB-INF/views/librarian/registerBook/registerMetaBook.jsp");
		
		// compositeView pattern 을 사용할 것이므로 항상 main/index 로 리턴
		return "main/index";
	}//addMetaBook end
	
	
	@Override
	@RequestMapping(value="/registerMetaBook", method=RequestMethod.POST)
	public String registerMetaBook(@ModelAttribute MetaBook metaBook
								 , Model model) {

		//price 에 세자리마다 , 가 표시된 채로 값이 넘어오므로 , 를 제거
		metaBook.setPrice(metaBook.getPrice().replace(",", ""));
		
		int successCnt = 0;
		
		
		successCnt = metaBookSv.insertMetaBook(metaBook);
		
		if (successCnt > 0) {
			model.addAttribute("message", "도서 공통정보가 등록되었습니다.");
		} else {
			model.addAttribute("message", "도서 공통정보 등록에 실패했습니다.");			
		}
		
		model.addAttribute("next", "/librarian/toRegisterMetaBook");
		
		//출력할 화면 설정
		model.addAttribute("content", "/WEB-INF/views/main/message.jsp");
		
		// compositeView pattern 을 사용할 것이므로 항상 main/index 로 리턴
		return "main/index";
	}//registerMetaBook end

}
