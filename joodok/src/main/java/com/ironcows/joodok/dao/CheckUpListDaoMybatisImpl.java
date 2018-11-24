package com.ironcows.joodok.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ironcows.joodok.dto.CheckUpList;
import com.ironcows.joodok.mapper.CheckUpListMapper;

@Repository(value="checkUpListDao")
public class CheckUpListDaoMybatisImpl implements CheckUpListDaoIf {

	/* 내부적으로 사용하는 factory 변수
	 * mybatis-context.xml 에서 id="factory" 로 생성된 빈 객체를 변수이름이 똑같은
	 * 아래의 factory 변수에 자동 연결한다.
	 */
	@Autowired
	private SqlSessionFactory factory;
	
	
	@Override
	public List<Map<String, String>> getPreRegisterDetailList(String value) {
		SqlSession session = factory.openSession();
		CheckUpListMapper mapper = session.getMapper(CheckUpListMapper.class);
		
		List<Map<String, String>> resultSet;
		
		try {
			resultSet = mapper.getPreRegisterDetailList(value);
		} finally {
			session.close();
		}

		return resultSet;
	}
	
	@Override
	public List<Map<String, String>> getUnRegisteredBookList() {
		SqlSession session = factory.openSession();
		CheckUpListMapper mapper = session.getMapper(CheckUpListMapper.class);
		
		List<Map<String, String>> resultSet;
		
		try {
			resultSet = mapper.getUnRegisteredBookList();
		} finally {
			session.close();
		}

		return resultSet;
	}
	
	@Override
	public CheckUpList getOneCheckUpList(CheckUpList checkUpList) {
		SqlSession session = factory.openSession();
		CheckUpListMapper mapper = session.getMapper(CheckUpListMapper.class);
		
		try {
			checkUpList = mapper.getOneCheckUpList(checkUpList);
		} finally {
			session.close();
		}
		
		return checkUpList;
	}

	@Override
	public int insertCheckUpList(CheckUpList checkUpList) {
		SqlSession session = factory.openSession(true);
		CheckUpListMapper mapper = session.getMapper(CheckUpListMapper.class);

		int successCnt = 0;
		
		try {
			successCnt = mapper.insertCheckUpList(checkUpList);
		} finally {
			session.close();
		}
		
		return successCnt;
	}

	
	@Override
	public int updateCheckUpList(CheckUpList checkUpList) {
		SqlSession session = factory.openSession(true);
		CheckUpListMapper mapper = session.getMapper(CheckUpListMapper.class);

		int successCnt;
		
		try {
			successCnt = mapper.updateCheckUpList(checkUpList);
		} finally {
			session.close();
		}
		
		return successCnt;
	}
	
	
}
