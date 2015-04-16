package com.qapro.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface SqlRowMapper<T>  {

	public  T  mapSqlToObject(ResultSet resultSet) throws SQLException;
	
	
}
