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
<meta http-equiv="Expires" content="0">
<meta http-equiv="kiben" content="no-cache">
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
<title>添加用户</title>
</head>
<body onload="roleAreaLoad()">
	<div class="container-fluid" style="margin:0px;padding:0px;">
		<div class="panel panel-info">
			<div class="panel-heading">添加用户</div>
			<div class="panel-body">
				<div>
					<label for="name">登&nbsp;录&nbsp;名:</label> <input type="text"
						name="name" maxlength="25" />
				</div>
				<div style="margin-top: 10px;">
					<label for="email">昵&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称:</label>
					<input name="cname" type="text" length="25">
				</div>
				<div style="margin-top: 10px;">
					<label for="email">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:</label>
					<input name="pwd" type="text" length="25">
				</div>
				<div style="margin-top: 10px;">
					<label for="email">确认密码</label> <input name="repwd" type="text"
						length="25">
				</div>
				<div id="" style="margin-top: 10px;">
				 <label for="role">角&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;色：</label>
						<c:if test="${lsRole!=null}">
							<select id="roleSelection">
								<c:forEach items="${lsRole}" var="role">
									<option name="${role.id}">${role.title}</option>
								</c:forEach>								
							</select>
						</c:if>
				</div>
				<div id="areas" style="margin-top: 10px;">
				  
				</div>
			</div>
			<div class="modal-footer" >
				<a href="user/index?authorithName=user" target="mainFrame"
					class="btn btn-default">返&nbsp;回</a>
				<button onclick="toAddUser()" class="btn btn-info">保&nbsp;存</button>
			</div>
		</div>
	</div>	
</body>
<script type="text/javascript" src="js/user/add.js"></script>
</html>
