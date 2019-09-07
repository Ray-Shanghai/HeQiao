var user="";
function getTitle(type){
	$.ajax({
		url:base.serverContet+"/manager/loginIn/currencyNote/queryCount.do",
		type:"get",
		data:{noteType:type},
		success:function(data){
			if(data.code=="000"){
				user=data.user;
				$("#formTitle").text($("#title").text()+"_"+data.user.userName+"_"+data.count);
				$("input[name='title']").val($("#title").text()+"_"+data.user.userName+"_"+data.count);
				$("#num").html("单据编号&nbsp;["+data.user.departName.substring(0,1)+"]字第"+data.count.replace(/_/g,""));
				$("input[name='titleNum']").val("单据编号    ["+data.user.departName.substring(0,1)+"]字第"+data.count.replace(/_/g,""));
				//将session中的用户所属部门填入发起部门
				$("#doSignDepartId").val(user.departId);
				$("#doSignDepartName").val(user.departName);
			}else{
				base.alert(data,2);
			}
		},error:function(){}
	});
}

$(function(){
	$(".close").click(function(){
		$(this).parent().parent().parent().parent().parent().hide();
	});
});