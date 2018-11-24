package com.ironcows.joodok.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ironcows.joodok.dao.LoginDaoIf;
import com.ironcows.joodok.dto.Librarian;
import com.ironcows.joodok.dto.Member;


@Service(value="loginService")
public class LoginService implements LoginServiceIf {

	
	/**
	 * LoginDaoMybatisImpl 에서 Repository 로 등록한 것을 
	 * Resource에 명시함으로써 연결한다.
	 */
	@Resource(name="loginDao")
	private LoginDaoIf dao;

	@Override
	public Member loginMember(Member member) {
		return dao.loginMember(member);
	}

	@Override
	public Librarian loginLibrarian(Librarian librarian) {
		return dao.loginLibrarian(librarian);
	}

}
