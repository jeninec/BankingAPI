package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnect {

	private static Connection conn = null;

	public static Connection getConnection() {
		/* 
		 * To establish a connection we need 3 credentials:
		 * url (end point), user name, password
		 */
		if (conn == null) {
			// establish connection
			String endpoint = "jenine-db-postgres.cheon2hs9vmf.us-east-2.rds.amazonaws.com";
			
			String url = "jdbc:postgresql://" + endpoint + "/postgres";
			String username = "cjenine";
			String pwd = "myPassword223";

			//return established connection
			try {
				conn = DriverManager.getConnection(url, username, pwd);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return conn;
	}
	
	/*
	 * FOR TESTING PURPOSES ONLY
	 * 
	 */
	
	public static void main(String[] args) {
		Connection conn1 = getConnection();
		
		System.out.println(conn1);
	}
	
}
