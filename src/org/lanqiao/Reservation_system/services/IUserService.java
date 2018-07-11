package org.lanqiao.Reservation_system.services;

import org.lanqiao.Reservation_system.domain.User;

public interface IUserService {

	//��¼�û������õ��û��Ƿ��ѯ�ɹ�
	public boolean login(String username, String password);
	
	//ע���û������õ��Ƿ�ע��ɹ�
	public boolean register(String username, String password);
	
	//��ѯ�Ƿ��Ѵ����û�
	public boolean registerFindUser(String username);
	
	//ͨ���û�����ѯ�û������û�����Ϣ
	public User UserAllInfo(String username);
	
	//�޸��û���Ϣ
	public boolean AlterUser(String username, String Alterusername, String Alterpassword, String Altertel, String Alteraddress);
}
