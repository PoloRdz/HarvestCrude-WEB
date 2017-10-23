package com.harvestcrude.services.destination;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.harvestcrude.common.persistence.mybatis.DataAccessException;
import com.harvestcrude.common.persistence.mybatis.MyBatisConnectionFactory;
import com.harvestcrude.model.destination.Destination;
import com.harvestcrude.services.destination.persistence.mybatis.DestinationDAO;

public class DestinationService {
	private static final Logger logger = Logger.getLogger(DestinationService.class);
	
	public List<Destination> getAllDestinations(){
		SqlSession session = null;
		DestinationDAO destinationDAO = null;
		try{
			session = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
			destinationDAO = new DestinationDAO(session);
			return destinationDAO.getAllDetinations();
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
