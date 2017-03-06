<%@page import="dao.NavbarDao"%>
<%@page import="been.Navbar"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="taglib.jsp" %>

<% 
	List<Navbar> navbars = NavbarDao.getNavbar();
	pageContext.setAttribute("navbars", navbars);
%>

		<nav class="navbar navbar-default" id="fixmenu">
				<div class="container-fluid">
					<div class="row">
					   <div class="col-md-1"></div>
					   <div class="col-md-2">
						   <div class="navbar-header">
						      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
						        <span class="icon-bar"></span>
						        <span class="icon-bar"></span>
						        <span class="icon-bar"></span>
						      </button>
						      <a href="${basePath}" class="navbar-brand">
								<img src="http://7xngza.com1.z0.glb.clouddn.com/logo.png" alt="Responsive image">
						      </a>
						    </div>
						</div>
						<div class="col-md-8">
						    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
						      <ul class="nav navbar-nav" id="anserdh">
						      <li><a href="${basePath}" id="a1">首 页</a><div class="ease"></div></li>
						      <c:forEach items="${navbars}" var="navbar">
						        <li><a href="${basePath}/class.jsp?id=${navbar.id}">${navbar.name}</a><div class="ease"></div></li>
						      </c:forEach>
						      
						      </ul>
					     	<!-- 
					     	  <form class="navbar-form navbar-right" role="search">
						        <div class="form-group has-error">
						          <input type="text" class="form-control" placeholder="关键字">
						        </div>
						        <button type="submit" class="btn"><span class="glyphicon glyphicon-search"></span>搜索</button>
						      </form>
						 	--> 
					    	</div><!-- /.navbar-collapse -->
				    	</div>
				    	<div class="col-md-1"></div>
				   	</div>
			  	</div><!-- /.container-fluid -->
		</nav>
		<script type="text/javascript">
		(function(){
		    var tDiv = document.getElementById("anserdh"),
		        links = tDiv.getElementsByTagName("li"),
		        url1 = tDiv.getElementsByTagName("a"),
		        index = 0,//默认第一个菜单项
		        url2 = location.href.split('?')[0].split('/').pop(),
		        url = window.location.href;
		    if(url2){//如果有取到, 则进行匹配, 否则默认为首页(即index的值所指向的那个)
		        for (var i=url1.length; i--;) {//遍历 menu 的中连接地址
		            if(url1[i].href.indexOf(url) !== -1){
		                index = i;
		                break;
		            }
		        }
		    }

		    links[index].className = 'active';
		})();
		</script>