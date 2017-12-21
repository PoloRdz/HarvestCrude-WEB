package com.harvestcrude.services.ticket;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.harvestcrude.common.persistence.mybatis.DataAccessException;
import com.harvestcrude.common.persistence.mybatis.MyBatisConnectionFactory;
import com.harvestcrude.model.ticket.TicketType;
import com.harvestcrude.services.ticket.persistence.mybatis.TicketTypeDAO;

public class TicketTypeService {
	public static final Logger logger = Logger.getLogger(TicketTypeService.class);
	
	public List<TicketType> getAllTicketTypes(){
		SqlSession session = null;
		TicketTypeDAO ticketTypeDAO = null;
		try{
			session = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
			ticketTypeDAO = new TicketTypeDAO(session);
			return ticketTypeDAO.getAllTicketType();
		} catch (IOException | DataAccessException e){
			logger.error(e);
			return Collections.emptyList();
		} finally{
			if(session != null){
				session.close();
			}
		}
	}

}
