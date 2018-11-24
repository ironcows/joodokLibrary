package com.ironcows.joodok.mapper;

import com.ironcows.joodok.dto.Grade;

public interface GradeMapper {

	
	/**
	 * 등급 1개 가져오기
	 * @param grade
	 * @return Grade type
	 */
	public abstract Grade getOneGrade(Grade grade);
	
	
	
}
