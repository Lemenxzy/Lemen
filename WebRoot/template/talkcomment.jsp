<%@page import="dao.Talkingdao"%>
<%@page import="been.Talking"%>
<%@page import="gj.StringUrtil"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/taglib.jsp" %>
<%
int port = request.getServerPort();
String path = request.getContextPath();
String basePath = "";
if(port == 80){	
	basePath = request.getScheme()+"://"+request.getServerName()+path;	
}else{
	basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;		
}
request.setAttribute("basePath", basePath);
%>
<% 
	String cid = request.getParameter("id");
	if(cid != null && StringUrtil.isNum(cid)){
		String pno = request.getParameter("pno");
		String psize = request.getParameter("psize");
		if(StringUrtil.isEmpty(pno))pno = "0" ;
		if(StringUrtil.isEmpty(psize))psize = "10";
		
		List<Talking> talkings = Talkingdao.findTalkings(Integer.parseInt(cid), Integer.parseInt(pno), Integer.parseInt(psize));
		int count = Talkingdao.count(Integer.parseInt(cid));
		pageContext.setAttribute("talkings", talkings);
		pageContext.setAttribute("talkingcount", count);
	}else{
		response.sendRedirect("error.jsp");
	}

%>
<c:forEach items="${talkings}" var="talking" varStatus="cindex">
	<div class="talk_infor">
	<div class="discuss_img">
	<img src="${talking.header }">
	</div>
	<div class="discuss_word">
		<p>
			<a href="javascript:void(0);">${talking.username}</a>
			&nbsp;
			<span>${tz:timeFormat(talking.creatTime)}</span>
		</p>
		<p>${talking.content}</p>
	</div>
	<div class="discuss_operate">
		<span>${cindex.count}楼</span>
		<p>
			<a href="javascript:void(0);">回复</a>&nbsp;&nbsp;<span>|</span>&nbsp;&nbsp;
			<a href="javascript:void(0);">赞同</a>&nbsp;<span>(0)</span>
		</p>
	</div>
	<div style="clear:both;"></div>
	</div>
</c:forEach>