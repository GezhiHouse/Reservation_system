package org.lanqiao.Reservation_system.dao;

import org.lanqiao.Reservation_system.domain.User;

public interface IUserDao {

	//�����Ƿ��ѯ���û���Ϣ
	public  boolean findUser(String username) ;
	
	//�����û����������ѯ �����Ƿ�鵽�û�
	public User findUser(String username, String password);
	
	//
	//public List<User> findUser();
	//ע���û�
	public Boolean insertUser(String username, String password) ;
	
	//ͨ���û�����ѯ�û���Ϣ
	public User findUserinfo(String username);
	
	//�޸��û���Ϣ
	public boolean update(String username,String Alterusername, String Alterpassword, String Altertel, String Alteraddress);
}
