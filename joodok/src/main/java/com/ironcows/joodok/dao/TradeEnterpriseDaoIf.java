package com.ironcows.joodok.dao;

import java.util.List;

import com.ironcows.joodok.dto.TradeEnterprise;

public interface TradeEnterpriseDaoIf {
	
	/**
	 * 거래처 1개 가져오기
	 * @param tradeEnterprise
	 * @return TradeEnterprise type
	 */
	public abstract TradeEnterprise getOneTradeEnterprise(TradeEnterprise tradeEnterprise);
	
	/**
	 * 거래처 전부 가져오기
	 * @return
	 */
	public abstract List<TradeEnterprise> getAllTradeEnterprise();

}
