<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<title></title>
</head>
<body style="margin:0px;overflow:hidden;background-color:deepskyblue;">
	<div
		style="width:100%;height:100%;padding-top:10px;">
		<div id="left" style="float: left; margin-left: 20px;">
			<img alt="95128" src="imgages/index/top/logo.png">
		</div>
		<div class="toploginUesr" style="float:right;margin-right:10px;">
			<a class="loginU" href="javascript:void(0)"><img alt=""
				src="imgages/index/top/username.png"> <label>张三丰</label></a>
			<a class="logout" href="user/login" target="_parent"> <img alt=""
				src="imgages/index/top/logout.png"><label>注销</label>
			</a>
		</div>
	</div>
</body>
</html>