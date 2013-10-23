package com.benjiaren.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.benjiaren.bean.User;
import com.benjiaren.util.DBConn;

public class UserDAO {
	private Connection conn;
	private PreparedStatement ptst;
	private ResultSet rs;
	
	public User getUserName(String name) {
		conn = DBConn.getConnect();
		User user = new User();
		try{
			ptst = conn.prepareStatement("select * from user");
			rs = ptst.executeQuery();
			while(rs.next()){
				
			}
		}catch (SQLException e) {
			// TODO: handle exception
		}
		return user;
	}
	
}
