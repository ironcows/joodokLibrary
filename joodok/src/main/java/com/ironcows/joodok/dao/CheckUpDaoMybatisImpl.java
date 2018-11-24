package com.ironcows.joodok.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ironcows.joodok.dto.CheckUp;
import com.ironcows.joodok.mapper.CheckUpMapper;

@Repository(value="checkUpDao")
public class CheckUpDaoMybatisImpl implements CheckUpDaoIf {

	/* 내부적으로 사용하는 factory 변수
	 * mybatis-context.xml 에서 id="factory" 로 생성된 빈 객체를 변수이름이 똑같은
	 * 아래의 factory 변수에 자동 연결한다.
	 */
	@Autowired
	private SqlSessionFactory factory;
	
	
	@Override
	public String getCheckUpNo(String value) {
		SqlSession session = factory.openSession();
		CheckUpMapper mapper = session.getMapper(CheckUpMapper.class);
		
		String checkUpNo;
		
		try {
			checkUpNo = mapper.getCheckUpNo(value);
		} finally {
			session.close();
		}
		
		return checkUpNo;
	}

	@Override
	public CheckUp getOneCheckUp(CheckUp checkUp) {
		SqlSession session = factory.openSession();
		CheckUpMapper mapper = session.getMapper(CheckUpMapper.class);
		
		try {
			checkUp = mapper.getOneCheckUp(checkUp);
		} finally {
			session.close();
		}
		
		return checkUp;
	}

	@Override
	public int insertCheckUp(CheckUp checkUp) {
		SqlSession session = factory.openSession(true);
		CheckUpMapper mapper = session.getMapper(CheckUpMapper.class);

		int successCnt = 0;
		
		try {
			successCnt = mapper.insertCheckUp(checkUp);
		} finally {
			session.close();
		}
		
		return successCnt;
	}

}
