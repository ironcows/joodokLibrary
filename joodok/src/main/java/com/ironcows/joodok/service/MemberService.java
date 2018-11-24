package com.ironcows.joodok.service;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ironcows.joodok.dao.MemberDaoIf;
import com.ironcows.joodok.dto.Member;

@Service(value="memberService")
public class MemberService implements MemberServiceIf {

	
	/**
	 * MemberDaoMybatisImpl 에서 Repository 로 등록한 것을 
	 * Resource에 명시함으로써 연결한다.
	 */
	@Resource(name="memberDao")
	private MemberDaoIf dao;
	
	
	@Override
	public Map<String, String> searchMember(String memberId) {
		return dao.searchMember(memberId);
	}
	
	
	@Override
	public Map<String, String> getMyInfo(Member member) {
		return dao.getMyInfo(member);
	}
	
	
	@Override
	public Member getOneMember(Member member) {
		return dao.getOneMember(member);
	}

	@Override
	public int updateMember(Member member) {
		int successCnt = 0;
		
		if(getOneMember(member) != null) {
			successCnt = dao.updateMember(member);
		}
		return successCnt;
	}

}
