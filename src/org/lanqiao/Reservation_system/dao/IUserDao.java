package org.lanqiao.Reservation_system.dao;

import org.lanqiao.Reservation_system.domain.User;

public interface IUserDao {

	//返回是否查询到用户信息
	public  boolean findUser(String username) ;
	
	//根据用户名和密码查询 返回是否查到用户
	public User findUser(String username, String password);
	
	//
	//public List<User> findUser();
	//注册用户
	public Boolean insertUser(String username, String password) ;
	
	//通过用户名查询用户信息
	public User findUserinfo(String username);
	
	//修改用户信息
	public boolean update(String username,String Alterusername, String Alterpassword, String Altertel, String Alteraddress);
}
