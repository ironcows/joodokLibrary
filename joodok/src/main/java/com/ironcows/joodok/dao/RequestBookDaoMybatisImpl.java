package com.ironcows.joodok.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ironcows.joodok.dto.RequestBook;
import com.ironcows.joodok.mapper.RequestBookMapper;


@Repository(value="requestBookDao")
public class RequestBookDaoMybatisImpl implements RequestBookDaoIf {

	/* 내부적으로 사용하는 factory 변수
	 * mybatis-context.xml 에서 id="factory" 로 생성된 빈 객체를 변수이름이 똑같은
	 * 아래의 factory 변수에 자동 연결한다.
	 */
	@Autowired
	private SqlSessionFactory factory;
	
	
	
	@Override
	public int getRequestListNum() {
		SqlSession session = factory.openSession();
		RequestBookMapper mapper = session.getMapper(RequestBookMapper.class);
		
		int totalCnt = 0;
		
		try {
			totalCnt = mapper.getRequestListNum();
		} finally {
			session.close();
		}
		
		return totalCnt;
	}
	
	@Override
	public List<Map<String, String>> getRequestBookList(int value) {
		SqlSession session = factory.openSession();
		RequestBookMapper mapper = session.getMapper(RequestBookMapper.class);
		
		List<Map<String, String>> resultSet = null;
		
		try {
			resultSet = mapper.getRequestBookList(value);
		} finally {
			session.close();
		}
		
		return resultSet;
	}
	
	
	@Override
	public int getMemberRequestListNum(String value) {
		SqlSession session = factory.openSession();
		RequestBookMapper mapper = session.getMapper(RequestBookMapper.class);

		int totalCnt = 0;
		
		try {
			totalCnt = mapper.getMemberRequestListNum(value);
		} finally {
			session.close();
		}
		return totalCnt;
	}
	
	
	@Override
	public List<Map<String, String>> getMemberRequestList(Map<String, Object> value) {
		SqlSession session = factory.openSession();
		RequestBookMapper mapper = session.getMapper(RequestBookMapper.class);
		
		List<Map<String, String>> resultSet = null;
		
		try {
			resultSet = mapper.getMemberRequestList(value);
		} finally {
			session.close();
		}
		
		return resultSet;
	}

	
	
	
	@Override
	public Map<String, String> getOneRequestBook_CLOB(RequestBook requestBook) {
		SqlSession session = factory.openSession();
		RequestBookMapper mapper = session.getMapper(RequestBookMapper.class);
		
		Map<String, String> resultSet = null;
		
		try {
			resultSet = mapper.getOneRequestBook_CLOB(requestBook);
		} finally {
			session.close();
		}
		
		return resultSet;
	}




	@Override
	public RequestBook getOneRequestBook(RequestBook requestBook) {
		SqlSession session = factory.openSession();
		RequestBookMapper mapper = session.getMapper(RequestBookMapper.class);
		
		try {
			requestBook = mapper.getOneRequestBook(requestBook);
		} finally {
			session.close();
		}
		
		return requestBook;
	}

	@Override
	public int insertRequestBook(RequestBook requestBook) {
		SqlSession session = factory.openSession(false);
		RequestBookMapper mapper = session.getMapper(RequestBookMapper.class);
		
		int successCnt;
		
		try {
			successCnt = mapper.insertRequestBook(requestBook);
		} finally {
			session.commit();
			session.close();
		}
		
		return successCnt;
	}

	@Override
	public int updateRequestBook(RequestBook requestBook) {
		SqlSession session = factory.openSession(false);
		RequestBookMapper mapper = session.getMapper(RequestBookMapper.class);
		
		int successCnt;
		try {
			successCnt = mapper.updateRequestBook(requestBook);
		} finally {
			session.commit();
			session.close();
		}
		
		return successCnt;
	}

}
