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
	<div class="panel panel-info">
		<div class="panel-heading">修改用户</div>
		<div class="panel-body">
			<form id="userFrom" method="post">
				<div>
					<label for="name">登&nbsp;录&nbsp;名:</label> <input
						class="easyui-validatebox" type="text" name="name"
						data-options="required:true" maxlength="25" />
				</div>
				<div style="margin-top: 10px;">
					<label for="email">昵&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称:</label>
					<input name="adduser" type="text" length="25"> <input
						class="easyui-validatebox" type="text" name="email"
						data-options="required:true" maxlength="25" />
				</div>
				<div style="margin-top: 10px;">
					省：<select id="cmbProvince"></select> 市：<select id="cmbCity"></select>
					区：<select id="cmbArea"></select>
				</div>
				<div id="" style="margin-top:10px;">
					<label for="area">角&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;色：</label><select
						id="roleSelection" class="easyui-combobox" name="dept"
						style="width:170px; margin-left: 10px;"
						data-options="editable:false">
					</select>
				</div>
			</form>
		</div>
		<div class="modal-footer" style="text-align: center;">
			<button class="btn btn-default" onclick="history.back()">返&nbsp;&nbsp;回</button>
			<button class="btn btn-info">确定修改</button>
		</div>
	</div>
</body>
</html>
