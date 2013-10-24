package com.benjiaren.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.benjiaren.bean.Geo;
import com.benjiaren.bean.JiongShi;
import com.benjiaren.bean.User;
import com.benjiaren.util.DBConn;
import com.benjiaren.util.Null;
import com.benjiaren.util.SQLDATE;
/**
 * table = ofjiongshi
 * @author Administrator
 *
 */
public class JiongShiDAO {
	private Connection conn;
	private PreparedStatement ptst;
	private ResultSet rs;
	public List<JiongShi> getAllJiongshi(){
		conn = DBConn.getConnect();
		List<JiongShi> list = new ArrayList<JiongShi>();
		try{
			ptst = conn.prepareStatement("select jsid,created_at,text,a.username,longitude,latitude," +
					"reposts_count,comments_count,attitudes_count,mievel,pic_urls,email from ofjiongshi a , ofuser b where a.username = b.username");
			rs = ptst.executeQuery();
			while(rs.next()){
				JiongShi js = new JiongShi();
				js.setId(rs.getInt("jsid"));
				js.setCreated_at(rs.getDate("created_at"));
				js.setText(rs.getString("text"));
				User user = new User();
				user.setName(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				js.setUser(user);
				Geo geo = new Geo();
				geo.setLongitude(rs.getString("longitude"));
				geo.setLatitude(rs.getString("latitude"));
				js.setGeo(geo);
				js.setReposts_count(rs.getInt("reposts_count"));
				js.setComments_count(rs.getInt("comments_count"));
				js.setAttitudes_count(rs.getInt("attitudes_count"));
				js.setMievel(rs.getInt("mievel"));
				String tem = rs.getString("pic_urls");
				
				String[] tems = tem.split(",");
				
				List<String> tt = new ArrayList<String>();
				for(int i = 0 ; i < tems.length ; i++){
					tt.add(tems[i]);
				}
				System.out.println(tt.size());
				js.setPic_urls(tt);
				list.add(js);
			}
		}catch (SQLException e) {
			// TODO: handle exception
		}finally{
			this.close();
		}
		
		return list;
	}
	
	public void insertJiongShi(JiongShi jiongshi){
		conn = DBConn.getConnect();
		try{
			String sql = "insert into ofjiongshi(created_at,text,username,longitude,latitude," +
					"reposts_count,comments_count,attitudes_count,mievel,pic_urls) value(?,?,?,?,?,?,?,?,?,?)";
			ptst = conn.prepareStatement(sql);
			ptst.setDate(1, SQLDATE.tosql(jiongshi.getCreated_at()));
			ptst.setString(2, Null.toNull(jiongshi.getText()));
			ptst.setString(3, Null.toNull(jiongshi.getUser().getName()));
			ptst.setString(4, Null.toNull(jiongshi.getGeo().getLongitude()));
			ptst.setString(5, Null.toNull(jiongshi.getGeo().getLatitude()));
			ptst.setInt(6, jiongshi.getReposts_count());
			ptst.setInt(7, jiongshi.getComments_count());
			ptst.setInt(8,jiongshi.getAttitudes_count());
			ptst.setInt(9, jiongshi.getMievel());
			StringBuffer sb = new StringBuffer();
			for(String s : jiongshi.getPic_urls()){
				sb.append(s);
				sb.append(",");
			}
			ptst.setString(10, Null.toNull(sb.toString()));
		    ptst.executeUpdate();
			//int a = ptst.getResultSetHoldability();
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
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
