package org.lanqiao.Reservation_system.views;

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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public abstract class AbstractPay extends JFrame {

	private Font font = new Font("华文楷体",  Font.BOLD, 18);
	private Font fontName = new Font("华文楷体",  Font.BOLD, 24);
	private JLabel backgroundLabel;
	protected JLabel FoodimgLabel;
	protected JLabel FoodNameLabel;
	protected JLabel FoodPriceLabel;
	protected JLabel UsernameLabel;
	protected JLabel UsersiteLabel;
	protected JLabel UserTelLabel;
	protected JLabel UserpayLabel;
	private static JButton ZPayButton;
	private static JButton WPayButton;
	protected JTextArea introtextArea;
	private JScrollPane  JScrollpane;
	protected String foodName;
	protected String username;
	
	public AbstractPay ( String foodname, String username) {
		this.foodName = foodname;
		this.username = username;
		this.setFont(font);
		this.setTitle("支付页面");
		Image img = new ImageIcon("images\\\\Logo.jpg").getImage();
		this.setIconImage(img);
		init();
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//设置布局为绝对定位
		this.setLayout(null);
		
		this.setBounds(0,0,700,500);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setFont(font);
		this.setVisible(true);
		this.showfoodInfo();
		this.showuserInfo();
		this.verityuserInfo();
	}

	private void init() {
		Container con = this.getContentPane();
		
		//设置背景
		backgroundLabel =  new JLabel();
		Image backgroundImage1 = new ImageIcon("images\\Paybg.jpg").getImage();
		backgroundLabel.setIcon(new ImageIcon(backgroundImage1));
		backgroundLabel.setBounds(0,0,700,500);
		
		FoodimgLabel =  new JLabel();
		FoodimgLabel.setBounds(50,50,210,210);
		
		FoodNameLabel =  new JLabel();
		FoodNameLabel.setFont(fontName);
		FoodNameLabel.setBounds(300,70,200,30);
		
		FoodPriceLabel =  new JLabel("10元/份");
		FoodPriceLabel.setFont(font);
		FoodPriceLabel.setBounds(500,75,150,30);
		
		introtextArea = new JTextArea();
		introtextArea.setFont(font);
		introtextArea.setLineWrap(true);
		introtextArea.append("烧麦又称烧卖、稍美（内蒙古写法，音shāo mài ）、肖米、稍麦、稍梅、烧梅、鬼蓬头，在日本称作焼売[1]，是形容顶端蓬松束折如花的形状，是一种以烫面为皮裹馅上笼蒸熟的小吃。");
		
		JScrollpane = new JScrollPane();
		JScrollpane.setViewportView(introtextArea);
		JScrollpane.setBounds(300, 110, 370,150 );
		JScrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		UsernameLabel =  new JLabel("姓      名：张三");
		UsernameLabel.setFont(font);
		UsernameLabel.setBounds(70,310,300,30);
		
		UsersiteLabel =  new JLabel("地   址：太原师范学院");
		UsersiteLabel.setFont(font);
		UsersiteLabel.setBounds(380,310,300,30);
		
		UserTelLabel =  new JLabel("联系方式：13097685668");
		UserTelLabel.setFont(font);
		UserTelLabel.setBounds(70,360,300,30);
		
		UserpayLabel =  new JLabel("应付款：200元");
		UserpayLabel.setFont(font);
		UserpayLabel.setBounds(380,360,300,30);
		
		ZPayButton = new JButton("支付宝支付");
		ZPayButton.setContentAreaFilled(false);
		ZPayButton.setBorder(BorderFactory.createRaisedBevelBorder());
		ZPayButton.setFocusPainted(false) ;
		ZPayButton.setFont(fontName);
		ZPayButton.setBounds(80, 400, 150, 50);
		
		WPayButton = new JButton("微信支付");
		WPayButton.setContentAreaFilled(false);
		WPayButton.setBorder(BorderFactory.createRaisedBevelBorder());
		WPayButton.setFocusPainted(false) ;
		WPayButton.setFont(fontName);
		WPayButton.setBounds(470, 400, 150, 50);
		
		con.add(WPayButton);
		con.add(ZPayButton);
		con.add(UsernameLabel);
		con.add(UsersiteLabel);
		con.add(	UserTelLabel);
		con.add(UserpayLabel);
		con.add(JScrollpane);
		con.add(backgroundLabel);
		
		con.add(FoodPriceLabel);
		con.add(FoodNameLabel);
		con.add(FoodimgLabel);
		con.add(backgroundLabel);
		addListener();
	}
	public void addListener() {
		ZPayButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					ZPayButton.setBorder(BorderFactory.createLoweredBevelBorder());
				}
				
			});
			
		ZPayButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
					ZPayButton.setBorder(BorderFactory.createRaisedBevelBorder());
					ZhifubaoPay zhifubao = new ZhifubaoPay();
				}
				
			});
		
		WPayButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				WPayButton.setBorder(BorderFactory.createLoweredBevelBorder());
			}
			
		});
		
		WPayButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				WPayButton.setBorder(BorderFactory.createRaisedBevelBorder());
				WeixinPay weixin = new WeixinPay();
			}
			
		});
	}
	
	public abstract void showfoodInfo();
	
	public abstract void showuserInfo();
	
	public  abstract void verityuserInfo();
}
