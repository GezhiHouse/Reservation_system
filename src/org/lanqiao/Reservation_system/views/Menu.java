package org.lanqiao.Reservation_system.views;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.lanqiao.Reservation_system.controller.Order_food;
import org.lanqiao.Reservation_system.controller.UserManage;

public class Menu extends JFrame{

	private Font font = new Font("华文楷体",  Font.BOLD, 20);
	
	private JLabel backgroundLabel;
	private static JButton UserButton;
	private static JButton OrderButton;
	private String username;
	public Menu (String username) {
		this.username = username;
		this.setFont(font);
		this.setTitle("菜单");
		Image img = new ImageIcon("images\\\\Logo.jpg").getImage();
		this.setIconImage(img);
		init();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//设置布局为绝对定位
		this.setLayout(null);
		
		this.setBounds(0,0,610,430);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setFont(font);
		this.setVisible(true);
	}


	private void init() {
		Container con = this.getContentPane();
		
		//设置背景
		backgroundLabel =  new JLabel();
		Image backgroundImage1 = new ImageIcon("images\\MenuBg.jpg").getImage();
		backgroundLabel.setIcon(new ImageIcon(backgroundImage1));
		backgroundLabel.setBounds(0,0,600,400);
		
		OrderButton = new JButton("开始订餐");
		OrderButton.setContentAreaFilled(false);
		OrderButton.setBorder(BorderFactory.createRaisedBevelBorder());
		OrderButton.setFocusPainted(false) ;
		OrderButton.setFont(font);
		OrderButton.setForeground(Color.WHITE);
		OrderButton.setBounds(90, 355, 100, 30);
		
		
		UserButton = new JButton("个人中心");
		UserButton.setContentAreaFilled(false);
		UserButton.setBorder(BorderFactory.createRaisedBevelBorder());
		UserButton.setFocusPainted(false) ;
		UserButton.setFont(font);
		UserButton.setForeground(Color.WHITE);
		UserButton.setBounds(420, 355, 100, 30);
		
		backgroundLabel.add(UserButton);
		backgroundLabel.add(OrderButton);
		con.add(backgroundLabel);
		
		addListener();
	}
	public void addListener() {
		
		OrderButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					OrderButton.setBorder(BorderFactory.createLoweredBevelBorder());
				}
				
			});
			
		OrderButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
					OrderButton.setBorder(BorderFactory.createRaisedBevelBorder());
					AbstractOrder_food order_food = new Order_food(username);
				}
				
			});
		
		UserButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				UserButton.setBorder(BorderFactory.createLoweredBevelBorder());
			}
			
		});
		
		UserButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				UserButton.setBorder(BorderFactory.createRaisedBevelBorder());
				AbstractUserManage abstractUserManage = new UserManage(username);
			}
			
		});
	}
}
