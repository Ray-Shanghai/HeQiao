$(function(){
	$(".close").click(function(){
		$(this).parent().parent().parent().parent().parent().hide();
	});
});

function queryUnit(){
	$("#showDepart").hide();
	$("#showSeal").hide();
	$("#showFile").hide();
	$("#showCompany").show();
	getUnit(0,'');
}
function queryDepart(){
	$("#showDepart").show();
	$("#showSeal").hide();
	$("#showFile").hide();
	$("#showCompany").hide();
	getUnit(1,$("#doSignUnitId").val());
}
$(function(){
	$("#selectCompany").click(function(){
		var company=$("#showCompany").find("input[type='radio']:checked");
		$("#showCompany").hide();
		$("#doSignDepartId").val("");
		$("#doSignDepartName").val("");
		$("#doSignUnitId").val(company.val());
		$("#doSignUnitName").val(company.parent().next().text());
	});
	$("#selectDepart").click(function(){
		var depart=$("#showDepart").find("input[type='radio']:checked");
		$("#showDepart").hide();
		$("#doSignDepartId").val(depart.val());
		$("#doSignDepartName").val(depart.parent().next().text());
	});
});

function getUnit(type,unitId){
	var data= {
			isVirtual:type,
			unitId:unitId
	};
	$.ajax({  
  		type : 'POST',  
   		url : base.serverContet+'/manager/loginIn/SysDepartInfo/queryUnitList.do',  
 		data: data,  
  		async : false,  
  		success : function(data) { 
    	  	if(data.code=="000"){
    	  		$(".remove").remove();
    	  		/* $("select[name='doSignDepart']").html(""); */
    	  		$.each(data.list,function(index,tag){
    	  			/*var isSelect=false;*/
    	  			if("0"==type){
    	  				var check=this.unitId==data.user.unitId?"checked":"";
    	  				$("#showCompany").find(".th").parent().after("<tr class='remove'><td><input "+check+" class='radio' type='radio' name='companyRadio' value='"+this.unitId+"'></td><td>"+this.unitName+"</td></tr>");
    	  				/* if(this.unitId==data.user.unitId){
        	  				isSelect=true;
        	  			}
    	  				$("select[name='doSignUnit']").append(new Option(this.unitName,this.unitId,isSelect,isSelect)); */
    	  			}else{
    	  				var check=this.departId==data.user.departId?"checked":"";
    	  				$("#showDepart").find(".th").parent().after("<tr class='remove'><td><input "+check+" class='radio' type='radio' name='departRadio' value='"+this.departId+"'></td><td>"+this.departName+"</td></tr>");
    	  				/* if(this.departId==data.user.departId){
        	  				isSelect=true;
        	  			}
    	  				$("select[name='doSignDepart']").append(new Option(this.departName,this.departId,isSelect,isSelect)); */
    	  			}
    	  		});	
    			/* $("#doSignUnitId").val($("select[name='doSignUnit']").find("option:selected").val());
    			$("#doSignUnitName").val($("select[name='doSignUnit']").find("option:selected").text());
    	  		$("#doSignDepartId").val($("select[name='doSignDepart']").find("option:selected").val());
    			$("#doSignDepartName").val($("select[name='doSignDepart']").find("option:selected").text()); */
           	  }else{
        	    return false;
           	  }
  		   },error : function() {}  
		}); 
	}