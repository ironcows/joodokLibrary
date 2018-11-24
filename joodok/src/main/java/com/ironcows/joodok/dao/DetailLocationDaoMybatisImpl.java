package com.ironcows.joodok.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ironcows.joodok.dto.DetailLocation;
import com.ironcows.joodok.mapper.DetailLocationMapper;

@Repository(value="detailLocationDao")
public class DetailLocationDaoMybatisImpl implements DetailLocationDaoIf {

	/* 내부적으로 사용하는 factory 변수
	 * mybatis-context.xml 에서 id="factory" 로 생성된 빈 객체를 변수이름이 똑같은
	 * 아래의 factory 변수에 자동 연결한다.
	 */
	@Autowired
	private SqlSessionFactory factory;
	
	
	@Override
	public DetailLocation getOneDetailLocation(DetailLocation detailLocation) {
		SqlSession session = factory.openSession();
		DetailLocationMapper mapper = session.getMapper(DetailLocationMapper.class);
		
		try {
			detailLocation = mapper.getOneDetailLocation(detailLocation);
		} finally {
			session.close();
		}
		
		return detailLocation;
	}

	@Override
	public List<Map<String, String>> getAllDetailLocation() {
		SqlSession session = factory.openSession();
		DetailLocationMapper mapper = session.getMapper(DetailLocationMapper.class);
		
		List<Map<String, String>> resultSet;
		
		try {
			resultSet = mapper.getAllDetailLocation();
		} finally {
			session.close();
		}
		
		return resultSet;
	}

}
