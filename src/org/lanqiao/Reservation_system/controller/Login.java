package org.lanqiao.Reservation_system.controller;


import org.lanqiao.Reservation_system.domain.User;
import org.lanqiao.Reservation_system.services.impl.UserServiceimpl;
import org.lanqiao.Reservation_system.views.AbstractLogin;
import org.lanqiao.Reservation_system.views.HintError;
import org.lanqiao.Reservation_system.views.HintSucceed;

public class Login extends AbstractLogin{
	private String username;
	private String password;
	//µÇÂ¼ÊÂ¼þ
	@Override
	public void login() {
		username = usernameTextField.getText();
		password = PasswordField.getText();
		UserServiceimpl userService = new UserServiceimpl();
		if(userService.login(username, password) && Captcha() ) {
			HintSucceed hintSucceed = new HintSucceed(username);
			super.setVisible(false);
		}else {
			if(Captcha()) {
				HintError  hintError = new HintError();
			}else {
				showRegisterError();
			}
		}
	}

	@Override
	public boolean Register() {
		
		return false;
	}

	@Override
	protected boolean Captcha() {
		if(captchaTextField.getText().equals(null) ||captchaStr.equalsIgnoreCase(captchaTextField.getText()) || captchaTextField.getText().equals("")) {
    		return true;
    	}else {
    		return false;
    	}
		
	}
}
