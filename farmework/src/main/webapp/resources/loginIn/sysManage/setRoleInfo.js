/**
 * author:王黎
 * day:2017-06-27
 * @deprecated 角色设置
 */


$(document).ready(function() { 
	var roleId=new Array();
	function query(){
		$.ajax({
		url:"../../../manager/loginIn/SysUserRole/query.do",
		type:"post",
		data:{userId:$("#userId").val()},
		async:false,
		success:function(msg){
			roleId=eval(msg);
		}
	});
	}
	if($("#userId").val()!=null&&$("#userId").val()!=""){
		query();
	}
	function isHas(row){
		if(roleId.length>0){
    		 for (var i = 0; i < roleId.length; i++) {
				if(row.departId==roleId[i]){
					return "✔是";
				}else if((roleId.length-1)==i){
					return "✘否";
				}
			}
    	}else{
    		return "✘否";	  
    	}
	}
	
	//部门添加
 	$('#sysRoleInfoId').tree({
	    onClick: function(node){
	        if(node.isVirtual=="0"&&node.nodeType=="5"){
	        	 var pnode = $('#sysRoleInfoId').tree('getParent', node.target);
	        	
	        	 	//alert(pnode.text);
	        		var s;
	        		var url="";
	        	 
	        		if(node.id.length%6==0){
	        			url="../../SysRoleInfo/addSysRole.do";
	        			 
	        			url+="?parentDepartId="+node.id+"&departName="+pnode.text;
	        			 s= [
	        			     {field:'departId1',title:'是否拥有',width:80,align:'center',
	    	                	  formatter:function(value,row,index){
	    	                		 return isHas(row);
	    	                  }},
	       	                  {field:'departId',title:'角色编号',width:100,align:'center'},
	    	                  {field:'departName',title:'角色名称',width:100,align:'center'},
	    	                  {field:'departDesc',title:'角色名称',width:100,	align:'center',hidden:true},             
	    	                  {field:'createTime',title:'创建时间',width:150,align:'center'},
	    	                  {field:'createUserName',title:'创建人',width:150,align:'center'}
	    	              ];
	        		}else{
	        			return;
	        		}
	        		var reqUrl ='../../../manager/loginIn/SysRoleInfo/getDepartInfoByParentId.do?parentDepartId='+node.id;
 		        	$(function(){
		        			 $('#listId').datagrid({ 
		        				 //title:'问题列表', 
		        			        iconCls:'icon-edit',//图标 
		        			        width: 800, 
		        			        height: '200', 
		        			        nowrap: false, 
		        			        striped: true, 
		        			        border: true, 
		        			        collapsible:false,//是否可折叠的 
		        			        fit: true,//自动大小 
		        			        url:reqUrl, 
		        			        //sortName: 'code', 
		        			        //sortOrder: 'desc', 
		        			        remoteSort:false,  
		        			        pageSize: 15,//每页显示的记录条数，默认为10 
		        			        pageList: [15,30,45],//可以设置每页记录条数的列表
		        			        idField:'departId', 
		        			        singleSelect:true,//是否单选 
		        			        pagination:true,//分页控件 
		        			        rownumbers:true,//行号 
		        					 columns:[s],
		        	        onClickRow: function(index, data) {
		        	        } ,
		        	        toolbar: [{ 
		        	            text: '添加', 
		        	            iconCls: 'icon-add', 
		        	            handler: function() {
		        	            	var userId = $("#userId").val();
		        	            	var row = $('#listId').datagrid('getSelected');
		        	            	if(row==null){
		        	            		return;
		        	            	}
		        	            	var isHas = true;
	        	            		for (var i = 0; i < roleId.length; i++) {
										if(row.departId==roleId[i]){
											isHas = false;
											break;
										}
									}
	        	            		if(isHas){
			        	            	var data = {userId:userId,roleId:row.departId};
			        	            	$.ajax({ url: "../../../manager/loginIn/SysUserRole/addUserRoleInfo.do",method:"POST", data: data, success: function(){
			        	                    alert("设置成功");
			        	                    query();
			        	                    $('#listId').datagrid('reload');
			        	                   }});
			        	            	
	        	            			}else{
	        	            				alert("已设置，请选择其他角色进行设置。");
	        	            			} 
		        	            	}
		        	         
		        	        },{
		        	        	text: '删除', 
		        	            iconCls: 'icon-remove', 
		        	            handler: function() {
		        	            	var userId = $("#userId").val();
		        	            	var row = $('#listId').datagrid('getSelected');
		        	            	if(row!=null){
		        	            		var isHas = false;
		        	            		 for (var i = 0; i < roleId.length; i++) {
												if(row.departId==roleId[i]){
													isHas = true;
													break;
												}
											}
		        	            		if(isHas){
				        	            	var data = {userId:userId,roleId:row.departId}
				        	            	$.ajax({ url: "../../../manager/loginIn/SysUserRole/delete.do",method:"POST", data: data, success: function(){
				        	                    alert("已删除成功。");
				        	                    query();
				        	                    $('#listId').datagrid('reload');
				        	                   }});
		        	            	
		        	            		}else{
		        	            			alert("请选择已拥有的角色信息。");
		        	            		}
		        	            	}else{
		        	            		alert("请选择已拥有的角色信息。");
		        	            	}
		        	            	
		        	            } 
		        	         
		        	        }]
		        	    });	
		        				//设置分页控件 
		        			    var p = $('#listId').datagrid('getPager'); 
		        			    $(p).pagination({ 
		        			        method : 'POST',
		        			        loading:true,
		        			        beforePageText: '第',//页数文本框前显示的汉字 
		        			        afterPageText: '页    共 {pages} 页', 
		        			        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录', 
		        			        onBeforeRefresh:function(){
		        			            $(this).pagination('loading');
		        			            alert('before refresh');
		        			            $(this).pagination('loaded');
		        			        },
		        			        onRefresh:function(){
		        			        	   $(this).pagination('loading');
		        				            alert('before onRefresh');
		        				            $(this).pagination('loaded');
		        			        	
		        			        }
		        			    });  
		        			    $(p).pagination('loading');
		        	});
	        }else{
	        }
	    }
	});
});
