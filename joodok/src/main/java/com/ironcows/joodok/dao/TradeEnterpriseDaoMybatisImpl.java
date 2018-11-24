package com.ironcows.joodok.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ironcows.joodok.dto.TradeEnterprise;
import com.ironcows.joodok.mapper.TradeEnterpriseMapper;

@Repository(value="tradeEnterpriseDao")
public class TradeEnterpriseDaoMybatisImpl implements TradeEnterpriseDaoIf {

	/* 내부적으로 사용하는 factory 변수
	 * mybatis-context.xml 에서 id="factory" 로 생성된 빈 객체를 변수이름이 똑같은
	 * 아래의 factory 변수에 자동 연결한다.
	 */
	@Autowired
	private SqlSessionFactory factory;
	
	
	@Override
	public TradeEnterprise getOneTradeEnterprise(TradeEnterprise tradeEnterprise) {
		SqlSession session = factory.openSession();
		TradeEnterpriseMapper mapper = session.getMapper(TradeEnterpriseMapper.class);
		
		try {
			tradeEnterprise = mapper.getOneTradeEnterprise(tradeEnterprise);
		} finally {
			session.close();
		}
		
		return tradeEnterprise;
	}

	@Override
	public List<TradeEnterprise> getAllTradeEnterprise() {
		SqlSession session = factory.openSession();
		TradeEnterpriseMapper mapper = session.getMapper(TradeEnterpriseMapper.class);
		List<TradeEnterprise> tradeEnterpriseList = new ArrayList<>();
		
		try {
			tradeEnterpriseList = mapper.getAllTradeEnterprise();
		} finally {
			session.close();
		}
		
		return tradeEnterpriseList;
	}

}
