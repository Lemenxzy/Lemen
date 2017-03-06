<%@page import="dao.ConnectDao"%>
<%@page import="been.Content"%>
<%@page import="gj.StringUrtil"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>乐梦(lemen)博客</title>
<meta name="description" content="乐梦博客(lemen)，个人网站博客，从设计到前端到后台全是一个人编写，纯属娱乐">
<meta name="keywords" content="乐梦,lemen,博客,前端,设计,">
<%@ include file="common/public.jsp" %>
<link href="css/class.css" rel=stylesheet type="text/css">
</head>
<body>
	<div id="top">
		<span class="glyphicon glyphicon-chevron-up"></span>
	</div>

	<%@include file="common/header.jsp" %>
	<%
	String id1 = request.getParameter("id");
	String id2 = StringUrtil.StringFilter(id1);
	id2 = StringUrtil.replaceBlank(id2);
	
	if(id2 == null || StringUrtil.isnotNum(id2)){
		response.sendRedirect("error.jsp");
		return;//一定要加
	}else{
		Navbar navbar = NavbarDao.getcontentnav(Integer.parseInt(id2));
		pageContext.setAttribute("navbar", navbar);
	}
	
	%>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-1"></div>
				<div class="col-md-10">
						<div class="wlecome bd">
							<h2 class="wt">${navbar.name}</h2>
							<p class="cc">${navbar.ename }</p>
						</div>
						<div class="index_artical">
						<%

								List<Content> contents = ConnectDao.findContentss(Integer.parseInt(id2));
								pageContext.setAttribute("contents", contents);

						%>
							<div class="row">
							<c:forEach items="${contents}" var="content">
								  <div class="col-sm-12 col-md-3 pd">
								  	<a href="${basePath}/detail.jsp?id=${content.id}">
									    <div class="thumbnail">
									      <img class="scrollLoading" src="http://7xngza.com1.z0.glb.clouddn.com/jiazai.gif" data-url="${content.img}">
									      <div class="caption">
									        <h4>${tz:subTextString(content.title, 22)}</h4>
									      </div>
									    </div>
								    </a>
								  </div>
							</c:forEach>
								  
							</div>
						</div>

					</div>
				</div>
			<div class="col-md-1"></div>
		</div>
	</div>





<script type="text/javascript">

		//顶置以及小滑块
		$(function() { 
		var topmenu = $("#fixmenu");
		var topmenu_top = topmenu.offset().top;
		$(window).scroll(function() { 
			reset_topmenu_top(topmenu, topmenu_top); 
		}); 
		}); 
		
		function reset_topmenu_top(topmenu, topmenu_top) { 
		var document_scroll_top = $(document).scrollTop(); 
		if (document_scroll_top > topmenu_top) {
		topmenu.addClass("navbar-fixed-top");
		$("#top").fadeIn("slow");
		}else{
		topmenu.removeClass("navbar-fixed-top");
		$("#top").stop(true,true).fadeOut("slow");
		}
		} 
		$("#top").on('click touchmove',function(){
				$("html,body").animate({
				scrollTop:0
				},"slow");
		});

		//延时加载图片
		$(".scrollLoading").scrollLoading();
</script>
</body>
</html>