package com.ironcows.joodok.dao;

import java.util.List;
import java.util.Map;

import com.ironcows.joodok.dto.Acquisition;

public interface AcquisitionDaoIf {
	
	
	/**
	 * 도서 공통정보 등록 화면에서 등록 대상을 선택하기 위한 목록 가져오기
	 * @return
	 */
	public abstract List<Map<String, String>> getAcquisitionForMetaBook();
	
	/**
	 * 검수 화면에서 검수 대상을 선택하기 위한 목록 가져오기
	 * @return
	 */
	public abstract List<Map<String, String>> getAcquisitionForCheckUp();
	
	/**
	 * 주문 화면에서 주문 대상을 선택하기 위한 목록 가져오기
	 * @return
	 */
	public abstract List<Map<String, String>> getAcqusitionForOrder();
	
	
	/**
	 * 수서 등록 화면에서 소장하고 있는 도서인지 확인하기
	 * @param value
	 * @return
	 */
	public abstract Map<String, String> checkExistIsbn(String value);
	
	/**
	 * 수서 1개 가져오기
	 * @param acquisition
	 * @return Acquisition type
	 */
	public abstract Acquisition getOneAcquisition(Acquisition acquisition);
	
	/**
	 * 수서 1개 등록하기
	 * @param acquisition
	 * @return 수서 등록에 성공한 갯수 1 or 0
	 */
	public abstract int insertAcquisition(Acquisition acquisition);
	
	
	/**
	 * 수서 1개 수정하기
	 * @param acquisition
	 * @return 수서 수정에 성공한 갯수 1 or 0
	 */
	public abstract int updateAcquisition(Acquisition acquisition);
	
}
