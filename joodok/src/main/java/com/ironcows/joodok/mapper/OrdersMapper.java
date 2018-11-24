package com.ironcows.joodok.mapper;

import com.ironcows.joodok.dto.Orders;

public interface OrdersMapper {

	
	/**
	 * 주문 번호 가져오기
	 * @param value
	 * @return
	 */
	public abstract String getOrderNo(String value);
	
	
	/**
	 * 주문 1개 가져오기
	 * @param order
	 * @return Order type
	 */
	public abstract Orders getOneOrders(Orders order);
	
	
	/**
	 * 주문 1개 등록하기
	 * @param order
	 * @return 주문 등록에 성공한 갯수 1 or 0
	 */
	public abstract int insertOrders(Orders order);
	
}
