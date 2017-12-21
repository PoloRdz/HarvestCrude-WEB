package com.harvestcrude.services.order.persistence.mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.harvestcrude.common.persistence.mybatis.DataAccessException;
import com.harvestcrude.model.dispatch.Dispatch;
import com.harvestcrude.model.order.Order;
import com.harvestcrude.model.order.DTO.OrderDTO;
import com.harvestcrude.model.user.User;

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
	
	public int updateOrder(Order order, User user) throws DataAccessException{
		Map<String, Object> params = new HashMap<>();
		params.put("lease_plant_number", order.getLeasePlant().getLeasePlantNumber());
		params.put("destination_id", order.getDestination().getDestinationId());
		params.put("order_identifier", order.getOrderStatus().getIdentifier());
		params.put("modified_by", user.getUserId());
		params.put("order_number", order.getOrderNumber());
		try{
			return getSession().update("OrderDAO.updateOrder", params);
		} catch (Exception e) {
			logger.error(e);
			throw new DataAccessException(e);
		}
	}
	
	public int insertOrderDriver(Order order, User user) throws DataAccessException{
		Map<String, Object> params = new HashMap<>();
		params.put("order_number", order.getOrderNumber());
		params.put("driver_user_id", order.getDriver().getUser().getUserId());
		params.put("truck_number", order.getTruck().getTruckNumber());
		params.put("created_by", user.getUserId());
		try {
			return getSession().insert("OrderDAO.insertOrderDriver", params);
		} catch (Exception e) {
			logger.error(e);
			throw new DataAccessException(e);
		}
	}
	
	public int updateOrderDriver(Order order, User user) throws DataAccessException{
		Map<String, Object> params = new HashMap<>();
		params.put("driver_user_id", order.getDriver().getUser().getUserId());
		params.put("truck_number", order.getTruck().getTruckNumber());
		params.put("modified_by", user.getUserId());
		params.put("order_number", order.getOrderNumber());
		try {
			return getSession().update("OrderDAO.updateOrderDriver", params);
		} catch (Exception e) {
			logger.error(e);
			throw new DataAccessException(e);
		}
	}
	
	public int insertTicket(Order order, User user) throws DataAccessException{
		Map<String, Object> params = new HashMap<>();
		params.put("ticket_number", order.getTicket().getTicketNumber());
		params.put("order_number", order.getOrderNumber());
		params.put("ticket_type_id", order.getTicket().getTicketType().getTicketTypeId());
		params.put("created_by", user.getUserId());
		try {
			return getSession().update("OrderDAO.insertTicket", params);
		} catch (Exception e) {
			logger.error(e);
			throw new DataAccessException(e);
		}
	}
	
	public int updateTicket(Order order, User user) throws DataAccessException{
		Map<String, Object> params = new HashMap<>();
		params.put("ticket_type_id", order.getTicket().getTicketType().getTicketTypeId());
		params.put("modified_by", user.getUserId());
		params.put("ticket_number", order.getTicket().getTicketNumber());
		params.put("order_number", order.getOrderNumber());
		try {
			return getSession().update("OrderDAO.updateTicket", params);
		} catch (Exception e) {
			logger.error(e);
			throw new DataAccessException(e);
		}
	}
	
	public int insertTicketData(Order order, User user) throws DataAccessException{
		Map<String, Object> params = new HashMap<>();
		params.put("ticket_number", order.getTicket().getTicketNumber());
		params.put("tank_id", order.getTicket().getTicketData().getTank().getTankId());
		params.put("total_barrels", order.getTicket().getTicketData().getTotalBarrels());
		params.put("gravity", order.getTicket().getTicketData().getGravity());
		params.put("temperature", order.getTicket().getTicketData().getTemp());
		params.put("bsw", order.getTicket().getTicketData().getBsw());
		params.put("seal_off", order.getTicket().getTicketData().getSealOff());
		params.put("seal_off_date", order.getTicket().getTicketData().getSealOffDate());
		params.put("seal_on", order.getTicket().getTicketData().getSealOn());
		params.put("seal_on_date", order.getTicket().getTicketData().getSealOnDate());
		params.put("comments", order.getTicket().getTicketData().getComments());
		params.put("created_by", user.getUserId());
		try {
			return getSession().insert("OrderDAO.insertTicketData", params);
		} catch (Exception e) {
			logger.error(e);
			throw new DataAccessException(e);
		}
	}
	
	public int updateTicketData(Order order, User user) throws DataAccessException{
		Map<String, Object> params = new HashMap<>();
		params.put("tank_id", order.getTicket().getTicketData().getTank().getTankId());
		params.put("total_barrels", order.getTicket().getTicketData().getTotalBarrels());
		params.put("gravity", order.getTicket().getTicketData().getGravity());
		params.put("temperature", order.getTicket().getTicketData().getTemp());
		params.put("bsw", order.getTicket().getTicketData().getBsw());
		params.put("seal_off", order.getTicket().getTicketData().getSealOff());
		params.put("seal_off_date", order.getTicket().getTicketData().getSealOffDate());
		params.put("seal_on", order.getTicket().getTicketData().getSealOn());
		params.put("seal_on_date", order.getTicket().getTicketData().getSealOnDate());
		params.put("comments", order.getTicket().getTicketData().getComments());
		params.put("modified_by", user.getUserId());
		params.put("ticket_number", order.getTicket().getTicketNumber());
		try {
			return getSession().insert("OrderDAO.updateTicketData", params);
		} catch (Exception e) {
			logger.error(e);
			throw new DataAccessException(e);
		}
	}
	
	public int insertTicketMeterData(Order order, User user) throws DataAccessException{
		Map<String, Object> params = new HashMap<>();
		params.put("ticket_number", order.getTicket().getTicketNumber());
		params.put("meter_off", order.getTicket().getTicketData().getTicketMeterData().getMeterOff());
		params.put("meter_on", order.getTicket().getTicketData().getTicketMeterData().getMeterOn());
		params.put("created_by", user.getUserId());
		try {
			return getSession().insert("OrderDAO.insertTicketMeterData", params);
		} catch (Exception e) {
			logger.error(e);
			throw new DataAccessException(e);
		}
	}
	
	public int updateTicketMeterData(Order order, User user) throws DataAccessException{
		Map<String, Object> params = new HashMap<>();
		params.put("meter_off", order.getTicket().getTicketData().getTicketMeterData().getMeterOff());
		params.put("meter_on", order.getTicket().getTicketData().getTicketMeterData().getMeterOn());
		params.put("modified_by", user.getUserId());
		params.put("ticket_number", order.getTicket().getTicketNumber());
		try {
			return getSession().insert("OrderDAO.updateTicketMeterData", params);
		} catch (Exception e) {
			logger.error(e);
			throw new DataAccessException(e);
		}
	}
	
	public int insertTicketGaugeData(Order order, User user) throws DataAccessException{
		Map<String, Object> params = new HashMap<>();
		params.put("ticket_number", order.getTicket().getTicketNumber());
		params.put("high_temp", order.getTicket().getTicketData().getTemp());
		params.put("high_ft", order.getTicket().getTicketData().getTicketGaugeData().getHighFeet());
		params.put("hight_in", order.getTicket().getTicketData().getTicketGaugeData().getHighInches());
		params.put("high_fract", order.getTicket().getTicketData().getTicketGaugeData().getHighFract());
		params.put("low_temp", order.getTicket().getTicketData().getTemp());
		params.put("low_ft", order.getTicket().getTicketData().getTicketGaugeData().getLowFeet());
		params.put("low_in", order.getTicket().getTicketData().getTicketGaugeData().getLowInches());
		params.put("low_fract", order.getTicket().getTicketData().getTicketGaugeData().getLowFract());
		params.put("created_by", user.getUserId());
		try {
			return getSession().insert("OrderDAO.insertTicketGaugeData", params);
		} catch (Exception e) {
			logger.error(e);
			throw new DataAccessException(e);
		}
	}
	
	public int updateTicketGaugeData(Order order, User user) throws DataAccessException{
		Map<String, Object> params = new HashMap<>();
		params.put("high_temp", order.getTicket().getTicketData().getTemp());
		params.put("high_ft", order.getTicket().getTicketData().getTicketGaugeData().getHighFeet());
		params.put("hight_in", order.getTicket().getTicketData().getTicketGaugeData().getHighInches());
		params.put("high_fract", order.getTicket().getTicketData().getTicketGaugeData().getHighFract());
		params.put("low_temp", order.getTicket().getTicketData().getTemp());
		params.put("low_ft", order.getTicket().getTicketData().getTicketGaugeData().getLowFeet());
		params.put("low_in", order.getTicket().getTicketData().getTicketGaugeData().getLowInches());
		params.put("low_fract", order.getTicket().getTicketData().getTicketGaugeData().getLowFract());
		params.put("modified_by", user.getUserId());
		params.put("ticket_number", order.getTicket().getTicketNumber());
		try {
			return getSession().insert("OrderDAO.updateTicketGaugeData", params);
		} catch (Exception e) {
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
	
	public Order selectCompleteOrder(Order order) throws DataAccessException{
		Map<String, Object> params = new HashMap<>();
		params.put("order_number", order.getOrderNumber());
		try{
			order = getSession().selectOne("OrderDAO.selectCompleteOrder", params);
			return order;
		} catch (Exception e) {
			logger.error(e);
			throw new DataAccessException(e);
		}
	}
	
	public Integer getPreviousOrderNumber(Order order, Dispatch dispatch) throws DataAccessException{
		Map<String, Object> params = new HashMap<>();
		params.put("order_number", order.getOrderNumber());
		params.put("dispatch_id", dispatch.getDispatchId());
		try{
			return getSession().selectOne("OrderDAO.getPreviousOrderNumber", params);
		} catch (Exception e) {
			logger.error(e);
			throw new DataAccessException(e);
		}
	}
	
	public Integer getNextOrderNumber(Order order, Dispatch dispatch) throws DataAccessException{
		Map<String, Object> params = new HashMap<>();
		params.put("order_number", order.getOrderNumber());
		params.put("dispatch_id", dispatch.getDispatchId());
		try{
			return getSession().selectOne("OrderDAO.getNextOrderNumber", params);
		} catch (Exception e) {
			logger.error(e);
			throw new DataAccessException(e);
		}
	}
	
	public int cancelOrder(Order order) throws DataAccessException{
		Map<String, Object> params = new HashMap<>();
		params.put("order_number", order.getOrderNumber());
		try{
			return getSession().update("OrderDAO.cancelOrder", params);
		} catch(Exception e){
			logger.error(e);
			throw new DataAccessException(e);
		}
	}
	
	public OrderDTO selectPrimaryOrderForSplitLoad(OrderDTO order) throws DataAccessException{
		Map<String, Object> params = new HashMap<>();
		params.put("order_number", order.getOrderNumber());
		try{
			return getSession().selectOne("OrderDAO.selectPrimaryOrderForSplitLoad", params);
		} catch (Exception e) {
			logger.error(e);
			throw new DataAccessException(e);
		}
	}
	
	public List<OrderDTO> selectOrdersForSplitLoad(Dispatch dispatch, OrderDTO order, String filter, int first, int pageSize) throws DataAccessException{
		Map<String, Object> params = new HashMap<>();
		params.put("order_number", order.getOrderNumber());
		params.put("dispatch_id", dispatch.getDispatchId());
		params.put("filter", filter);
		params.put("first", first);
		params.put("page_size", pageSize);
		try {
			return getSession().selectList("OrderDAO.selectOrdersForSplitLoad", params);
		} catch (Exception e) {
			logger.error(e);
			throw new DataAccessException(e);
		}
	}
	
	public Integer selectOrdersForSplitLoadCount(Dispatch dispatch, OrderDTO order, String filter) throws DataAccessException{
		Map<String, Object> params = new HashMap<>();
		params.put("order_number", order.getOrderNumber());
		params.put("dispatch_id", dispatch.getDispatchId());
		params.put("filter", filter);
		try {
			return getSession().selectOne("OrderDAO.selectOrdersForSplitLoadCount", params);
		} catch (Exception e) {
			logger.error(e);
			throw new DataAccessException(e);
		}
	}
}
