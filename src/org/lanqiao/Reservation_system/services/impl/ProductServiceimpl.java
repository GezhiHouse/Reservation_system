package org.lanqiao.Reservation_system.services.impl;

import java.util.List;

import org.lanqiao.Reservation_system.dao.IproductDao;
import org.lanqiao.Reservation_system.dao.impl.ProductDaoimpl;
import org.lanqiao.Reservation_system.domain.Food;
import org.lanqiao.Reservation_system.services.IproductService;

public class ProductServiceimpl implements IproductService{

	IproductDao product = new ProductDaoimpl();
	@Override
	public List<Food> getFoodList(String foodname, int i) {
		if(product.GetfoodList(foodname, i).size() != 0) {
			return product.GetfoodList(foodname, i);
		}else{
			return null;
		}	
	}
	@Override
	public Food getFood(String foodname) {
		IproductDao productdao = new ProductDaoimpl();
		productdao.GetFood(foodname);
		return productdao.GetFood(foodname);
	}

	
}
