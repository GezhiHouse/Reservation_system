package org.lanqiao.Reservation_system.controller;

import javax.swing.ImageIcon;

import org.lanqiao.Reservation_system.domain.Food;
import org.lanqiao.Reservation_system.domain.User;
import org.lanqiao.Reservation_system.services.IUserService;
import org.lanqiao.Reservation_system.services.IproductService;
import org.lanqiao.Reservation_system.services.impl.ProductServiceimpl;
import org.lanqiao.Reservation_system.services.impl.UserServiceimpl;
import org.lanqiao.Reservation_system.views.AbstractPay;
import org.lanqiao.Reservation_system.views.HintUserInfo;

public class Pay extends AbstractPay{

	public Pay(String foodname, String username) {
		super(foodname, username);
		// TODO Auto-generated constructor stub
	}

	//private String foodName;
	String foodaddress = "E:\\JAVA\\eclipsework\\Reservation_system\\Foodimgs";
	private Food food = new Food();
	

	@Override
	public void showfoodInfo() {
		IproductService productService = new ProductServiceimpl();
		food = productService.getFood(super.foodName);
		String foodaddress = "E:\\JAVA\\eclipsework\\Reservation_system\\Foodimgs\\";
		FoodimgLabel.setIcon(new ImageIcon(foodaddress + food.getF_PIC()));
		FoodNameLabel.setText(foodName);
		FoodPriceLabel.setText(food.getF_SAL()+ "元/份");
		introtextArea.setText(food.getF_INTRO());
		UserpayLabel.setText("应付款：" + food.getF_SAL() + "元");
	}

	@Override
	public void showuserInfo() {
		IUserService userService = new UserServiceimpl();
		User user = new User();
		UsernameLabel.setText("姓      名：" + username);
		user = userService.UserAllInfo(username);
		UsersiteLabel.setText("地   址：" + user.getAddress());
		UserTelLabel.setText("联系方式：" + user.getTel());
	}

	@Override
	public void verityuserInfo() {
		IUserService userService = new UserServiceimpl();
		User user = new User();
		user = userService.UserAllInfo(username);
		if((user.getAddress()== null || user.getAddress().equals("")) || (user.getTel()==null || user.getTel().equals(""))) {
			HintUserInfo hintUserInfo = new HintUserInfo(username);
		}
		
	}
	

}
