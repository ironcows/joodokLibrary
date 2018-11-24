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

import com.ironcows.joodok.dto.Acquisition;
import com.ironcows.joodok.service.AcquisitionServiceIf;

@Controller(value="libAcquisitionController")
@RequestMapping(value="/librarian")
public class AcquisitionController implements AcquisitionControllerIf {

	//필요한 service 들을 가져온다.
	
	/**
	 * com.ironcows.joodok.service 안의 클래스에서 Repository(Service) 로 등록한 것을 
	 * Resource에 명시함으로써 연결한다.
	 */
	
	@Resource(name="acquisitionService")
	private AcquisitionServiceIf acquisitionSv;
	
	
	
	
	@Override
	@RequestMapping(value="/toAcquisition", method=RequestMethod.GET)
	public String toAcquisition(Model model) {
		//출력할 화면 설정
		model.addAttribute("content", "/WEB-INF/views/librarian/acquisition/insertAcquisition.jsp");
		
		// compositeView pattern 을 사용할 것이므로 항상 main/index 로 리턴
		return "main/index";
	}//toAcquisition end
	
	
	@Override
	@RequestMapping(value="/addAcquisition", method=RequestMethod.POST)
	public String addAcquisition(@RequestParam("addIsbn") String addIsbn
							   , @RequestParam("addCategory") String addCategory
							   , @RequestParam(value="acquisitionIsbn", required=false) List<String> acquisitionIsbns
							   , @RequestParam(value="category", required=false) List<String> categorys
							   , Model model) {
		
		/**
		 * 수서를 위해서
		 * 1. 이미 추가된 도서가 있으면 acquisitionInfos 에 추가
		 * 2. 같은 도서가 acquisitionInfos 에 있는지 검사
		 * 3. 소장하고 있는 도서를(이미 등록이 된) 추가하는지 검사
		 *    위 조건을 모두 만족할 때 추가하려는 도서의 정보를 acquisitionInfos 에 추가
		 */
		List<Map<String, String>> acquisitionInfos = new ArrayList<>();
		
		// 1. 이미 추가된 도서가 있으면 acquisitionInfos 에 추가한다
		if(acquisitionIsbns != null && categorys != null) {
			for (int i = 0; i < acquisitionIsbns.size(); i++) {
				Map<String, String> acquisitionInfo = new HashMap<>();
				
				acquisitionInfo.put("acquisitionIsbn", acquisitionIsbns.get(i));
				acquisitionInfo.put("category", categorys.get(i));
				
				acquisitionInfos.add(acquisitionInfo);
			}
		}
		
		if(acquisitionIsbns != null 
		&& acquisitionIsbns.contains(String.format("%s", addIsbn))) {
			//2. 이미 추가된 도서를 추가하려는 경우, 메시지 출력
			model.addAttribute("message", "이미 추가된 도서입니다.");
		}else {
			//3. 소장하고 있는 도서를(이미 등록이 된) 추가하는지 검사
			if(acquisitionSv.checkExistIsbn(addIsbn) != null) {
				//이미 소장하고 있는 경우, 메시지 출력
				model.addAttribute("message", "이미 등록된 도서입니다.");
			}else {
				//소장하고 있지 않은 경우, 도서를 acquisitionInfos 에 추가
				Map<String, String> acquisitionInfo = new HashMap<>();
				acquisitionInfo.put("acquisitionIsbn", addIsbn);
				acquisitionInfo.put("category", addCategory);
				
				acquisitionInfos.add(acquisitionInfo);
			}//second if else end
		}//first if else end
		
		// 추가한 수서 정보를 유지한다
		model.addAttribute("acquisitionInfos", acquisitionInfos);
		
		//출력할 화면 설정
		model.addAttribute("content", "/WEB-INF/views/librarian/acquisition/insertAcquisition.jsp");
		
		// compositeView pattern 을 사용할 것이므로 항상 main/index 로 리턴
		return "main/index";
	}//addAcquisition end
	
	
	@Override
	@RequestMapping(value="/acquisition", method=RequestMethod.POST)
	public String acquisition(HttpServletRequest req
							, @RequestParam("acquisitionIsbn") List<String> acquisitionIsbns
							, @RequestParam("category") List<String> categorys
							, Model model) {
		HttpSession session = req.getSession();
		String librarianNo = (String)session.getAttribute("librarianNo");
		
		//수서 건수를 표시하기 위한 변수 
		int acquisitionCnt = 0;
		
		for (int i = 0; i < acquisitionIsbns.size(); i++) {
			int successCnt = 0;
			
			Acquisition acquisition = new Acquisition();
			acquisition.setAcquisitionIsbn(acquisitionIsbns.get(i));
			acquisition.setCategory(categorys.get(i));
			acquisition.setLibrarianNo(librarianNo);
			
			successCnt = acquisitionSv.insertAcquisition(acquisition);

			acquisitionCnt += successCnt;
		}
		
		// acquisitionCnt 의 값에 따라 정상 처리 결과 판단
		if(acquisitionCnt > 0) {
			model.addAttribute("message", acquisitionCnt + " 건의 수서가 정상 처리되었습니다.");
		}else {
			model.addAttribute("message", "수서에 실패했습니다.");
		}
		
		//출력할 화면 설정
		model.addAttribute("content", "/WEB-INF/views/librarian/acquisition/insertAcquisition.jsp");
		
		// compositeView pattern 을 사용할 것이므로 항상 main/index 로 리턴
		return "main/index";
	}//acquisition end


}
