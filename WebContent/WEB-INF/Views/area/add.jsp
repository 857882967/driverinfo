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
<script type="text/javascript"
	src="<%=basePath%>easyui/address/jsAddress.js"></script>
<title>添加地区</title>
</head>
<body style="padding:0px;">
	<!--
 系统用户添加所有省，市，县 ；省级可以添加市级，市级可以添加县级；
 省级添加成功后添加对应的driverCood carCood 表
-->
	<div class="container-fluid" style="padding:0px;margin: 0px;">
		<div class="panel panel-info">
			<div class="panel-heading">
				<h5>添加地区</h5>
			</div>
			<div class="panel-body">
				<div style="float:left;">
					<select id="cmbProvince"></select> 市：<select id="cmbCity"></select>
					区：<select id="cmbArea"></select>
				</div>
				<div style="float: left;">
					&nbsp;&nbsp;<button type="button" onclick="addArea()" class="btn btn-success btn-sm">确定添加</button>
				</div>
			</div>
			<div class="panel-food" style="text-align: center;">
			<button type="button" onclick="history.back()" class="btn btn-default btn-sm" >返&nbsp;&nbsp;回</button>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	addressInit('cmbProvince', 'cmbCity', 'cmbArea', '河南', '郑州市', '市辖区');
	function addArea(){
	var province=$.trim($("#cmbProvince").find("option:selected").text());
	var city=$.trim($("#cmbCity").find("option:selected").text());
	var county=$.trim($("#cmbArea").find("option:selected").text());
	if(province.length!=0&&city.length!=0&&county.length!=0){
	$.ajax({
		dataType:"json",
		type:"POST",
		url:"area/add",
		timeout:5000,
		data:{
			cmbProvince:province,
			cmbCity:city,
			cmbArea:county
		},
		success:function(data){
	 		
		}
	});	
	}
  }
</script>
</html>
