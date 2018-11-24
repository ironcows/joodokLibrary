package com.ironcows.joodok.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ironcows.joodok.dao.TradeEnterpriseDaoIf;
import com.ironcows.joodok.dto.TradeEnterprise;

@Service(value="tradeEnterpriseService")
public class TradeEnterpriseService implements TradeEnterpriseServiceIf {


	/**
	 * TradeEnterpriseDaoMybatisImpl 에서 Repository 로 등록한 것을 
	 * Resource에 명시함으로써 연결한다.
	 */
	@Resource(name="tradeEnterpriseDao")
	private TradeEnterpriseDaoIf dao;
	
	
	@Override
	public TradeEnterprise getOneTradeEnterprise(TradeEnterprise tradeEnterprise) {
		return dao.getOneTradeEnterprise(tradeEnterprise);
	}

	@Override
	public List<TradeEnterprise> getAllTradeEnterprise() {
		return dao.getAllTradeEnterprise();
	}

	
}
