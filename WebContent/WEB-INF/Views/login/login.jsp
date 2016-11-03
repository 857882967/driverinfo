<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="zh">
<head>
<base href="<%=basePath%>">
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<link rel="stylesheet" href="css/login/login.css">
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<title>95128官方管理系统登录</title>
</head>
<body>
<div class="wrapper">
	<div class="container" style="background-image:imgages/login/95128logo.png" >
	    <h1><img alt="" src="imgages/login/logo.png" width="50" height="50"></h1>
		<h1 class="title"><strong>95128</strong>官方司机管理系统</h1><p>v1.1</p>
		<form class="form" action="user/tologin" method="post">
			<input id="usname" name="usname" type="text" placeholder="用户名" required="required" maxlength="50" value="admin">
			<input id="psword" name="psword" type="password" placeholder="密码" required="required" maxlength="50" value="admin"><br>
			<button type="submit" id="login-button"><strong>登&nbsp;&nbsp;&nbsp;陆</strong></button>			
		</form>
	</div>
	<ul class="bg-bubbles">
		<li></li>
		<li></li>	
	</ul>
	<div id="mess" style="display:none;position:absolute;height:auto;width:auto;background-color:#67eaea;left:40%;top:40%;font-size:30px;padding:20px;color:red;border-radius:10px;z-index:1000">账户密码不匹配!</div>
	<input type="hidden" id="user" value="${loginUser}"/>
</div>
</body>
<script type="text/javascript">
   $("form").submit(function(){
	   var usname= $.trim($("#usname").val());
	   var psword= $.trim($("#psword").val());
	   if(usname.length>0&&psword.length>0){
		   return true;
	   }else{
		   return false;
	   }	 
	});
   
   //$("#mess").show();
   //$("#mess").slideUp("slow");
   //$("#mess").fadeOut("slow");
   function tripMess(){
	   var us=$("#user").val();
	   if(us=="null"){
		   $("#mess").slideDown();
		   setTimeout(function(){
		   $("#mess").slideUp("slow");
		   },2000);   
	   }
   }
   tripMess();
   
</script>
</html>
