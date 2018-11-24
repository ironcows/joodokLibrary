package com.ironcows.joodok.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ironcows.joodok.dao.BookDetailDaoIf;
import com.ironcows.joodok.dto.BookDetail;


@Service(value="bookDetailService")
public class BookDetailService implements BookDetailServiceIf {

	/**
	 * BookDetailDaoMybatisImpl 에서 Repository 로 등록한 것을 
	 * Resource에 명시함으로써 연결한다.
	 */
	@Resource(name="bookDetailDao")
	private BookDetailDaoIf dao;
	
	
	@Override
	public Map<String, String> getBookInfoWithDiscard(String value) {
		return dao.getBookInfoWithDiscard(value);
	}
	
	@Override
	public Map<String, String> getBookForBorrow(String value) {
		return dao.getBookForBorrow(value);
	}
	
	@Override
	public List<Map<String, String>> seeBookDetail(String value) {
		return dao.seeBookDetail(value);
	}

	@Override
	public BookDetail getOneBookDetail(BookDetail bookDetail) {
		return dao.getOneBookDetail(bookDetail);
	}

	@Override
	public int insertBookDetail(BookDetail bookDetail) {
		return dao.insertBookDetail(bookDetail);
	}

	@Override
	public int updateBookDetail(BookDetail bookDetail) {
		int successCnt = 0;
		
		if(getOneBookDetail(bookDetail) != null) {
			successCnt = dao.updateBookDetail(bookDetail);
		}
		
		return successCnt;
	}

}
