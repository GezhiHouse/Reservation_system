package org.lanqiao.Reservation_system.tools;


import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;

public class JDBCUtils {
	public static final String DRIVER_CLASS_NAME = "oracle.jdbc.driver.OracleDriver";
	public static final String URL = "jdbc:oracle:thin:@WIN-JENFKJ6I39H:1521:orcl";
	public static final String USERNAME = "re_sys";
	public static final String PASSWORD = "admin";
	
	private static final int MAX_IDLE = 3;
	private static final long MAX_WAIT = 5000;
	private static final int MAX_ACTIVE = 5;
	private static final int INITIAL_SIZE = 10;
	
	private static BasicDataSource dataSource = new BasicDataSource();
	static {
		dataSource.setDriverClassName(DRIVER_CLASS_NAME);
		dataSource.setUrl(URL);
		dataSource.setUsername(USERNAME);
		dataSource.setPassword(PASSWORD);
			
		dataSource.setMaxActive(MAX_IDLE);
		dataSource.setMaxWait(MAX_WAIT);
		dataSource.setMaxActive(MAX_ACTIVE);
		dataSource.setInitialSize(INITIAL_SIZE);
	}
	
	public static DataSource getDataSource() {
		return dataSource;
	}
}

