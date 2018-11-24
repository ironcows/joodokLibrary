package com.ironcows.joodok.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ironcows.joodok.dao.CheckUpListDaoIf;
import com.ironcows.joodok.dto.CheckUpList;

@Service(value="checkUpListService")
public class CheckUpListService implements CheckUpListServiceIf {


	/**
	 * CheckUpListDaoMybatisImpl 에서 Repository 로 등록한 것을 
	 * Resource에 명시함으로써 연결한다.
	 */
	@Resource(name="checkUpListDao")
	private CheckUpListDaoIf dao;
	
	
	@Override
	public List<Map<String, String>> getPreRegisterDetailList(String value) {
		return dao.getPreRegisterDetailList(value);
	}
	
	@Override
	public List<Map<String, String>> getUnRegisteredBookList() {
		return dao.getUnRegisteredBookList();
	}
	
	@Override
	public CheckUpList getOneCheckUpList(CheckUpList checkUpList) {
		return dao.getOneCheckUpList(checkUpList);
	}

	@Override
	public int insertCheckUpList(CheckUpList checkUpList) {
		return dao.insertCheckUpList(checkUpList);
	}

	
	@Override
	public int updateCheckUpList(CheckUpList checkUpList) {
		int successCnt = 0;
		
		if(getOneCheckUpList(checkUpList) != null) {
			successCnt = dao.updateCheckUpList(checkUpList);
		}
		
		return successCnt;
	}
	
}
