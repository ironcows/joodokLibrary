package com.ironcows.joodok.service;

import com.ironcows.joodok.dto.CheckUp;

public interface CheckUpServiceIf {

	/**
	 * 검수 번호 가져오기
	 * @param value
	 * @return
	 */
	public abstract String getCheckUpNo(String value);
	
	/**
	 * 검수 1개 가져오기
	 * @param checkUp
	 * @return CheckUp type
	 */
	public abstract CheckUp getOneCheckUp(CheckUp checkUp);
	
	/**
	 * 검수 1개 등록하기
	 * @param checkUp
	 * @return 검수 등록에 성공한 갯수 1 or 0
	 */
	public abstract int insertCheckUp(CheckUp checkUp);
	
	
}
