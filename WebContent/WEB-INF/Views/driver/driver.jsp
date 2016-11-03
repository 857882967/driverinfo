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
<title>查看司機</title>
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
	<div class="panel panel-info">
		<div class="panel-heading">司机管理</div>
		<div class="panel-body">
			<table id="dgDriver" class="easyui-datagrid"
				style="width: 1000px; height: 450px;"></table>
			<!-- 工具栏 -->
			<div id="dgUsersTb" style="padding: 5px; height: auto">
				<div style="margin-bottom: 5px">
					<c:forEach items="${lsauth}" var="authBtn">
						<a name="<c:out value="${authBtn.url}"></c:out>"
							href="javascript:void(0)" class="easyui-linkbutton"
							iconCls="<c:out value="${authBtn.icon}"></c:out>" plain="true"><c:out
								value="${authBtn.title}"></c:out></a>
					</c:forEach>
				</div>
				<div>
					公司:<input id="companycombox" class="easyui-combobox" name="company"
						style="width: auto;"
						data-options="url:'company/getbyuserid',method:'get',valueField:'name',textField:'desc'">
					<select id="parmType" class="easyui-combobox" panelHeight="auto"
						style="width: auto;">
						<option value="chp">车 牌 号 码</option>
						<option value="sjname">司 机 姓 名</option>
						<option value="lxdh">联 系 电 话</option>
						<option value="sfzh">身 份 证 号</option>
					</select> <input id="parmValue" class="easyui-textbox"
						style="width: 150px; height: 26px"> <a id="btnSearch"
						class="easyui-linkbutton" iconCls="icon-search">查&nbsp;&nbsp;询</a>
					<a id="driverToExcel" class="easyui-linkbutton" iconCls="icon-redo"
						style="margin-left: 25px;">导出Excel</a>
				</div>
			</div>
			<!-- 工具栏 -->
			<!-- 模态 -->
			<!-- Modal -->
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 id="modalTitle" class="modal-title" id="myModalLabel">修改信息</h4>
						</div>
						<div class="modal-body">
							<div class="input-group">
								<input id="driverId" type="hidden" value="" /> <span
									class="input-group-addon">车&nbsp;&nbsp;牌&nbsp;&nbsp;号:</span> <input
									id="chp" type="text" class="form-control" required="required"
									maxlength="5" placeholder="例如:T9786" />
							</div>
							<div class="input-group" style="margin-top: 10px;">
								<span class="input-group-addon">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名:</span>
								<input id="sjname" type="text" class="form-control"
									required="required" placeholder="例如:张三" maxlength="10">
							</div>
							<div class="input-group" style="margin-top: 10px;">
								<span class="input-group-addon">资格证号:</span> <input type="text"
									id="zgzh" class="form-control" required="required"
									placeholder="例如:41011321221234" maxlength="19">
							</div>
							<div class="input-group" style="margin-top: 10px;">
								<span class="input-group-addon">身份证号:</span> <input type="text"
									id="sfzh" class="form-control" required="required"
									placeholder="请输入司机的身份证号" maxlength="18">
							</div>
							<div class="input-group" style="margin-top: 10px;">
								<span class="input-group-addon">住&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;址:</span>
								<input id="sjzz" type="text" class="form-control"
									required="required" placeholder="请输入司机的住址" maxlength="50">
							</div>
							<div class="input-group" style="margin-top: 10px;">
								<span class="input-group-addon">联系电话:</span> <input id="lxdh"
									type="text" class="form-control" required="required"
									placeholder="请输入司机的手机号码" maxlength="11">
							</div>
						</div>
						<div class="modal-footer">
							<label id="updateMess" style="font-size: 20px;">添加失败,请检查身份证信息</label>
							<button type="button" class="btn btn-default"
								data-dismiss="modal">取 消</button>
							<button id="btnUpdate" type="submit" class="btn btn-primary">确定保存</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="<%=basePath%>js/driver/driver.js"></script>
</body>
</html>
