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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.lanqiao.Reservation_system.controller.Pay;

public abstract class AbstractOrder_food extends JFrame{

	private JLabel backgroundLabel;
	private JLabel UserHeadLabel;
	private JLabel UserNameLabel;
	private JLabel UserSignatureLabel;
	private JLabel ScreenLabel;
	private JLabel showLabel;
	private JLabel commonSearchLabel;
	private JLabel materialSearchLabel;
	protected JTextField searchTextField;
	private static JButton searchButton;
	private static JButton commonButton;
	private static JButton materialButton;
	private static JButton previousButton;
	private static JButton nextButton;
	private static JButton sucai;
    private static JButton huncai;
    private static JButton gaifan;
    private static JButton mianshi;
    private static JButton tanglei;
    private static JButton gaodian;
    private static JButton material1;
    private static JButton material2;
    private static JButton material3;
    private static JButton material4;
    private static JButton material5;
    private static JButton material6;
    protected JButton showMeunButton1;
    protected JButton showMeunButton2;
    protected  JLabel showMeunNameButton1;
    protected JLabel showMeunNameButton2;
    
	private String Username;
	protected int pageflag = 0;
	private String foodflag = "sucai";
	
	
	private Font font = new Font("华文楷体",  Font.BOLD, 18);
	private Font foodNameFont = new Font("华文楷体",  Font.BOLD, 20);
	
	public AbstractOrder_food (String username) {
		this.Username = username;
		this.setFont(font);
		this.setTitle("用户订餐页面");
		Image img = new ImageIcon("images\\\\Logo.jpg").getImage();
		this.setIconImage(img);
		init();
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//设置布局为绝对定位
		this.setLayout(null);
		
		this.setBounds(0,0,1000,600);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setFont(font);
		this.setVisible(true);
	//	this.addwinListener();
	}

