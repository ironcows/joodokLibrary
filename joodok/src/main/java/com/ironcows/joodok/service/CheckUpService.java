package com.ironcows.joodok.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ironcows.joodok.dao.CheckUpDaoIf;
import com.ironcows.joodok.dto.CheckUp;


@Service(value="checkUpService")
public class CheckUpService implements CheckUpServiceIf {
	

	/**
	 * CheckUpDaoMybatisImpl 에서 Repository 로 등록한 것을 
	 * Resource에 명시함으로써 연결한다.
	 */
	@Resource(name="checkUpDao")
	private CheckUpDaoIf dao;
	

	@Override
	public String getCheckUpNo(String value) {
		return dao.getCheckUpNo(value);
	}

	@Override
	public CheckUp getOneCheckUp(CheckUp checkUp) {
		return dao.getOneCheckUp(checkUp);
	}

	@Override
	public int insertCheckUp(CheckUp checkUp) {
		return dao.insertCheckUp(checkUp);
	}

}
