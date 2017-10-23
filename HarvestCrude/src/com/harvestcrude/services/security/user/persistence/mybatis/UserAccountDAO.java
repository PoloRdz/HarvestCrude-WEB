package com.harvestcrude.services.security.user.persistence.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

public class UserAccountDAO { 
	private static final Logger logger = Logger.getLogger(UserAccountDAO.class);
	
	private SqlSessionFactory sqlSessionFactory = null;
	
	public UserAccountDAO(SqlSessionFactory sqlSessionFactory){
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	public String getUserAccount(){
		SqlSession session = sqlSessionFactory.openSession();
		
		try{
			return session.selectOne("UserAccount.getUserAccountByUsername");
		} catch (Exception e) {
			logger.error(e);
			throw e;
		} finally{
			if(session != null){
				session.close();
			}
		}
	}

}
