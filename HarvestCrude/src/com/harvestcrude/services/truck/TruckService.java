package com.harvestcrude.services.truck;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.harvestcrude.common.persistence.mybatis.DataAccessException;
import com.harvestcrude.common.persistence.mybatis.MyBatisConnectionFactory;
import com.harvestcrude.model.truck.Truck;
import com.harvestcrude.model.user.User;
import com.harvestcrude.services.ServiceException;
import com.harvestcrude.services.truck.persistence.mybatis.TruckDAO;

public class TruckService {
	private static final Logger logger = Logger.getLogger(TruckService.class);
	
	public Truck selectDriverTruck(User user) throws ServiceException{
		SqlSession session = null;
		TruckDAO truckDAO = null;
		try {
			session = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
			truckDAO = new TruckDAO(session);
			return truckDAO.selectDriverTruck(user);
		} catch (IOException | DataAccessException e) {
			logger.error(e);
			throw new ServiceException(e);
		} finally{
			if(session != null){
				session.close();
			}
		}
	}
}
