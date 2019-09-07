var noticeId=window.location.search.split("=")[1];
	 	
    	$(function(){
    		$.ajax({
    			url: base.serverContet+'/manager/loginIn/notice/queryByPkId.do',
    			type:'post',
    			data:{noticeId:noticeId},
    			async:false,
    			success:function(data){
						if(data.code=='000'){
							$("#noticeTitle").html(data.notice.noticeTitle);
							$("#createDate").html("发布时间："+data.notice.createTime);
							$("#noticeContent").html("全体员工：<br>&emsp;&emsp;"+data.notice.noticeContent);
							$("#noticeDepartment").html("发布部门："+data.notice.departName);
							for (var i = 0; i < data.fileList.length; i++) {
								var file=data.fileList[i];
								$(".file").after("<div class='title' style='font-size:0.2rem;padding-top:0.1rem;'>"
													+"<a href=javascript:downLoadFile(this,'/HeQiao/"+file.filePath+"&resouceName="+file.fileName+"')>"
													+file.fileName+"</a></div>");
							}
						}else{
							base.alert(data,1);
						} 				
    			},error:function(reg){
    			}
    		});
    	});
    	function downLoadFile(obj,url){
    		if(confirm("您真的要下载此文件吗？")){
    			window.location.href=url;
    		}
    	}