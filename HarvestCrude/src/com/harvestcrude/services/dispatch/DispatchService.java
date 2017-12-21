package com.harvestcrude.services.dispatch;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.harvestcrude.common.persistence.mybatis.DataAccessException;
import com.harvestcrude.common.persistence.mybatis.MyBatisConnectionFactory;
import com.harvestcrude.model.dispatch.Dispatch;
import com.harvestcrude.model.dispatch.DTO.DispatchDTO;
import com.harvestcrude.model.order.Order;
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
	
	public List<DispatchDTO> searchAllDispatch(String filter, int first, int pageSize) throws ServiceException{
		SqlSession session = null;
		DispatchDAO dispatchDAO = null;
		try {
			session = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
			dispatchDAO = new DispatchDAO(session);
			return dispatchDAO.searchAllDispatch(filter, first, pageSize);
		} catch (IOException | DataAccessException e) {
			logger.error(e);
			throw new ServiceException("Failed to load data", e);
		} finally{
			if(session != null){
				session.close();
			}
		}
	}
	
	public int searchAllDispatchCount(String filter) throws ServiceException{
		SqlSession session = null;
		DispatchDAO dispatchDAO = null;
		try {
			session = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
			dispatchDAO = new DispatchDAO(session);
			return dispatchDAO.searchAllDispatchCount(filter);
		} catch (IOException | DataAccessException e) {
			logger.error(e);
			throw new ServiceException("Failed to load data", e);
		} finally{
			if(session != null){
				session.close();
			}
		}
	}
	
	public Dispatch getOrderCurrentDispatch(Order order) throws ServiceException{
		SqlSession session = null;
		DispatchDAO dispatchDAO = null;
		try{
			session = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
			dispatchDAO = new DispatchDAO(session);
			return dispatchDAO.getOrderCurrentDispatch(order);
		} catch(IOException | DataAccessException e){
			logger.error(e);
			throw new ServiceException("Failed to load order's dispatch");
		} finally{
			if(session != null){
				session.close();
			}
		}
	}
}
