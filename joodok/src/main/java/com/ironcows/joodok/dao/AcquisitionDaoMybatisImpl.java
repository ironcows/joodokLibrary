package com.ironcows.joodok.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ironcows.joodok.dto.Acquisition;
import com.ironcows.joodok.mapper.AcquisitionMapper;

@Repository(value="acquisitionDao")
public class AcquisitionDaoMybatisImpl implements AcquisitionDaoIf {

	/* 내부적으로 사용하는 factory 변수
	 * mybatis-context.xml 에서 id="factory" 로 생성된 빈 객체를 변수이름이 똑같은
	 * 아래의 factory 변수에 자동 연결한다.
	 */
	@Autowired
	private SqlSessionFactory factory;
	
	
	@Override
	public List<Map<String, String>> getAcquisitionForMetaBook() {
		SqlSession session = factory.openSession();
		AcquisitionMapper mapper = session.getMapper(AcquisitionMapper.class);

		List<Map<String, String>> resultSet;
		
		try {
			resultSet = mapper.getAcquisitionForMetaBook();
		} finally {
			session.close();
		}
		
		return resultSet;
	}
	
	@Override
	public List<Map<String, String>> getAcquisitionForCheckUp() {
		SqlSession session = factory.openSession();
		AcquisitionMapper mapper = session.getMapper(AcquisitionMapper.class);

		List<Map<String, String>> resultSet;
		
		try {
			resultSet = mapper.getAcquisitionForCheckUp();
		} finally {
			session.close();
		}
		
		return resultSet;
	}
	
	@Override
	public List<Map<String, String>> getAcqusitionForOrder() {
		SqlSession session = factory.openSession();
		AcquisitionMapper mapper = session.getMapper(AcquisitionMapper.class);
		
		List<Map<String, String>> resultSet;
		
		try {
			resultSet = mapper.getAcqusitionForOrder();
		} finally {
			session.close();
		}
		
		return resultSet;
	}
	
	
	@Override
	public Map<String, String> checkExistIsbn(String value) {
		SqlSession session = factory.openSession();
		AcquisitionMapper mapper = session.getMapper(AcquisitionMapper.class);
		
		Map<String, String> resultSet;
		
		try {
			resultSet = mapper.checkExistIsbn(value);
		} finally {
			session.close();
		}
		
		return resultSet;
	}

	@Override
	public Acquisition getOneAcquisition(Acquisition acquisition) {
		SqlSession session = factory.openSession();
		AcquisitionMapper mapper = session.getMapper(AcquisitionMapper.class);

		try {
			acquisition = mapper.getOneAcquisition(acquisition);
		} finally {
			session.close();
		}
		
		return acquisition;
	}

	@Override
	public int insertAcquisition(Acquisition acquisition) {
		SqlSession session = factory.openSession(true);
		AcquisitionMapper mapper = session.getMapper(AcquisitionMapper.class);

		int successCnt = 0;
		
		try {
			successCnt = mapper.insertAcquisition(acquisition);
		} finally {
			session.close();
		}
		
		return successCnt;
	}

	@Override
	public int updateAcquisition(Acquisition acquisition) {
		SqlSession session = factory.openSession(true);
		AcquisitionMapper mapper = session.getMapper(AcquisitionMapper.class);
		
		int successCnt = 0;
		
		try {
			successCnt = mapper.updateAcquisition(acquisition);
		} finally {
			session.close();
		}
		
		return successCnt;
	}

}
