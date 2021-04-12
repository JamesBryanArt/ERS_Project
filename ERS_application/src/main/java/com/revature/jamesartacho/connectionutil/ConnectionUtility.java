package com.revature.jamesartacho.connectionutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtility {
public static Connection getConnection() throws SQLException {
		
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String user = "bryan";
		String pss = "idkpass";
		
		return DriverManager.getConnection(url,user,pss);
	}
}
