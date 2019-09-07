/**
 * 遍历三种不同类型的申请单
 */
$(function(){
	var code=window.location.search.split("&")[0].split("=")[1];
	$.ajax({
		url:base.serverContet+'/manager/loginIn/currencyNote/queryWaitingListAll.do',
		type:'post',
		data:{code:code},
		async:false,
		success:function(data){
			if(data.code=='000'){
				for (var i = 0; i < data.currency.length; i++) {
					var noteType=data.currency[i].note_type;
				if(noteType.substring(0,1)=='3'){
					$('#notice').after("<div class='detail-class mt-40'>"
						+"<div class='title'>通用申请</div>"
						+"<div class='apply'>"
						+"<div class='info-all'>"+data.currency[i].title+"</div>"
						+"<div class='person-info'>"
						+"<div class='pb-20'>申请人："+data.currency[i].CREATE_USER_NAME+"</div>"
						+"<div class='pb-20'>签呈主旨："+data.currency[i].do_main+"</div>"
						+"<div class='word-time'>日期："+data.currency[i].CREATE_TIME.substring(0,data.currency[i].CREATE_TIME.length-9)+"</div>"
						+"</div>"
						+"<div class='apple-detail'><a href='currencyDetail.html?code=0&noteId="+data.currency[i].note_id+"&taskId="+data.currency[i].task_id+"&noteType="+noteType+"' class='md-blue-btn'>详细内容</a></div>"
						+"<div class='btn-index row mt-20'>"
						+"<div class='col-6 pr-20'><a class='md-blue-btn mr-20 come-back agree' onclick='showAppreovenText(this,2,0,"+noteType+")' value='"+data.currency[i].task_id+"&"+data.currency[i].note_id+","+data.currency[i].note_type+"'>通过</a></div>"
						+"<div class='col-6 pl-20'><a class='md-blue-border-btn come-back' onclick='showAppreovenText(this,3,0,"+noteType+")' value='"+data.currency[i].task_id+"&"+data.currency[i].note_id+","+data.currency[i].note_type+"'>退回</a></div>"
						+"</div>"
						+"</div>"
						+"</div>");
				}
				if(noteType.substring(0,1)=='1'){
					$('#notice').after("<div class='detail-class mt-40'>"
						+"<div class='title'>支出申请</div>"
						+"<div class='apply'>"
						+"<div class='info-all'>"+data.currency[i].title+"</div>"
						+"<div class='person-info'>"
						+"<div class='pb-20'>申请人："+data.currency[i].CREATE_USER_NAME+"</div>"
						+"<div class='word-time'>日期："+data.currency[i].CREATE_TIME.substring(0,data.currency[i].CREATE_TIME.length-9)+"</div>"
						+"<div class='pb-20'>"+data.currency[i].do_main+"</div>"
						+"<div class='pb-20'>本案实支金额："+data.currency[i].pay_money+"</div>"
						+"</div>"
						+"<div class='apple-detail'><a href='payDetail.html?code=0&noteId="+data.currency[i].note_id+"&taskId="+data.currency[i].task_id+"&noteType="+noteType+"' class='md-blue-btn'>详细内容</a></div>"
						+"<div class='btn-index row mt-20'>"
						+"<div class='col-6 pr-20'><a class='md-blue-btn mr-20 come-back' onclick='showAppreovenText(this,2,0,"+noteType+")' value='"+data.currency[i].task_id+"&"+data.currency[i].note_id+","+data.currency[i].note_type+"'>通过</a></div>"
						+"<div class='col-6 pl-20'><a class='md-blue-border-btn come-back' onclick='showAppreovenText(this,3,0,"+noteType+")' value='"+data.currency[i].task_id+"&"+data.currency[i].note_id+","+data.currency[i].note_type+"'>退回</a></div>"
						+"</div>"
						+"</div>"
						+"</div>");
				}
				if(noteType.substring(0,1)=='2'){
	            	var leave_type=data.currency[i].leave_type;
	            	$('#notice').after("<div class='detail-class mt-40'>"
	            			+"<div class='title'>请假申请</div>"
	            			+"<div class='apply'>"
	            			+"<div class='info-all'>"+data.currency[i].title+"</div>"
	            			+"<div class='person-info'>"
	            			+"<div class='pb-20'>申请人："+data.currency[i].CREATE_USER_NAME+"<span class='fr'>"+leave_type+"："+data.currency[i].leave_total_time+"</span></div>"
	            			+"<div class='word-time'>请假起止时间："+data.currency[i].leave_start_date+" "+data.currency[i].leave_start_time+"至"+data.currency[i].leave_end_date+" "+data.currency[i].leave_end_time+"</div>"
	            			+"</div>"
	            			+"<div class='apple-detail'><a href='leaveDetail.html?code=0&noteId="+data.currency[i].note_id+"&taskId="+data.currency[i].task_id+"&noteType="+noteType+"' class='md-blue-btn'>详细内容</a></div>"
	            			+"<div class='btn-index row mt-20'>"
	            			+"<div class='col-6 pr-20'><a class='md-blue-btn mr-20 come-backagree' onclick='showAppreovenText(this,2,0,"+noteType+")' value='"+data.currency[i].task_id+"&"+data.currency[i].note_id+","+data.currency[i].note_type+"'>通过</a></div>"
	            			+"<div class='col-6 pl-20'><a class='md-blue-border-btn' onclick='showAppreovenText(this,3,0,"+noteType+")' value='"+data.currency[i].task_id+"&"+data.currency[i].note_id+","+data.currency[i].note_type+"'>退回</a></div>"
	            			+"</div>"
	            			+"</div>"
	            			+"</div>");
				}
				}
			}
			else{
				base.alert(data,1);
				window.location.href="../heqiao/login.html";
			}
		}
	});
});
function showAppreovenText(obj,auditStatus,isDetail,noteType){
	var taskId=$(obj).attr('value').split('&')[0];
	var noteId=$(obj).attr('value').split('&')[1].split(',')[0];
	$('#remarkText').css('display','block');
	$('.ok').attr('val',auditStatus+','+isDetail+','+noteType+','+taskId+','+noteId);
	
}
function hideApprovenText(){
	$('#remarkText').css('display','none');
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
	$("#approvenRemark").val("");
 }
/**
 * 遍历系统公告
 */
$(function(){
	$.ajax({
		url: base.serverContet+'/manager/loginIn/notice/queryListForWechat.do',
		type:'get',
		async:false,
		success:function(data){
				if(data.code=='000'){
					for (var k = 0; k < data.rows.length; k++) {
						var notice=data.rows[k];
						if(k%2==0){
							$('.notice-ct').append("<li>"
								+"<a class='fl ellipsis' href='noticeDetail.html?noteceId="+notice.noticeId+"'>"+notice.noticeTitle+"</a>"
								+"<span class='fr pr-20'>"+notice.createTime.substring(0,10)+"</span>"
								+"</li>");
						}else{
							$('.notice-ct').append("<li class='bg-white'>"
									+"<a class='fl ellipsis' href='noticeDetail.html?noteceId="+notice.noticeId+"'>"+notice.noticeTitle+"</a>"
									+"<span class='fr pr-20'>"+notice.createTime.substring(0,10)+"</span>"
									+"</li>");
						}
					}
				}else{
				} 				
		},error:function(reg){
		}
	});
});