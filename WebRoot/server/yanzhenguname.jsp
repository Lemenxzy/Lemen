<%@page import="dao.SavaUser"%>
<%@page import="been.UserBeen"%>
<%@page import="gj.StringUrtil"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String uname = request.getParameter("uname");
	uname = StringUrtil.delHTMLTag(uname);
	if(uname.length()>18){
		uname=uname.substring(0,18);
	}
	if(StringUrtil.isnotEmpty(uname)){
		UserBeen user = SavaUser.finduname(uname);
		if(user!=null){
			out.print("fail");
		}else{
			out.print("success");
		}
		
	}else{
		out.print("null");
	}


%>