$(document).ready(function() { 
	$.ajax({
		url : base.serverContet+'/manager/loginIn/SysUserInfo/getCurrentUserMenu.do',
		type : 'post',
		async: false,//使用同步的方式,true为异步方式
		data : "",//这里使用json对象
		success : function(data){
			
			
			if(data.code.indexOf("000")>-1){
				window.meuns=data.functionMap;
				window.user=data.user;
				window.userName=data.user.userName;
			}else{
				base.alertTip(data);
			}
		},
		fail:function(data){
			alert(res);
		}
		});
	
	
	
	BUI.use('common/main',function(){
		$("#userName").text(window.userName);
	      var config = [{
	            id:'sysManager',
	            menu:window.meuns["1"]
	            	
	          }];
	      new PageUtil.MainPage({
	        modulesConfig : config
	      });
	    });
	
	 
	
	
}); 


		
	
 
