package com.harvestcrude.services.order;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.harvestcrude.common.persistence.mybatis.DataAccessException;
import com.harvestcrude.common.persistence.mybatis.MyBatisConnectionFactory;
import com.harvestcrude.model.dispatch.Dispatch;
import com.harvestcrude.model.order.Order;
import com.harvestcrude.model.order.DTO.OrderDTO;
import com.harvestcrude.model.user.User;
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
			return orderDAO.validateOrderNumber(order) == 0 ? true : false;
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
	
	public Order selectCompleteOrder(Order order) throws ServiceException, NoSuchOrderException{
		SqlSession session = null;
		OrderDAO orderDAO = null;
		try{
			session = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
			orderDAO = new OrderDAO(session);
			order = orderDAO.selectCompleteOrder(order);
			if(order == null){
				throw new NoSuchOrderException("The requested order number does not exist");
			}
			return order;
		} catch(DataAccessException e){
			logger.error(e);
			throw new ServiceException("Error encountered while requesting order", e);
		} catch(IOException e){
			logger.error(e);
			throw new ServiceException("Can't establish connection with database", e);
		} finally{
			if(session != null){
				session.close();
			}
		}
	}
	
	public Integer getPreviousOrderNumber(Order order, Dispatch dispatch) throws ServiceException{
		SqlSession session = null;
		OrderDAO orderDAO = null;
		try{
			session = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
			orderDAO = new OrderDAO(session);
			return orderDAO.getPreviousOrderNumber(order, dispatch);
		} catch (IOException | DataAccessException e) {
			logger.error(e);
			throw new ServiceException("Failed to get previous order number");
		} finally{
			if(session != null){
				session.close();
			}
		}
	}
	
	public Integer getNextOrderNumber(Order order, Dispatch dispatch) throws ServiceException{
		SqlSession session = null;
		OrderDAO orderDAO = null;
		try{
			session = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
			orderDAO = new OrderDAO(session);
			return orderDAO.getNextOrderNumber(order, dispatch);
		} catch (IOException | DataAccessException e) {
			logger.error(e);
			throw new ServiceException("Failed to get next order number");
		} finally{
			if(session != null){
				session.close();
			}
		}
	}
	
	public void cancelOrder(Order order) throws ServiceException{
		SqlSession session = null;
		OrderDAO orderDAO = null;
		int updatedRows = 0;
		try{
			session = MyBatisConnectionFactory.getSqlSessionFactory().openSession(false);
			orderDAO = new OrderDAO(session);
			updatedRows = orderDAO.cancelOrder(order);
			if(updatedRows != 1){
				session.rollback();
				throw new ServiceException("Unexpected error encountered while canceling order");
			}
			
			session.commit();
		} catch (IOException | DataAccessException e){
			logger.error(e);
			session.rollback();
			throw new ServiceException("Unexpected error encountered while canceling order");
		} finally{
			if(session != null){
				session.close();
			}
		}
	}
	
	public void saveOrderTicketInformation(Order order, User user) throws ServiceException{
		SqlSession session = null;
		try{
			session = MyBatisConnectionFactory.getSqlSessionFactory().openSession(false);
			updateOrder(order, user, session);
			updateOrderDriver(order, user, session);
			updateTicket(order, user, session);
			updateTicketData(order, user, session);
			if(order.getTicket().getTicketType().getIsMeterRequired()){
				updateTicketMeterData(order, user, session);
			} else{
				updateTicketGaugeData(order, user, session);
			}
			session.commit();
		} catch (IOException | DataAccessException e) {
			logger.error(e);
			session.rollback();
			throw new ServiceException("Unexpected error encountered while saving order information");
		} catch (ServiceException e){
			session.rollback();
			throw e;
		} finally{
			if(session != null){
				session.close();
			}
		}
	}
	
	public OrderDTO selectPrimaryOrderForSplitLoad(OrderDTO order) throws ServiceException{
		OrderDAO orderDAO = null;
		SqlSession session = null;
		try {
			session = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
			orderDAO = new OrderDAO(session);
			return orderDAO.selectPrimaryOrderForSplitLoad(order);
		} catch (Exception e) {
			logger.error(e);
			throw new ServiceException(e);
		} finally{
			if(session != null){
				session.close();
			}
		}
	}
	
	public List<OrderDTO> selectOrdersForSplitLoad(Dispatch dispatch, OrderDTO order, String filter, int first, int pageSize) throws ServiceException{
		OrderDAO orderDAO = null;
		SqlSession session = null;
		try {
			session = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
			orderDAO = new OrderDAO(session);
			return orderDAO.selectOrdersForSplitLoad(dispatch, order, filter, first, pageSize);
		} catch (Exception e) {
			logger.error(e);
			throw new ServiceException(e);
		} finally{
			if(session != null){
				session.close();
			}
		}
	}
	
	public Integer selectOrdersForSplitLoadCount(Dispatch dispatch, OrderDTO order, String filter) throws ServiceException{
		OrderDAO orderDAO = null;
		SqlSession session = null;
		try {
			session = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
			orderDAO = new OrderDAO(session);
			return orderDAO.selectOrdersForSplitLoadCount(dispatch, order, filter);
		} catch (Exception e) {
			logger.error(e);
			throw new ServiceException(e);
		} finally{
			if(session != null){
				session.close();
			}
		}
	}
	
	private void updateOrder(Order order, User user, SqlSession session) throws DataAccessException, ServiceException{
		OrderDAO orderDAO = new OrderDAO(session);
		if(orderDAO.updateOrder(order, user) == 0){
			throw new ServiceException("Error saving order information");
		}
	}
	
	private void updateOrderDriver(Order order, User user, SqlSession session) throws DataAccessException, ServiceException{
		OrderDAO orderDAO = new OrderDAO(session);
		if(orderDAO.updateOrderDriver(order, user) < 1){
			insertOrderDriver(order, user, session);
		}
	}
	
	private void insertOrderDriver(Order order, User user, SqlSession session) throws DataAccessException, ServiceException{
		OrderDAO orderDAO = new OrderDAO(session);
		if(orderDAO.insertOrderDriver(order, user) == 0){
			throw new ServiceException("Error saving driver information for this order");
		}
	}
	
	private void updateTicket(Order order, User user, SqlSession session) throws DataAccessException, ServiceException{
		OrderDAO orderDAO = new OrderDAO(session);
		if(orderDAO.updateTicket(order, user) < 1){
			insertTicket(order, user, session);
		}
	}
	
	private void insertTicket(Order order, User user, SqlSession session) throws DataAccessException, ServiceException{
		OrderDAO orderDAO = new OrderDAO(session);
		if(orderDAO.insertTicket(order, user) < 1){
			throw new ServiceException("Error saving ticket information for this order");
		}
	}
	
	private void updateTicketData(Order order, User user, SqlSession session) throws DataAccessException, ServiceException{
		OrderDAO orderDAO = new OrderDAO(session);
		if(orderDAO.updateTicketData(order, user) < 1){
			insertTicketData(order, user, session);
		}
	}
	
	private void insertTicketData(Order order, User user, SqlSession session) throws DataAccessException, ServiceException{
		OrderDAO orderDAO = new OrderDAO(session);
		if(orderDAO.insertTicketData(order, user) < 1){
			throw new ServiceException("Error saving ticket data for this order");
		}
	}
	
	private void updateTicketMeterData(Order order, User user, SqlSession session) throws DataAccessException, ServiceException{
		OrderDAO orderDAO = new OrderDAO(session);
		if(orderDAO.updateTicketMeterData(order, user) < 1){
			insertTicketMeterData(order, user, session);
		}
	}
	
	private void insertTicketMeterData(Order order, User user, SqlSession session) throws DataAccessException, ServiceException{
		OrderDAO orderDAO = new OrderDAO(session);
		if(orderDAO.insertTicketMeterData(order, user) < 1){
			throw new ServiceException("Error saving meter data for this order");
		}
	}
	
	private void updateTicketGaugeData(Order order, User user, SqlSession session) throws DataAccessException, ServiceException{
		OrderDAO orderDAO = new OrderDAO(session);
		if(orderDAO.updateTicketGaugeData(order, user) < 1){
			insertTicketGaugeData(order, user, session);
		}
	}
	
	private void insertTicketGaugeData(Order order, User user, SqlSession session) throws DataAccessException, ServiceException{
		OrderDAO orderDAO = new OrderDAO(session);
		if(orderDAO.insertTicketGaugeData(order, user) < 1){
			throw new ServiceException("Error saving gauge data for this order");
		}
	}
	 
}
