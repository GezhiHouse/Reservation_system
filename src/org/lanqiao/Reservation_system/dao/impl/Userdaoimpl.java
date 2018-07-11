package org.lanqiao.Reservation_system.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.lanqiao.Reservation_system.dao.IUserDao;
import org.lanqiao.Reservation_system.domain.User;
import org.lanqiao.Reservation_system.tools.JDBCUtils;

public class Userdaoimpl  implements IUserDao{

	private DataSource dataSource = JDBCUtils.getDataSource();
	private Connection conn = null;
	private ResultSet res = null;
	private PreparedStatement pstmt = null;
	
	//获得连接
	public void getconnction() {
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//关闭连接
	public boolean closeResouce() {
		try {
			if(res != null) {
				res.close();
			}
			if(pstmt != null) {
				pstmt.close();
			}
			if(conn !=null) {
				conn.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	//查询是否存在用户
	@Override
	public boolean findUser(String username) {
		getconnction();
		String sql = "SELECT * from USER_RE where USERNAMe  = ?";
		String user = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			res = pstmt.executeQuery();
			while(res.next()) {
				user = res.getString(1);
			}
			closeResouce();
		} catch (SQLException e) {
			
		}
		if(user != null) {
			return true;
		}else {
			return false;
		}
	}

	//
	@Override
	public User findUser(String username, String password) {
		User user = null;
		getconnction();
		String sql = "SELECT * from USER_RE where USERNAMe  = ? and PASSWORD = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			res = pstmt.executeQuery();
			while(res.next()) {
				user = new User();
				user.setUsername(res.getString(1));
				user.setPassword(res.getString(2));
			}
			closeResouce();
			return user;
		} catch (SQLException e) {
			
			return user;
		}
	}

	@Override
	public Boolean insertUser(String username, String password) {
		getconnction();
		String sql = "INSERT INTO USER_RE(USERNAME, PASSWORD) VALUES(?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.execute();
			closeResouce();
			return true;
		} catch (SQLException e) {
			
			return false;
		}
	}

	@Override
	public User findUserinfo(String username) {
		User user = null;
		getconnction();
		String sql = "SELECT * from USER_RE where USERNAMe  = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			res = pstmt.executeQuery();
			while(res.next()) {
				user = new User();
				user.setUsername(res.getString(1));
				user.setPassword(res.getString(2));
				user.setTel(res.getString(3));
				user.setAddress(res.getString(4));
			}
			closeResouce();
			return user;
		} catch (SQLException e) {
			
			return user;
		}
	}

	@Override
	public boolean update(String username, String Alterusername, String Alterpassword, String Altertel, String Alteraddress) {
		getconnction();
		String sql = "UPDATE USER_RE SET USERNAME = ?, \"PASSWORD\" = ?, \"tel\" = ?, \"address\" = ? where USERNAME = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(5, username);
			pstmt.setString(1, Alterusername);
			pstmt.setString(2, Alterpassword);
			pstmt.setString(3, Altertel);
			pstmt.setString(4, Alteraddress);
			 pstmt.executeQuery();
			closeResouce();
			return true;
		} catch (SQLException e) {
			
			return false;
		}
	}

}
