package com.qapro.util;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBConnectionUtil {
	
	private static ComboPooledDataSource dataSource;
	
	private static ComboPooledDataSource getInstance() throws PropertyVetoException
	{
	
		if(dataSource == null){			
			
			dataSource = new ComboPooledDataSource();
			dataSource.setDriverClass("com.mysql.jdbc.Driver");
			dataSource.setJdbcUrl("jdbc:mysql://us-cdbr-iron-east-02.cleardb.net/heroku_f7be13520b27e62?autoReconnect=true");
			dataSource.setUser("bdff44960ec18e");
			dataSource.setPassword("d5eb5e39");
			
			dataSource.setMaxIdleTime(180);
		
			dataSource.setMinPoolSize(1);
			dataSource.setMaxPoolSize(16);
			
		}
		return dataSource;
	}
	
	
	public static Connection getConnection() throws SQLException, PropertyVetoException{
		
		return getInstance().getConnection();
	}

}
