package org.lanqiao.Reservation_system.dao;

import java.util.List;

import org.lanqiao.Reservation_system.domain.Food;

public interface IproductDao {

	//ͨ��SQL����ѯ�б�
	public List<Food> GetfoodList(String foodname, int i);
	
	//ͨ��SQL����ѯFood����
	public Food GetFood(String foodname);
	
}
