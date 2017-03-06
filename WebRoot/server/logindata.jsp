<%@page import="been.UserBeen"%>
<%@page import="dao.LoginData"%>
<%@page import="gj.StringUrtil"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	
	if(StringUrtil.isnotEmpty(username) && StringUrtil.isnotEmpty(password)){
		UserBeen user = LoginData.logindata(username, StringUrtil.md5Base64("xzy"+password));

		if(user!=null){
			//放入会话
			user.setPassword(null);
			session.setAttribute("user", user);
			session.setAttribute("username",user.getUsername());
			session.setAttribute("userId", user.getId());
			session.setAttribute("userhead", user.getUserhead());
			out.print("success");
		}else{
			out.print("fail");
		}
	}else{
		out.print("null");
	}
%>