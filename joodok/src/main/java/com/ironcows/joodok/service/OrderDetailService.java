package com.ironcows.joodok.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ironcows.joodok.dao.OrderDetailDaoIf;
import com.ironcows.joodok.dto.OrderDetail;


@Service(value="orderDetailService")
public class OrderDetailService implements OrderDetailServiceIf {


	/**
	 * OrderDetailDaoMybatisImpl 에서 Repository 로 등록한 것을 
	 * Resource에 명시함으로써 연결한다.
	 */
	@Resource(name="orderDetailDao")
	private OrderDetailDaoIf dao;
	
	@Override
	public OrderDetail getOneOrderDetail(OrderDetail orderDetail) {
		return dao.getOneOrderDetail(orderDetail);
	}

	@Override
	public int insertOrderDetail(OrderDetail orderDetail) {
		return dao.insertOrderDetail(orderDetail);
	}

}
