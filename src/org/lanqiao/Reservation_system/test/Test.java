package org.lanqiao.Reservation_system.test;

import org.lanqiao.Reservation_system.controller.Order_food;
import org.lanqiao.Reservation_system.controller.UserManage;
import org.lanqiao.Reservation_system.dao.IUserDao;
import org.lanqiao.Reservation_system.dao.impl.Userdaoimpl;
import org.lanqiao.Reservation_system.domain.User;
import org.lanqiao.Reservation_system.views.AbstractOrder_food;
import org.lanqiao.Reservation_system.views.AbstractUserManage;
import org.lanqiao.Reservation_system.views.HintUserInfo;

public class Test {

	public static void main(String[] args) {
		AbstractOrder_food ab = new Order_food("admin");
		
		//ZhifubaoPay z = new ZhifubaoPay();
		//HintUserInfo h = new HintUserInfo("admin");
		//AbstractUserManage um = new  UserManage("admin");
		
		/*IUserDao u = new Userdaoimpl();
		System.out.println(u.findUserinfo("admin111"));*/
		//IUserDao u = new Userdaoimpl();
		//u.update("李四", "王五", "12345", "9876543210", "fasfasf");
	}
}