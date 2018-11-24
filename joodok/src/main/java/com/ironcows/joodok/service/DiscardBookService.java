package com.ironcows.joodok.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ironcows.joodok.dao.DiscardBookDaoIf;
import com.ironcows.joodok.dto.DiscardBook;

@Service(value="discardBookService")
public class DiscardBookService implements DiscardBookServiceIf {


	/**
	 * DiscardBookDaoMybatisImpl 에서 Repository 로 등록한 것을 
	 * Resource에 명시함으로써 연결한다.
	 */
	@Resource(name="discardBookDao")
	private DiscardBookDaoIf dao;
	
	@Override
	public DiscardBook getOneDiscardBook(DiscardBook discardBook) {
		return dao.getOneDiscardBook(discardBook);
	}

	@Override
	public int insertDiscardBook(DiscardBook discardBook) {
		return dao.insertDiscardBook(discardBook);
	}
	
}
