package com.ironcows.joodok.service;

import java.util.Map;

import com.ironcows.joodok.dto.Member;

public interface MemberServiceIf {
	
	
	/**
	 * 사서가 사용할 대출을 위한 회원 조회
	 * @param memberId
	 * @return
	 */
	public abstract Map<String, String> searchMember(String memberId);	
	
	
	/**
	 * 회원 본인의 개인 정보 보기
	 * @param member
	 * @return
	 */
	public abstract Map<String, String> getMyInfo(Member member);
	
	
	/**
	 * 회원 1명 선택하기
	 * @param member
	 * @return Member type
	 */
	public abstract Member getOneMember(Member member);
	
	
	/**
	 * 회원 1명 수정하기
	 * @param member
	 * @return 회원 수정에 성공한 갯수 1 or 0
	 */
	public abstract int updateMember(Member member);
}
