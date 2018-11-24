package com.ironcows.joodok.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ironcows.joodok.dao.AcquisitionDaoIf;
import com.ironcows.joodok.dto.Acquisition;

@Service(value="acquisitionService")
public class AcquisitionService implements AcquisitionServiceIf {

	/**
	 * AcquisitionDaoMybatisImpl 에서 Repository 로 등록한 것을 
	 * Resource에 명시함으로써 연결한다.
	 */
	@Resource(name="acquisitionDao")
	private AcquisitionDaoIf dao;


	@Override
	public List<Map<String, String>> getAcquisitionForMetaBook() {
		return dao.getAcquisitionForMetaBook();
	}
	
	@Override
	public List<Map<String, String>> getAcquisitionForCheckUp() {
		return dao.getAcquisitionForCheckUp();
	}
	
	@Override
	public List<Map<String, String>> getAcqusitionForOrder() {
		return dao.getAcqusitionForOrder();
	}
	
	
	@Override
	public Map<String, String> checkExistIsbn(String value) {
		return dao.checkExistIsbn(value);
	}

	@Override
	public Acquisition getOneAcquisition(Acquisition acquisition) {
		return dao.getOneAcquisition(acquisition);
	}

	@Override
	public int insertAcquisition(Acquisition acquisition) {
		return dao.insertAcquisition(acquisition);
	}

	@Override
	public int updateAcquisition(Acquisition acquisition) {
		int successCnt = 0;
		
		if(getOneAcquisition(acquisition) != null) {
			successCnt = dao.updateAcquisition(acquisition);
		}
		
		return successCnt;
	}
	
	
}
