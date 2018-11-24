package com.ironcows.joodok.librarian.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ironcows.joodok.dto.TradeEnterprise;
import com.ironcows.joodok.service.TradeEnterpriseServiceIf;

@Controller(value="libTradeEnterpriseController")
@RequestMapping(value="/librarian")
public class TradeEnterpriseController implements TradeEnterpriseControllerIf {

	//필요한 service 들을 가져온다.
	
	/**
	 * com.ironcows.joodok.service 안의 클래스에서 Repository(Service) 로 등록한 것을 
	 * Resource에 명시함으로써 연결한다.
	 */
	
	@Resource(name="tradeEnterpriseService")
	private TradeEnterpriseServiceIf tradeEnterpriseSv;
	
	@Override
	@RequestMapping(value="/toTradeEnterprise", method=RequestMethod.GET)
	public String toTradeEnterprise(Model model) {
		
		
		List<TradeEnterprise> tradeEnterpriseList = tradeEnterpriseSv.getAllTradeEnterprise();
		
		model.addAttribute("tradeEnterpriseList", tradeEnterpriseList);
		
		//출력할 화면 설정
		model.addAttribute("content", "/WEB-INF/views/librarian/tradeEnterprise/seeTradeEnterprise.jsp");
		
		// compositeView pattern 을 사용할 것이므로 항상 main/index 로 리턴
		return "main/index";
	}//toTradeEnterprise end

}
