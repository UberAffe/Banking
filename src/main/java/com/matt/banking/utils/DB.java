package com.matt.banking.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DB {
	private static Connection conn;
	public static boolean isTestCase=false;
	
	public static Connection getConnection() throws SQLException {
		if(conn==null) {
			try {
				String[] info = Secrets.liveLinks;
				if(isTestCase) {
					info=Secrets.testLinks;
				}
				Class.forName("org.postgresql.Driver");
				conn = DriverManager.getConnection(info[0], info[1], info[2]);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return conn;
	}
	@Override
	public void finalize() throws Throwable {
		super.finalize();
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
