package org.lanqiao.Reservation_system.views;

import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.lanqiao.Reservation_system.controller.UserManage;

public class HintUserInfo extends JFrame{
	
	private static JButton hintButton;
	private JLabel hintLabel;
	private JLabel backgroundLabel;
	private String username;
	
	private Font font = new Font("华文楷体",  Font.BOLD, 18);
	public HintUserInfo (String username) {
		this.username = username;
		this.setFont(font);
		this.setTitle("温馨提示");
		Image img = new ImageIcon("images\\\\Logo.jpg").getImage();
		this.setIconImage(img);
		init();
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//设置布局为绝对定位
		this.setLayout(null);
		
		this.setBounds(0,0,300,200);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setFont(font);
		this.setVisible(true);
		this.addwinListener();
	}
	private void init() {
		Container con = this.getContentPane();
		
		backgroundLabel =  new JLabel();
		Image backgroundImage1 = new ImageIcon("images\\background1.jpg").getImage();
		backgroundLabel.setIcon(new ImageIcon(backgroundImage1));
		backgroundLabel.setBounds(0,0,300,200);
		
		hintLabel = new JLabel("您的信息不完整，请补充信息！");
		hintLabel.setFont(font);
		hintLabel.setBounds(30,40,240,30);		
		
		hintButton = new JButton("确定");
		hintButton.setContentAreaFilled(false);
		hintButton.setBorder(BorderFactory.createRaisedBevelBorder());
		hintButton.setFocusPainted(false) ;
		hintButton.setFont(font);
		hintButton.setBounds(110,100, 75, 30);
		
		backgroundLabel.add(hintLabel);
		backgroundLabel.add(hintButton);
		con.add(backgroundLabel);
		addListener();
	}
	
	public void addListener() {
		hintButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				hintButton.setBorder(BorderFactory.createLoweredBevelBorder());
			}
			
		});
		
		hintButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				hintButton.setBorder(BorderFactory.createRaisedBevelBorder());
				closeWin();
			}
			
		});
	}
	
	public void closeWin() {
		this.setVisible(false);
		AbstractUserManage userManage = new UserManage(username);
	}
	
	public  void addwinListener() {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				AbstractUserManage userManage = new UserManage(username);
            }
			
		});
	}
}
