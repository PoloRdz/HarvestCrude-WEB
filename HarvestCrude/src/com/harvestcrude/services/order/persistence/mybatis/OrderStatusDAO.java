package com.harvestcrude.services.order.persistence.mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.harvestcrude.common.persistence.mybatis.DataAccessException;
import com.harvestcrude.model.order.Order;
import com.harvestcrude.model.order.OrderStatus;
import com.harvestcrude.services.destination.persistence.mybatis.DestinationDAO;

public class OrderStatusDAO {
private static final Logger logger = Logger.getLogger(DestinationDAO.class);
	
	private SqlSession session;
	
	public OrderStatusDAO(SqlSession session){
		this.session = session;
	}
	
	public SqlSession getSession() {
		return session;
	}
	
	public List<OrderStatus> getAllOrderStatuses() throws DataAccessException{
		try{
			return getSession().selectList("OrderStatusDAO.getAllOrderStatuses");
		} catch(Exception e){
			logger.error(e);
			throw new DataAccessException(e);
		}
	}
	
	public OrderStatus getOrderStatus(Order order) throws DataAccessException{
		Map<String, Object> params = new HashMap<>();
		params.put("order_number", order.getOrderNumber());
		try{
			return getSession().selectOne("OrderStatusDAO.selectOrderStatus", params);
		} catch (Exception e) {
			logger.error(e);
			throw new DataAccessException(e);
		}
	} 	
}
