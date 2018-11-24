package com.ironcows.joodok.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ironcows.joodok.dto.MetaBook;
import com.ironcows.joodok.mapper.MetaBookMapper;

@Repository(value="metaBookDao")
public class MetaBookDaoMybatisImpl implements MetaBookDaoIf {

	/* 내부적으로 사용하는 factory 변수
	 * mybatis-context.xml 에서 id="factory" 로 생성된 빈 객체를 변수이름이 똑같은
	 * 아래의 factory 변수에 자동 연결한다.
	 */
	@Autowired
	private SqlSessionFactory factory;
	
	
	@Override
	public List<Map<String, String>> searchAsTitle(String value) {
		SqlSession session = factory.openSession();
		MetaBookMapper mapper = session.getMapper(MetaBookMapper.class);
		
		List<Map<String, String>> resultSet;
		
		try {
			resultSet = mapper.searchAsTitle(value);
		} finally {
			session.close();
		}
		
		return resultSet;
	}

	@Override
	public List<Map<String, String>> searchAsAuthor(String value) {
		SqlSession session = factory.openSession();
		MetaBookMapper mapper = session.getMapper(MetaBookMapper.class);
		
		List<Map<String, String>> resultSet;
		
		try {
			resultSet = mapper.searchAsAuthor(value);
		} finally {
			session.close();
		}
		
		return resultSet;
	}

	@Override
	public List<Map<String, String>> searchAsPublisher(String value) {
		SqlSession session = factory.openSession();
		MetaBookMapper mapper = session.getMapper(MetaBookMapper.class);
		
		List<Map<String, String>> resultSet;
		
		try {
			resultSet = mapper.searchAsPublisher(value);
		} finally {
			session.close();
		}
		
		return resultSet;
	}

	@Override
	public MetaBook getOneMetaBook(MetaBook metaBook) {
		SqlSession session = factory.openSession();
		MetaBookMapper mapper = session.getMapper(MetaBookMapper.class);
		
		try {
			metaBook = mapper.getOneMetaBook(metaBook);
		} finally {
			session.close();
		}
		
		return metaBook;
	}

	@Override
	public int insertMetaBook(MetaBook metaBook) {
		SqlSession session = factory.openSession(true);
		MetaBookMapper mapper = session.getMapper(MetaBookMapper.class);
		int successCnt;
		
		try {
			successCnt = mapper.insertMetaBook(metaBook);
		} finally {
			session.close();
		}
		
		return successCnt;
	}

	
	
}
