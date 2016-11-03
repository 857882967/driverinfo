<%@page import="com.driverinfo.hibernateEntity.Authority"%>
<%@page import="com.driverinfo.hibernateEntity.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="initial-scale=1.0, maximum-scale=1.0,user-scalable=no,width=device-width" />
<meta http-equiv="pragma" content="no-cache">
<link rel="stylesheet"
	href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>/easyui/themes/bootstrap/datagrid.css">
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>easyui/jquery.easyui.min.js"></script>
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>easyui/locale/easyui-lang-zh_CN.js"></script>
</head>
<body>
	<script type="text/javascript">
		
		
	</script>
	<div class="container-fluid" style="padding: 0px; margin: 0px;">
		<div class="panel panel-info">
			<div class="panel-heading">用户管理</div>
			<div class="panel-body" style="">
				<table id="dgUsers" class="easyui-datagrid"
					style="width: 750px; height: 500px;"></table>
				<div id="dgUsersTb" style="padding: 5px; height: auto">
					<div id="toolbarBtn" style="margin-bottom: 5px">
						<c:forEach items="${lsauth}" var="authBtn">
							<a
								onclick="toolbarFunciton('<c:out value="${authBtn.url}"></c:out>')"
								href="javascript:void(0)" class="easyui-linkbutton"
								iconCls="<c:out value="${authBtn.icon}"></c:out>" plain="true"><c:out
									value="${authBtn.title}"></c:out></a>
						</c:forEach>
					</div>
					<div>
						<label>地区:</label><select id="cc" class="easyui-combobox"
							name="dept" style="width: 100px;">
							<option>中心</option>
						</select><span>省</span><select id="cc" class="easyui-combobox" name="dept"
							style="width: 100px;">
							<option>中心</option>
						</select><span>市</span><select id="cc" class="easyui-combobox" name="dept"
							style="width: 100px;">
							<option>eitem5</option>
						</select><span>县</span> <label style="font-size: 20px; margin-left: 20px;">用户名:</label>
						<input id="parmValue" class="easyui-textbox"
							style="width: 150px; height: 26px" placeholder="请输入用户名">
						<a id="searchUser" href="javascript:void(0)"
							class="easyui-linkbutton" iconCls="icon-search">查询</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="<%=basePath%>js/user/user.js"></script>
</body>
</html>
