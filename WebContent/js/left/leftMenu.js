$(".menuTitle").click(function(){
	 var next= $(this).next(".menuContent");
	 var display= $(next).css("dispaly");
	 if(display=="block"){
		 $(next).css("dispaly","none")
	 }else {
		 $(next).css("dispaly","block")
	 }
	 
});