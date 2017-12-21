package com.harvestcrude.services.ticket.persistence.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.harvestcrude.common.persistence.mybatis.DataAccessException;
import com.harvestcrude.model.ticket.TicketType;

public class TicketTypeDAO {
	private static final Logger logger = Logger.getLogger(TicketTypeDAO.class);
	
	private SqlSession session;	
	
	public TicketTypeDAO(SqlSession session){
		this.session = session;
	}

	public SqlSession getSession() {
		return session;
	}
	
	public List<TicketType> getAllTicketType() throws DataAccessException{
		try{
			return getSession().selectList("TicketTypeDAO.getAllTicketTypes");
		} catch(Exception e){
			logger.error(e);
			throw new DataAccessException(e);
		}
	}
}
