package com.harvestcrude.services.truck.persistence.mybatis;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.harvestcrude.common.persistence.mybatis.DataAccessException;
import com.harvestcrude.model.truck.Truck;
import com.harvestcrude.model.user.User;

public class TruckDAO {
	private static final Logger logger = Logger.getLogger(TruckDAO.class);

	private SqlSession session;
	
	public TruckDAO(SqlSession session){
		this.session = session;
	}
	
	public SqlSession getSession(){
		return session;
	}
	
	public Truck selectDriverTruck(User user) throws DataAccessException{
		Map<String, Object> params = new HashMap<>();
		params.put("driver_id", user.getUserId());
		try{
			return getSession().selectOne("TruckDAO.selectDriverTruck", params);
		} catch (Exception e) {
			logger.error(e);
			throw new DataAccessException(e);
		}
	}
}
