package com.ironcows.joodok.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ironcows.joodok.dto.Member;
import com.ironcows.joodok.mapper.MemberMapper;

@Repository(value="memberDao")
public class MemberDaoMybatisImpl implements MemberDaoIf {

	
	/* 내부적으로 사용하는 factory 변수
	 * mybatis-context.xml 에서 id="factory" 로 생성된 빈 객체를 변수이름이 똑같은
	 * 아래의 factory 변수에 자동 연결한다.
	 */
	@Autowired
	private SqlSessionFactory factory;
	
	//기본 생성자
	public MemberDaoMybatisImpl() {}
	
	
	@Override
	public Map<String, String> searchMember(String memberId) {
		SqlSession session = factory.openSession();
		MemberMapper mapper = session.getMapper(MemberMapper.class);
		Map<String, String> memberInfo = new HashMap<String, String>();
		
		try {
			memberInfo = mapper.searchMember(memberId);
		} finally {
			session.close();
		}
		return memberInfo;
	}
	
	
	@Override
	public Map<String, String> getMyInfo(Member member) {
		SqlSession session = factory.openSession();
		MemberMapper mapper = session.getMapper(MemberMapper.class);
		Map<String, String> myInfo = new HashMap<String, String>();
		
		try {
			myInfo = mapper.getMyInfo(member);
		} finally {
			session.close();
		}
		return myInfo;
	}
	
	
	
	@Override
	public Member getOneMember(Member member) {
		SqlSession session = factory.openSession();
		MemberMapper mapper = session.getMapper(MemberMapper.class);
		
		try {
			member = mapper.getOneMember(member);
		} finally {
			session.close();
		}
		return member;
	}
	
	
	@Override
	public int updateMember(Member member) {
		SqlSession session = factory.openSession(true);
		MemberMapper mapper = session.getMapper(MemberMapper.class);
		int successCnt;
		
		try {
			successCnt = mapper.updateMember(member);
		} finally {
			session.close();
		}
		return successCnt;
	}
	
	
	
}
