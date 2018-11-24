package com.ironcows.joodok.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ironcows.joodok.dao.RequestBookDaoIf;
import com.ironcows.joodok.dto.RequestBook;

@Service(value="requestBookService")
public class RequestBookService implements RequestBookServiceIf {

	/**
	 * RequestBookDaoMybatisImpl 에서 Repository 로 등록한 것을 
	 * Resource에 명시함으로써 연결한다.
	 */
	@Resource(name="requestBookDao")
	private RequestBookDaoIf dao;
	
	
	@Override
	public int getRequestListNum() {
		return dao.getRequestListNum();
	}
	
	@Override
	public List<Map<String, String>> getRequestBookList(int value) {
		return dao.getRequestBookList(value);
	}
	
	@Override
	public int getMemberRequestListNum(String value) {
		return dao.getMemberRequestListNum(value);
	}
	
	
	@Override
	public List<Map<String, String>> getMemberRequestList(Map<String, Object> value) {
		return dao.getMemberRequestList(value);
	}

	@Override
	public Map<String, String> getOneRequestBook_CLOB(RequestBook requestBook) {
		return dao.getOneRequestBook_CLOB(requestBook);
	}
	
	
	@Override
	public RequestBook getOneRequestBook(RequestBook requestBook) {
		return dao.getOneRequestBook(requestBook);
	}

	@Override
	public int insertRequestBook(RequestBook requestBook) {
		int successCnt = 0;
		
		//primary key가 insert query 실행하면서 생성되므로 getRequestBook을 이용해 동일값이 존재하는지
		//검사할 필요가 없다.
		successCnt = dao.insertRequestBook(requestBook);
			
		return successCnt;
	}

	@Override
	public int updateRequestBook(RequestBook requestBook) {
		int successCnt = 0;
		
		if(getOneRequestBook_CLOB(requestBook) != null) {
			successCnt = dao.updateRequestBook(requestBook);
		}
		
		return successCnt;
	}

}
