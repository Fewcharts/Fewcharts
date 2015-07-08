package com.qapro.util;

import java.beans.PropertyVetoException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBConnectionUtil {

    private static ComboPooledDataSource dataSource;

    private static ComboPooledDataSource getInstance()
	    throws PropertyVetoException {

        

	if (dataSource == null) {
	    try {
		
		dataSource = new ComboPooledDataSource();
		dataSource.setDriverClass(System.getenv().get("DATABASE_DRIVER"));
		dataSource
			.setJdbcUrl(System.getenv().get("DATABASE_CONNECTION_URL"));
		dataSource.setUser(System.getenv().get("DATABASE_USER"));
		dataSource.setPassword(System.getenv().get("DATABASE_PASSWORD"));

		dataSource.setMaxIdleTime(180);

		dataSource.setMinPoolSize(1);
		dataSource.setMaxPoolSize(16);

	    } catch (Exception ex) {
		ex.printStackTrace();
	    } 
	}
	return dataSource;
    }

    public static Connection getConnection() throws SQLException,
	    PropertyVetoException {

	return getInstance().getConnection();
    }

}
