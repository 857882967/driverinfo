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
	content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no,width=device-width" />
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
<body style="border-bottom: none;">
	<div class="container-fluid" style="padding: 0px; border:none">
		<div class="panel panel-info" style="border: none;">
			<div class="panel-heading">角色权限管理</div>
			<div class="panel-body" style="border:none;">
				<div id="roleNameModule" style="margin: 20px;">
					<label>角色名称:</label> <input id="roleSelection" name="dept" value="">
					<label>
						<a id="btn_save" href="javascript:void(0)" class="easyui-linkbutton" style="font-size:22px; margin-left:50px;" data-options="iconCls:'icon-save'">保&nbsp;&nbsp;存</a>
					</label>
				</div>
				<!-- menuAuthority  buttonAuthority -->
				<div id="roleContext"
					style="margin-top: 10px;text-align:center;  width: 100%; height: 100%">
					<c:if test="${listMenu!=null}">
						<c:forEach items="${listMenu}" var="menu">
							<div style="float:left;margin-left:20px;">
								<div class="toptitle"
									style="">
									<c:out value="${menu.menuAuthority.title}"></c:out>
								</div>
								<div
									style="background: #CCE6FF; width: 150px; height: 120px; padding-top: 10px;">
									<c:forEach items="${menu.buttonAuthority}" var="button">
										<ul style="list-style: none;">
											<li><input name="${button.id}" class="buttonCs"
												type="checkbox"><span><c:out
														value="${button.title}"></c:out></span></li>
										</ul>
									</c:forEach>
								</div>
							</div>
						</c:forEach>
					</c:if>
				</div>
			</div>
		</div>
	</div>
	<style type="text/css">
	.toptitle{
	background-color: dodgerblue; 
	color: white;
	width: 150px;
	height: 30px;
	text-align: center; padding-top: 2px;
	font-size: 18px;
 }
	</style>
<script type="text/javascript">
$("#roleSelection").combobox({
    url:'role/findbyAllToConvert',
    valueField:'name',
    textField:'desc',
    onSelect:function(record){
    var roleId=record.name;
	$.ajax({
	   type: "POST",
	   url: "auth/findByRoleId",
	   data:{roleId:roleId},
	   success: function(lsAuth){
	    if(lsAuth!=null){
	    	$(".buttonCs").removeAttr("checked");
	    	var buttons= $(".buttonCs");
	    	for (var i = 0; i < buttons.length; i++) {
				for (var j = 0; j < lsAuth.length; j++) {				
					if($(buttons[i]).attr("name")==lsAuth[j].id){
						$(buttons[i]).prop("checked",true);
					}			
				}
			}
	     }
	   }
 	});
   }
 });
</script>
</body>
</html>