	private void init() {
		Container con = this.getContentPane();
		
		//设置背景
		backgroundLabel =  new JLabel();
		Image backgroundImage1 = new ImageIcon("images\\MenuOrderbg.jpg").getImage();
		backgroundLabel.setIcon(new ImageIcon(backgroundImage1));
		backgroundLabel.setBounds(0,0,1000,600);
		//设置用户头像
		UserHeadLabel = new JLabel();
		Image UserHead = new ImageIcon("images\\head.jpg").getImage();
		UserHeadLabel.setIcon(new ImageIcon(UserHead));
		UserHeadLabel.setBounds(50, 50, 70,70);
		
		//设置用户名
		String setusername = "欢迎用户" + Username;
		UserNameLabel = new JLabel(setusername);
		UserNameLabel.setFont(font);
		UserNameLabel.setBounds(140, 50, 300, 30);
		
		//用户的个性签名
		UserSignatureLabel = new JLabel("让每个人吃的更健康");
		UserSignatureLabel.setFont(font);
		UserSignatureLabel.setBounds(140, 80, 300, 30);
		
		//搜索栏
		searchTextField = new JTextField();
		searchTextField.setFont(font);
		searchTextField.setBounds(400,60,400,35);
		
		//搜索按钮
		searchButton = new JButton("搜索");
		searchButton.setContentAreaFilled(false);
		searchButton.setBorder(BorderFactory.createRaisedBevelBorder());
		searchButton.setFocusPainted(false) ;
		searchButton.setFont(font);
		searchButton.setBounds(830, 60, 100, 35);
		
		//筛选框
		ScreenLabel = new JLabel();
		ScreenLabel.setBorder(BorderFactory.createLineBorder(Color.gray));
		ScreenLabel.setFont(font);
		ScreenLabel.setBounds(50, 150, 280, 380);
		
		//普通筛选按钮
		commonButton = new JButton("普通筛选");
		commonButton.setContentAreaFilled(false);
		//commonButton.setBorder(BorderFactory.createRaisedBevelBorder());
		commonButton.setBorder(BorderFactory.createLoweredBevelBorder());
		commonButton.setFocusPainted(false) ;
		commonButton.setFont(font);
		commonButton.setBounds(1, 1, 138, 35);
		
		//食材筛选按钮
		materialButton = new JButton("食材筛选");
		materialButton.setContentAreaFilled(false);
		materialButton.setBorder(BorderFactory.createRaisedBevelBorder());
		materialButton.setFocusPainted(false) ;
		materialButton.setFont(font);
		materialButton.setBounds(138, 1, 141, 35);

		showLabel = new JLabel();
		showLabel.setBorder(BorderFactory.createLineBorder(Color.gray));
		showLabel.setFont(font);
		showLabel.setBounds(370, 150, 580, 330);
		
		ImageIcon showImage1 = new ImageIcon("images\\0001.jpg");
		showMeunButton1 = new JButton(showImage1);
		showMeunButton1.setContentAreaFilled(false);
		showMeunButton1.setBorder(BorderFactory.createRaisedBevelBorder());
		showMeunButton1.setFocusPainted(false) ;
		showMeunButton1.setBounds(410, 190, 210, 210);
		
		
		ImageIcon showImage2 = new ImageIcon("images\\0002.jpg");
		showMeunButton2 = new JButton(showImage2);
		showMeunButton2.setContentAreaFilled(false);
		showMeunButton2.setBorder(BorderFactory.createRaisedBevelBorder());
		showMeunButton2.setFocusPainted(false) ;
		showMeunButton2.setBounds(700, 190, 210, 210);
		
		showMeunNameButton1 = new JLabel("烤山芋",JLabel.CENTER);
		showMeunNameButton1.setFont(foodNameFont);
		showMeunNameButton1.setBounds(410, 420, 210, 30);
		
		showMeunNameButton2 = new JLabel("油炸臭干",JLabel.CENTER);
		showMeunNameButton2.setFont(foodNameFont);
		showMeunNameButton2.setBounds(700, 420, 210, 30);
		
		previousButton = new JButton("上一页");
		previousButton.setContentAreaFilled(false);
		previousButton.setBorder(BorderFactory.createRaisedBevelBorder());
		previousButton.setFocusPainted(false) ;
		previousButton.setFont(font);
		previousButton.setBounds(470, 490, 120, 30);
		
		nextButton = new JButton("下一页");
		nextButton.setContentAreaFilled(false);
		nextButton.setBorder(BorderFactory.createRaisedBevelBorder());
		nextButton.setFocusPainted(false) ;
		nextButton.setFont(font);
		nextButton.setBounds(720, 490, 120, 30);
		
		commonScreen();
		materialScreen();
		
		
		backgroundLabel.add(showMeunButton1);
		backgroundLabel.add(showMeunButton2);
		backgroundLabel.add(showMeunNameButton1);
		backgroundLabel.add(showMeunNameButton2);
		backgroundLabel.add(previousButton);
		backgroundLabel.add(nextButton);
		backgroundLabel.add(showLabel);
		backgroundLabel.add(searchButton);
		backgroundLabel.add(searchTextField);
		backgroundLabel.add(UserSignatureLabel);
		backgroundLabel.add(UserHeadLabel);
		backgroundLabel.add(UserNameLabel);
		ScreenLabel.add(commonButton);
		ScreenLabel.add(materialButton);
		con.add(backgroundLabel);
		backgroundLabel.add(ScreenLabel);
		
		addListener();
	}
	
