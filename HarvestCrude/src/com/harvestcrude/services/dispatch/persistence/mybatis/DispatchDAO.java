package com.harvestcrude.services.dispatch.persistence.mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.harvestcrude.common.persistence.mybatis.DataAccessException;
import com.harvestcrude.model.dispatch.Dispatch;
import com.harvestcrude.model.dispatch.DTO.DispatchDTO;
import com.harvestcrude.model.order.Order;

public class DispatchDAO {
	private static final Logger logger = Logger.getLogger(DispatchDAO.class);
	
	private SqlSession session;
	
	public DispatchDAO(SqlSession session){
		this.session = session;
	}
	
	public SqlSession getSession() {
		return session;
	}
	
	public Dispatch getDispatchById(Dispatch dispatch) throws DataAccessException{
		Map<String, Object> params = new HashMap<>();
		params.put("dispatch_id", dispatch.getDispatchId());
		try{
			return getSession().selectOne("DispatchDAO.getDispatchById", params);
		} catch(Exception e){
			logger.error(e);
			throw new DataAccessException(e);
		}
	}
	
	public List<DispatchDTO> searchAllDispatch(String filter, int first, int pageSize) throws DataAccessException{
		Map<String, Object> params = new HashMap<>();
		params.put("filter", filter);
		params.put("first", first);
		params.put("page_size", pageSize);
		try {
			return getSession().selectList("DispatchDAO.searchAllDispatch", params);
		} catch (Exception e) {
			logger.error(e);
			throw new DataAccessException(e);
		}
	}
	
	public int searchAllDispatchCount(String filter) throws DataAccessException{
		Map<String, Object> params = new HashMap<>();
		params.put("filter", filter);
		try {
			return getSession().selectOne("DispatchDAO.searchAllDispatchCount");
		} catch (Exception e) {
			logger.error(e);
			throw new DataAccessException(e);
		}
	}
	
	public Dispatch getOrderCurrentDispatch(Order order) throws DataAccessException{
		Map<String, Object> params = new HashMap<>();
		params.put("order_number", order.getOrderNumber());
		try{
			return getSession().selectOne("DispatchDAO.getOrderCurrentDispatch", params);
		} catch (Exception e) {
			logger.error(e);
			throw new DataAccessException(e);
		}
	}
}
