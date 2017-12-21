package com.harvestcrude.services.lease.plant.tank;

import java.util.Collections;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.harvestcrude.common.persistence.mybatis.MyBatisConnectionFactory;
import com.harvestcrude.model.lease.plant.LeasePlant;
import com.harvestcrude.model.lease.plant.tank.Tank;
import com.harvestcrude.services.lease.plant.tank.persistence.mybatis.TankDAO;

public class TankService {
	private static final Logger logger = Logger.getLogger(TankService.class);
	
	public List<Tank> selectLeasePlantTanks(LeasePlant leasePlant){
		SqlSession session = null;
		TankDAO tankDAO = null;
		try {
			session = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
			tankDAO = new TankDAO(session);
			return tankDAO.selectLeasePlantTanks(leasePlant);
		} catch (Exception e) {
			logger.error(e);
			return Collections.emptyList();
		} finally{
			if(session != null){
				session.close();
			}
		}
	}

}
