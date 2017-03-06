<%@page import="dao.SavaUser"%>
<%@page import="gj.StringUrtil"%>
<%@page import="been.UserBeen"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String username = request.getParameter("username");
	username = StringUrtil.delHTMLTag(username);
	String password = request.getParameter("password");
	password = StringUrtil.delHTMLTag(password);
	String email = request.getParameter("email");
	email = StringUrtil.delHTMLTag(email);
	String userimg = request.getParameter("userimg");
	
	if(StringUrtil.isnotEmpty(username) && StringUrtil.isnotEmpty(password) && StringUrtil.isnotEmpty(email) && StringUrtil.isnotEmpty(userimg)){
		UserBeen user = new UserBeen();
		user.setUsername(username);
		user.setPassword(StringUrtil.md5Base64("xzy"+password));
		user.setEmail(email);
		user.setUserhead(userimg);
		boolean flag = SavaUser.savauser(user);
		if(flag){
			out.print("success");
		}else{
			out.print("fail");
		}
	}else{
		out.print("null");
	}
	
	
	
%>