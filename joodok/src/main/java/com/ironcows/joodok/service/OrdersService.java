package com.ironcows.joodok.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ironcows.joodok.dao.OrdersDaoIf;
import com.ironcows.joodok.dto.Orders;

@Service(value="ordersService")
public class OrdersService implements OrdersServiceIf {


	/**
	 * OrdersDaoMybatisImpl 에서 Repository 로 등록한 것을 
	 * Resource에 명시함으로써 연결한다.
	 */
	@Resource(name="ordersDao")
	private OrdersDaoIf dao;
	
	
	@Override
	public String getOrderNo(String value) {
		return dao.getOrderNo(value);
	}
	
	@Override
	public Orders getOneOrders(Orders order) {
		return dao.getOneOrders(order);
	}

	@Override
	public int insertOrders(Orders order) {
		return dao.insertOrders(order);
	}

}
