package com.harvestcrude.services.lease.plant;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.harvestcrude.common.persistence.mybatis.DataAccessException;
import com.harvestcrude.common.persistence.mybatis.MyBatisConnectionFactory;
import com.harvestcrude.model.lease.plant.LeasePlant;
import com.harvestcrude.services.lease.plant.persistence.mybatis.LeasePlantDAO;

public class LeasePlantService {
	private static final Logger logger = Logger.getLogger(LeasePlantService.class);
	
	public List<LeasePlant> getAllLeasePlants(){
		SqlSession session = null;
		LeasePlantDAO leasePlantDAO = null;
		try {
			session = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
			leasePlantDAO = new LeasePlantDAO(session);
			return leasePlantDAO.getAllLeasePlants();
		} catch (IOException | DataAccessException e) {
			logger.error(e);
			return Collections.emptyList();
		} finally{
			if(session != null){
				session.close();
			}
		}
	}
}
