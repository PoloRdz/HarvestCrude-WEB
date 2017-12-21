package com.harvestcrude.services.driver.persistence.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.harvestcrude.common.persistence.mybatis.DataAccessException;
import com.harvestcrude.model.driver.Driver;

public class DriverDAO {
	private static final Logger logger = Logger.getLogger(DriverDAO.class);
	
	private SqlSession session;
	
	public DriverDAO(SqlSession session){
		this.session = session;
	}
	
	public List<Driver> getAllDrivers() throws DataAccessException{
		try{
			return getSession().selectList("DriverDAO.getAllDrivers");
		} catch(Exception e){
			logger.error(e);
			throw new DataAccessException(e);
		}
	}
	
	public SqlSession getSession() {
		return session;
	}
}
