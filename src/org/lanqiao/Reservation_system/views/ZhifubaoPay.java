package org.lanqiao.Reservation_system.views;

import java.awt.Container;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ZhifubaoPay extends JFrame{

	private Font font = new Font("华文楷体",  Font.BOLD, 18);
	private JLabel backgroundLabel;
	
	public ZhifubaoPay () {
		this.setFont(font);
		this.setTitle("支付宝支付");
		Image img = new ImageIcon("images\\\\Logo.jpg").getImage();
		this.setIconImage(img);
		init();
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//设置布局为绝对定位
		this.setLayout(null);
		
		this.setBounds(0,0,265,285);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setFont(font);
		this.setVisible(true);
	}

	private void init() {
		Container con = this.getContentPane();
		
		backgroundLabel =  new JLabel();
		Image backgroundImage1 = new ImageIcon("images\\erweima.jpg").getImage();
		backgroundLabel.setIcon(new ImageIcon(backgroundImage1));
		backgroundLabel.setBounds(0,0,260,260);
		
		con.add(backgroundLabel);
		
	}
}
