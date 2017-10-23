package com.harvestcrude.services.dispatch.persistence.mybatis;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.harvestcrude.common.persistence.mybatis.DataAccessException;
import com.harvestcrude.model.dispatch.Dispatch;

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
}
