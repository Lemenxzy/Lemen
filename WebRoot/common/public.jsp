<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=no">
<link rel="Shortcut Icon" href="${basePath}/images/favicon.ico" type="image/x-icon" />
<link href="http://apps.bdimg.com/libs/bootstrap/3.2.0/css/bootstrap.min.css" rel=stylesheet type="text/css">
<link href="http://apps.bdimg.com/libs/bootstrap/3.2.0/css/bootstrap-theme.min.css" rel=stylesheet type="text/css">
<script type="text/javascript" src="http://libs.baidu.com/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="http://apps.bdimg.com/libs/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${basePath}/js/jquery.scrollLoading-min.js"></script>
<script type="text/javascript" src="${basePath}/js/sgutil.js"></script>
<script type="text/javascript">var basePath = "${basePath}";</script>

