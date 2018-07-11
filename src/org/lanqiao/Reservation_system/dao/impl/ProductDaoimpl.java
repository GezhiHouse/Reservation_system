package org.lanqiao.Reservation_system.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.lanqiao.Reservation_system.dao.IproductDao;
import org.lanqiao.Reservation_system.domain.Food;
import org.lanqiao.Reservation_system.tools.JDBCUtils;


public class ProductDaoimpl implements IproductDao{

	private Food food = new Food();
	
	private DataSource dataSource = JDBCUtils.getDataSource();
	private QueryRunner qr = new QueryRunner(dataSource);
	private List<Food> foodlist = null;

	@Override
	public List<Food> GetfoodList(String foodname, int i) {
		foodlist = new ArrayList<>();
		String sql = "SELECT * FROM (SELECT ROWNUM AS rowno, F.* FROM \"FoodInfo\" F WHERE F_KIND LIKE '%"+ foodname +"%' OR F_NAME LIKE '%" + foodname + "%')table_alias WHERE table_alias.rowno >" +i  * 2+" AND " +(i + 1) * 2 +">= table_alias.rowno";
		try {
			foodlist = qr.query(sql, new BeanListHandler<Food>(Food.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return foodlist;
	}

	@Override
	public Food GetFood(String foodname) {
		Food food = null;
		String sql = "select * from \"FoodInfo\" WHERE F_NAME = ?";
		try {
			food = new Food();
			food = qr.query(sql, new BeanHandler<Food>(Food.class),foodname);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return food;
	}
	
	
}
