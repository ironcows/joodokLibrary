package com.ironcows.joodok.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ironcows.joodok.dao.LocationDaoIf;
import com.ironcows.joodok.dto.Location;

@Service(value="locationService")
public class LocationService implements LocationServiceIf {

	/**
	 * LocationDaoMybatisImpl 에서 Repository 로 등록한 것을 
	 * Resource에 명시함으로써 연결한다.
	 */
	@Resource(name="locationDao")
	private LocationDaoIf dao;
	

	@Override
	public Location getOneLocation(Location location) {
		return dao.getOneLocation(location);
	}

	@Override
	public List<Map<String, String>> getAllLocation() {
		return dao.getAllLocation();
	}

}
