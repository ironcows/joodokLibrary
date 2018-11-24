package com.ironcows.joodok.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ironcows.joodok.dto.OrderDetail;
import com.ironcows.joodok.mapper.OrderDetailMapper;

@Repository(value="orderDetailDao")
public class OrderDetailDaoMybatisImpl implements OrderDetailDaoIf {
	
	/* 내부적으로 사용하는 factory 변수
	 * mybatis-context.xml 에서 id="factory" 로 생성된 빈 객체를 변수이름이 똑같은
	 * 아래의 factory 변수에 자동 연결한다.
	 */
	@Autowired
    private	SqlSessionFactory factory;
	
	
	@Override
	public OrderDetail getOneOrderDetail(OrderDetail orderDetail) {
		SqlSession session = factory.openSession();
		OrderDetailMapper mapper = session.getMapper(OrderDetailMapper.class);
		
		try {
			orderDetail = mapper.getOneOrderDetail(orderDetail);
		} finally {
			session.close();
		}
		
		return orderDetail;
	}

	@Override
	public int insertOrderDetail(OrderDetail orderDetail) {
		SqlSession session = factory.openSession(true);
		OrderDetailMapper mapper = session.getMapper(OrderDetailMapper.class);
		int successCnt = 0;
		
		try {
			successCnt = mapper.insertOrderDetail(orderDetail);
		} finally {
			session.close();
		}
		
		return successCnt;
	}

}
