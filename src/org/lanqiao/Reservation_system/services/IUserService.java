package org.lanqiao.Reservation_system.services;

import org.lanqiao.Reservation_system.domain.User;

public interface IUserService {

	//登录用户，并得到用户是否查询成功
	public boolean login(String username, String password);
	
	//注册用户，并得到是否注册成功
	public boolean register(String username, String password);
	
	//查询是否已存在用户
	public boolean registerFindUser(String username);
	
	//通过用户名查询用户返回用户的信息
	public User UserAllInfo(String username);
	
	//修改用户信息
	public boolean AlterUser(String username, String Alterusername, String Alterpassword, String Altertel, String Alteraddress);
}
