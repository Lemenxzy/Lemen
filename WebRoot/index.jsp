<%@page import="dao.Musicdao"%>
<%@page import="been.Indexmusic"%>
<%@page import="dao.ConnectDao"%>
<%@page import="been.Content"%>
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
<%@include file="common/public.jsp" %>
<link href="css/index.css" rel=stylesheet type="text/css">
</head>
<body>
<% 

	Indexmusic music = Musicdao.getMusic(1);
	pageContext.setAttribute("music",music);

%>
	<!--头部开始-->
	<div id="top">
		<span class="glyphicon glyphicon-chevron-up"></span>
	</div>

	<header class="heaplay">
		<!--上导航-->
		<div class="container-fluid nav_audio">
		  <div class="row">
		    <div class="col-sm-1 col-xs-12"></div>
		    	<!--start audio-->
			    <div class="col-sm-8 col-xs-12">
			    	<div class="ontainer-fluid">
			    		<div class="row play">
		    				<div class="col-sm-4 col-xs-12 music_magges">
		    					<span class="glyphicon glyphicon-music music" aria-hidden="true"></span>
				    			<span>当前播放:</span>
				    			<div class="width"><marquee behavior="scroll"  scrollAmount="2"  direction="left"><span id="songname"></span></marquee></div>
		    				</div>
			    			<div class="col-sm-5 col-xs-12" id="show">
				    			<div class="progress">
									<div class="progress-bar progress-bar-danger progress-bar-striped" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" id="jindu"></div>
									<div class="music_btn" id="music_btn"></div>
									<div class="music_bg"></div>
								</div>
								<span class="ttime" id="ctime" style="margin-left:5px"></span>
								<span class="ttime">/</span>
								<span class="ttime" id="ttime"></span>
							</div>
							<div class="col-sm-3 col-xs-12 music_button">
								<a href="Javascript:void(0)" id="last"><span class="glyphicon glyphicon-backward music" aria-hidden="true"></span></a>
								<a href="Javascript:void(0)"><span class="glyphicon glyphicon-pause music" id="pause" aria-hidden="true"></span></a>
								<a href="Javascript:void(0)" id="next"><span class="glyphicon glyphicon-forward music" aria-hidden="true"></span></a>
								<a href="Javascript:void(0)"><span class="glyphicon glyphicon-volume-up music" id="volume" aria-hidden="true"></span></a>
								<div class="voidprogress" id="voidprogress">
									<div class="void_bar"></div>
									<div class="void_btn" id="void_btn"></div>
									<div class="void_bg"></div>
								</div>
							</div>
			    		</div>
			    	</div>
			    </div>
				<!--start loign-->
				
			<c:if test="${empty username}">
			    <div class="col-sm-2 col-xs-12">
			    	<div class="login">
			    		<div class="text-right">
			    			<a href="${basePath}/login.jsp">登录</a>
			    			<span style="color:#fefefe"> | </span>
			    			<a href="${basePath}/reg.jsp">注册</a>
			    		</div>
			    	</div>
			    </div>
			</c:if>    
			
			<c:if test="${not empty username}">
				<div class="col-sm-2 col-xs-12">
			    	<div class="login">
			    		<div class="text-right">
			    			<img src="${basePath}/${sessionScope.userhead}" width="25px" height="25px"/>
			    			<span style="color:#fefefe"><%=session.getAttribute("username")%></a>
			    			<span style="color:#fefefe"> | </span>
			    			<a href="${basePath}/server/loginout.jsp">注销</a>
			    		</div>
			    	</div>
			    </div>
			</c:if>
			    
		    <div class="col-sm-1 col-xs-12"></div>
		  </div>
		</div>
		<!--乐梦背景-->
		<div class="container-fluid nav_bg"  data-src="${music.musicSrc}" id="musicsrc">
				<div class="row">
					<h1>乐梦<span class="glyphicon glyphicon-music music animation-target" aria-hidden="true" id="musicbg"></span>博客<br /><small>Lenmen Design</small>
					</h1>
					<div class="hg_bg"></div>
				</div>
		</div>
		<!--end navbg-->
	</header>
	<!--nav start-->
	<%@include file="common/header.jsp" %>
	<!--end nav-->
	<!--头部结束-->
	<audio id = "audiomp3" autoplay="autoplay"></audio>
	<!--身体开始-->
	<section class="container-fluid tbody">
		<div class="row">
				<div class="col-md-1 pd" ></div>	
				<div class="col-md-10 col-sm-12">
					<!--轮播-->
					<div class="col-sm-9 col-xs-12 artbg">
						<div id="slide-example" data-interval="3000" class="carousel slide" data-ride="carousel">
						  <!-- 幻灯页面 -->
						  <div class="carousel-inner">
						    <div class="item active">
						      <a href="${basePath}/detail.jsp?id=19"><img src="http://7xngza.com1.z0.glb.clouddn.com/banner4.jpg" alt="设计思路"></a>
						      <div class="carousel-caption">
						        <p>逗比猿的设计思路。。。</p>
						      </div>
						    </div>
						    <div class="item">
						      <a href="${basePath}/detail.jsp?id=20"><img src="http://7xngza.com1.z0.glb.clouddn.com/banner2.jpg" alt="技术"></a>
						      <div class="carousel-caption">
						        <p>术业有专攻，学无止境</p>
						      </div>
						    </div>
						    <div class="item">
						      <a href="${basePath}/detail.jsp?id=8"><img src="http://7xngza.com1.z0.glb.clouddn.com/banner3.jpg" alt="青春乐曲"></a>
						      <div class="carousel-caption">
						        <p>夜晚就要听民谣</p>
						      </div>
						    </div>
						    <div class="item">
						      <a href="${basePath}/detail.jsp?id=6"><img src="http://7xngza.com1.z0.glb.clouddn.com/banner1.jpg" alt="梦想"></a>
						      <div class="carousel-caption">
						       <p>乐梦谈梦想</p>
						      </div>
						    </div>
						  </div>
						  
						  <!-- 幻灯切换控制 -->
						  <a class="left carousel-control" href="#slide-example" role="button" data-slide="prev">
						    <span class="glyphicon glyphicon-chevron-left"></span>
						    <span class="sr-only">上一个</span>
						  </a>
						  <a class="right carousel-control" href="#slide-example" role="button" data-slide="next">
						    <span class="glyphicon glyphicon-chevron-right"></span>
						    <span class="sr-only">下一个</span>
						  </a>
						  <!-- 圆点导航控制 -->
						  <ol class="carousel-indicators">
						    <li data-target="#slide-example" data-slide-to="0" class="active"></li>
						    <li data-target="#slide-example" data-slide-to="1"></li>
						    <li data-target="#slide-example" data-slide-to="2"></li>
						    <li data-target="#slide-example" data-slide-to="3"></li>
						  </ol>
						</div>

						<article class="bg">
							<div class="wlecome bd">
								<h2 class="wt"><span class="glyphicon glyphicon-glass"></span>&nbsp;欢迎光临</h2>
								<p class="cc">Lemen Design</p>
							</div>
							<div class="wlecome">
								<p class="wt sm">十分感谢您来到我的博客，我目前是一名大学生，web开发有2年左右，如果有不足之处值得改进的地方，希望各位前辈多加指点,感激不尽。Email:704694231@qq.com; &nbsp;&nbsp;&nbsp;TEL：18367490590; &nbsp;&nbsp;&nbsp;wechat：xzyzmai</p>
								<p class="cc">——Lemen</p>
							</div>
						</article>
						<%
							List<Content> contents = ConnectDao.findContents(2, 0, 3);
							pageContext.setAttribute("contents", contents);
						%>
						<article class="index_tittle">
							<div class="wlecome bd">
								<h2 class="wt">&nbsp;${navbars[0].name }</h2>
								<p class="cc">Nice article</p>
							</div>
						<div class="index_artical">
							<div class="row">
							
								<c:forEach items="${contents}" var="content">
									  <div class="col-sm-12 col-md-4">
									  	<a href="${basePath}/detail.jsp?id=${content.id}">
										    <div class="thumbnail">
										      <img class="scrollLoading" src="http://7xngza.com1.z0.glb.clouddn.com/jiazai.gif" data-url="${content.img}" width="300" height="200">
										      <div class="caption">
										        <h4>
													${tz:subTextString(content.title, 22)}
										        </h4>
										      </div>
										    </div>
									    </a>
									  </div>
								</c:forEach>
											
								<a href="${basePath}/class.jsp?id=${navbars[0].id}" class="btn btn-primary" role="button">查看更多</a> 
							</div><!--A模块-->
							<%
								List<Content> mccontents = ConnectDao.findContents(3, 0, 6);
								pageContext.setAttribute("mccontents", mccontents);
							%>
							<div class="wlecome bd">
								<h2 class="wt"> &nbsp;${navbars[1].name}</h2>
								<p class="cc">Radio station</p>
							</div>
							<div class="index_artical">
								<div class="row">
								<c:forEach items="${mccontents}" var="mccontent">
								  <div class="col-sm-12 col-md-4">
									  <a href="${basePath}/detail.jsp?id=${mccontent.id}">
									    <div class="thumbnail">
									      <img data-url="${mccontent.img}" class="scrollLoading" src="http://7xngza.com1.z0.glb.clouddn.com/jiazai.gif" width="300" height="200">
									      <div class="caption">
									        <h4>${mccontent.title}</h4>
									      </div>
									    </div>
									  </a>
								  </div>
								 </c:forEach>
								</div>
								<a href="${basePath}/class.jsp?id=${navbars[1].id}" class="btn btn-primary" role="button">查看更多</a> 
							</div>
							
							<%
								List<Content> jscontents = ConnectDao.findContents(4, 0, 6);
								pageContext.setAttribute("jscontents", jscontents);
							%>
							<div class="wlecome bd">
								<h2 class="wt">${navbars[2].name }</h2>
								<p class="cc">About technology</p>
							</div>
							<div class="index_artical art_text">
								<div class="row">
								  <c:forEach items="${jscontents}" var="jscontent">
									  <div class="col-sm-12 col-md-4">
									    <div class="thumbnail">
									      <div class="caption">
									        <h3>${tz:subTextString(jscontent.title, 50)}</h3>
									        <p>${tz:subTextString(jscontent.description,90)}</p>
									        <a href="${basePath}/detail.jsp?id=${jscontent.id}" class="btn btn-primary" role="button">全文</a>
									      </div>
									    </div>
									  </div>
								   </c:forEach>
								</div>
								<a href="${basePath}/class.jsp?id=${navbars[2].id}" class="btn btn-primary " role="button">查看更多</a> 
							</div>
							
							<div class="wlecome bd">
								<h2 class="wt">${navbars[3].name }</h2>
								<p class="cc">Lemen's quotations</p>
							</div>
							<div class="index_artical art_yulu">

							<%
								List<Content> xqcontents = ConnectDao.findContents(5, 0, 6);
								pageContext.setAttribute("xqcontents", xqcontents);
							%>
								<div class="art_text">
									<div class="row">
									<c:forEach items="${xqcontents}" var="xqcontent">
									  <div class="col-sm-12 col-md-4">
									    <div class="thumbnail">
									      <div class="caption">
									        <h3>${tz:subTextString(xqcontent.title, 30)}</h3>
									        <p>${tz:subTextString(xqcontent.description, 76)}</p>
									        <a href="${basePath}/detail.jsp?id=${xqcontent.id}" class="btn btn-primary" role="button">全文</a>
									      </div>
									    </div>
									  </div>
									   </c:forEach>
									</div>
								</div>
								<a href="${basePath}/class.jsp?id=${navbars[3].id}" class="btn btn-primary" role="button">查看更多</a> 
							</div>
						</article>
					</div>
					<!--右侧-->
					<aside class="col-sm-3 col-xs-12">
						<div class="asisst">
							<img src="http://7xngza.com1.z0.glb.clouddn.com/logoda.png" class="img-responsive logo">
							<div>
								<div class="know">
									<img src="http://7xngza.com1.z0.glb.clouddn.com/know.png"  class="img-responsive know_logo">
									<div class="konw_text">
										<span class="font_1">解读乐梦</span>
										<span>Account For Lemen</span>
									</div>
									<div class="clean"></div>
								</div>
								<div class="artical">
									<p class="tit">乐梦:</p>
									<p>顾名思义乐观的追求着梦想的理想主义青年，出生于天上脚下，跨过河西走廊，就读于浙江宁波万里学院，通信工程专业，”M“和上面的WIFI信号代表着这些。因为“乐”(yue)是多音字，这也象征着他热爱音乐，热爱民谣吉他，但由于时间的限制，他好像玩的并不是很精通（但还是很帅^_^）。</p>
									<p class="tit">Lemen:</p>
									<p>显然这是的汉字音译..中文翻译是柠檬草，,柠檬草这种植物适应性极强，对土壤的要求不高。这不是正好在说我吗? n(*≧▽≦*)n 于是，这个英文名就诞生了 ...</p>
								</div>
							</div>

							<div>
								<div class="know">
									<img src="http://7xngza.com1.z0.glb.clouddn.com/power.png"  class="img-responsive know_logo">
									<div class="konw_text">
										<span class="font_1">我的技能</span>
										<span>power</span>
									</div>
									<div class="clean"></div>
								</div>
								<div class="artical">
									<p>HTML:
									<div class="jdt">
										<div class="jd j1">90%</div>
									</div>
									</p>
									<p>HTML5:
									<div class="jdt">
										<div class="jd j2">72%</div>
									</div>
									</p>
									<p>CSS:
									<div class="jdt">
										<div class="jd j3">85%</div>
									</div></p>
									<p>CSS3:
									<div class="jdt">
										<div class="jd j4">75%</div>
									</div></p>
									<p>JS:
									<div class="jdt">
										<div class="jd j5">80%</div>
									</div></p>
									<p>Bootstrap:
									<div class="jdt">
										<div class="jd j6">70%</div>
									</div></p>
									<p>PHP:
									<div class="jdt">
										<div class="jd j7">50%</div>
									</div></p>
									<p>java:
									<div class="jdt">
										<div class="jd j7">60%</div>
									</div></p>
									<p>MySQL:
									<div class="jdt">
										<div class="jd j8">60%</div>
									</div></p>
									<p>吉他:
									<div class="jdt">
										<div class="jd j9">70%</div>
									</div></p>
								</div>
							</div>
						</div>
					</aside>
				</div>
				<div class="col-md-1 pd" ></div>
			
		</div>
	</section>

	<%@include file="common/footer.jsp" %>


<script type="text/javascript" src="js/index.js"></script>

</body>
</html>