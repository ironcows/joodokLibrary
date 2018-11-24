package com.ironcows.joodok.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ironcows.joodok.dao.DetailLocationDaoIf;
import com.ironcows.joodok.dto.DetailLocation;

@Service(value="detailLocationService")
public class DetailLocationService implements DetailLocationServiceIf {


	/**
	 * DetailLocationDaoMybatisImpl 에서 Repository 로 등록한 것을 
	 * Resource에 명시함으로써 연결한다.
	 */
	@Resource(name="detailLocationDao")
	private DetailLocationDaoIf dao;
	
	
	@Override
	public DetailLocation getOneDetailLocation(DetailLocation detailLocation) {
		return dao.getOneDetailLocation(detailLocation);
	}

	@Override
	public List<Map<String, String>> getAllDetailLocation() {
		return dao.getAllDetailLocation();
	}

}
