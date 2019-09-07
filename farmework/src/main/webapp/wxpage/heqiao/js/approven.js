 
 /**
 * @param obj this
 * @param auditStatus 审核状态 2：同意 3：不同意
 * @param isDetail 用来判断是从列表过来的审批（0：是 1：否）
 * @param noteType 类型（1，通用 2，支出 3，请假）
 */
function doApproven(obj,auditStatus,isDetail,noteType){
    		var status="";
    		var taskId=$(".ok").attr("val").split(",")[3];
    		var noteId=$(".ok").attr("val").split(",")[4];
    		var approvResult="";
    		if(auditStatus=='2'){
    			status=auditStatus;
        		approvResult="1";
    		}
			if(auditStatus=='3'){
    			status=auditStatus;
    			approvResult="2";
    		}
    		if(confirm("你真的要审核吗？")){
    			var data  = {
    					auditStatus:status,
						approvenResult:approvResult,
						taskId:taskId,
						noteId:noteId,
						approvenRemark:$("textarea[name=approvenRemark]").val(),
						noteType:noteType,
						approvenSign:obj
				}
				$.ajax({  
		      		type : 'POST',  
		       		url : base.serverContet+'/manager/loginIn/currencyNote/saveApproven.do',
		       		data: data,
		       		async : false,  
		      		success : function(data) {  
		        	  	if(data.code=="000"){
		        		     alert("审批成功");
		            	     window.location.href=base.serverContet+"/wxpage/heqiao/index.html";
		               	  }else{
		               		base.alert(data,1);
		               		$("#remarkText").css("display","none");
		               	  }
		      		   },error : function() {}  
		  		}); 
    		}
    	}