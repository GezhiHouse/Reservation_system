package org.lanqiao.Reservation_system.views;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.lanqiao.Reservation_system.controller.Register;
import org.lanqiao.Reservation_system.tools.VerifyCodeUtils;

public  abstract class AbstractLogin extends JFrame{

	//组件
	protected JTextField usernameTextField;
	protected JPasswordField PasswordField;
	protected static JTextField captchaTextField;
	private JLabel backgroundLabel;
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JLabel captchaLabel;
	private JLabel usernameImageLabel;
	private JLabel passwordImageLabel;
	private JLabel captchaImageLabel;
	private static JLabel captchaFieldLabel;
	private static JButton loginButton;
	private static JButton registerButton;
	private static JButton captchaImageButton;
	private static ImageIcon captchaImage;
	
	private Font font = new Font("华文楷体",  Font.BOLD, 18);
	protected static String captchaStr;
	
	public AbstractLogin () {
		this.setFont(font);
		this.setTitle("用户订餐系统");
		Image img = new ImageIcon("images\\\\Logo.jpg").getImage();
		this.setIconImage(img);
		init();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//设置布局为绝对定位
		this.setLayout(null);
		
		this.setBounds(0,0,510,300);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setFont(font);
		this.setVisible(true);
	}

	private void init() {
		//设置容器
		Container con = this.getContentPane();
		
		//设置背景
		backgroundLabel =  new JLabel();
		Image backgroundImage1 = new ImageIcon("images\\background1.jpg").getImage();
		backgroundLabel.setIcon(new ImageIcon(backgroundImage1));
		backgroundLabel.setBounds(0,0,510,300);
		
		//账号相关组件
		usernameTextField = new JTextField();
		usernameTextField.setFont(font);
		usernameTextField.setBounds(200,90,150,25);
		
		usernameLabel = new JLabel("账   号：");
		usernameLabel.setFont(font);
		usernameLabel.setBounds(110, 90, 150, 30);
		
		usernameImageLabel = new JLabel();
		Image usernameImage = new ImageIcon("images\\username.png").getImage();
		usernameImageLabel.setIcon(new ImageIcon(usernameImage));
		usernameImageLabel.setBounds(85,95,20,20);
		
		//密码相关组件
		PasswordField = new JPasswordField();
		PasswordField.setFont(font);
		PasswordField.setBounds(200, 120, 150, 25);
		
		passwordLabel = new JLabel("密   码：");
		passwordLabel.setFont(font);
		passwordLabel.setBounds(110,120,150,30);
		
		passwordImageLabel = new JLabel();
		Image passwordImage = new ImageIcon("images\\password.png").getImage();
		passwordImageLabel.setIcon(new ImageIcon(passwordImage));
		passwordImageLabel.setBounds(85,125,20,20);
		
		//验证码相关组件
		captchaTextField = new JTextField();
		captchaTextField.setFont(font);
		captchaTextField.setBounds(200,150,80,25);
		
		captchaLabel = new JLabel("验证码：");
		captchaLabel.setFont(font);
		captchaLabel.setBounds(110,150,150,25);
		
		captchaImageLabel = new JLabel();
		Image captchaIcon= new ImageIcon("images\\captcha.png").getImage();
		captchaImageLabel.setIcon(new ImageIcon(captchaIcon));
		captchaImageLabel.setBounds(85,155,20,20);
		
		File imageFile = null;
		try {
			imageFile = VerifyCodeUtils.getImages();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String imageFileName = imageFile.getName();
		captchaStr = imageFileName.substring(0, 4);
		captchaImage = new ImageIcon(imageFileName);
		captchaImageButton = new JButton(captchaImage);
		captchaImageButton.setContentAreaFilled(false);
		captchaImageButton.setFocusPainted(false) ;
		captchaImageButton.setBounds(300,150,70,25);
		
		
		captchaFieldLabel = new JLabel();
		captchaFieldLabel.setBounds(200,180,200,25);
		captchaFieldLabel.setForeground(Color.RED);
		captchaFieldLabel.setFont(font);
		
		//登录按钮组件
		loginButton = new JButton("登录");
		loginButton.setContentAreaFilled(false);
		loginButton.setBorder(BorderFactory.createRaisedBevelBorder());
		loginButton.setFocusPainted(false) ;
		loginButton.setFont(font);
		loginButton.setBounds(300, 200, 80, 20);
		
		//注册组件
		registerButton = new JButton("注册");
		registerButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				registerButton.setBorder(BorderFactory.createLoweredBevelBorder());
				AbstractRegister register = new Register();
				setClose();
			}
			
		});
		registerButton.setContentAreaFilled(false);
		registerButton.setBorder(BorderFactory.createRaisedBevelBorder());
		registerButton.setFocusPainted(false) ;
		registerButton.setFont(font);
		registerButton.setBounds(100,200,80, 20);
		
		con.add(usernameTextField);
		con.add(PasswordField);
		con.add(captchaTextField);
		backgroundLabel.add(usernameLabel);
		backgroundLabel.add(passwordLabel);
		backgroundLabel.add(captchaLabel);
		backgroundLabel.add(loginButton);
		backgroundLabel.add(registerButton);
		backgroundLabel.add(captchaImageButton);
		backgroundLabel.add(usernameImageLabel);
		backgroundLabel.add(passwordImageLabel);
		backgroundLabel.add(captchaFieldLabel);
		backgroundLabel.add(captchaImageLabel);
		con.add(backgroundLabel);
		addListener();
	}
	
	public void addListener() {
		captchaTextField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
            	showRegisterError();
            }
           
        });
		 captchaImageButton.addMouseListener(new MouseAdapter() {
             @Override
             public void mouseClicked(MouseEvent e) {
             	File imageFile = null;
         		try {
         			imageFile = VerifyCodeUtils.getImages();
         		} catch (IOException e1) {
         			// TODO Auto-generated catch block
         			e1.printStackTrace();
         		}
         		String imageFileName = imageFile.getName();
         		captchaStr = imageFileName.substring(0, 4);
         		captchaImage = new ImageIcon(imageFileName);
         		captchaImageButton.setIcon(captchaImage);
             }
         });
		 loginButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					loginButton.setBorder(BorderFactory.createLoweredBevelBorder());
				}
				
			});
			
		 loginButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
					loginButton.setBorder(BorderFactory.createRaisedBevelBorder());
					login();
				}
				
			});
		 
		 
		 registerButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					registerButton.setBorder(BorderFactory.createLoweredBevelBorder());
				}
				
			});
			
		 registerButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
					registerButton.setBorder(BorderFactory.createRaisedBevelBorder());
				}
				
			});
	}
	
	public  void setClose() {
		this.dispose();
	}
	
	
	public void showRegisterError() {
		if(captchaTextField.getText().equals(null) ||captchaStr.equalsIgnoreCase(captchaTextField.getText()) || captchaTextField.getText().equals("")) {
    		captchaFieldLabel.setText("");
    	}else {
    		captchaFieldLabel.setText("验证码输入有误！");
    	}
	}
	
	 public abstract void login();
	 public abstract boolean Register();
	 protected abstract boolean Captcha();
}
