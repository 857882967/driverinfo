<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	/* 设置浏览器禁止缓存 */
	response.setHeader("Cache-Control","no-cache");
	response.setHeader("Pragma","no-cache");
	response.setDateHeader("Expiress",-1);
	
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<!-- 然而这些还是不够的，有些浏览器还是缓存了文件，
那么就必须给每个文件加个后缀时间戳，告诉浏览器这个是新文件
，必须重新加载，浏览器就会从新到服务器端读取数据文件显示出来 -->
<meta HTTP-EQUIV="pragma" CONTENT="no-cache">
<meta HTTP-EQUIV="Cache-Control"
	CONTENT="no-cache,no-store, must-revalidate">
<meta HTTP-EQUIV="expires" CONTENT="Wed, 26 Feb 1997 08:21:57 GMT">
<meta HTTP-EQUIV="expires" CONTENT="0">

<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<link rel="stylesheet"
	href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>easyui/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>css/home/index.css">
<script type="text/javascript" src="<%=basePath%>easyui/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>easyui/jquery.easyui.min.js"></script>
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>easyui/locale/easyui-lang-zh_CN.js"></script>
<title>95128官方司机信息管理</title>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',border:false"
		style="height: 75px; background: deepskyblue; padding: 10px">
		<div style="float: left;">
			<img alt="" src="imgages/index/top/logo.png">
		</div>
		<div class="toploginUesr" style="float: right">
			<a class="loginU" href="javascript:void(0)"><img alt=""
				src="imgages/index/top/username.png"> <label>${loginUser.cname}</label></a>
			<a class="logout" href="user/login"> <img alt=""
				src="imgages/index/top/logout.png"><label>注销</label>
			</a>
		</div>
	</div>
	<div data-options="region:'west',split:true,title:''"
		style="width: 150px; padding: 10px;">
		<div id="leftMenu" class="menu">
			<c:forEach items="${auths}" var="auth">
				<ul>
					<li><a href='javascript:void(0)' title="" name="${auth.url},${auth.name}">${auth.title}</a></li>
				</ul>
			</c:forEach>
		</div>
	</div>
	<div data-options="region:'center',title:''">
	     <div id="contextCenter" class="easyui-panel" style="width:200px;height:100px;padding:0px;"
			data-options="fit:true,border:false,title:''">    
	     </div>
	</div>
	<div data-options="region:'south',border:false"
		style="height: 10px; background: #A9FACD; padding: 10px;"></div>
</body>
<script type="text/javascript" src="<%=basePath%>js/home/index.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/auth/auth.js"></script>
</html>
