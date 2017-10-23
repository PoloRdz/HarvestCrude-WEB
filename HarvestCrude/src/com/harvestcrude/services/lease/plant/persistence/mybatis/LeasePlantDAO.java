package com.harvestcrude.services.lease.plant.persistence.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.harvestcrude.common.persistence.mybatis.DataAccessException;
import com.harvestcrude.model.lease.plant.LeasePlant;

public class LeasePlantDAO {
	private static final Logger logger = Logger.getLogger(LeasePlantDAO.class);
	
	private SqlSession session;

	public LeasePlantDAO(SqlSession session) {
		this.session = session;
	}
	
	public List<LeasePlant> getAllLeasePlants() throws DataAccessException{
		try{
			return getSession().selectList("LeasePlantDAO.getAllLeasePlants");
		} catch (Exception e) {
			logger.error(e);
			throw new DataAccessException(e);
		}
	}
	
	public SqlSession getSession() {
		return session;
	}
}
