package org.lanqiao.Reservation_system.controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import org.lanqiao.Reservation_system.domain.Food;
import org.lanqiao.Reservation_system.services.IproductService;
import org.lanqiao.Reservation_system.services.impl.ProductServiceimpl;
import org.lanqiao.Reservation_system.views.AbstractOrder_food;

public class Order_food extends AbstractOrder_food{
	private IproductService productService = new ProductServiceimpl();
	private int pageflag;

	public Order_food(String username) {
		super(username);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sortscreen(String foodname,int i) {
		String F_PIC_position = "E:\\JAVA\\eclipsework\\Reservation_system\\Foodimgs\\";
		List<Food> listfood = new ArrayList<>();
		listfood = productService.getFoodList(foodname, i);	
		if(listfood != null) {
			this.pageflag = super.pageflag;
			if(listfood.size() == 2) {
				ImageIcon butimg1 = new ImageIcon(F_PIC_position +listfood.get(0).getF_PIC());
				ImageIcon butimg2 = new ImageIcon(F_PIC_position + listfood.get(1).getF_PIC());
				showMeunButton1.setIcon(butimg1);
				showMeunButton2.setIcon(butimg2);
				showMeunNameButton1.setText(listfood.get(0).getF_NAME());
				showMeunNameButton2.setText(listfood.get(1).getF_NAME());
			}else if(listfood.size() == 1) {
				ImageIcon butimg1 = new ImageIcon(F_PIC_position + listfood.get(0).getF_PIC());
				ImageIcon butimg2 = new ImageIcon();
				showMeunButton1.setIcon(butimg1);
				showMeunButton2.setIcon(butimg2);
				showMeunNameButton1.setText(listfood.get(0).getF_NAME());
				showMeunNameButton2.setText("");
			}
		}else {
			showMeunButton1.setIcon(null);
			showMeunButton2.setIcon(null);
			showMeunNameButton1.setText("нч");
			showMeunNameButton2.setText("нч");
			super.pageflag = this.pageflag;
		}
	}
}
