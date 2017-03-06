<%@page import="gj.StringUrtil"%>
<%@page import="been.Talking"%>
<%@page import="dao.Talkingdao"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%


	Integer userId = (Integer)session.getAttribute("userId");//这里要强制转换因为返回的是一个obj类型,获取session中的id
	if(userId==null){
		out.print("nologin");
		return;
	}
	String content1 = request.getParameter("ctk");
	String content = StringUrtil.delHTMLTag(content1);
	if(content.length()>600){
		content=content.substring(0,600);
	}
	if(StringUrtil.isnotEmpty(content)){
		String cententId = request.getParameter("cid");
		Talking talking = new Talking();
		talking.setContent(content);
		talking.setUserId(userId);
		talking.setContentID(Integer.parseInt(cententId));
		talking.setIsDelete(0);
		boolean comment = Talkingdao.setTalking(talking);
		if (comment) {
			out.print("success");
		}else{
			out.print("fail");
		}
		
	}else{
		out.print("null");
	}

	
%>