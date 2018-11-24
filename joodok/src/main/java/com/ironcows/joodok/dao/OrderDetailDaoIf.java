package com.ironcows.joodok.dao;

import com.ironcows.joodok.dto.OrderDetail;

public interface OrderDetailDaoIf {

	/**
	 * 주문상세 1개 가져오기
	 * @param orderDetail
	 * @return OrderDetail type
	 */
	public abstract OrderDetail getOneOrderDetail(OrderDetail orderDetail);
	
	
	/**
	 * 주문상세 1개 등록하기
	 * @param orderDetail
	 * @return 주문상세 등록에 성공한 갯수 1 or 0
	 */
	public abstract int insertOrderDetail(OrderDetail orderDetail);
	
}
