package com.ironcows.joodok.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ironcows.joodok.dto.BookDetail;
import com.ironcows.joodok.mapper.BookDetailMapper;



@Repository(value="bookDetailDao")
public class BookDetailDaoMybatisImpl implements BookDetailDaoIf {

	/* 내부적으로 사용하는 factory 변수
	 * mybatis-context.xml 에서 id="factory" 로 생성된 빈 객체를 변수이름이 똑같은
	 * 아래의 factory 변수에 자동 연결한다.
	 */
	@Autowired
	private SqlSessionFactory factory;
	
	
	
	
	@Override
	public Map<String, String> getBookInfoWithDiscard(String value) {
		SqlSession session = factory.openSession();
		BookDetailMapper mapper = session.getMapper(BookDetailMapper.class);
		Map<String, String> resultSet;
		
		try {
			resultSet = mapper.getBookInfoWithDiscard(value);
		} finally {
			session.close();
		}
		
		return resultSet;
	}
	
	@Override
	public Map<String, String> getBookForBorrow(String value) {
		SqlSession session = factory.openSession();
		BookDetailMapper mapper = session.getMapper(BookDetailMapper.class);
		Map<String, String> resultSet;
		
		try {
			resultSet = mapper.getBookForBorrow(value);
		}finally {
			session.close();
		}
		
		return resultSet;
	}
	
	@Override
	public List<Map<String, String>> seeBookDetail(String value) {
		SqlSession session = factory.openSession();
		BookDetailMapper mapper = session.getMapper(BookDetailMapper.class);
		
		List<Map<String, String>> resultSet;
		
		try {
			resultSet = mapper.seeBookDetail(value);
		} finally {
			session.close();
		}
		
		return resultSet;
	}


	@Override
	public BookDetail getOneBookDetail(BookDetail bookDetail) {
		SqlSession session = factory.openSession();
		BookDetailMapper mapper = session.getMapper(BookDetailMapper.class);
		
		try {
			bookDetail = mapper.getOneBookDetail(bookDetail);
		} finally {
			session.close();
		}
		
		return bookDetail;
	}

	@Override
	public int insertBookDetail(BookDetail bookDetail) {
		SqlSession session = factory.openSession(true);
		BookDetailMapper mapper = session.getMapper(BookDetailMapper.class);
		int successCnt;
		
		try {
			successCnt = mapper.insertBookDetail(bookDetail);
		} finally {
			session.close();
		}
		
		return successCnt;
	}

	@Override
	public int updateBookDetail(BookDetail bookDetail) {
		SqlSession session = factory.openSession(true);
		BookDetailMapper mapper = session.getMapper(BookDetailMapper.class);
		int successCnt;
		
		try {
			successCnt = mapper.updateBookDetail(bookDetail);
		} finally {
			session.close();
		}
		
		return successCnt;
	}

}
