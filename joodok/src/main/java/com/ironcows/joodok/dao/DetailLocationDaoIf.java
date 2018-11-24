package com.ironcows.joodok.dao;

import java.util.List;
import java.util.Map;

import com.ironcows.joodok.dto.DetailLocation;

public interface DetailLocationDaoIf {

	
	/**
	 * 위치상세 1개 가져오기
	 * @param detailLocation
	 * @return DetailLocation type
	 */
	public abstract DetailLocation getOneDetailLocation(DetailLocation detailLocation);
	
	/**
	 * 위치상세 전부 가져오기
	 * @return DetailLocation type
	 */
	public abstract List<Map<String, String>> getAllDetailLocation();
	

	
}
