package com.harvestcrude.services.driver;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.harvestcrude.common.persistence.mybatis.DataAccessException;
import com.harvestcrude.common.persistence.mybatis.MyBatisConnectionFactory;
import com.harvestcrude.model.driver.Driver;
import com.harvestcrude.services.driver.persistence.mybatis.DriverDAO;

public class DriverService {
	private static final Logger logger = Logger.getLogger(DriverService.class);
	
	public List<Driver> getAllDrivers(){
		SqlSession session = null;
		DriverDAO driverDAO = null;
		try{
			session = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
			driverDAO = new DriverDAO(session);
			return driverDAO.getAllDrivers();
		} catch(IOException | DataAccessException e){
			logger.error(e);
			return Collections.emptyList();
		} finally{
			if(session != null){
				session.close();
			}
		}
	}
}
