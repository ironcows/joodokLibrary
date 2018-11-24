package com.ironcows.joodok.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ironcows.joodok.dto.Librarian;
import com.ironcows.joodok.dto.Member;
import com.ironcows.joodok.mapper.LoginMapper;


@Repository(value="loginDao")
public class LoginDaoMybatisImpl implements LoginDaoIf {

	
	/* 내부적으로 사용하는 factory 변수
	 * mybatis-context.xml 에서 id="factory" 로 생성된 빈 객체를 변수이름이 똑같은
	 * 아래의 factory 변수에 자동 연결한다.
	 */
	@Autowired
	private SqlSessionFactory factory;
	
	
	//기본 생성자
	public LoginDaoMybatisImpl() {}
	
	
	@Override
	public Member loginMember(Member member) {
		SqlSession session = factory.openSession();
		LoginMapper mapper = session.getMapper(LoginMapper.class);
		
		try {
			member = mapper.loginMember(member);
		} finally {
			session.close();	
		}
		return member;
	}

	
	@Override
	public Librarian loginLibrarian(Librarian librarian) {
		SqlSession session = factory.openSession();
		LoginMapper mapper = session.getMapper(LoginMapper.class);
		
		try {
			librarian = mapper.loginLibrarian(librarian);
		} finally {
			session.close();
		}
		return librarian;
	}

}
