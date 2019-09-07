<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="../wxpage/css/bootstrap.css" />
		<link rel="stylesheet" type="text/css" href="../wxpage/css/bootstrap.min.css" />
		<link rel="stylesheet" href="../wxpage/css/style.css" />
		<link rel="stylesheet" href="../wxpage/css/targetManage/loginAndRegister/login.css" />
		<script src="../resources/js/jquery-1.8.1.min.js"> </script>  
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<title>微信端模拟首页</title>
	</head>
	<body>
	<br>
	<br><br><br>
	;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;<button onclick="test()"> fdsfsdf</button>
		 </body>
	<script type="text/javascript">


 function test(){
window.testwx=true;
	 
	$.ajax({ 
        type: "POST",
        data:{},
        url: "/HeQiao/wx/weixinpay.do",
        async: true,
        dataType: "json",
        success: function(data){
	        	if(data.code=="000"){
	        			var dataJson=JSON.parse("{"+data.key+"}");
	        		    WeixinJSBridge.invoke('getBrandWCPayRequest',dataJson,
        		    function(res){
        		       //支付成功或失败前台判断
            	       if(res.err_msg=='get_brand_wcpay_request:ok'){
            	    	   alert("success");
            	       }else{
            	    	   alert(res);
            	       }
        		     });
        	}else{
        		 alert(data);
        	}
        },error:function(rec){
        	 alert(rec);
        }
    });
 }

</script>
</html>


