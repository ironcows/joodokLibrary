package com.ironcows.joodok.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.ironcows.joodok.dao.BudgetDaoIf;
import com.ironcows.joodok.dto.Budget;

@Service(value="budgetService")
public class BudgetService implements BudgetServiceIf {
	

	/**
	 * BudgetDaoMybatisImpl 에서 Repository 로 등록한 것을 
	 * Resource에 명시함으로써 연결한다.
	 */
	@Resource(name="budgetDao")
	private BudgetDaoIf dao;

	@Override
	public Budget getOneBudget(Budget budget) {
		return dao.getOneBudget(budget);
	}
	
	
	@Override
	public List<Budget> getAllBudget() {
		return dao.getAllBudget();
	}
	
}
