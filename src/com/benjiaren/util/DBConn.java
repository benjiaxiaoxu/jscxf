package com.benjiaren.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
	
	public static Connection getConnect() {
	    String driver = "com.mysql.jdbc.Driver";
	    String url = "jdbc:mysql://127.0.0.1:3306/openfire??useUnicode=true&characterEncoding=utf8";
	    String user = "root"; 
	    String password = "root";
	    try {
			Class.forName(driver);
		    Connection conn = DriverManager.getConnection(url,user,password);
		    return conn;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return null;
	}

	public static void main(String[] args) {
		DBConn.getConnect();
	}
   
}
