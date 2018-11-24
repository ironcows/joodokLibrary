package com.ironcows.joodok.mapper;

import java.util.List;
import java.util.Map;

import com.ironcows.joodok.dto.Location;

public interface LocationMapper {

	
	/**
	 * 위치 1개 가져오기
	 * @param location
	 * @return Location type
	 */
	public abstract Location getOneLocation(Location location);
	
	/**
	 * 위치 전부 가져오기
	 * @return
	 */
	public abstract List<Map<String, String>> getAllLocation();
	
}
