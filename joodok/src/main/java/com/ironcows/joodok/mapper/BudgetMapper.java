package com.ironcows.joodok.mapper;

import java.util.List;

import com.ironcows.joodok.dto.Budget;

public interface BudgetMapper {
	
	
	/**
	 * 예산 1개 가져오기
	 * @param budget
	 * @return Budget type
	 */
	public abstract Budget getOneBudget(Budget budget);
	
	/**
	 * 예산 전체 가져오기
	 * @param budget
	 * @return Budget type
	 */
	public abstract List<Budget> getAllBudget();
	
	
	
}
