
function roleAreaLoad(){
	
   var text= $("#roleSelection option:selected").val();
  if(text=="省级管理员"){
	   //获取所有的省级名称
	  //<select id="cmbCity"></select>市<select id="cmbArea"></select>县
	  $.ajax({
		  url:"areas/getAllProvince",
		  dataType:"json",
		  success:function(laAreas){
			if(laAreas!=null){
			$("#areas").append("<select id='cmbProvince'></select>");
				for (var i = 0; i < laAreas.length; i++) {
				  $("#cmbProvince").append("<option name='"+laAreas[i].name+"'>"+laAreas[i].desc+"</option>");
				}
				$("#cmbProvince option:eq(15)").prop("selected", 'selected');//默认选中河南省
			}
		  }
	  });
  }else if(text=="市级超级用户"||text=="市级管理员"){
	  
  }else if(text=="县级管理员"){
	  
  }else if(text=="公司管理员"){
	  
  }
   
}