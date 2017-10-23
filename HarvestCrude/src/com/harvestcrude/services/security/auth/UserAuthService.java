package com.harvestcrude.services.security.auth;

import org.apache.log4j.Logger;

import com.harvestcrude.common.persistence.mybatis.MyBatisConnectionFactory;
import com.harvestcrude.services.security.user.persistence.mybatis.UserAccountDAO;

public class UserAuthService {
	private static final Logger logger = Logger.getLogger(UserAuthService.class);
	
	public void getUserAccount(){
		try{
			UserAccountDAO userAccountDAO = new UserAccountDAO(MyBatisConnectionFactory.getSqlSessionFactory());
			String abc = userAccountDAO.getUserAccount();
			System.out.println(abc);
		} catch (Exception e) {
			logger.error(e);
		}		
	}

}
