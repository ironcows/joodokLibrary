package com.ironcows.joodok.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ironcows.joodok.dto.Budget;
import com.ironcows.joodok.mapper.BudgetMapper;

@Repository(value="budgetDao")
public class BudgetDaoMybatisImpl implements BudgetDaoIf {

	
	/* 내부적으로 사용하는 factory 변수
	 * mybatis-context.xml 에서 id="factory" 로 생성된 빈 객체를 변수이름이 똑같은
	 * 아래의 factory 변수에 자동 연결한다.
	 */
	@Autowired
	private SqlSessionFactory factory;
	
	
	@Override
	public Budget getOneBudget(Budget budget) {
		SqlSession session = factory.openSession();
		BudgetMapper mapper = session.getMapper(BudgetMapper.class);
		
		try {
			budget = mapper.getOneBudget(budget);
		} finally {
			session.close();
		}
		
		return budget;
	}

	@Override
	public List<Budget> getAllBudget() {
		SqlSession session = factory.openSession();
		BudgetMapper mapper = session.getMapper(BudgetMapper.class);
		List<Budget> resultSet;
		
		try {
			resultSet = mapper.getAllBudget();
		} finally {
			session.close();
		}
		
		return resultSet;
	}

}
