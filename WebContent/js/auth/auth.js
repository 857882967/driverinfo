/**
 * 
 */
$(document).ready(function(){
 //获取权限列表

 
 //点击角色加载权限
 $(".roleTitle").click(function(){
	 var roleId= $(this).attr("name");
	 $.ajax({
		 dataType:"json",
		 url:"auth/findByRoleId",
		 data:"roleId="+roleId,
		 success:function(lsAuth){
			if(lsAuth!=null){
				for (var i = 0; i < lsAuth.length; i++) {
				  if(lsAuth[i].type=="menu"){
					  
				  }
				}
			}
		 }
	 });
 });
 
 
 
 

 
 
 //角色列表下拉菜单
 
 
 //<div>
//	<label style="font-size: 20px;color:deepskyblue;">公司管理</label><input type="checkbox" style="margin-left:20px;" /><span>添加公司</span><input type="checkbox" style="margin-left:20px;" /><span>删除公司</span><input type="checkbox" style="margin-left:20px;" /><span>查询公司</span>
//	</div><hr>

 function addAuthtoPage(lsAuth){
	 var menuName=[];
	 for(var i=0;i<lsAuth.length;i++) {
		 var auth= lsAuth[i];		
		 if(auth.type=="menu"){
			 $("#roleContext").append("<div><label class='menulabel' name='"+auth.name+"'>"+auth.title+"</label></div>");
			 menuName.push(auth.name);
			 //$("#roleNameModule").append("<label>"+auth.title+"</label>");
		 }
	}
    for (var i = 0; i < menuName.length; i++) {
		for (var j = 0; j < lsAuth.length; j++) {
			if(lsAuth[j].name==menuName[i]&&lsAuth[j].type=="button"){
				$(".menulabel[name='"+menuName[i]+"']").append("<span>"+lsAuth[j].title+"</span>");
			}
		}
	}
 }
 
 
 //批量更新角色权限
 $("#btn_save").click(function(){
	 var inputs= $("#roleContext input");
	 if(inputs.length!=0){
		 for (var i = 0; i < inputs.length; i++) {
			var input =inputs[i];
			var checked= $(input).attr("checked");
			alert("checked="+checked);
		 }
	 }
 });
 
 
 
 
 
 
 
 
});
