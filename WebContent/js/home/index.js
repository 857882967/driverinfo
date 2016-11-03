
$("#leftMenu a").click(function(event){
	var url=$(this).attr("name");
	//user/index,user
	 var urlname= url.split(",");
	 
	//var group=$(this).attr("title");
	//$("#contextCenter").layout({href:"user/manage?groupid="+group});href:'user/login'
	//$("#contextCenter").layout({href:"www.baidu.com"});
	$("#contextCenter").panel({
		href:urlname[0]+"?authorithName="+urlname[1]
	});
	
});


//$("#leftMenu a").click(function(event){
//	var url=$(this).attr("name");
//	//user/index,user
//	 var urlname= url.split(",");
//	 
//	$("#contextCenter").append("<iframe width='100%' height='100%' src='"+urlname[0]+"?authorithName="+urlname[1]+"'></iframe>");
//	
//});

