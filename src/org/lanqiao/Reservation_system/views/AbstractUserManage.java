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
import javax.swing.JTextField;

public abstract class AbstractUserManage extends JFrame{

	private Font font = new Font("华文楷体",  Font.BOLD, 18);
	private Font ShowFont = new Font("华文楷体",  Font.BOLD, 22);
	
	private JLabel backgroundLabel;
	private JLabel UserHeadLabel;
	private JLabel UserNameLabel;
	private JLabel UserSignatureLabel;
	private JLabel UserShowLabel;
	private JLabel UserShowAlterLabel;
	protected JLabel UserNameShowLabel;
	protected JLabel UserpasswordShowLabel;
	protected JLabel UsertelShowLabel;
	protected JLabel UseraddressShowLabel;
	private JLabel UserNameAlterLabel;
	private JLabel UserpasswordAlterLabel;
	protected JLabel hintLabel;
	private JLabel UsertelAlterLabel;
	private JLabel UseraddressAlterLabel;
	protected JTextField UserNameAlterField;
	protected JTextField UserpasswordAlterField;
	protected JTextField UsertelAlterField;
	protected JTextField UseraddressAlterField;
	private JButton AlterButton;
	private JButton submitButton;
	private JButton resetButton;
	protected String username;
	
	public AbstractUserManage ( String username) {
		this.username = username;
		this.setFont(font);
		this.setTitle("个人信息管理");
		Image img = new ImageIcon("images\\\\Logo.jpg").getImage();
		this.setIconImage(img);
		init();
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//设置布局为绝对定位
		this.setLayout(null);
		
		showUserInfo();
		this.setBounds(0,0,350,500);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setFont(font);
		this.setVisible(true);
	}
	private void init() {
		Container con = this.getContentPane();
		backgroundLabel =  new JLabel();
		Image backgroundImage1 = new ImageIcon("images\\Paybg.jpg").getImage();
		backgroundLabel.setIcon(new ImageIcon(backgroundImage1));
		backgroundLabel.setBounds(0,0,350,500);
		
		//设置用户头像
		UserHeadLabel = new JLabel();
		Image UserHead = new ImageIcon("images\\head.jpg").getImage();
		UserHeadLabel.setIcon(new ImageIcon(UserHead));
		UserHeadLabel.setBounds(30, 30, 70,70);
		
		//设置用户名
		UserNameLabel = new JLabel(username);
		UserNameLabel.setFont(font);
		UserNameLabel.setBounds(120, 30, 300, 30);
		
		//用户的个性签名
		UserSignatureLabel = new JLabel("让每个人吃的更健康");
		UserSignatureLabel.setFont(font);
		UserSignatureLabel.setBounds(120, 60, 300, 30);
		
		UserShowLabel = new JLabel();
		UserShowLabel.setFont(font);
		UserShowLabel.setBorder(BorderFactory.createLineBorder(Color.gray));
		UserShowLabel.setBounds(30, 120, 300, 270);
		
		
		UserNameShowLabel = new JLabel("姓名：" + username);
		UserNameShowLabel.setFont(ShowFont);
		UserNameShowLabel.setBounds(10, 10, 300, 50);
		
		UserpasswordShowLabel = new JLabel("密码：******");
		UserpasswordShowLabel.setFont(ShowFont);
		UserpasswordShowLabel.setBounds(10, 70, 300, 30);
		
		UsertelShowLabel = new JLabel("电话：");
		UsertelShowLabel.setFont(ShowFont);
		UsertelShowLabel.setBounds(10, 130, 300, 30);
		
		UseraddressShowLabel = new JLabel("地址：");
		UseraddressShowLabel.setFont(ShowFont);
		UseraddressShowLabel.setBounds(10, 190, 300, 30);
		
		AlterButton = new JButton("修改");
		AlterButton.setFont(ShowFont);
		AlterButton.setContentAreaFilled(false);
		AlterButton.setBorder(BorderFactory.createRaisedBevelBorder());
		AlterButton.setFocusPainted(false) ;
		AlterButton.setBounds(220, 420, 80, 30);
		
		submitButton = new JButton("提交");
		submitButton.setFont(ShowFont);
		submitButton.setContentAreaFilled(false);
		submitButton.setBorder(BorderFactory.createRaisedBevelBorder());
		submitButton.setFocusPainted(false) ;
		submitButton.setVisible(false);
		submitButton.setBounds(50, 420, 80, 30);
		
		resetButton = new JButton("重置");
		resetButton.setFont(ShowFont);
		resetButton.setContentAreaFilled(false);
		resetButton.setBorder(BorderFactory.createRaisedBevelBorder());
		resetButton.setFocusPainted(false) ;
		resetButton.setVisible(false);
		resetButton.setBounds(220, 420, 80, 30);
		
		
		UserShowLabel.add(UseraddressShowLabel);
		UserShowLabel.add(UsertelShowLabel);
		UserShowLabel.add(UserpasswordShowLabel);
		UserShowLabel.add(UserNameShowLabel);
		
		//修改页面
		UserShowAlterLabel = new JLabel();
		UserShowAlterLabel.setFont(font);
		UserShowAlterLabel.setVisible(false);
		UserShowAlterLabel.setBounds(30, 120, 300, 270);
		UserShowAlterLabel.setBorder(BorderFactory.createLineBorder(Color.gray));
		
		UserNameAlterLabel = new JLabel("姓名：" );
		UserNameAlterLabel.setFont(ShowFont);
		UserNameAlterLabel.setBounds(10, 10, 70, 50);
		
		UserNameAlterField = new JTextField();
		UserNameAlterField.setFont(ShowFont);
		UserNameAlterField.setBounds(80, 20, 200, 30);
		
		UserpasswordAlterLabel = new JLabel("密码：");
		UserpasswordAlterLabel.setFont(ShowFont);
		UserpasswordAlterLabel.setBounds(10, 70, 70, 30);
		
		UserpasswordAlterField = new JTextField();
		UserpasswordAlterField.setFont(ShowFont);
		UserpasswordAlterField.setBounds(80, 70, 200, 30);
		
		
		UsertelAlterLabel = new JLabel("电话：");
		UsertelAlterLabel.setFont(ShowFont);
		UsertelAlterLabel.setBounds(10, 130, 300, 30);
		
		UsertelAlterField = new JTextField();
		UsertelAlterField.setFont(ShowFont);
		UsertelAlterField.setBounds(80, 130, 200, 30);
		
		hintLabel = new JLabel("电话格式不正确");
		hintLabel.setFont(font);
		hintLabel.setVisible(false);
		hintLabel.setForeground(Color.RED);
		hintLabel.setBounds(80, 165, 200, 20);
		
		UseraddressAlterLabel = new JLabel("地址：");
		UseraddressAlterLabel.setFont(ShowFont);
		UseraddressAlterLabel.setBounds(10, 190, 300, 30);
		
		UseraddressAlterField = new JTextField();
		UseraddressAlterField.setFont(ShowFont);
		UseraddressAlterField.setBounds(80, 190, 200, 30);
		
		UserShowAlterLabel.add(hintLabel);
		UserShowAlterLabel.add(UseraddressAlterField);
		UserShowAlterLabel.add(UsertelAlterField);
		UserShowAlterLabel.add(UserpasswordAlterField);
		UserShowAlterLabel.add(UserNameAlterField);
		UserShowAlterLabel.add(UserNameAlterLabel);
		UserShowAlterLabel.add(UserpasswordAlterLabel);
		UserShowAlterLabel.add(UsertelAlterLabel);
		UserShowAlterLabel.add(UseraddressAlterLabel);
		
		con.add(resetButton);
		con.add(submitButton);
		con.add(AlterButton);
		con.add(UserShowLabel);
		con.add(UserShowAlterLabel);
		con.add(UserHeadLabel);
		con.add(UserNameLabel);
		con.add(UserSignatureLabel);
		con.add(backgroundLabel);
		addListener();
	}

