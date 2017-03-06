<%@page import="dao.SavaUser"%>
<%@page import="been.UserBeen"%>
<%@page import="gj.StringUrtil"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String email = request.getParameter("email");
	email = StringUrtil.delHTMLTag(email);
	if(StringUrtil.isnotEmpty(email)){
		UserBeen user = SavaUser.findemail(email);
		if(user!=null){
			out.print("fail");
		}else{
			out.print("success");
		}
		
	}else{
		out.print("null");
	}
%>					

