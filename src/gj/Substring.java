package gj;


    
public class Substring{  
	public static String subTextString(String str,int len){  
	    if(str.length()<len/2)return str;  
	    int count = 0;  
	    StringBuffer sb = new StringBuffer();  
	    String[] ss = str.split("");  
	    for(int i=1;i<ss.length;i++){  
	        count+=ss[i].getBytes().length>1?2:1;  
	        sb.append(ss[i]);  
	        if(count>=len)break;  
	    }  
	    //不需要显示...的可以直接return sb.toString();  
	    return (sb.toString().length()<str.length())?sb.append("...").toString():str;  
	}  
}  