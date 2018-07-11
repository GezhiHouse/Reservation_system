package org.lanqiao.Reservation_system.views;

import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public  abstract class AbstractUser_manual  extends JFrame{

	private Font font = new Font("楷体",  Font.BOLD, 14);
	
	private static JTextArea textArea;
	private JLabel backgroundLabel;
	private JScrollPane  JScrollpane;
	
	public AbstractUser_manual() {
		this.setFont(font);
		this.setTitle("用户服务手册");
		Image img = new ImageIcon("images\\\\Logo.jpg").getImage();
		this.setIconImage(img);
		init();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//设置布局为绝对定位
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(0,0,410, 510);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setFont(font);
		this.setVisible(true);
	}
	private void init() {
		Container con = this.getContentPane();
		
		backgroundLabel =  new JLabel();
		Image backgroundImage = new ImageIcon("images\\User_manual_background.jpg").getImage();
		backgroundLabel.setIcon(new ImageIcon(backgroundImage));
		backgroundLabel.setBounds(0,0,410, 500);
		
		textArea = new JTextArea();
		textArea.setFont(font);
		textArea.setLineWrap(true);
		
		JScrollpane = new JScrollPane();
		JScrollpane.setViewportView(textArea);
		JScrollpane.setBounds(0, 0, 410,500 );
		JScrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		con.add(JScrollpane);
		con.add(backgroundLabel);
		inputFile();
		
	}
	
	public static void inputFile() {
		try {
			InputStream in = new FileInputStream(new File("用户注册协议.txt"));
			byte[] data = new byte[1024];  
			int length = 0;
			 while ((length = in.read(data)) != -1) { 
				 	textArea.append(new String(data));
	            }  
		} catch (FileNotFoundException e) {
			System.out.println("没有相应的文件！");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
