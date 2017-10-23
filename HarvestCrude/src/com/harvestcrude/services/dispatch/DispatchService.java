package com.harvestcrude.services.dispatch;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.harvestcrude.common.persistence.mybatis.DataAccessException;
import com.harvestcrude.common.persistence.mybatis.MyBatisConnectionFactory;
import com.harvestcrude.model.dispatch.Dispatch;
import com.harvestcrude.services.ServiceException;
import com.harvestcrude.services.dispatch.persistence.mybatis.DispatchDAO;

public class DispatchService {
	private static final Logger logger = Logger.getLogger(DispatchService.class);
	
	public Dispatch getDispatchById(Dispatch dispatch) throws ServiceException{
		SqlSession session = null;
		DispatchDAO dispatchDAO = null;
		try {
			session = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
			dispatchDAO = new DispatchDAO(session);
			return dispatch = dispatchDAO.getDispatchById(dispatch);
		} catch (IOException | DataAccessException e) {
			logger.error(e);
			throw new ServiceException("Failed to load dispatch", e);
		} finally{
			if(session != null){
				session.close();
			}
		}
	}
}
