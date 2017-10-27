package com.harvestcrude.services.order.persistence.mybatis;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.harvestcrude.common.persistence.mybatis.DataAccessException;
import com.harvestcrude.model.dispatch.Dispatch;
import com.harvestcrude.model.order.Order;

public class OrderDAO {
private static final Logger logger = Logger.getLogger(OrderDAO.class);
	
	private SqlSession session;	
	
	public OrderDAO(SqlSession session) {
		this.session = session;
	}

	public SqlSession getSession() {
		return session;
	}
	
	public void insertOrder(Dispatch dispatch, Order order) throws DataAccessException{
		Map<String, Object> params = new HashMap<>();
		params.put("order_number", order.getOrderNumber());
		params.put("lease_plant_number", order.getLeasePlant().getLeasePlantNumber());
		params.put("destination_id", dispatch.getDispatchId());
		params.put("dispatch_id", order.getDestination().getDestinationId());
		params.put("order_status_id", 1);
		params.put("created_by", 1);
		try{
			getSession().insert("OrderDAO.insertOrder", params);
		} catch(Exception e){
			logger.error(e);
			throw new DataAccessException(e);
		}
	}
	
	public int validateOrderNumber(Order order) throws DataAccessException{
		Map<String, Object> params = new HashMap<>();
		params.put("order_number", order.getOrderNumber());
		try{
			return getSession().selectOne("OrderDAO.validateOrderNumber", params) == null ? 0 : 1;
		} catch (Exception e) {
			logger.error(e);
			throw new DataAccessException(e);
		}
	}
}
