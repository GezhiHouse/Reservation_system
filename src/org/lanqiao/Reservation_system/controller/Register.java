package org.lanqiao.Reservation_system.controller;

import org.lanqiao.Reservation_system.services.IUserService;
import org.lanqiao.Reservation_system.services.impl.UserServiceimpl;
import org.lanqiao.Reservation_system.views.AbstractRegister;
import org.lanqiao.Reservation_system.views.RegisterError;
import org.lanqiao.Reservation_system.views.RegisterSucceed;

public class Register extends AbstractRegister{

	private String username;
	private String password;
	private String repassword;
	private boolean tos;
	
	@Override
	public void register() {
		username = usernameTextField.getText();
		password = passwordField.getText();
		repassword = rePasswordField.getText();
		tos = tosSelect.isSelected();
		IUserService userservice = new UserServiceimpl();
		
		if(tos) {
			if(repassword.equals(password)) {
				if(password !=null && !password.equals("")) {
					if(userservice.registerFindUser(username)) {
						RegisterError registerError = new RegisterError();
					}else {
						userservice.register(username, password);
						RegisterSucceed regiseterSucceed = new RegisterSucceed(username);
						super.setVisible(false);
					}
				}
			}else {
				verifyPasswordLable.setText("ÃÜÂë²»Ò»ÖÂ£¡");
			}
		}
		
	}
	@Override
	public void reset() {
		usernameTextField.setText(null);
		passwordField.setText(null);
		rePasswordField.setText(null);
	}
	
}
