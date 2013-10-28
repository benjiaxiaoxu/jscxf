package com.benjiaren.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.benjiaren.bean.Comments;
import com.benjiaren.util.DBConn;
import com.benjiaren.util.SQLDATE;

public class CommentsDAO {
	private Connection conn;
	private PreparedStatement ptst;
	private ResultSet rs;
	
	public List<Comments> getCommentsByUsernameANDJiongshiId(String username,long jiongshiid){
		conn = DBConn.getConnect();
		List<Comments> list = new ArrayList<Comments>();
		
		try{
			ptst = conn.prepareStatement("select created_at,ofcommentid,text,source,username,jiongshiid,reply_comment from ofcomments where username = ? and jiongshiid = ?");
			
			ptst.setString(1, username);
			ptst.setInt(2, (int) jiongshiid);
			rs = ptst.executeQuery();
			while(rs.next()){
				Comments comm = new Comments();
				comm.setCreated_at(SQLDATE.sqlto(rs.getDate("created_at")));
				comm.setId(rs.getLong("ofcommentid"));
				comm.setJiongshiId(rs.getInt("jiongshiid"));
				comm.setText(rs.getString("text"));
				comm.setSource(rs.getString("source"));
				comm.setUsername(rs.getString("username"));
				comm.setReply_comment(rs.getString("reply_comment"));
				list.add(comm);
			}
		}catch (SQLException e) {
			// TODO: handle exception
		}finally{
			this.close();
		}
		
		return list;
	}
	
	public void insertComment(Comments comm){
		conn = DBConn.getConnect();
		try{
			String sql = "insert into ofcomments(created_at,text,source,username,jiongshiid,reply_comment) value(?,?,?,?,?,?)";
			
			ptst = conn.prepareStatement(sql);
			ptst.setDate(1, SQLDATE.tosql(comm.getCreated_at()));
			ptst.setString(2, comm.getText());
			ptst.setString(3, comm.getSource());
			ptst.setString(4, comm.getUsername());
			ptst.setInt(5, comm.getJiongshiId());
			ptst.setString(6, comm.getReply_comment());
			ptst.executeUpdate();
			
		}catch(SQLException e){
			
		}finally {
			this.close();
		}
	}
	
	
	public void close(){
		try{
			if(rs != null){
				rs.close();
			}
			if(ptst != null){
				ptst.close();
			}
			if(conn != null){
				conn.close();
			}
		}catch(final SQLException e){
			e.printStackTrace();
		}
		
	}
}
