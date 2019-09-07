var base ={};
base.serverContet = "/HeQiao";


//登录超时，打开登录页面
var loginOut = function(obj){
  window.location.href=base.serverContet+"/login.html";
};		
	
base.alertTip = function(data){
	 
	 BUI.Message.Alert(data.msg,function(){
		  
		  if(data.code=="111"){
			  loginOut();
		  }
		   
      },'info');
};

base.alert=function(data,isWx){
	alert(data.msg);
	if(data.code=="111"&&isWx=="2"){
		window.parent.location.href=base.serverContet+"/page/heqiao/login.html";
	 }
	if(data.code=="111"&&isWx=="1"){
		window.location.href=base.serverContet+"/wxpage/heqiao/login.html";
	  }
};

 
