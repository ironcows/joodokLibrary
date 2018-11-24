package com.ironcows.joodok.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ironcows.joodok.dto.DiscardBook;
import com.ironcows.joodok.mapper.DiscardBookMapper;

@Repository(value="discardBookDao")
public class DiscardBookDaoMybatisImpl implements DiscardBookDaoIf {

	
	/* 내부적으로 사용하는 factory 변수
	 * mybatis-context.xml 에서 id="factory" 로 생성된 빈 객체를 변수이름이 똑같은
	 * 아래의 factory 변수에 자동 연결한다.
	 */
	@Autowired
	private SqlSessionFactory factory;
	
	
	@Override
	public DiscardBook getOneDiscardBook(DiscardBook discardBook) {
		SqlSession session = factory.openSession();
		DiscardBookMapper mapper = session.getMapper(DiscardBookMapper.class);
		
		try {
			discardBook = mapper.getOneDiscardBook(discardBook);
		} finally {
			session.close();
		}
		
		return discardBook;
	}

	@Override
	public int insertDiscardBook(DiscardBook discardBook) {
		SqlSession session = factory.openSession(true);
		DiscardBookMapper mapper = session.getMapper(DiscardBookMapper.class);
		
		int successCnt = 0;
		
		try {
			successCnt = mapper.insertDiscardBook(discardBook);
		} finally {
			session.close();
		}
	
		return successCnt;
	}

}
