$("#dgCompany").datagrid({
	singleSelect:true,
	toolbar:"#dgUsersTb",
	fitColumns:true,
	striped:true,
	loadMsg:"加載中,請稍等....",
	url:'company/findAll',
	columns:[[
    {field:'id',hidden:true},
    {field:'allName',title:'公司全称',width:120,align:'center'},    
    {field:'simpleName',title:'公司简称',width:80,align:'center'},
    {field:'area',title:'所在地区',width:80,align:'center'},
    {field:'phone',title:'联系电话',width:80,align:'center'},
    {field:'createtime',title:'创建时间',width:120,align:'center',formatter:function(value,row,index){
    return  new Date(value).toLocaleString();     
    }}
    ]],
	method:'POST',
	rownumbers:true,
	autoRowHeight:false,
	pagination:true,
	pageNumber:1,
    pageSize:10, 
    pageList:[10,20,50],
	resizeHandle:'right',
});


$("#btnAdd").click(function(){
	$('#myModal').modal('show');
});
$("#subAddCom").click(function(){
	
	
	
});

function roleTest(){
	var com=$("#company").val();
	var comsimple=$("#companySimple").val();
	var cmprovin=$("#cmbProvince").val();
	var cmcity=$("#cmbCity").val();
	var cmgjphone=$("#gjphone").val();
	if(com.length>2&&comsimple.length>2&&cmprovin.length>2&&cmcity.length>2){
		$.ajax({
			dataType:"json",
			type:"POST",
			url:"company/addcompany",
			data:{com:com,comsimple:comsimple,cmprovin:cmprovin,cmcity:cmcity,cmgjphone:cmgjphone},
		    success:function(data){
		    	alert(data);
		    }
		});
	}else{
		
	}
}







//地区初始化
//addressInit('area','cmbProvince','cmbCity','cmbArea','华中地区', '河南', '郑州', '中原区');




