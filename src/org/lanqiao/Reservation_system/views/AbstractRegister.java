package org.lanqiao.Reservation_system.views;

import java.awt.Color;
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
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.lanqiao.Reservation_system.controller.Login;
import org.lanqiao.Reservation_system.controller.Register;
import org.lanqiao.Reservation_system.controller.User_manual;

public  abstract class AbstractRegister extends JFrame {

	private Font font = new Font("华文楷体",  Font.BOLD, 18);
	
	private JLabel backgroundLabel;
	private JLabel headlineLabel;
	private JLabel registerTextLabel;
	private JLabel usernameLabel;
	private static JLabel passwordLabel;
	private JLabel rePasswordLabel;
	private JLabel userTOS;
	protected static JLabel verifyPasswordLable;
	protected JTextField usernameTextField;
	protected static JPasswordField passwordField;
	protected static JPasswordField rePasswordField;
	protected JCheckBox tosSelect;
	private static JButton TosButten;
	private static JButton submitButten;
	private static JButton resetButten;
	
	
	public AbstractRegister() {
		this.setFont(font);
		this.setTitle("用户订餐系统—注册");
		Image img = new ImageIcon("images\\\\Logo.jpg").getImage();
		this.setIconImage(img);
		init();
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//设置布局为绝对定位
		this.setLayout(null);
		
		this.setBounds(0,0,520,340);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setFont(font);
		this.setVisible(true);
		this.addwinListener();
	}
	private void init() {
		Container con = this.getContentPane();
		
		//设置背景
		backgroundLabel =  new JLabel();
		Image backgroundImage1 = new ImageIcon("images\\background2.jpg").getImage();
		backgroundLabel.setIcon(new ImageIcon(backgroundImage1));
		backgroundLabel.setBounds(0,0,520,340);
		
		Font headlineFont = new Font("华文楷体", Font.BOLD, 28);
		headlineLabel = new JLabel( "欢迎新用户");
		headlineLabel.setFont(headlineFont);
		headlineLabel.setBounds(300, 20, 150, 40);
		
		registerTextLabel  = new JLabel("注  册");
		registerTextLabel.setFont(new Font("华文楷体", Font.BOLD, 24));
		registerTextLabel.setBounds(140, 60, 150, 40);
		
		usernameLabel = new JLabel("用 户 名 ：");
		usernameLabel.setFont(font);
		usernameLabel.setBounds(100, 120, 100, 50);
		
		usernameTextField = new JTextField();
		usernameTextField.setFont(font);
		usernameTextField.setBounds(200, 130, 160, 25);
		
		passwordLabel = new JLabel("密      码：");
		passwordLabel.setFont(font);
		passwordLabel.setBounds(100, 155, 100, 50);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(200, 165, 160, 25);
		
		rePasswordLabel = new JLabel("确认密码：");
		rePasswordLabel.setFont(font);
		rePasswordLabel.setBounds(100, 200, 100, 20);
		
		rePasswordField = new JPasswordField();
		rePasswordField.setBounds(200,200, 160, 25);
		
		verifyPasswordLable = new JLabel();
		verifyPasswordLable.setFont(font);
		verifyPasswordLable.setForeground(Color.RED);
		verifyPasswordLable.setBounds(380,200, 160, 30);
		
		userTOS = new JLabel("同意用户服务条款");
		userTOS.setFont(font);
		userTOS.setBounds(40, 230, 170, 20);
		
		tosSelect = new JCheckBox();
		tosSelect.setBounds(200, 225, 30, 30);
		
		TosButten = new JButton("点此查看用户条款");
		TosButten.setFont(font);
		TosButten.setFocusPainted(false) ;
		TosButten.setContentAreaFilled(false);
		TosButten.setBorderPainted(false);
		TosButten.setBounds(220, 230, 190, 20);
		
		submitButten = new JButton("提交");
		submitButten.setFont(font);
		submitButten.setContentAreaFilled(false);
		submitButten.setBorder(BorderFactory.createRaisedBevelBorder());
		submitButten.setFocusPainted(false) ;
		submitButten.setFont(font);
		submitButten.setBounds(200, 260, 80, 20);
		
		resetButten = new JButton("重置");
		resetButten.setFont(font);
		resetButten.setContentAreaFilled(false);
		resetButten.setBorder(BorderFactory.createRaisedBevelBorder());
		resetButten.setFocusPainted(false) ;
		resetButten.setFont(font);
		resetButten.setBounds(300, 260, 80, 20);
		
		backgroundLabel.add(verifyPasswordLable);
		backgroundLabel.add(submitButten);
		backgroundLabel.add(resetButten);
		backgroundLabel.add(TosButten);
		backgroundLabel.add(tosSelect);
		backgroundLabel.add(userTOS);
		backgroundLabel.add(rePasswordField);
		backgroundLabel.add(passwordField);
		backgroundLabel.add(usernameTextField);
		backgroundLabel.add(passwordLabel);
		backgroundLabel.add(rePasswordLabel);
		backgroundLabel.add(usernameLabel);
		backgroundLabel.add(headlineLabel);
		backgroundLabel.add(registerTextLabel);
		con.add(backgroundLabel);
		addListener();
		
		
	}
	public  void addListener() {
		TosButten.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				TosButten.setForeground(Color.blue);
            }
			
		});
		TosButten.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				TosButten.setForeground(Color.black);
			}
			
		});
		
		TosButten.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				AbstractUser_manual suer_manual = new User_manual();
			}
			
		});
		
		submitButten.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				submitButten.setBorder(BorderFactory.createLoweredBevelBorder());
			}
			
		});
		
		submitButten.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				submitButten.setBorder(BorderFactory.createRaisedBevelBorder());
				register();
			}
			
		});
		
		
		resetButten.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				resetButten.setBorder(BorderFactory.createLoweredBevelBorder());
			}
			
		});
		
		resetButten.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				resetButten.setBorder(BorderFactory.createRaisedBevelBorder());
				reset();
			}
			
		});
		rePasswordField.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseExited(MouseEvent e) {
            	if(rePasswordField.getText().equals(passwordField.getText())) {
            		verifyPasswordLable.setText("");
            	}else {
            		verifyPasswordLable.setText("密码不一致！");
            	}
            }
           
        });
		
	}
	
	public  void addwinListener() {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				AbstractLogin login = new Login();
            }
			
		});
	}
	
	public abstract void register();
	
	/**
	 * 
	 */
	public abstract void reset();
	
}
