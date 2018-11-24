package com.ironcows.joodok.librarian.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ironcows.joodok.service.BorrowServiceIf;

@Controller(value="libDelayedBookController")
@RequestMapping(value="/librarian")
public class DelayedBookController implements DelayedBookControllerIf {

	//필요한 service 들을 가져온다.
	
	/**
	 * com.ironcows.joodok.service 안의 클래스에서 Repository(Service) 로 등록한 것을 
	 * Resource에 명시함으로써 연결한다.
	 */
	
	@Resource(name="borrowService")
	private BorrowServiceIf borrowSv;
	
	
	@Override
	@RequestMapping(value="/toDelayedBookList", method=RequestMethod.GET)
	public String toDelayedBookList(Model model) {
		
		
		List<Map<String, String>> delayedBookList = borrowSv.getDelayedBookList();
		
		model.addAttribute("delayedBookList", delayedBookList);
		
		//출력할 화면 설정
		model.addAttribute("content", "/WEB-INF/views/librarian/delayedBook/seeDelayedBookList.jsp");
		
		// compositeView pattern 을 사용할 것이므로 항상 main/index 로 리턴
		return "main/index";
	}//toDelayedBookList end
	
}