	public void addListener() {
		
		AlterButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				AlterButton.setBorder(BorderFactory.createRaisedBevelBorder());
				hideUserShowLabel();
				submitButton.setVisible(true);
				resetButton.setVisible(true);
				AlterButton.setVisible(false);
			}
		});
		AlterButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					AlterButton.setBorder(BorderFactory.createLoweredBevelBorder());
				}
				
			});
		submitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				submitButton.setBorder(BorderFactory.createRaisedBevelBorder());
				hideAlterLabel();
				submitButton.setVisible(false);
				AlterButton.setVisible(true);
				resetButton.setVisible(false);
				showUser();
			}
		});
		submitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				submitButton.setBorder(BorderFactory.createLoweredBevelBorder());
			}
			
		});
		
		resetButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				resetButton.setBorder(BorderFactory.createRaisedBevelBorder());
				
			}
		});
		resetButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				resetButton.setBorder(BorderFactory.createLoweredBevelBorder());
				UserNameAlterField.setText("");
				UserpasswordAlterField.setText("");
				UsertelAlterField.setText("");
				UseraddressAlterField.setText("");
			}
			
		});
		
		UsertelAlterField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
            	verity_tel();
            }
           
        });
	}
	
	public void hideAlterLabel() {
		UserShowLabel.setVisible(true);
		UserShowAlterLabel.setVisible(false);
	}
	public void hideUserShowLabel() {
		
		UserShowAlterLabel.setVisible(true);
		UserShowLabel.setVisible(false);
	}

	public abstract void showUserInfo();
	
	public abstract void showUser();
	
	//验证电话号是否符合规则
	public abstract void verity_tel();
}
