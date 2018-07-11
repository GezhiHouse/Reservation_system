package org.lanqiao.Reservation_system.services.impl;

import org.lanqiao.Reservation_system.dao.IUserDao;
import org.lanqiao.Reservation_system.dao.impl.Userdaoimpl;
import org.lanqiao.Reservation_system.domain.User;
import org.lanqiao.Reservation_system.services.IUserService;
import org.lanqiao.Reservation_system.tools.MD5Util;

public class UserServiceimpl implements IUserService{
	private 	User user = new User();
	private static IUserDao userdao = new Userdaoimpl();
	
	//登录用户
	public boolean login(String username, String password) {
		Boolean flog = false;
		MD5Util md5 = new MD5Util();
		String md5Password = md5.crypt(password);
		User user = userdao.findUser(username, md5Password);
		if(user != null) {
			flog = true;
			return flog;
		}
		return flog;
	}

	//注册用户
	@Override
	public boolean register(String username, String password) {
		IUserDao userdao = new Userdaoimpl();
		MD5Util md5 = new MD5Util();
		String md5Password = md5.crypt(password);
		boolean flog = userdao.insertUser(username, md5Password);
		return flog;
	}

	//注册时，查询用户是否已经存在
	@Override
	public boolean registerFindUser(String username) {
		boolean flog = userdao.findUser(username);
		return flog;
	}

	@Override
	public User UserAllInfo(String username) {
		User user = new User();
		user = userdao.findUserinfo(username);
		return user;
	}

	@Override
	public boolean AlterUser(String username, String Alterusername, String Alterpassword, String Altertel,
			String Alteraddress) {
		MD5Util md5 = new MD5Util();
		String md5Password = md5.crypt(Alterpassword);
		return userdao.update(username, Alterusername, md5Password, Altertel, Alteraddress);
	}
	
	
	
}
