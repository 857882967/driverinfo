
//d.id,d.name,d.sex,d.sfzh,d.zgzh,d.address.d.lxdh,d.driverNo,d.
$("#dgDriver").datagrid({
		singleSelect : true,
		fitColumns : true,
		url:"driver/findAll",
		toolbar:"#dgUsersTb",
		striped : true,
		loadMsg : "加載中,請稍等....",
		columns : [ [{
			field : 'id',
			hidden : true
		},{
			field : 'sjname',
			title : '司机姓名',
			width : 80,
			align : 'center'
		}, {
			field : 'sex',
			title : '性别',
			width : 80,
			align : 'center'
		}, {
			field : 'zgzh',
			title : '资格证号',
			width : 120,
			align : 'center',
			formatter : function(value, row, index) {
				return "No." + value;
			}
		}, {
			field : 'lxdh',
			title : '联系电话',
			width : 150,
			align : 'center'
		}, {
			field : 'sfzh',
			title : '身份证号',
			width : 150,
			align : 'center'
		}, {
			field : 'address',
			title : '司机住址',
			width : 180,
			align : 'center'
		}, {
			field : 'driverNo',
			title : '驾驶证',
			width : 180,
			align : 'center'
		}, {
			field : 'driverLevel',
			title : '证件等级',
			width : 80,
			align : 'center'
		},{
			field : 'createtime',
			title : '创建时间',
			width : 170,
			align : 'center',
			formatter : function(value, row, index) {
				return new Date(value).toLocaleString();
			}
		} ] ],
		method : 'get',
		rownumbers : true,
		autoRowHeight : false,
		pagination : true,
		pageNumber : 1,
		pageSize : 10,
		pageList : [ 10, 20, 50 ],
		resizeHandle : 'right',
	});
	function searchBtn() {
		var value = $("#searchValue").val();
		if (value != ""&&value.length>0) {
			var select = document.getElementById("driverSelectType");
			var index = document.getElementById("driverSelectType").selectedIndex;//索引
			var type = select.options[index].value; // 选中值
			$("#dgDriver").datagrid({
				url : 'driver/findByProperty',
				queryParams : {
					type : type,
					value : value,
					companyId : $("#showDriverComId").val()
				}
			});
		} else {
			$("#dgDriver").datagrid({
				url : 'driver/findAll',
				queryParams : {
					companyId : $("#showDriverComId").val()
				}
			});
		}
	}
	/////////////update////////////////////
	$("#btn-toupdate").click(function(){
		var row=$("#dgDriver").datagrid("getSelected");
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
		 alert("请选择要修改的行");	
		}
	});
	$("#btn_update").click(function(){		
		$.ajax({
			url:'driver/updateDriver',
			type:'post',
			data:{	
				chp:$("#chp").val(),
				sjname:$("#sjname").val(),
				zgzh:$("#zgzh").val(),
				sfzh:$("#sfzh").val(),
				sjzz:$("#sjzz").val(),
				lxdh:$("#lxdh").val()
			},
			success:function(data){
				if(data=='1'){
					$("#updateMess").text("修改成功！").css("color","green");
					$("#dgDriver").datagrid("reload");
				}else{
					$("#updateMess").text("修改失败！").css("color","red");
				}
			}
		});
	});


	

//公司列表   
$("#companycombox").combobox({
	onLoadSuccess: function(param){
	var companyData=$('#companycombox').combobox('getData');
	$('#companycombox').combobox('select',companyData[0].name);
	},
	onSelect:function(record){		
		 $('#dgDriver').datagrid({
			 url : 'driver/findbyCompanyid',
			 queryParams: {
				 companyId: record.name
				}			
		});
	}
});

//导出Excel
$("#driverToExcel").click(function(){
	$("#driverToExcel").attr("href","driver/toExcel?compandyId="+$("#companycombox").combobox("getValue"));
});
//删除deleteByid
$("#btnDelete").click(function(){
	var row=$("#dgDriver").datagrid("getSelected");
	if(row!=null){
		$.messager.confirm('注意', '确定删除车牌号:'+row.chp+'&nbsp;吗?', function(r){
		 if (r){
			 $.ajax({
				   type: "POST",
				   url: "driver/deleteByid?id="+row.id,
				   success: function(msg){
				     if(msg=="success"){
				    	 $.messager.show({
			    			title:'提示',
			    			msg:'删除成功',
			    			timeout:2000,
			    			showType:'slide'
				    	 });
				    	 $('#dgDriver').datagrid("reload");
				     }else if(msg=="fail"){
				    	 $.messager.show({
			    			title:'提示',
			    			msg:"<label style='color'>删除失败</label>",
			    			timeout:2000,
			    			showType:'slide'
					     }); 
				     }
				   }
				});	
		   }
		});
	}else{
	$.messager.alert('提示','请选择要删除的一行!','info');	
	}
});

