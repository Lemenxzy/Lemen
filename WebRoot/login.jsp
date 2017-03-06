<%@page import="gj.StringUrtil"%>
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
<link href="css/login.css" rel=stylesheet type="text/css">
	<body>
		<%
		String username = (String)session.getAttribute("username");
			if(StringUrtil.isnotEmpty(username)){
				response.sendRedirect(basePath);//重定向
			}
		%>	
	
		<%@include file="common/header.jsp" %>
		<div class="login_box">
			<div>
				<div class="login_logo"></div>
				<div class="login">
					<ul class="g_list">
						<li class="g_u">
							<input type="text" class="ipt" placeholder="请输入邮箱" id="username"></input>
						</li>
						<li class="g_p">
							<input type="password" class="ipt" placeholder="密码" id="password"></input>
						</li>
					</ul>
					<a class="login_btn" href="javascript:void(0)" onclick="login(this)" id="btnSumit">登 录</a>
					<div class="g_feedback">
						<a href="javascript:void(0)" class="f_fgt">忘了密码？(该功能还未完成)</a>
						<a href="${basePath}/reg.jsp" class="f_reg">立即注册</a>				
					</div>
				</div>
			</div>
		</div>
		<div class="reader" id="reader"></div>

	<script type="text/javascript" src="js/login.js"></script>
	</body>
</html>