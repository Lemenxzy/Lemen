package gj;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import sun.misc.BASE64Encoder;

public class StringUrtil{
	
	/**
	 * 空判断 
	 * com.tz.util 
	 * 方法名：isEmpty
	 * 创建人：xuchengfei 
	 * 时间：2015年9月1日-下午11:47:57 
	 * @param content
	 * @return boolean
	 * @exception 
	 * @since  1.0.0
	 * 
	 */
	public static boolean isEmpty(String content){
		return (content==null || content.equals(""))?true:false;
	}
	
	
	/**
	 * 非空判断
	 * com.tz.util 
	 * 方法名：isNotEmpty
	 * 创建人：xuchengfei 
	 * 时间：2015年9月1日-下午11:48:08 
	 * @param content
	 * @return boolean
	 * @exception 
	 * @since  1.0.0
	 */
	public static boolean isnotEmpty(String content){
		return !isEmpty(content);
	}
	
	
	/**
	 * 
	 * 是否为数字
	 * gj 
	 * 方法名：base64Encode
	 * 创建人：许智源
	 * 手机号码：18367490590
	 * 邮箱：704694231@qq.com
	 * 时间：2015年12月25日-上午12:21:32 
	 * @param b
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	public static boolean isNum(String str){
		return str.matches("[0-9]+");
	}
	

	public static boolean isnotNum(String str){
		return !isNum(str);
	}
	/**
	 * 过滤所有特舒服特殊符
	 * (这里用一句话描述这个方法的作用)
	 * gj 
	 * 方法名：StringFilter
	 * 创建人：许智源
	 * 手机号码：18367490590
	 * 邮箱：704694231@qq.com
	 * 时间：2016年3月24日-下午3:21:28 
	 * @param str
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	public   static   String StringFilter(String   str){     
        // 只允许字母和数字       
        // String   regEx  =  "[^a-zA-Z0-9]";                     
           // 清除掉所有特殊字符  
	  String regEx="[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";  
	  Pattern   p   =   Pattern.compile(regEx);     
	  Matcher   m   =   p.matcher(str);     
	  return   m.replaceAll("").trim();     
	  } 
	
	public static String base64Encode(byte[] b) {
		if (b == null) {
			return null;
		}
		return new BASE64Encoder().encode(b);
	}
	
	/**
	 * md5加密
	 * 方法名：md5Base64<BR>
	 * 创建人：keke <BR>
	 * 时间：2014年11月28日-上午12:51:12 <BR>
	 * @param str
	 * @return String<BR>
	 * @exception <BR>
	 * @since  1.0.0
	 */
	public static String md5Base64(String str) {
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			return base64Encode(md5.digest(str.getBytes()));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * (过滤html)
	 * gj 
	 * 方法名：delHTMLTag
	 * 创建人：许智源
	 * 手机号码：18367490590
	 * 邮箱：704694231@qq.com
	 * 时间：2016年3月16日-下午3:25:05 
	 * @param htmlStr
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */

    public static String delHTMLTag(String htmlStr){ 
        String regEx_script="<script[^>]*?>[\\s\\S]*?<\\/script>"; //定义script的正则表达式 
        String regEx_style="<style[^>]*?>[\\s\\S]*?<\\/style>"; //定义style的正则表达式 
        String regEx_html="<[^>]+>"; //定义HTML标签的正则表达式 
         
        Pattern p_script=Pattern.compile(regEx_script,Pattern.CASE_INSENSITIVE); 
        Matcher m_script=p_script.matcher(htmlStr); 
        htmlStr=m_script.replaceAll(""); //过滤script标签 
         
        Pattern p_style=Pattern.compile(regEx_style,Pattern.CASE_INSENSITIVE); 
        Matcher m_style=p_style.matcher(htmlStr); 
        htmlStr=m_style.replaceAll(""); //过滤style标签 
         
        Pattern p_html=Pattern.compile(regEx_html,Pattern.CASE_INSENSITIVE); 
        Matcher m_html=p_html.matcher(htmlStr); 
        htmlStr=m_html.replaceAll(""); //过滤html标签 

        return htmlStr.trim(); //返回文本字符串 
    } 

	
	
    /**
	 * 去空去换行
	 * (这里用一句话描述这个方法的作用)
	 * gj 
	 * 方法名：replaceBlank
	 * 创建人：许智源
	 * 手机号码：18367490590
	 * 邮箱：704694231@qq.com
	 * 时间：2016年3月24日-下午3:32:02 
	 * @param str
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	public static String replaceBlank(String str) {
        String dest = "";
        if (str!=null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
       
        return dest;
    }
	

	
	
	
	public static void main(String[] args) {
		
		System.out.println(md5Base64("keke123456"));
		String str1="1122.2.2";
		String str2="-111";
		String str3="1112";
		String str4="111s";
		String str5="111.s";
		String str6="1s11";
		System.out.println(str1+":"+isNum(str1));
		System.out.println(str2+":"+isNum(str2));
		System.out.println(str3+":"+isNum(str3));
		System.out.println(str4+":"+isNum(str4));
		System.out.println(str5+":"+isNum(str5));
		System.out.println(str6+":"+isNum(str6));
		String html = "<p style='color:red'>abcdefg</p><script type='text/javascript'>alert(0)</script>";
		System.out.println("删除后：" + delHTMLTag(html));
		String str7 = "<p>70469423@qq.com</p>";
		System.out.println("删除后：" + delHTMLTag(str7));
		
		System.out.println(isnotNum("d21s21a"));
		System.out.println(isNum("a2121"));
		String f1 = "2 das;'';lp[";
		String f2 = StringFilter(f1);
		System.out.println(f2);
		System.out.println(replaceBlank(f2));

		
	}
}