//准备更新
$("#btnToUpdate").click(function(){
	var row=$("#dgDriver").datagrid("getSelected");
	if(row!=null){
		$('#myModal').modal('show');
		$("#modalTitle").text("修改信息");
		$("#driverId").val(row.id);
		$("#chp").val(row.chp);
		$("#sjname").val(row.sjname);
		$("#zgzh").val(row.zgzh);
		$("#sfzh").val(row.sfzh);
		$("#sjzz").val(row.sjzz);
		$("#lxdh").val(row.lxdh);
		$("#updateMess").text("");
	}else{
	$.messager.alert('提示','请选择要修改的一行!','info');	
	}
});

function updateDriver(){
	$.ajax({
		url:'driver/updateDriver',
		type:'POST',
		data:{
			id:$("#driverId").val(),
			chp:$("#chp").val(),
			sjname:$("#sjname").val(),
			zgzh:$("#zgzh").val(),
			sfzh:$("#sfzh").val(),
			sjzz:$("#sjzz").val(),
			lxdh:$("#lxdh").val()
		},
		success:function(data){
			if(data=='success'){
				$("#updateMess").text("修改成功！").css("color","green");
				$("#dgDriver").datagrid("reload");
			}else if(data=='fail'){
				$("#updateMess").text("修改失败！").css("color","red");
			}
			setTimeout(function(){
				$("#updateMess").text("");
			},2000)
		}
	});
}
//确定更新或更新
$("#btnUpdate").click(function(){
	var title= $("#modalTitle").text();
	if(title=="修改信息"){
		updateDriver();
	}else if(title=="添加司机"){
		addDriver();
	}
});

//添加
$("#btnAdd").click(function(){
	if($("#companycombox").combobox("getValue")=="0"){
		$.messager.alert('提示','请选择对应公司!','info');
	}else{
		$('#myModal').modal('show');
		$("#modalTitle").text("添加司机");	
	}
});


function addDriver(){
	var chp=$("#chp").val();
	var sjname=$("#sjname").val();
	var zgzh=$("#zgzh").val();
	var sfzh=$("#sfzh").val();
	var sjzz=$("#sjzz").val();
	var lxdh=$("#lxdh").val();
	if(testValues(sfzh,lxdh)){
		$.ajax({
			url:'driver/addDriver',
			type:'POST',
			data:{
				chp:chp,
				sjname:sjname,
				zgzh:zgzh,
				sfzh:sfzh,
				sjzz:sjzz,
				lxdh:lxdh,
				companyId:$("#companycombox").combobox("getValue")
			},
			success:function(data){
				if(data=='success'){
					$("#updateMess").text("添加成功!").css("color","green");
					$("#dgDriver").datagrid("reload");
				}else if(data=='fail'){
					$("#updateMess").text("添加失败,请检查身份证信息!").css("color","red");
				}
				setTimeout(function(){
					$("#updateMess").text("")
				},2000)
			}
		});
	}	
}

//表单验证
function testValues(sfzh,lxdh){
	var reg=true;
	var Tsfzh=/^\d{17}\d|X$/;
	var Tlxdh=/^\d{11}$/;
	if(!Tsfzh.test(sfzh)){
		reg=false;
		$("#updateMess").text("身份证号格式错误！").css("color","red");
	}else if(!Tlxdh.test(lxdh)){
		reg=false;
		$("#updateMess").text("手机号格式错误！").css("color","red");
	}
	return reg;
}


$("#btnSearch").click(function(){
	var value= $.trim($("#parmValue").val());
	var sd=$("#parmType").combobox("getValue");
	if(value.length>0){
		$('#dgDriver').datagrid({
			 url :'driver/findbyParm',
			 method:"POST",
			 queryParams: {
				 parm:$("#parmType").combobox("getValue"),
				 value:value
			}
		});
	}else{
		$('#dgDriver').datagrid({
			 url : 'driver/findbyCompanyid',
			 queryParams: {
			   companyId: $("#companycombox").combobox("getValue")
			}			
		});
	}
});
