package com.ironcows.joodok.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ironcows.joodok.dto.Borrow;
import com.ironcows.joodok.dto.Member;
import com.ironcows.joodok.mapper.BorrowMapper;

@Repository(value="borrowDao")
public class BorrowDaoMybatisImpl implements BorrowDaoIf {

	
	/* 내부적으로 사용하는 factory 변수
	 * mybatis-context.xml 에서 id="factory" 로 생성된 빈 객체를 변수이름이 똑같은
	 * 아래의 factory 변수에 자동 연결한다.
	 */
	@Autowired
	private SqlSessionFactory factory;
	
	
	//기본 생성자
	public BorrowDaoMybatisImpl() {	}
	
	
	
	@Override
	public List<Map<String, String>> getDelayedBookList() {
		SqlSession session = factory.openSession();
		BorrowMapper mapper = session.getMapper(BorrowMapper.class);
		
		List<Map<String, String>> resultSet;
		
		try {
			resultSet = mapper.getDelayedBookList();
		} finally {
			session.close();
		}
		
		return resultSet;
	}
	
	@Override
	public Map<String, String> getBorrowInfo(String value) {
		SqlSession session = factory.openSession();
		BorrowMapper mapper = session.getMapper(BorrowMapper.class);
		
		Map<String, String> resultSet;
		
		try {
			resultSet = mapper.getBorrowInfo(value);
		}finally {
			session.close();
		}
		
		return resultSet;
	}
	
	@Override
	public List<Map<String, String>> getMemberBorrow(Member member) {
		SqlSession session = factory.openSession();
		BorrowMapper mapper = session.getMapper(BorrowMapper.class);
		
		List<Map<String, String>> resultSet;
		
		try {
			resultSet = mapper.getMemberBorrow(member);
		} finally {
			session.close();
		}
		
		return resultSet;
	}

	@Override
	public Borrow getOneBorrow(Borrow borrow) {
		SqlSession session = factory.openSession();
		BorrowMapper mapper = session.getMapper(BorrowMapper.class);
		
		try {
			borrow = mapper.getOneBorrow(borrow);
		} finally {
			session.close();
		}
		
		return borrow;
	}

	@Override
	public int insertBorrow(Borrow borrow) {
		SqlSession session = factory.openSession(true);
		BorrowMapper mapper = session.getMapper(BorrowMapper.class);
		int successCnt;
		
		try {
			successCnt = mapper.insertBorrow(borrow);
		} finally {
			session.close();
		}
		
		return successCnt;
	}

	@Override
	public int updateBorrow(Borrow borrow) {
		SqlSession session = factory.openSession(true);
		BorrowMapper mapper = session.getMapper(BorrowMapper.class);
		int successCnt;
		
		try {
			successCnt = mapper.updateBorrow(borrow);
		} finally {
			session.close();
		}
		
		return successCnt;
	}

}
