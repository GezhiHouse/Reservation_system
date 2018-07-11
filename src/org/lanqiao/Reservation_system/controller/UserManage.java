package org.lanqiao.Reservation_system.controller;

import javax.swing.JFrame;

import org.lanqiao.Reservation_system.domain.User;
import org.lanqiao.Reservation_system.services.IUserService;
import org.lanqiao.Reservation_system.services.impl.UserServiceimpl;
import org.lanqiao.Reservation_system.tools.Tel_verify;
import org.lanqiao.Reservation_system.views.AbstractUserManage;
import org.lanqiao.Reservation_system.views.AlterError;
import org.lanqiao.Reservation_system.views.AlterSucceed;

public class UserManage extends AbstractUserManage{
	private String username;
	public UserManage(String username) {
		super(username);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void showUserInfo() {
		IUserService userservice = new UserServiceimpl();
		User user = null;
		username = super.username;
		user = userservice.UserAllInfo(username);
		UserNameShowLabel.setText("姓名：" + user.getUsername());
		UsertelShowLabel.setText("电话：" + user.getTel());
		System.out.println(user.getTel());
		UseraddressShowLabel.setText("地址：" + user.getAddress());
	}

	@Override
	public void showUser() {
		IUserService userservice = new UserServiceimpl();
		boolean flag = false;
		flag = userservice.AlterUser(username, UserNameAlterField.getText(), UserpasswordAlterField.getText(), UsertelAlterField.getText(), UseraddressAlterField.getText());
		if(flag) {
			AlterSucceed alterSucceed = new AlterSucceed();
			super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}else {
			AlterError alterError = new AlterError();
		}
	}

	@Override
	public void verity_tel() {
		String tel = UsertelAlterField.getText();
		if(UsertelAlterField.getText().equals("") || UsertelAlterField.getText().equals(null) || Tel_verify.isMobile(tel) || Tel_verify.isPhone(tel)) {
			hintLabel.setVisible(false);
		}else {
			hintLabel.setVisible(true);
		}
		
	}
	
	
}
