<%@page import="dao.Userhead"%>
<%@page import="been.Headimg"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>乐梦(lemen)博客</title>
<meta name="description" content="乐梦博客(lemen)，个人网站博客，从设计到前端到后台全是一个人编写，纯属娱乐">
<meta name="keywords" content="乐梦,lemen,博客,前端,设计,">
<%@include file="common/public.jsp" %>
<%@include file="common/taglib.jsp" %>
<link href="css/reg.css" rel=stylesheet type="text/css">
	<body>
		<%@include file="common/header.jsp" %>
		<% 
			List<Headimg> headimgs = Userhead.finduserHead(0, 21);
			pageContext.setAttribute("headimgs", headimgs);
		%>
		<div class="login_box">
			<div>
				<div class="login_logo"></div>

					<ul class="g_list">
						<li class="g_p">
							<span class="about">邮 箱：</span>
							<input type="text" class="ipt" placeholder="输入邮箱" id="email" onblur="chkvalue(this)"></input>
							<div class="ts" id="eml"></div>
						</li>
						<li class="g_u">
							<span class="about">昵称：</span>
							<input type="text" class="ipt" maxlength="18" placeholder="输入昵称" id="username" onblur="usname(this)"></input>
							<div class="ts" id="usn"></div>
						</li>
						<li class="g_p">
							<span class="about">密 码：</span>
							<input type="password" class="ipt" placeholder="6-32位密码" id="password" onblur="passworduser(this)"></input>
							<div class="ts" id="pass"></div>
						</li>
						<li class="g_p">
							<span class="about">确认密码：</span>
							<input type="password" class="ipt" placeholder="再次输入密码" id="agpassword" onblur="yzpw(this)"></input>
							<div class="ts" id="agpass"></div>
						</li>
						<li class="g_p">
							<span class="about">选择头像：</span>
							<div class="head_img" id="himg">
								<ul>
									<c:forEach items="${headimgs}" var="headimg">
									<li>
										<input type="radio" name="aaa" class="rd" name="img" value="${headimg.url}"> <img id="${headimg.id}" src="${headimg.url}" onclick="myFun(this.id)" >
									</li>
									</c:forEach>
									<div class="clear"></div>
								</ul>
							</div>
						</li>
					</ul>
					<a class="login_btn" href="javascript:void(0)" onclick="regbtn(this)" id="btnSumit">注 册</a>
			</div>
		</div>
		<p id="test" class="test"></p>
		
		
		<script type="text/javascript" src="js/reg.js"></script>
	</body>
</html>