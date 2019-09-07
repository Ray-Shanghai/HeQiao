$(document).ready(function() { 
	var code=window.location.search.split('=')[1].split('&')[0];;
	var noteId=window.location.search.split('=')[2].split('&')[0];
		var taskId=window.location.search.split('=')[3].split('&')[0];
		var noteType=window.location.search.split("=")[4];
    	var data={
    		code:code,
    		noteId:noteId,
    		taskId:taskId,
    		noteType:noteType
    	};
    	$(function(){
    		$.ajax({
    			type:'post',
    			url:base.serverContet+'/manager/loginIn/currencyNote/queryByPkIdForMysql.do',
    			data:data,
    			success:function(data){
    					   if(data.code=='000'){
    						   var currency=data.currencyNote;
    						   var currency=data.currencyNote;
	   	    					$("#title").text(currency.title);
	   	    					$("#createUserName").text(currency.createDepartName+"-"+currency.createUserName);
	   	    					$("#payee").text(currency.payee);
	   	    					$("#applyDate").text(currency.applyDate);
	   	    					$("#needDate").text(currency.needDate);
	   	    					$("#doMain").text(currency.doMain);
	   	    					$("#payMoney").text(currency.payMoney);
	   	    					$("#currentBudgetMoney").text(currency.currentBudgetMoney);
	   	    					$("#previousBudgetMoney").text(currency.previousBudgetMoney);
    	    					//给通过不通过的按钮上存值，审核时会用到
    	    					$(".back").attr("name",currency.noteType);
    	    					$(".agree").attr("name",currency.noteType);
    	    					$(".back").attr("value",taskId+"&"+noteId);
    	    			    	$(".agree").attr("value",taskId+"&"+noteId);
    	    			    	for (var i = 0; i < data.approvenTaksList.length; i++) {
    	    			    		var approven=data.approvenTaksList[i];
    	    			    		var result="";
    	    			    		if(approven.approvenStatus=="1"){
    	    			    			result="待审核";
    	    			    		}
    	    			    		if(approven.approvenResult=="1"){
    	    			    			result="审核通过"
    	    			    		}
    	    			    		if(approven.approvenResult=="2"){
    	    			    			result="审核未通过"
    	    			    		}
    	    			    		var position=approven.approvenPostionName;
    	    			    		var signImg;
    	    		            	if(approven.approvenSign==undefined ||approven.approvenSign==""){
    	    		            		 signImg="";
    	    		            	}else{
    	    		            		 signImg ="<img src='"+approven.approvenSign+"' style='width:1rem;height:1rem'>";
    	    		            	}
    	    		            	$(".approveOrder").append("<tr class='bgcolor-blue-tint'>"
    		            					+"<tr class='bgcolor-blue-tint'>"
    		            					+"<td rowspan='2'>"+approven.ruleOrderOld+"</td>"
    		            					+"<td>"
    		            					+"<p class='post-people'>"+position+"："+signImg+"</p>"								
    		            					+"</td>"
    		            					+"<td><p>"+result+"</p></td>"
    		            					+"<td>"+approven.approvenEndTime+"</td>"
    		            					+"</tr>"
    		            					+"<tr class='bgcolor-blue-tint'>"
    		            					+"<td colspan='3'><p class='pr-20'>意见："+approven.approvenRemark+"</p></td>"
    		            					+"</tr>");
    	    			      }
    	    			    	 for (var j = 0; j < data.expendTureList.length; j++) {
    			    			    	var expendDetail = data.expendTureList[j]; 
    			    			    	$(".expendTureDetail").after("<div class='table-four mt-20'>"
			    			    			+"<table border='0' cellpadding='0' cellspacing='0'>"
			    			    			+"<thead>"
			    			    			+"<tr>"
    										+"<td>项目"+(j+1)+"</td>"
    										+"<td>请款金额"+expendDetail.detailSumMoney+"</td>"
    										+"</tr>"
    										+"</thead>"
    										+"<tbody>"
    										+"<tr>"
    										+"<td width='30%' class='info-title'>电汇金额</td>"
    										+"<td width='70%'>"+expendDetail.detailCheckNo+"</td>"
    										+"</tr>"
    										+"<tr>"
    										+"<td width='30%' class='info-title'>银行别</td>"
    										+"<td width='70%'>"+expendDetail.detailBank+"</td>"
    										+"</tr>"
    										+"<tr>"
    										+"<td width='30%' class='info-title'>现金金额</td>"
    										+"<td width='70%'>"+expendDetail.detailCash+"</td>"
    										+"</tr>"
    										+"<tr>"
    										+"<td width='30%' class='info-title'>摘要</td>"
    										+"<td width='70%'>"+expendDetail.detailAbstract+"</td>"
    										+"</tr>"
    										+"</tbody>"
    										+"</table>"
    										+"</div>");
    								} 
    					   }else{
    						   base.alert(data,1);
    						   window.location.href="../heqiao/login.html";
    					   }
    			},error:function(reg){
    			}
    		});
    	});
 	});

function showAppreovenText(obj,auditStatus,isDetail){
	var noteType=$(obj).attr("name");
	var taskId=$(obj).attr("value").split("&")[0];
	var noteId=$(obj).attr("value").split("&")[1].split(",")[0];
	$("#remarkText").css("display","block");
	$(".ok").attr("val",auditStatus+","+isDetail+","+noteType+","+taskId+","+noteId);
}
function hideApprovenText(){
	$("#remarkText").css("display","none");
}
function openApproven(obj){
	if(obj==""||obj==undefined){
		alert("请签名");
		return;
	}
	$(".ok").attr("val");
	var auditStatus=$(".ok").attr("val").split(",")[0];
	var isDetail=$(".ok").attr("val").split(",")[1];
	var noteType=$(".ok").attr("val").split(",")[2];
	doApproven(obj,auditStatus,isDetail,noteType);
}
function showSignText(){
	$("#remarkText").css("display","none");
	$("#signText").addClass("signop");
  }
function closeSignText(){
	$("#remarkText").css("display","none");
	$("#signText").css("display","none");
	
 }
function showPdf(obj,url,isShow){
	$("#pdfContainer").attr("src","/HeQiao/wxpage/heqiao/viewer.html?name"+url);
	var state = "";
	if(isShow){
		state = "block";
	}else{
		state = "none";
	}
	var pop = document.getElementById("pop");
	pop.style.display = state;
	var lightbox = document.getElementById("lightbox");
	lightbox.style.display = state;
}
function close(){
	showPdf(false);
}
function downLoadPdf(obj){
	if(confirm("您真的要下载吗？")){
		$(obj).attr("href",obj);
	}
}