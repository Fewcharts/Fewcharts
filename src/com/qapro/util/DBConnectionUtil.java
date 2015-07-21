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

		Properties prop = new Properties();
		InputStream input = null;

		if (dataSource == null) {
			try {
				input = new FileInputStream(
						System.getProperty("fewcharts.config.path")
								+ File.separator + "config.properties");
				prop.load(input);

				dataSource = new ComboPooledDataSource();
				dataSource.setDriverClass(prop.getProperty("database.driver"));
				dataSource.setJdbcUrl(prop
						.getProperty("database.connectionURL"));
				dataSource.setUser(prop.getProperty("database.user"));
				dataSource.setPassword(prop.getProperty("database.password"));

				dataSource.setMaxIdleTime(180);

				dataSource.setMinPoolSize(1);
				dataSource.setMaxPoolSize(16);

			} catch (IOException ex) {
				ex.printStackTrace();
			} finally {
				if (input != null) {
					try {
						input.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}

	}
	return dataSource;
    }

    public static Connection getConnection() throws SQLException,
	    PropertyVetoException {

	return getInstance().getConnection();
    }

}