	public void commonScreen() {
		commonSearchLabel = new JLabel();
		commonSearchLabel.setBounds(0, 36, 280, 345);
		
		sucai = new JButton("素菜");
		sucai.setContentAreaFilled(false);
		sucai.setBorder(BorderFactory.createRaisedBevelBorder());
		sucai.setFocusPainted(false) ;
		sucai.setForeground(Color.gray);
		sucai.setContentAreaFilled(false);
		sucai.setBorderPainted(false);
		sucai.setFont(foodNameFont);
		sucai.setBounds(30, 30, 80, 35);
		
		huncai = new JButton("荤菜");
		huncai.setContentAreaFilled(false);
		huncai.setBorder(BorderFactory.createRaisedBevelBorder());
		huncai.setFocusPainted(false) ;
		huncai.setContentAreaFilled(false);
		huncai.setBorderPainted(false);
		huncai.setForeground(Color.gray);
		huncai.setFont(foodNameFont);
		huncai.setBounds(170, 30, 80, 35);
		
		gaifan = new JButton("盖饭");
		gaifan.setContentAreaFilled(false);
		gaifan.setBorder(BorderFactory.createRaisedBevelBorder());
		gaifan.setFocusPainted(false) ;
		gaifan.setContentAreaFilled(false);
		gaifan.setForeground(Color.gray);
		gaifan.setBorderPainted(false);
		gaifan.setFont(foodNameFont);
		gaifan.setBounds(30, 130, 80, 35);
		
		mianshi = new JButton("面食");
		mianshi.setContentAreaFilled(false);
		mianshi.setBorder(BorderFactory.createRaisedBevelBorder());
		mianshi.setFocusPainted(false) ;
		mianshi.setContentAreaFilled(false);
		mianshi.setBorderPainted(false);
		mianshi.setForeground(Color.gray);
		mianshi.setFont(foodNameFont);
		mianshi.setBounds(170, 130, 80, 35);
		
		tanglei = new JButton("汤类");
		tanglei.setContentAreaFilled(false);
		tanglei.setBorder(BorderFactory.createRaisedBevelBorder());
		tanglei.setFocusPainted(false) ;
		tanglei.setContentAreaFilled(false);
		tanglei.setBorderPainted(false);
		tanglei.setForeground(Color.gray);
		tanglei.setFont(foodNameFont);
		tanglei.setBounds(30, 230, 80, 35);
		
		gaodian = new JButton("糕点");
		gaodian.setContentAreaFilled(false);
		gaodian.setBorder(BorderFactory.createRaisedBevelBorder());
		gaodian.setFocusPainted(false) ;
		gaodian.setContentAreaFilled(false);
		gaodian.setBorderPainted(false);
		gaodian.setFont(foodNameFont);
		gaodian.setForeground(Color.gray);
		gaodian.setBounds(170, 230, 80, 35);

		commonSearchLabel.add(sucai);
		commonSearchLabel.add(huncai);
		commonSearchLabel.add(gaifan);
		commonSearchLabel.add(mianshi);
		commonSearchLabel.add(tanglei);
		commonSearchLabel.add(gaodian);
		
		ScreenLabel.add(commonSearchLabel);
		commonSearchLabel.setVisible(true);
		
	}
	
