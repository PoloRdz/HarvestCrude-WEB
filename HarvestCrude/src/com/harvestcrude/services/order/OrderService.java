package com.harvestcrude.services.order;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.harvestcrude.common.persistence.mybatis.DataAccessException;
import com.harvestcrude.common.persistence.mybatis.MyBatisConnectionFactory;
import com.harvestcrude.model.dispatch.Dispatch;
import com.harvestcrude.model.order.Order;
import com.harvestcrude.services.ServiceException;
import com.harvestcrude.services.order.persistence.mybatis.OrderDAO;

public class OrderService {
	private static final Logger logger = Logger.getLogger(OrderService.class);
	
	public void insertOrder(Dispatch dispatch, Order order) throws ServiceException, ExistingOrderException{
		SqlSession session = null;
		OrderDAO orderDAO = null;
		try{
			if(isOrderNew(order)){
				session = MyBatisConnectionFactory.getSqlSessionFactory().openSession(false);
				orderDAO = new OrderDAO(session);
				orderDAO.insertOrder(dispatch, order);
				session.commit();
			} else{
				throw new ExistingOrderException("Order number already exists");
			}
		} catch(DataAccessException e){
			logger.error(e);
			if(session != null){
				session.rollback();
			}
			throw new ServiceException("Error encountered while saving order", e);
		} catch(IOException e){
			logger.error(e);
			throw new ServiceException("Can't establish connection with database", e);
		} finally{
			if(session != null){
				session.close();
			}
		}
	}
	
	private boolean isOrderNew(Order order) throws IOException, DataAccessException{
		SqlSession session = null;
		OrderDAO orderDAO = null;
		try{
			session = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
			orderDAO = new OrderDAO(session);
			return orderDAO.validateOrderNumber(order) == 0 ? true: false;
		} catch(DataAccessException e){
			logger.error(e);
			throw e;
		} catch(IOException e){
			logger.error(e);
			throw e;
		} finally{
			if(session != null){
				session.close();
			}
		}
	}
}
