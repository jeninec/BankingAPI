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
			// add your actual db url as endpoint
			String endpoint = "db url";
			
			String url = "jdbc:postgresql://" + endpoint + "/postgres";
			// add your actual username
			String username = "username";
			//add your actual password
			String pwd = "password";

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
