<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<% 
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
	java.util.Date date=new java.util.Date();  
	String str=sdf.format(date); 
	String dateString = str.substring(0,4);
	pageContext.setAttribute("date", dateString);
%>
	
	<footer>
		<p>Copyright &copy;${date} 乐梦(Lemen)</p>
	</footer>
