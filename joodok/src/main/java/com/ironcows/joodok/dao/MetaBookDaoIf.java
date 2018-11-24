package com.ironcows.joodok.dao;

import java.util.List;
import java.util.Map;

import com.ironcows.joodok.dto.MetaBook;

public interface MetaBookDaoIf {

	
	/**
	 * 서명으로 도서 검색하기
	 * @param value
	 * @return
	 */
	public abstract List<Map<String, String>> searchAsTitle(String value);
	
	
	/**
	 * 저자명으로 도서 검색하기
	 * @param value
	 * @return
	 */
	public abstract List<Map<String, String>> searchAsAuthor(String value);
	
	
	/**
	 * 출판사로 도서 검색하기
	 * @param value
	 * @return
	 */
	public abstract List<Map<String, String>> searchAsPublisher(String value);
	
	
	/**
	 * 도서공통 1개 가져오기
	 * @param metaBook
	 * @return MetaBook type
	 */
	public abstract MetaBook getOneMetaBook(MetaBook metaBook);
	
	
	/**
	 * 도서공토 1개 등록하기
	 * @param metaBook
	 * @return 도서공통 등록에 성공한 갯수 1 or 0
	 */
	public abstract int insertMetaBook(MetaBook metaBook);
	
}
