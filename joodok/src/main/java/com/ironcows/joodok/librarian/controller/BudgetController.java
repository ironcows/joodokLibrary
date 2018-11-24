package com.ironcows.joodok.librarian.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ironcows.joodok.dto.Budget;
import com.ironcows.joodok.service.BudgetServiceIf;


@Controller(value="libBudgetController")
@RequestMapping(value="/librarian")
public class BudgetController implements BudgetControllerIf {

	//필요한 service 들을 가져온다.
	
	/**
	 * com.ironcows.joodok.service 안의 클래스에서 Repository(Service) 로 등록한 것을 
	 * Resource에 명시함으로써 연결한다.
	 */
	@Resource(name="budgetService")
	private BudgetServiceIf budgetSv;
	
	@Override
	@RequestMapping(value="/toBudget", method=RequestMethod.GET)
	public String toBudget(Model model) {
		
		List<Budget> budgetList = budgetSv.getAllBudget();
		
		model.addAttribute("budgetList", budgetList);
		
		//출력할 화면 설정
		model.addAttribute("content", "/WEB-INF/views/librarian/budget/seeBudget.jsp");
		
		// compositeView pattern 을 사용할 것이므로 항상 main/index 로 리턴
		return "main/index";
	}//toBudget end
	
	

}
