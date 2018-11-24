package com.ironcows.joodok.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ironcows.joodok.dao.BorrowDaoIf;
import com.ironcows.joodok.dto.Borrow;
import com.ironcows.joodok.dto.Member;


@Service(value="borrowService")
public class BorrowService implements BorrowServiceIf {


	/**
	 * BorrowDaoMybatisImpl 에서 Repository 로 등록한 것을 
	 * Resource에 명시함으로써 연결한다.
	 */
	@Resource(name="borrowDao")
	private BorrowDaoIf dao;
	
	@Override
	public List<Map<String, String>> getDelayedBookList() {
		return dao.getDelayedBookList();
	}
	
	@Override
	public Map<String, String> getBorrowInfo(String value) {
		return dao.getBorrowInfo(value);
	}
	
	@Override
	public List<Map<String, String>> getMemberBorrow(Member member) {
		return dao.getMemberBorrow(member);
	}

	@Override
	public Borrow getOneBorrow(Borrow borrow) {
		return dao.getOneBorrow(borrow);
	}

	@Override
	public int insertBorrow(Borrow borrow) {
		return dao.insertBorrow(borrow);
	}

	@Override
	public int updateBorrow(Borrow borrow) {
		int successCnt = 0;
		
		if(getOneBorrow(borrow) != null) {
			successCnt = dao.updateBorrow(borrow);
		}
		return successCnt;
	}

}
