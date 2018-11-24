package com.ironcows.joodok.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ironcows.joodok.dto.Location;
import com.ironcows.joodok.mapper.LocationMapper;

@Repository(value="locationDao")
public class LocationDaoMybatisImpl implements LocationDaoIf {

	
	/* 내부적으로 사용하는 factory 변수
	 * mybatis-context.xml 에서 id="factory" 로 생성된 빈 객체를 변수이름이 똑같은
	 * 아래의 factory 변수에 자동 연결한다.
	 */
	@Autowired
	private SqlSessionFactory factory;
	
	
	@Override
	public Location getOneLocation(Location location) {
		SqlSession session = factory.openSession();
		LocationMapper mapper = session.getMapper(LocationMapper.class);
		
		try {
			location = mapper.getOneLocation(location);
		} finally {
			session.close();
		}
		
		return location;
	}

	@Override
	public List<Map<String, String>> getAllLocation() {
		SqlSession session = factory.openSession();
		LocationMapper mapper = session.getMapper(LocationMapper.class);
		
		List<Map<String, String>> resultSet;
		
		try {
			resultSet = mapper.getAllLocation();
		} finally {
			session.close();
		}
		
		return resultSet;
	}

}
