package org.lanqiao.Reservation_system.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tel_verify {

	/** 
	  * �ֻ�����֤ 
	  * @author ��shijing 
	  * 2016��12��5������4:34:46 
	  * @param  str 
	  * @return ��֤ͨ������true 
	  */  
	 public static boolean isMobile(final String str) {  
	     Pattern p = null;  
	     Matcher m = null;  
	     boolean b = false;  
	     p = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$"); // ��֤�ֻ���  
	     m = p.matcher(str);  
	     b = m.matches();  
	     return b;  
	 }  
	 /** 
	  * �绰������֤ 
	  * @author ��shijing 
	  * 2016��12��5������4:34:21 
	  * @param  str 
	  * @return ��֤ͨ������true 
	  */  
	 public static boolean isPhone(final String str) {  
	     Pattern p1 = null, p2 = null;  
	     Matcher m = null;  
	     boolean b = false;  
	     p1 = Pattern.compile("^[0][1-9]{2,3}-[0-9]{5,10}$");  // ��֤�����ŵ�  
	     p2 = Pattern.compile("^[1-9]{1}[0-9]{5,8}$");         // ��֤û�����ŵ�  
	     if (str.length() > 9) {  
	        m = p1.matcher(str);  
	        b = m.matches();  
	     } else {  
	         m = p2.matcher(str);  
	        b = m.matches();  
	     }  
	     return b;  
	 }  
}
