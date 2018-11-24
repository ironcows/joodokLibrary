package com.ironcows.joodok.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ironcows.joodok.dto.Orders;
import com.ironcows.joodok.mapper.OrdersMapper;

@Repository(value="ordersDao")
public class OrdersDaoMybatisImpl implements OrdersDaoIf {

	/* 내부적으로 사용하는 factory 변수
	 * mybatis-context.xml 에서 id="factory" 로 생성된 빈 객체를 변수이름이 똑같은
	 * 아래의 factory 변수에 자동 연결한다.
	 */
	@Autowired
    private	SqlSessionFactory factory;
	
	
	@Override
	public String getOrderNo(String value) {
		SqlSession session = factory.openSession();
		OrdersMapper mapper = session.getMapper(OrdersMapper.class);
		
		String orderNo;
		
		try {
			orderNo = mapper.getOrderNo(value);
		} finally {
			session.close();
		}
		
		return orderNo;
	}
	
	
	@Override
	public Orders getOneOrders(Orders order) {
		SqlSession session = factory.openSession();
		OrdersMapper mapper = session.getMapper(OrdersMapper.class);
		
		try {
			order = mapper.getOneOrders(order);
		} finally {
			session.close();
		}
		
		return order;
	}

	@Override
	public int insertOrders(Orders order) {
		SqlSession session = factory.openSession(true);
		OrdersMapper mapper = session.getMapper(OrdersMapper.class);

		int successCnt = 0;
		
		try {
			successCnt = mapper.insertOrders(order);
		}finally {
			session.close();
		}
		
		return successCnt;
	}

}