	public void materialScreen() {
		materialSearchLabel = new JLabel();
		materialSearchLabel.setBounds(0, 36, 280, 345);
		
		material1= new JButton("黄瓜");
		material1.setContentAreaFilled(false);
		material1.setBorder(BorderFactory.createRaisedBevelBorder());
		material1.setFocusPainted(false) ;
		material1.setContentAreaFilled(false);
		material1.setBorderPainted(false);
		material1.setForeground(Color.gray);
		material1.setFont(foodNameFont);
		material1.setBounds(30, 30, 80, 35);
		
		material2 = new JButton("茄子");
		material2.setContentAreaFilled(false);
		material2.setBorder(BorderFactory.createRaisedBevelBorder());
		material2.setFocusPainted(false) ;
		material2.setContentAreaFilled(false);
		material2.setBorderPainted(false);
		material2.setFont(foodNameFont);
		material2.setForeground(Color.gray);
		material2.setBounds(170, 30, 80, 35);
		
		material3 = new JButton("白菜");
		material3.setContentAreaFilled(false);
		material3.setBorder(BorderFactory.createRaisedBevelBorder());
		material3.setFocusPainted(false) ;
		material3.setContentAreaFilled(false);
		material3.setBorderPainted(false);
		material3.setForeground(Color.gray);
		material3.setFont(foodNameFont);
		material3.setBounds(30, 130, 80, 35);
		
		material4 = new JButton("西红柿");
		material4.setContentAreaFilled(false);
		material4.setBorder(BorderFactory.createRaisedBevelBorder());
		material4.setFocusPainted(false) ;
		material4.setContentAreaFilled(false);
		material4.setBorderPainted(false);
		material4.setForeground(Color.gray);
		material4.setFont(foodNameFont);
		material4.setBounds(170, 130, 80, 35);
		
		material5 = new JButton("卷心菜");
		material5.setContentAreaFilled(false);
		material5.setBorder(BorderFactory.createRaisedBevelBorder());
		material5.setFocusPainted(false) ;
		material5.setContentAreaFilled(false);
		material5.setBorderPainted(false);
		material5.setForeground(Color.gray);
		material5.setFont(foodNameFont);
		material5.setBounds(30, 230, 80, 35);
		
		material6 = new JButton("土豆");
		material6.setContentAreaFilled(false);
		material6.setBorder(BorderFactory.createRaisedBevelBorder());
		material6.setFocusPainted(false) ;
		material6.setContentAreaFilled(false);
		material6.setBorderPainted(false);
		material6.setForeground(Color.gray);
		material6.setFont(foodNameFont);
		material6.setBounds(170, 230, 80, 35);
		
		
		materialSearchLabel.add(material1);
		materialSearchLabel.add(material2);
		materialSearchLabel.add(material3);
		materialSearchLabel.add(material4);
		materialSearchLabel.add(material5);
		materialSearchLabel.add(material6);
		
		ScreenLabel.add(materialSearchLabel);
		materialSearchLabel.setVisible(false);
	}

