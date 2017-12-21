package com.harvestcrude.services.order;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.harvestcrude.common.persistence.mybatis.DataAccessException;
import com.harvestcrude.common.persistence.mybatis.MyBatisConnectionFactory;
import com.harvestcrude.model.order.Order;
import com.harvestcrude.model.order.OrderStatus;
import com.harvestcrude.services.ServiceException;
import com.harvestcrude.services.order.persistence.mybatis.OrderStatusDAO;

public class OrderStatusService {
	private static final Logger logger = Logger.getLogger(OrderStatusService.class);
	
	public List<OrderStatus> getAllOrderStatus(){
		SqlSession session = null;
		OrderStatusDAO orderStatusDAO = null;
		try{
			session = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
			orderStatusDAO = new OrderStatusDAO(session);
			return orderStatusDAO.getAllOrderStatuses();
		} catch(IOException | DataAccessException e){
			logger.error(e);
			return Collections.emptyList();
		} finally{
			if(session != null){
				session.close();
			}
		}
	}
	
	public OrderStatus selectOrderStatus(Order order) throws ServiceException{
		SqlSession session = null;
		OrderStatusDAO orderStatusDAO = null;
		try{
			session = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
			orderStatusDAO = new OrderStatusDAO(session);
			return orderStatusDAO.getOrderStatus(order);
		} catch(IOException | DataAccessException e){
			logger.error(e);
			throw new ServiceException("Unable to get the order status");
		} finally{
			if(session != null){
				session.close();
			}
		}
	}

}
