package com.harvestcrude.common.persistence.mybatis;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

public final class MyBatisConnectionFactory {
	private static final Logger logger = Logger.getLogger(MyBatisConnectionFactory.class);
	
	private static SqlSessionFactory sqlSessionFactory;
	
	private static synchronized void getMyBatisConfig() throws IOException, FileNotFoundException{
		try{
			String resource = "com/harvestcrude/persistence/mybatis/mybatis-config.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			
		} catch (FileNotFoundException e) {
			logger.error(e);
			throw e;
		} catch (IOException e){
			logger.error(e);
			throw e;
		}
		
	}

	public static SqlSessionFactory getSqlSessionFactory() throws IOException, FileNotFoundException{
		if(sqlSessionFactory == null){
			getMyBatisConfig();
		}
		return sqlSessionFactory;
	}	

}
