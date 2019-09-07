/**
 * 加载审批职位信息
 */
$(function(){
	var sourceTablePkColumnValue=$("input[name=sourceTablePkColumnValue]").val();
	$.ajax({
		url:base.serverContet+'/manager/loginIn/currencyNote/queryFirstPerson.do?sourceTablePkColumnValue='+sourceTablePkColumnValue,
		type:'get',
		async:false,
		success:function(data){
			if(data.code=='000'){
				var approven=data.sysApprovenTask;
				var position="";
	    		switch(approven.approvenPostion)
            	{
            	case "1":
            		approven.approvenPostion="董事长";
            	  break;
            	case "2":
            		approven.approvenPostion='营运长';
            	  break;
            	case "3":
            		approven.approvenPostion='总经理';
            	  break;
            	case "4":
            		approven.approvenPostion='部门总监';
            	  break;
            	case "5":
            		approven.approvenPostion='项目经理';
            	  break;
            	case "6":
            		approven.approvenPostion='财务总监';
            	  break;
            	case "7":
            		approven.approvenPostion='出纳';
            	  break;
            	case "8":
            		approven.approvenPostion='职员';
            	  break;
            	}
            	position=approven.approvenPostion;
				$("#firstPerson").after("："+position+" "+approven.approvenUserName);
			}
			else{
				alert(data.msg);
			}
		},error:function(reg){}
	});
});