	public void addListener() {
		commonButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				materialButton.setBorder(BorderFactory.createRaisedBevelBorder());
				hidematerial();
			}
		});
		commonButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					commonButton.setBorder(BorderFactory.createLoweredBevelBorder());
				}
				
			});
		materialButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				commonButton.setBorder(BorderFactory.createRaisedBevelBorder());
				hidecommon();
			}
			
		});
		materialButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				materialButton.setBorder(BorderFactory.createLoweredBevelBorder());
			}
			
		});
		
		previousButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				previousButton.setBorder(BorderFactory.createRaisedBevelBorder());
				if(pageflag > 0) {
					pageflag--;
					System.out.println(pageflag);
					sortscreen(foodflag,pageflag);
				}
			}
		});
		previousButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					previousButton.setBorder(BorderFactory.createLoweredBevelBorder());
				}
				
			});
		
		nextButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				nextButton.setBorder(BorderFactory.createRaisedBevelBorder());
				if(pageflag < 20) {
					
					System.out.println(pageflag);
					sortscreen(foodflag,pageflag);
					pageflag++;
				}
			}
		});
		nextButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				nextButton.setBorder(BorderFactory.createLoweredBevelBorder());
			}
			
		});
		
		searchButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				searchButton.setBorder(BorderFactory.createRaisedBevelBorder());
				pageflag = 0;
				foodflag =searchTextField.getText();
				sortscreen(foodflag,pageflag);
				
			}
		});
		searchButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				searchButton.setBorder(BorderFactory.createLoweredBevelBorder());
			}
			
		});
		
		sucai.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				sucai.setForeground(Color.red);
            }
			
		});
		sucai.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				sucai.setForeground(Color.gray);
			}
			
		});
		
		sucai.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				//String str = sucai.getText();
				pageflag = 0;
				foodflag = sucai.getText();
				sortscreen(foodflag , pageflag);
				
			}
		});
		huncai.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				huncai.setForeground(Color.red);
			}
			
		});
		huncai.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				huncai.setForeground(Color.gray);
			}
			
		});
		huncai.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				//String str = sucai.getText();
				pageflag = 0;
				foodflag = huncai.getText();
				sortscreen(foodflag , pageflag);
				
			}
		});
		gaifan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				gaifan.setForeground(Color.red);
			}
			
		});
		gaifan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				gaifan.setForeground(Color.gray);
			}
			
		});
		gaifan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				//String str = sucai.getText();
				pageflag = 0;
				foodflag = gaifan.getText();
				sortscreen(foodflag , pageflag);
				
			}
		});
		mianshi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mianshi.setForeground(Color.red);
			}
			
		});
		mianshi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				mianshi.setForeground(Color.gray);
			}
			
		});
		mianshi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				//String str = sucai.getText();
				pageflag = 0;
				foodflag = mianshi.getText();
				sortscreen(foodflag, pageflag);
				
			}
		});
		tanglei.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				tanglei.setForeground(Color.red);
			}
			
		});
		tanglei.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				tanglei.setForeground(Color.gray);
			}
			
		});
		tanglei.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				//String str = sucai.getText();
				pageflag = 0;
				foodflag = tanglei.getText();
				sortscreen(foodflag , pageflag);
				
			}
		});
		gaodian.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				gaodian.setForeground(Color.red);
			}
			
		});
		gaodian.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				gaodian.setForeground(Color.gray);
			}
			
		});
		gaodian.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				//String str = sucai.getText();
				pageflag = 0;
				foodflag = gaodian.getText();
				sortscreen(foodflag , pageflag);
				
			}
		});
		material1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				material1.setForeground(Color.red);
			}
			
		});
		material1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				material1.setForeground(Color.gray);
			}
			
		});
		material1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				material1.setBorder(BorderFactory.createRaisedBevelBorder());
				pageflag = 0;
				foodflag = material1.getText();
				sortscreen(foodflag , pageflag);
			}
		});
		material2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				material2.setForeground(Color.red);
			}
			
		});
		material2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				material2.setForeground(Color.gray);
			}
			
		});
		material2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				//String str = sucai.getText();
				pageflag = 0;
				foodflag = material2.getText();
				sortscreen(foodflag , pageflag);
				
			}
		});
		material3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				material3.setForeground(Color.red);
			}
			
		});
		material3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				material3.setForeground(Color.gray);
			}
			
		});
		material3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				//String str = sucai.getText();
				pageflag = 0;
				foodflag = material3.getText();
				sortscreen(foodflag , pageflag);
				
			}
		});
		material4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				material4.setForeground(Color.red);
			}
			
		});
		material4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				material4.setForeground(Color.gray);
			}
			
		});
		material4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				//String str = sucai.getText();
				pageflag = 0;
				foodflag = material4.getText();
				sortscreen(foodflag , pageflag);
				
			}
		});
		material5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				material5.setForeground(Color.red);
			}
			
		});
		material5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				material5.setForeground(Color.gray);
			}
			
		});
		material5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				//String str = sucai.getText();
				pageflag = 0;
				foodflag = material5.getText();
				sortscreen(foodflag , pageflag);
				
			}
		});
		material6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				material6.setForeground(Color.red);
			}
			
		});
		material6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				material6.setForeground(Color.gray);
			}
			
		});
		material6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				//String str = sucai.getText();
				pageflag = 0;
				foodflag = material6.getText();
				sortscreen(foodflag , pageflag);
				
			}
		});
		
		showMeunButton1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				showMeunButton1.setBorder(BorderFactory.createLoweredBevelBorder());
			}
			
		});
		
		showMeunButton1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				showMeunButton1.setBorder(BorderFactory.createRaisedBevelBorder());
				AbstractPay pay = new Pay(showMeunNameButton1.getText(), Username);
			}
		});
		
		showMeunButton2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				showMeunButton2.setBorder(BorderFactory.createLoweredBevelBorder());
				
			}
			
		});
		
		showMeunButton2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				showMeunButton2.setBorder(BorderFactory.createRaisedBevelBorder());
				Pay pay = new Pay(showMeunNameButton2.getText(),Username);
			}
			
		});
		
	}
	
	public void hidecommon() {
		materialSearchLabel.setVisible(true);
		commonSearchLabel.setVisible(false);
	}
	public void hidematerial() {
		
		commonSearchLabel.setVisible(true);
		materialSearchLabel.setVisible(false);
	}
	
	
	public abstract void sortscreen(String foodname,int i);
}
