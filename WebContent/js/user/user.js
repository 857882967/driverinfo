
$("#dgUsers").datagrid({
	singleSelect:true,
	fitColumns:true,
	striped:true,
	toolbar:"#dgUsersTb",
	loadMsg:"加載中,請稍等....",
	url:'user/findUsersbyUserid',
	columns:[[
	{field:'id',title:'id',hidden:true},
    {field:'name',title:'用户名',width:80,align:'center'},    
    {field:'cname',title:'昵称',width:80,align:'center'},
    {field:'areaName',title:'所属地区',width:80,align:'center'},
    {field:'createtime',title:'创建时间',width:80,align:'center',formatter:function(value,row,index){
    	if(value!=null&&value.length!=0){
    		return new Date(parseInt(value)).toLocaleDateString()
    	}
	}}
    ]],
	method:'get',
	rownumbers:true,
	autoRowHeight:false,
	pagination:true,
	pageNumber:1,
    pageSize:10, 
    pageList:[10,20,50],
	resizeHandle:'right',
});


 function toolbarFunciton(url) {
	switch (url) {
	case "user/add":
		window.location.href=url;
		break;
	case "user/update":
		$('#addUserModal').modal('show');
		$("#myModalTitle").text("更新用户");
		var selectRow = $("#dgUsers").datagrid('getSelected');
		if (selectRow != null) {
			window.location.href=url+"?userid="+selectRow.id;
		} else {
			$.messager.show({
				title : "提示",
				msg : "<label style='color:blue;font-size:18px;'>请选择一行数据</label>",
				showType : 'show'
			});
		}
		break;
	case "user/delete":
		var selectRow = $("#dgUsers").datagrid('getSelected');
		if (selectRow != null) {
			$.messager.confirm('提示', '<span>确定删除</span><Strong>'
					+ selectRow.cname + "</Strong>?", function(r) {
				if (r) {
					deleteUser(selectRow.id);
				}
			});
		} else {
			$.messager.show({
				title : "提示",
				msg : "<label style='color:blue;font-size:18px;'>请选择一行数据</label>",
				showType : 'show'
			});
		}
		break;
	default:
		break;
	}
  }
 //删除
  function deleteUser(userid){
	  if(userid.length!=0){
		  $.ajax({
				url:"user/delete?userid="+userid,
				dataType:"json",
				success:function(data){
				  $.messager.alert(data.name,data.desc);
				}
			});  
	  }
 }












//地区初始化 
//  addressInit('cmbProvince', 'cmbCity', 'cmbArea', '陕西', '宝鸡市', '金台区');
//addressInit('area','cmbProvince','cmbCity','cmbArea','华中地区', '河南', '郑州', '中原区');


//
// //地区下拉
//$('#provinceSelection').combobox({
//    url:'area/findProvinceByuserid',
//    valueField:'name',
//    textField:'desc',
//    onLoadSuccess:function(){
//    var citySelectionElement="<select id='citySelection' class='easyui-combobox' name='dept' style='width:70px;'>"
//    	citySelectionElement+="</select><label>市</label>"
//    	$("#lbsheng").append(citySelectionElement);
//    },
//    onSelect:function(record){
//      $("#citySelection").combobox({
//        url:'area/findCityByProvince?areaid='+record.name,
//        valueField:'name',
//        textField:'desc',
//      });
//    }
//   
//});
//
//  

  
  
  //工具功能栏按钮
