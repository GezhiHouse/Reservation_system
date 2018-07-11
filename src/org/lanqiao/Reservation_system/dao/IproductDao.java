package org.lanqiao.Reservation_system.dao;

import java.util.List;

import org.lanqiao.Reservation_system.domain.Food;

public interface IproductDao {

	//通过SQL语句查询列表
	public List<Food> GetfoodList(String foodname, int i);
	
	//通过SQL语句查询Food对象
	public Food GetFood(String foodname);
	
}
