
package gj;


import java.util.Date;



/**
 * 
 * TzFunctions
 * 创建人:许智源 
 * 时间：2015年9月10日-下午11:17:02 
 * @version 1.0.0
 * 
 */
public class TzFunctions {

	
	/**
	 * 格式化日期
	 * com.tz.tld 
	 * 方法名：formatDate
	 * 创建人：许智源 
	 * 手机号码:15074816437
	 * 时间：2015年9月10日-下午11:17:34 
	 * @param date
	 * @param pattern
	 * @return 
	 * 返回类型：String
	 * @exception 
	 * @since  1.0.0
	 */
	
	public static String getTimeFormat(Date startTime){
		try{
			long startTimeMills = startTime.getTime();
			long endTimeMills = System.currentTimeMillis();
			long diff = (endTimeMills - startTimeMills)/1000;//秒
			long day_diff  = (long) Math.floor(diff/86400);//天
			StringBuffer buffer = new StringBuffer();
			if(day_diff<0){
				return "[error],时间越界...";
			}else{
				if(day_diff==0 && diff<60){
					if(diff==0)diff=1;
					buffer.append(diff+"秒前");
				}else if(day_diff==0 && diff<120){
					buffer.append("1 分钟前");
				}else if(day_diff==0 && diff<3600){
					buffer.append(Math.round(Math.floor(diff/60))+"分钟前");
				}else if(day_diff==0 && diff<7200){
					buffer.append("1小时前");
				}else if(day_diff==0 && diff<86400){
					buffer.append(Math.round(Math.floor(diff/3600))+"小时前");
				}else if(day_diff==1){
					buffer.append("1天前");
				}else if(day_diff<7){
					buffer.append(day_diff+"天前");
				}else if(day_diff <30){
					buffer.append(Math.round(Math.ceil( day_diff / 7 )) + " 星期前");
				}else if(day_diff >=30 && day_diff<=179 ){
					buffer.append(Math.round(Math.ceil( day_diff / 30 )) + "月前");
				}else if(day_diff >=180 && day_diff<365){
					buffer.append("半年前");
				}else if(day_diff>=365){
					buffer.append(Math.round(Math.ceil( day_diff /30/12))+"年前");
				}
			}
			return buffer.toString();
		}catch(Exception ex){
			return "";
		}
	}
}
