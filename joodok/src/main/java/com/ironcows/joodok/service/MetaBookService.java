package com.ironcows.joodok.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ironcows.joodok.dao.MetaBookDaoIf;
import com.ironcows.joodok.dto.MetaBook;

@Service(value="metaBookService")
public class MetaBookService implements MetaBookServiceIf {

	/**
	 * MetaBookDaoMybatisImpl 에서 Repository 로 등록한 것을 
	 * Resource에 명시함으로써 연결한다.
	 */
	@Resource(name="metaBookDao")
	private MetaBookDaoIf dao;
	
	
	
	@Override
	public List<Map<String, String>> searchAsTitle(String value) {
		return dao.searchAsTitle(value);
	}

	@Override
	public List<Map<String, String>> searchAsAuthor(String value) {
		return dao.searchAsAuthor(value);
	}

	@Override
	public List<Map<String, String>> searchAsPublisher(String value) {
		return dao.searchAsPublisher(value);
	}

	@Override
	public MetaBook getOneMetaBook(MetaBook metaBook) {
		return dao.getOneMetaBook(metaBook);
	}

	@Override
	public int insertMetaBook(MetaBook metaBook) {
		int successCnt = 0;

		successCnt = dao.insertMetaBook(metaBook);

		return successCnt;
	}

}
