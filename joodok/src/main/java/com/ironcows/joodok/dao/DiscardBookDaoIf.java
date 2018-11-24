package com.ironcows.joodok.dao;

import com.ironcows.joodok.dto.DiscardBook;

public interface DiscardBookDaoIf {
	
	/**
	 * 폐기도서 1개 가져오기
	 * @param discardBook
	 * @return DiscardBook type
	 */
	public abstract DiscardBook getOneDiscardBook(DiscardBook discardBook);
	
	/**
	 * 폐기도서 1개 등록하기
	 * @param discardBook
	 * @return 폐기도서 등록에 성공한 갯수 1 or 0
	 */
	public abstract int insertDiscardBook(DiscardBook discardBook);
	
}