//  $("#toolbarBtn a").click(function(){
//	 var text=$(this).text().trim();
//	 
//	 if(text=="添加用户"){
//		$("#Udialog").dialog('open');
//		$("#Udialog").dialog({
//	       title:"添加用户信息"
//		});
//		 $("#toAction").attr("name",$(this).attr("name"));
//		var url= $(this).attr("name");
//	 }else if(text=="修改用户"){
//		 var selectRow=$("#dgUsers").datagrid('getSelected');
//	 		if(selectRow!=null){
//	 			$("#Udialog").dialog('open');
//	 			$("#Udialog").dialog({
//	 				 title:"修改用户"
//	 			 });
//	 			 $("#toAction").attr("name",$(this).attr("name"));
//	 		}else{
//	 			$.messager.show({
//				 title:'提示',
//				 msg:"<label style='font-size:20px;color:blue;'>请选择数据</label>",
//				 timeout:5000,
//				 showType:'slide'
//	 		    });
//	 		}
//	 }else if(text=="删除用户"){
//		 var selectRow=$("#dgUsers").datagrid('getSelected');
//	  		if(selectRow!=null){
//	  			$.messager.confirm('提示','确定删除 '+selectRow.name+" ?",function(r){
//  			     if (r){
//  			    	
//  			     }
//	  			});
//	  		}else{
//	  			$.messager.show({
//	 			 title:'提示',
//	 			 msg:"<label style='font-size:20px;color:blue;'>请选择数据</label>",
//	 			 timeout:5000,
//	 			 showType:'slide'
//	  		    });
//	  		}    	
//	   }
//	 
//    if(selectRow!=null){
//      $("#userDialog").dialog("close");
//	   $.ajax({
//	     dataType:"json",
//	     url:url,
//	     data:{id:selectRow.id},
//	     success:function(reg){
//	       $.messager.alert(reg.name,"<label style='font-size:20px;color:blue'>"+reg.desc+"</label>");
//	     }
//	  });
//    }else{
//    	$.messager.show({
//		 title:'提示',
//		 msg:"<label style='font-size:20px;color:blue;'>请选择数据</label>",
//		 timeout:5000,
//		 showType:'slide'
//    	});
//    }
	 
//  });
  
//  $("#toolbarBtn a").click(function(){
//	 var name= $(this).attr("name");
//	 if(name=="user/add"){
//		 $("#Udialog").dialog('open').dialog("setTitle","添加用户");
//		 $("#toAction").attr("name",name);
//		 
//		 $('#addUserModal').modal('show');
//		 
//		 
//	 }else if(name=="user/update"){
//		 $("#Udialog").dialog('open').dialog("setTitle","修改用户");
//		 $("#toAction").attr("name",name);
//	 }else if(name=="user/delete"){
//		 var selectRow=$("#dgUsers").datagrid('getSelected');
//		 if(selectRow!=null){
//		 $.messager.confirm('提示','<Strong>确定删除'+selectRow.cname+"</Strong>?",function(r){
//		   if (r){
//		     
//		   }
//		 });
//		}else{
//			$.messager.show({
//				title:"提示",
//				showType:'show',
//				msg:"<label style='color:blue;font-size:18px;'>请选择数据</label>"
//			});
//		}
//	 }
//  });
//  
//  
  
  //确定动作
  $("#toAction").click(function(){
	 // $.messager.alert("url",$("#toAction").attr("name"));
	 // $("#toAction").removeAttr("name");
  });
  
  $("#toCancel").click(function(){
	  $("#Udialog").dialog("close");
  });
  
  
//密码重置
function resetPass(valueId){
 $.messager.confirm("确认","<h4 style='color:blue'>您确认想要重置此用户的密码吗？</h4>",function(r){    
    if (r){    
        $.ajax({
        dataType:"json",
        url:"user/resetPass",
        data:{Id:valueId},
        success:function(reg){
        if(reg=="1"){
        $.messager.alert("成功","<h4 style='color:green'>此用户密码重置成功，重置后的密码为：666666</h4>");
        }else{
        $.messager.alert("失败","<h4 style='color:red'>重置密码失败,请尝试重试！</h4>");
        }
        }
        });
    }    
}); 
}

//权限
$("#btnRole").click(function(){
	var row=$("#dgUsers").datagrid("getSelected");
	if(row!=null){
		$('#myModal').modal('show');
		$("#chp").val(row.chp);
		$("#sjname").val(row.sjname);
		$("#zgzh").val(row.zgzh);
		$("#sfzh").val(row.sfzh);
		$("#sjzz").val(row.sjzz);
		$("#lxdh").val(row.lxdh);
		$("#updateMess").text("");
	}else{
		$.messager.alert("提示","请选择要一用户");
	}
});


$("#searchUser").click(function(){
	var value=$("#parmValue").val().trim();
	if(value.length!=0&&value!=""){
		$("#dgUsers").datagrid({
			url:'user/findUsersbyParm',
			queryParams: {
				param:value,
			}
		});	
	}
});


//////




