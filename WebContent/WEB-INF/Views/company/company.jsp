<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<title>公司管理</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no,width=device-width" />
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet"
	href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>/easyui/themes/icon.css">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>/easyui/locale/easyui-lang-zh_CN.js"></script>
</head>
<body>
	<div class="container-fluid" style="padding:0px;">
		<div class="panel panel-info">
			<div class="panel-heading">公司管理</div>
			<div class="panel-body">
				<table id="dgCompany" class="easyui-datagrid"
					style="width: 800px; height: 450px;">
				</table>
				<div id="dgUsersTb" style="padding: 5px; height: auto">
					<div style="margin-bottom: 5px">
						<c:forEach items="${lsauth}" var="authBtn">
							<a name="<c:out value="${authBtn.url}"></c:out>" href="javascript:void(0)"
								class="easyui-linkbutton"
								iconCls="<c:out value="${authBtn.icon}"></c:out>" plain="true"><c:out
									value="${authBtn.title}"></c:out></a>
						</c:forEach>
					</div>
					<div>
						<input class="easyui-textbox" style="width: 150px"> <a
							href="javascript:void(0)" class="easyui-linkbutton"
							iconCls="icon-search">查 询</a>
					</div>
				</div>
				<!-- add -->
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
								<h4 id="modalTitle" class="modal-title" id="myModalLabel">新增公司</h4>
							</div>
							<div class="modal-body">
								<div class="input-group" style="margin-top: 10px;">
									<span class="input-group-addon">公司全称</span><input id="company"
										type="text" name="allName" class="form-control"
										placeholder="例如：深圳市腾讯计算机系统有限公司" required="required"
										maxlength="50">
								</div>
								<div class="input-group" style="margin-top: 10px;">
									<span class="input-group-addon">公司简称</span><input id="companySimple"
										type="text" name="simplName" class="form-control"
										placeholder="例如：腾讯公司" required="required" maxlength="20">
								</div>
								<div class="input-group" style="margin-top: 10px;">
									<span class="input-group-addon">地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;区</span>&nbsp;&nbsp;<select
										id="area"></select> 省：<select id="cmbProvince" name="province"></select>
									市：<select id="cmbCity" name="City"></select> <select
										id="cmbArea" style="display: none"></select>
								</div>
								<div class="input-group" style="margin-top: 10px;">
									<span class="input-group-addon">公司电话</span><input type="number"
										id="gjphone" name="phone" class="form-control" placeholder=""
										required="required" maxlength="20">
								</div>
								<div class="row" style="margin-top: 10px;">
									<div class="col-md-6">
										<strong id="addcompanyRes" style="font-size: large;">${regMess}</strong>
									</div>
									<div class="col-md-2">
										<button type="reset" class="btn btn-default">重 置</button>
									</div>
									<div class="col-md-2">
										<button id="subAddCom" type="submit" class="btn btn-info">提交</button>
									</div>
									<div class="col-md-2"></div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- add -->
			</div>
		</div>
	</div>
	<script type="text/javascript" src="<%=basePath%>js/company/company.js"></script>
</body>
<script src="js/province/jsAddress.js"></script>

</html>
