package com.ironcows.joodok.service;

import java.util.List;
import java.util.Map;

import com.ironcows.joodok.dto.Borrow;
import com.ironcows.joodok.dto.Member;

public interface BorrowServiceIf {

	
	/**
	 * 연체 목록 가져오기
	 * @return
	 */
	public abstract List<Map<String, String>> getDelayedBookList();
	
	
	/**
	 * 도서 반납 할 때 도서를 추가하기 위해 해당도서의 대출정보 가져오기
	 * @param value
	 * @return
	 */
	public abstract Map<String, String> getBorrowInfo(String value);	
	
	
	/**
	 * 회원 개인의 대출 목록 가져오기
	 * @param member
	 * @return map을 리스트화 한 것이므로 결과셋을 List<Map<String, String>>
	 */
	public abstract List<Map<String, String>> getMemberBorrow(Member member);
	
	
	/**
	 * 대출 1개 가져오기
	 * @param borrow
	 * @return Borrow type
	 */
	public abstract Borrow getOneBorrow(Borrow borrow);
	
	
	/**
	 * 대출 1개 등록하기
	 * @param borrow
	 * @return 대출 등록에 성공한 갯수 1 or 0
	 */
	public abstract int insertBorrow(Borrow borrow);
	
	
	/**
	 * 대출 1개 수정하기
	 * @param borrow
	 * @return 대출 수정에 성공한 갯수 1 or 0
	 */
	public abstract int updateBorrow(Borrow borrow);	
	
	
}
