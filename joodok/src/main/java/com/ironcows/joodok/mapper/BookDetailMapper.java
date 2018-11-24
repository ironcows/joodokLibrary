package com.ironcows.joodok.mapper;

import java.util.List;
import java.util.Map;

import com.ironcows.joodok.dto.BookDetail;

public interface BookDetailMapper {

	
	
	/**
	 * 도서 폐기 화면에서 도서 추가를 위해 해당 도서 정보 가져오기
	 * @param value
	 * @return
	 */
	public abstract Map<String, String> getBookInfoWithDiscard(String value);
	
	/**
	 * 도서 대출 화면에서 대출 도서 목록을 출력하기
	 * @param value
	 * @return
	 */
	public abstract Map<String, String> getBookForBorrow(String value);
	
	/**
	 * 도서 상세 정보 보기
	 * @param value
	 * @return
	 */
	public abstract List<Map<String, String>> seeBookDetail(String value);
	
	/**
	 * 도서상세 1개 가져오기
	 * @param bookDetail
	 * @return BookDetail type
	 */
	public abstract BookDetail getOneBookDetail(BookDetail bookDetail);
	
	
	/**
	 * 도서상세 1개 등록하기
	 * @param bookDetail
	 * @return 도서상세 등록에 성공한 갯수 1 or 0
	 */
	public abstract int insertBookDetail(BookDetail bookDetail);
	
	
	/**
	 * 도서상세 1개 수정하기
	 * @param bookDetail
	 * @return 도서상세 수정에 성공한 갯수 1 or 0
	 */
	public abstract int updateBookDetail(BookDetail bookDetail);
	
	
	
}
