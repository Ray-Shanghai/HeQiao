/**
 * author:王黎
 * day:2017-6-22
 * @deprecated 组织架构
 */
$(document).ready(function() { 
	 
 	$('#sysdepartInfoId').tree({
	    onClick: function(node){
	        if(node.isVirtual=="0"){
	        	 var pnode = $('#sysdepartInfoId').tree('getParent', node.target);
	        	
	        		var columnsDefine;
	        		var url="";
	        		var editUrl ="";
	        		var i=node.id.length;
	        		if(i%6==0){
	        			window.type=i;
		        		 url=base.serverContet+"/page/sysManage/sysUnitInfo/addDepart.html";
		        		 url+="?parentDepartId="+node.id+"&unitName="+escape(pnode.text)+"&unitId="+pnode.id;
		        		 editUrl=base.serverContet+"/page/sysManage/sysUnitInfo/editDepart.html";
		        		 columnsDefine= [
	       	                  {field:'departId',title:'部门编号',width:250,align:'center'},
	    	                  {field:'parentDepartName',title:'上级部门名称',width:100,align:'center'},
	    	                  {field:'departName',title:'部门名称',width:100,align:'center'},
	    	                  {field:'createTime',title:'创建时间',width:250,align:'center'},
	    	                  {field:'createUserName',title:'创建人',width:150,align:'center'}
	    	              ];
	        		} else{
	        			return;
	        		}
	        		var reqUrl =base.serverContet+'/manager/loginIn/SysDepartInfo/getDepartInfoByParentId.do?parentDepartId='+node.id;
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
		        			        remoteSort:false,  
		        			        pageSize: 15,//每页显示的记录条数，默认为10 
		        			        pageList: [15,30,45],//可以设置每页记录条数的列表
		        			        idField:'questionId', 
		        			        singleSelect:true,//是否单选 
		        			        pagination:true,//分页控件 
		        			        rownumbers:true,//行号 
		        					 columns:[columnsDefine],
		        	        onClickRow: function(index, data) {
		        	        	var row = $('#listId').datagrid('getSelected');
 		        	        } ,
		        	        toolbar: [{ 
		        	            text: '添加', 
		        	            iconCls: 'icon-add', 
		        	            handler: function() {
		        	            	var title = "";
		        	            	var id = "";
		        	            	if(window.type%6==0){
		        	            		
		        	            		title = "部门添加";
		        	            		id = "departAddPage";	
		        	            	}else{
		        	            		return ;
		        	            	}
	        	            		top.topManager.openPage({
		        	            	    id : id,
		        	            	    href : url,
		        	            	    title : title
	        	            		});
		        	            		
		        	            } 
		        	        },{ 
		        	            text: '修改', 
		        	            iconCls: 'icon-edit', 
		        	            handler: function() { 
		        	            	var row = $('#listId').datagrid('getSelected');
		        	            	
		        	            	var title = "";
		        	            	var id = "";
		        	            	var editUrl1 ="";
		        	            	if(window.type%6==0){
		        	            		title = "部门修改";
		        	            		id = "departEditPage";	
			        	            	editUrl1 = editUrl +"?departId="+row.departId+"&departName="+escape(row.departName)+"&departDesc="+escape(row.departDesc)+"&unitName="+escape(pnode.text);

		        	            	}else{
		        	            		return ;
		        	            	}
	        	            		top.topManager.openPage({
		        	            	    id : id,
		        	            	    href : editUrl1,
		        	            	    title : title
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
	        }else{
	        }
	    }
	});	
}); 
