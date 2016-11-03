<%@page import="com.driverinfo.hibernateEntity.Areas"%>
<%@page import="com.driverinfo.hibernateEntity.User"%>
<%@page import="com.driverinfo.context.ContextData"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>title</title>
<style type="text/css">
body {
	margin: 0xp;
	padding: 0px;
}
</style>
</head>
<body>
	<div class="container-fluid" style="margin:0px;padding:0px;">
		<div class="panel panel-primary">
			<form id="userFrom" method="post">
				<div class="panel-heading">
					<h5 class="panel-title">添加用户</h5>
				</div>
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
						<label for="area">角&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;色：</label>
						<c:if test="${lsRole!=null}">
							<select id="roleSelection">
								<c:forEach items="${lsRole}" var="role">
									<option name="<c:out value="${role.id}"></c:out>"><c:out
											value="${role.title}"></c:out></option>
								</c:forEach>
							</select>
						</c:if>
					</div>
					<div style="margin-top: 10px;">
						<label for="area">地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;区:</label>
						<c:if test="${lsProvince!=null}">
							<select id="cmbProvince">
								<c:forEach items="${lsProvince}" var="province">
									<option name="<c:out value="${province.name}"></c:out>"><c:out
											value="${province.desc}"></c:out></option>
								</c:forEach>
							</select>
						</c:if>
						省<select id="cmbCity"></select>市<select id="cmbArea"></select>县
					</div>
				</div>
				<div class="modal-footer" style="text-align: center;">
					<a href="user/index?authorithName=user" target="mainFrame"
						class="btn btn-default">返&nbsp;回</a>
					<button onclick="toAddUser()" class="btn btn-info">保&nbsp;存</button>
				</div>
			</form>
		</div>
	</div>
</body>
<script type="text/javascript">
	$("#roleSelection").change(function() {
		var roleId = $(this).children('option:selected').val();//selected的值 
		//var name = $("#roleSelection option:selected").attr("name");
		//alert("选中了=" + name)
		switch (roleId) {
		case 1:
			//system省

			break;
		case 2:
			//省级

			break;
		case 3:
			//市级sa

			break;
		case 4:
			//市级市级管理
			break;
		case 5:
			//县级管理
			break;
		case 6:
			//公司管理
			break;
		}
	});

	function toAddUser() {
		$.messager.alert("提示", "保存成功");
	}
</script>
</html>
