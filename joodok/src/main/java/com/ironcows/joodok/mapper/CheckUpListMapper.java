package com.ironcows.joodok.mapper;

import java.util.List;
import java.util.Map;

import com.ironcows.joodok.dto.CheckUpList;

public interface CheckUpListMapper {

	
	/**
	 * 도서 상세정보 등록을 위해 등록 대기 도서 목록을 가져오기
	 * @return
	 */
	public abstract List<Map<String, String>> getPreRegisterDetailList(String value);
	
	
	/**
	 * 도서 상세정보 등록을 위해 미등록 도서 목록을 가져오기
	 * @return
	 */
	public abstract List<Map<String, String>> getUnRegisteredBookList();
	
	/**
	 * 검수내역 1개 가져오기
	 * @param checkUpList
	 * @return CheckUp type
	 */
	public abstract CheckUpList getOneCheckUpList(CheckUpList checkUpList);
	
	/**
	 * 검수내역 1개 등록하기
	 * @param checkUpList
	 * @return 검수내역 등록에 성공한 갯수 1 or 0
	 */
	public abstract int insertCheckUpList(CheckUpList checkUpList);
	
	
	/**
	 * 검수내역 1개 수정하기
	 * @param checkUpList
	 * @return 검수내역 수정에 성공한 갯수 1 or 0
	 */
	public abstract int updateCheckUpList(CheckUpList checkUpList);
	
	
}
