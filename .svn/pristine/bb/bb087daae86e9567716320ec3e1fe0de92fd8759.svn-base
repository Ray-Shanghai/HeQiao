/**
 * author:杨洋
 * day:2016-11-19
 * @deprecated 设置功能模块
 */
$(document).ready(function() { 
	 
 	$('#sysFunctionInfoId').tree({
	    onClick: function(node){
	        		var s;
	        		var url="";
	        		var editUrl="";
	        		if(node.id.length==3&&node.isVirtual=="1"){
	        			
	        			url=base.serverContet+"/page/sysManage/sysFunctionInfo/addFunctionTypeInfo.html";
	        			editUrl=base.serverContet+"/page/sysManage/sysFunctionInfo/editFunctionTypeInfo.html";
	        			s= [
	       	                  {field:'functionId',title:'功能编号',width:100,align:'center'},
	    	                  {field:'functionName',title:'功能类型',width:150,align:'center'},
	    	                  {field:'functionDesc',title:'功能描述',width:150,align:'center'},
	    	                  {field:'createUserName',title:'创建人',width:150,align:'center'},
	    	                  {field:'createTime',title:'创建时间',width:250,align:'center'}
	    	              ];
	        		}else if(node.id.length==6&&node.isVirtual=="0"){
	        			url=base.serverContet+"/page/sysManage/sysFunctionInfo/addFunctionInfo.html?parentFunctionId="+node.id;
	        			editUrl=base.serverContet+"/page/sysManage/sysFunctionInfo/editFunctionInfo.html";

	        			s= [
	       	                  {field:'functionId',title:'功能编号',width:100,align:'center'},
	    	                  {field:'functionName1',title:'功能类型',width:100,align:'center',
	    	                	  formatter:function(value,row,index){
	    	                		  return node.text;
	    	                	  }  
	    	                  },
	    	                  {field:'functionName',title:'功能名称',width:150,align:'center'},
	    	                  {field:'functionUrl',title:'功能路径',width:150,align:'center'},
	    	                  {field:'createUserName',title:'创建人',width:150,align:'center'},
	    	                  {field:'createTime',title:'创建时间',width:250,align:'center'}
	    	              ];
	        		}else{
	        			return ;
	        		}
	        		var reqUrl =base.serverContet+"/manager/loginIn/SysFunctionInfo/query.do?parentFunctionId="+node.id;
	        		 
	        		
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
		        			        pageSize: 10,//每页显示的记录条数，默认为10 
		        			        pageList: [10,20],//可以设置每页记录条数的列表
		        			        idField:'questionId', 
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
 		        	            	top.topManager.openPage({
		        	            	    id : "addFunctionInfo",
		        	            	    href : url,
		        	            	    title : "添加功能模块"
	        	            		});
		        	            } 
		        	        },{ 
		        	            text: '修改', 
		        	            iconCls: 'icon-edit', 
		        	            handler: function() {
		        	            	var row = $('#listId').datagrid('getSelected');
		        	            	var c =editUrl+"?functionId="+row.functionId+"&functionName="+escape(row.functionName)+"&functionUrl="+escape(row.functionUrl)+"&functionDesc="+escape(row.functionDesc);
		        	             
		        	            	top.topManager.openPage({
		        	            	    id : "editFunctionInfo",
		        	            	    href : c,
		        	            	    title : "修改功能模块"
	        	            		});
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
	    }
	});	
}); 


		
	
 
