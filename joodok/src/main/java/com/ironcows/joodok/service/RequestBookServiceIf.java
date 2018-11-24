package com.ironcows.joodok.service;

import java.util.List;
import java.util.Map;

import com.ironcows.joodok.dto.RequestBook;

public interface RequestBookServiceIf {
	
	/**
	 * 사서의 도서요청 목록 조회를 위한 리스트 총 갯수 가져오기
	 * @param value
	 * @return
	 */
	public abstract int getRequestListNum();
	
	/**
	 * 사서의 도서요청 목록 조회를 위한 리스트 가져오기 
	 * @param value
	 * @return
	 */
	public abstract List<Map<String, String>> getRequestBookList(int value);
	
	/**
	 * 회원 본인의 도서요청 리스트 총 갯수 가져오기
	 * @param value
	 * @return
	 */
	public abstract int getMemberRequestListNum(String value);	
	
	/**
	 * 회원 본인의 도서 요청 리스트 가져오기
	 * @param value
	 * @return
	 */
	public abstract List<Map<String, String>> getMemberRequestList(Map<String, Object> value);
	
	
	/**
	 * 도서 요청 리스트에서 클릭했을 때 해당 글의 내용을 가져오기
	 * @param requestBook
	 * @return
	 */
	public abstract Map<String, String> getOneRequestBook_CLOB(RequestBook requestBook);
			
	
	
	/**
	 * 도서요청 1개 가져오기
	 * @param requestBook
	 * @return RequestBook type
	 */
	public abstract RequestBook getOneRequestBook(RequestBook requestBook);
	
	
	/**
	 * 도서요청 1개 등록하기
	 * @param requestBook
	 * @return 도서요청 등록에 성공한 갯수 1 or 0
	 */
	public abstract int insertRequestBook(RequestBook requestBook);
	
	
	/**
	 * 도서요청 1개 수정하기
	 * @param requestBook
	 * @return 도서요청 수정에 성공한 갯수 1 or 0
	 */
	public abstract int updateRequestBook(RequestBook requestBook);
	
}
