<%@page import="dao.Talkingdao"%>
<%@page import="been.Talking"%>
<%@page import="gj.StringUrtil"%>
<%@page import="been.Content"%>
<%@page import="dao.ConnectDao"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/tz.tld" prefix="tz"%>
<!DOCTYPE html>
<%
String id1 = request.getParameter("id");
String id2 = StringUrtil.StringFilter(id1);
id2 = StringUrtil.replaceBlank(id2);
if(StringUrtil.isnotNum(id2) || id2==null){
	response.sendRedirect("error.jsp");
	return;
}else{
	Content content = ConnectDao.getContent(Integer.parseInt(id2));
	pageContext.setAttribute("content", content);
}
%>

<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>乐梦(lemen)博客</title>
<meta name="description" content="乐梦博客(lemen)，个人网站博客，从设计到前端到后台全是一个人编写，纯属娱乐">
<meta name="keywords" content="乐梦,lemen,博客,前端,设计,">
<%@ include file="common/public.jsp" %>
<link href="css/detail.css" rel=stylesheet type="text/css">
<script type="text/javascript" src="${basePath}/js/tz_page.js"></script>
</head>
<body data-opid="${content.id}">
	<div id="top">
		<span class="glyphicon glyphicon-chevron-up"></span>
	</div>
	<audio id = "audiomp3" autoplay="autoplay"></audio>
	<%@include file="common/header.jsp" %>
	

	<section class="container-fluid sec">
		<div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-10">
				<div class="row">
					<div class="col-md-6 col-xs-12 as">
						<img src="http://7xngza.com1.z0.glb.clouddn.com/gg1.jpg" class="img-responsive">
					</div>
					<div class="col-md-6 col-xs-12 as">
						<img src="http://7xngza.com1.z0.glb.clouddn.com/gg2.png" class="img-responsive">
					</div>
					<div class="col-md-12 col-xs-12 sec_sec">
						
						<p class="sec_title"><span>${content.title}</span></p>
						<p class="sec_keyword"><span>作者 : ${content.author}</span><span>日期 : <fmt:formatDate value="${content.creaTime}" type="both"/></span><span>分类 : ${content.channelName}</span></p>

						<div class="sec_content">
						<img src="${content.img }" class="img-responsive sec_logo">
						<div class="col-md-2 col-xs-1"></div>
						<div class="col-md-8 col-xs-10 context1">${content.content}</div>
						<div class="col-md-2 col-xs-1"></div>
						<div data-cotnt="${content.music}" id="contentbox" class="col-md-12 col-xs-12 content"></div>
						</div>
					</div>
					<div class="col-md-12 col-xs-12 talk">
						<textarea class="textarea_box" id="content" placeholder="快来抢沙发吧.." maxlength="600"></textarea>
						<div>
							<a href="javascript:void(0)" data-cid="${content.id}" class="talk_btn" id="btn">评论</a>
							<span class="talk_no">勿超过<span style="color:red">600</span>字</span>
							<div style="clear:both;"></div>
						</div>
						<% 
							String cid1 = request.getParameter("id");
							String cid2 = StringUrtil.StringFilter(cid1);
							cid2 = StringUrtil.replaceBlank(cid2);
							if(StringUrtil.isnotNum(cid2) || cid2 == null){
								response.sendRedirect("error.jsp");
								return;
							}else{
								List<Talking> talkings = Talkingdao.findTalkings(Integer.parseInt(cid2), 0, 10);
								int count = Talkingdao.count(Integer.parseInt(cid2));
								pageContext.setAttribute("talkings", talkings);
								pageContext.setAttribute("talkingcount", count);
								
							}
	
						%>
						<div class="talk_title">
							<span>全部评论（${talkingcount}）</span>
						</div>
						<div id="content_list" data-itcount="${talkingcount}">
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
									<p class="ctex">${talking.content}</p>
								</div>
								<div class="discuss_operate">
									<span>${cindex.count}楼</span>
									<!--<p>
										<a href="javascript:void(0);">回复</a>&nbsp;&nbsp;<span>|</span>&nbsp;&nbsp;
										<a href="javascript:void(0);">赞同</a>&nbsp;<span>(0)</span>
									</p>
									-->
								</div>
								<div style="clear:both;"></div>
								</div>
							</c:forEach>
						</div>
						
					</div>
				</div>
			</div>
			<div class="col-md-1"></div>
		</div>
	</section>

	<div id="page" class="page"></div>
	
	
	
	<%@include file="common/footer.jsp" %>



<script type="text/javascript" src="js/detail.js"></script>
</body>
</html>