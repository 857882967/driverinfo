<%@page import="java.util.ArrayList"%>
<%@page import="com.driverinfo.hibernateEntity.Authority"%>
<%@page import="java.util.List"%>
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
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet"
	href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet"
	href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/left/leftMenu.js"></script>
<title>title</title>
<style type="text/css">
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	padding: 20px;
}

.menuTitle {
	width: 150px;
	background-color: cornflowerblue;
	text-align: center;
	border-radius: 5px 5px 0px 0px;
	font-size: 20px;
}

.menuContent ul {
	list-style: none;
	margin-left: -10px;
	line-height: 20px;
	font-size: 18px;
	padding-bottom: 10px;
}

.menu {
	text-align: center;
	width: 150px;
	height: auto;
	border: 1px solid cornflowerblue;
	border-radius: 7px 7px 0px 0px;
}

.menu1 {
	line-height: 20px;
}
</style>
</head>
<body>
	<%
		Object obj = request.getAttribute("leftMenu");
		if (obj != null) {
			List<Authority> ls = (List<Authority>) obj;
			List<String> baseMenu = new ArrayList<String>();
			baseMenu.add("user");
			baseMenu.add("company");
			baseMenu.add("driver");
			baseMenu.add("car");
	%>
	<!-- 菜单 -->
	<div id="menu1" class="menu" style="">
		<div class="menuTitle" style="">基础管理</div>
		<div class="menuContent" style="display: block;">
			<ul class="menu1">
				<%
					for (int i = 0; i < ls.size(); i++) {
							if (ls.get(i).getType().equals("menu")) {
								if (baseMenu.contains(ls.get(i).getName())) {
				%>
				<li style="margin-top:5px;"><a href="<%=ls.get(i).getUrl()%>?authorithName=<%=ls.get(i).getName()%>" target="mainFrame"><%=ls.get(i).getTitle()%></a></li>
				<%
					}
							}
						}
					}
				%>
			</ul>
		</div>
	</div>
	<!-- 菜单 -->
</body>
<script type="text/javascript">
	$(".menuTitle").click(function() {
		var dis = $(this).next().css("display");
		if (dis == "block") {
			$(this).next().css("display", "none");
		} else {
			$(this).next().css("display", "block");
		}
	});
</script>
</html>
