package com.harvestcrude.services.lease.plant.tank.persistence.mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.harvestcrude.common.persistence.mybatis.DataAccessException;
import com.harvestcrude.model.lease.plant.LeasePlant;
import com.harvestcrude.model.lease.plant.tank.Tank;

public class TankDAO {
	private static final Logger logger = Logger.getLogger(TankDAO.class);
	
	private SqlSession session;
	
	public TankDAO(SqlSession session){
		this.session = session;
	}

	public SqlSession getSession(){
		return session;
	}
	
	public List<Tank> selectLeasePlantTanks(LeasePlant leasePlant) throws DataAccessException{
		Map<String, Object> params = new HashMap<>();
		params.put("lease_plant_number", leasePlant.getLeasePlantNumber());
		try{
			return getSession().selectList("TankDAO.selectLeasePlantTanks", params);
		} catch(Exception e){
			logger.error(e);
			throw new DataAccessException(e);
		}
	}
}
