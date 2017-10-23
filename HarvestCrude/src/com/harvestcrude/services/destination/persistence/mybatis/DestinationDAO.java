package com.harvestcrude.services.destination.persistence.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.harvestcrude.common.persistence.mybatis.DataAccessException;
import com.harvestcrude.model.destination.Destination;

public class DestinationDAO {
	private static final Logger logger = Logger.getLogger(DestinationDAO.class);
	
	private SqlSession session;
	
	public DestinationDAO(SqlSession session){
		this.session = session;
	}
	
	public List<Destination> getAllDetinations() throws DataAccessException{
		try{
			return getSession().selectList("DestinationDAO.getAllDestinations");
		} catch(Exception e){
			logger.error(e);
			throw new DataAccessException(e);
		}
	}

	public SqlSession getSession() {
		return session;
	}
}
