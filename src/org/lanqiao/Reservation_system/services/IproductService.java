package org.lanqiao.Reservation_system.services;

import java.util.List;

import org.lanqiao.Reservation_system.domain.Food;

public interface IproductService {

	public List<Food> getFoodList(String foodname, int i);
	
	public Food getFood(String foodname);
}
