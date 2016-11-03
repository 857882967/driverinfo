<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<style type="text/css">
a{
text-decoration: none;
}
</style>
<title>95128官方信息管理系统</title>
</head>
<!-- a标签 target="mainFrame" 跳转名称  <frame  name="mainFrame"/>  -->
 <frameset rows="60,*,20" border="1px solid lightblue" scrolling="No" noresize="noresize"  framespacing="0">
	<frame src="user/top" name="topFrame" scrolling="No"  noresize="noresize" id="topFrame" />
	<frameset cols="175,*">
		<frame src="user/left"  noresize="noresize" scrolling="auto" />
		<frame id="centerContent" src="user/default"  name="mainFrame" scrolling="auto"/>
	</frameset>
		<frame src="user/food" name="bottomFrame" scrolling="No" noresize="noresize" id="bottomFrame" />
</frameset>
<noframes>
	<body>您的浏览器不支持框架！</body>
</noframes>
</html>
