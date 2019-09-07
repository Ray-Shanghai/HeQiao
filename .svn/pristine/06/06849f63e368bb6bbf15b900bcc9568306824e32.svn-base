package com.sd.farmework.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sd.farmework.common.util.DateUtil;
import com.sd.farmework.common.util.StringUtil;
import com.sd.farmework.mapper.HqApprovenRuleMapper;
import com.sd.farmework.mapper.SysApprovenFunctionRuleMapper;
import com.sd.farmework.mapper.SysApprovenRulePersonMapper;
import com.sd.farmework.mapper.SysApprovenTaskMapper;
import com.sd.farmework.mapper.SysApprovenTaskedMapper;
import com.sd.farmework.mapper.SysUserInfoMapper;
import com.sd.farmework.pojo.HqApprovenRule;
import com.sd.farmework.pojo.SysApprovenFunctionRule;
import com.sd.farmework.pojo.SysApprovenTask;
import com.sd.farmework.pojo.SysUserInfo;

public class ApprovenUtil {
	/**
	 * 添加审批任务
	 * @param approvenRuleId
	 * @param sysTaskP
	 * @param sysApprovenTaskService
	 * @param ruleServices
	 */
	public Map<String,String> addApprovenTask(HttpSession session ,HttpServletRequest request,HttpServletResponse response, 
			String exp,SysApprovenTask sysTaskP,HqApprovenRuleMapper approvenRuleMapper,SysApprovenTaskMapper sysApprovenTaskMapper,SysUserInfoMapper sysUserInfoMapper){
		Map<String,String>  resultMap =new HashMap<String,String>(); 
		resultMap.put("code", "000");
		resultMap.put("msg", "审批信息设置成功");
		HttpSessionProvider httpSessionProvider =new HttpSessionProvider();
		SysUserInfo sessionUserInfo=httpSessionProvider.getCurrentUserSession(session, request, response);
		try {
			//查找对应部门下是否有审批流，没有就往上级部门查看
			String approvenDepartId=sysTaskP.getApprovenDepartId();
			SysUserInfo user=null;
			List<HqApprovenRule> ruleList=null;
			HqApprovenRule hqApprovenRule=new HqApprovenRule();
			//审批表达式
			hqApprovenRule.setApprovenExp(exp);
			//提交人职位编号
			hqApprovenRule.setApplyPositionNo(sessionUserInfo.getAuthorityId());
			//审批类型
			hqApprovenRule.setApprovenTypeId(sysTaskP.getApprovenFunctionId());
			//如果是通用审批
			if(sysTaskP.getApprovenFunctionId().substring(0, 1).equals("3")){
				do{
					//对应审批部门
					hqApprovenRule.setApprovenUnitId(approvenDepartId);
					//取出符合规则的最小审批表达式值
					hqApprovenRule.setApprovenExp(approvenRuleMapper.queryExpForMysql(hqApprovenRule));
					ruleList=approvenRuleMapper.queryForMysql(hqApprovenRule);
					if(ruleList.size()>0){
						for(int i=0;i<ruleList.size();i++){
							user=new SysUserInfo();
							//拿到审批人部门编号和职位编号去用户表匹配
							user.setDepartId(ruleList.get(i).getApprovenUnitId());
							user.setAuthorityId(ruleList.get(i).getApprovenPositionNo());
							user=(SysUserInfo) sysUserInfoMapper.queryUserForAppr(user);
							//如果在用户表匹配到了，那么创建代办任务，并退出循环
							if(user!=null){
								SysApprovenTask sysTask =new SysApprovenTask();
								addApprovenTask(sysTask, sysTaskP, ruleList.get(i), user);
								sysTask.setRuleOrder(2);
								sysTask.setRuleOrderOld(2);
								sysTask=(SysApprovenTask) httpSessionProvider.fillBaseInfo(sysTask, sessionUserInfo);
								//如果设定了审核人，那么审核人先审核通过再进入审批流
								if(StringUtil.isNotNullOrBlank(sysTaskP.getApprovenPersonId())){
									SysApprovenTask sysApprovenTask =new SysApprovenTask();
									SysUserInfo approvenUser=new SysUserInfo();
									approvenUser.setUserId(sysTaskP.getApprovenPersonId());
									approvenUser=(SysUserInfo) sysUserInfoMapper.queryByIdForMysql(approvenUser);
									addApprovenTask(sysApprovenTask,sysTaskP,ruleList.get(i),approvenUser);
									sysApprovenTask.setRuleOrder(1);  //审批顺序设为1
									sysApprovenTask.setRuleOrderOld(1);
									sysApprovenTask=(SysApprovenTask) httpSessionProvider.fillBaseInfo(sysApprovenTask, sessionUserInfo);
									sysApprovenTaskMapper.add(sysApprovenTask);
								}else{
									sysTask.setRuleOrder(1);
									sysTask.setRuleOrderOld(1);
								}
								sysApprovenTaskMapper.add(sysTask);
								break;
							}else if(i==ruleList.size()-1){
								break;
							}
						}
						break;  //如果找到对应的审批流，那么退出循环
					}
					//当前部门编号减6位，获取到上级部门的编号
					if(approvenDepartId.length()>6){
						approvenDepartId=approvenDepartId.substring(0,approvenDepartId.length()-6);
					}
				}while(approvenDepartId.length()>3);
				
				if(ruleList==null||ruleList.size()==0){
					 resultMap.put("code", "001");
					 resultMap.put("msg", "没有定义审批流");
				}else if(user==null){
					 resultMap.put("code", "002");
					 resultMap.put("msg", "没有相应的审批人");
				}
				
			}else{ //如果非通用审批
				int num=0;
				SysApprovenTask sysTask =new SysApprovenTask();
				boolean flag=false;
				if(StringUtil.isNotNullOrBlank(sysTaskP.getApprovenPersonId())){
					SysApprovenTask sysApprovenTask =new SysApprovenTask();
					SysUserInfo approvenUser=new SysUserInfo();
					approvenUser.setUserId(sysTaskP.getApprovenPersonId());
					approvenUser=(SysUserInfo) sysUserInfoMapper.queryByIdForMysql(approvenUser);
					addApprovenTask(sysApprovenTask,sysTaskP,hqApprovenRule,approvenUser);
					sysApprovenTask.setRuleOrder(1);  //审批顺序设为0
					sysApprovenTask.setRuleOrderOld(1);
					sysApprovenTask=(SysApprovenTask) httpSessionProvider.fillBaseInfo(sysApprovenTask, sessionUserInfo);
					sysApprovenTaskMapper.add(sysApprovenTask);
					flag=true;
				}
				if(flag){
					num=1;
				}
				Integer currentExp=Integer.valueOf(exp);
				do{
					//对应审批部门
					hqApprovenRule.setApprovenUnitId(approvenDepartId);
					//查出当前部门下是否有审批流
					Integer maxExp=approvenRuleMapper.queryMaxExp(hqApprovenRule);
					if(maxExp!=null){ //如果有
						if(currentExp>=maxExp){ //而且提交的审批表达式大于等于当前部门下最大的表达式值
							//对应审批部门
							hqApprovenRule.setApprovenUnitId(approvenDepartId);
							ruleList=approvenRuleMapper.queryApprovenList(hqApprovenRule);
							//将当前部门下所有审批流在用户表有审批人的放入待办任务表中
							for(int i=0;i<ruleList.size();i++){
								user=new SysUserInfo();
								//拿到审批人部门编号和职位编号去用户表匹配
								user.setDepartId(ruleList.get(i).getApprovenUnitId());
								user.setAuthorityId(ruleList.get(i).getApprovenPositionNo());
								user=(SysUserInfo) sysUserInfoMapper.queryUserForAppr(user);
								//如果在用户表匹配到了，那么创建代办任务
								if(user!=null){
									num++;
									addApprovenTask(sysTask, sysTaskP, ruleList.get(i), user);
									sysTask.setRuleOrder(num);
									sysTask.setRuleOrderOld(num);
									sysTask=(SysApprovenTask) httpSessionProvider.fillBaseInfo(sysTask, sessionUserInfo);
									sysApprovenTaskMapper.add(sysTask);
								}
							}
							if(approvenDepartId.length()>6){
								approvenDepartId=approvenDepartId.substring(0,approvenDepartId.length()-6);
							}
						}else{ //如果小于最大审批表达式
							//对应审批部门
							hqApprovenRule.setApprovenUnitId(approvenDepartId);
							//取出符合规则的最小审批表达式值
							hqApprovenRule.setApprovenExp(approvenRuleMapper.queryExpForMysql(hqApprovenRule));
							ruleList=approvenRuleMapper.queryForMysql(hqApprovenRule);
							for(int i=0;i<ruleList.size();i++){
								user=new SysUserInfo();
								//拿到审批人部门编号和职位编号去用户表匹配
								user.setDepartId(ruleList.get(i).getApprovenUnitId());
								user.setAuthorityId(ruleList.get(i).getApprovenPositionNo());
								user=(SysUserInfo) sysUserInfoMapper.queryUserForAppr(user);
								//如果在用户表匹配到了，那么创建代办任务
								if(user!=null){
									num++;
									addApprovenTask(sysTask, sysTaskP, ruleList.get(i), user);
									sysTask.setRuleOrder(num);
									sysTask.setRuleOrderOld(num);
									sysTask=(SysApprovenTask) httpSessionProvider.fillBaseInfo(sysTask, sessionUserInfo);
									sysApprovenTaskMapper.add(sysTask);
								}
							}
							break;
						}
						
					}else{
						if(approvenDepartId.length()>6){
							approvenDepartId=approvenDepartId.substring(0,approvenDepartId.length()-6);
						}
					}
					
				}while(approvenDepartId.length()>3);
				if(ruleList==null||ruleList.size()==0){
					 sysApprovenTaskMapper.deleteTaskForApprovenPerson(sysTaskP);
					 resultMap.put("code", "001");
					 resultMap.put("msg", "没有定义审批流");
				}
			}
			
			/*if(ruleList.size()>0){
				int i=0;
				for (HqApprovenRule approvenRule : ruleList) {
					SysApprovenTask sysTask =new SysApprovenTask();
					sysTask.setTaskName(sysTaskP.getTaskName());
					 sysTask.setApprovenResult(sysTaskP.getApprovenResult());
					 
					 sysTask.setApprovenUserId("");
					 sysTask.setApprovenUserName("");
					 
					 sysTask.setApprovenUnitId(sysTaskP.getApprovenUnitId());
					 sysTask.setApprovenUnitName(sysTaskP.getApprovenUnitName());
					 sysTask.setApprovenDepartId(sysTaskP.getApprovenDepartId());
					 sysTask.setApprovenDepartName(sysTaskP.getApprovenDepartName());
					 sysTask.setApprovenPostion(approvenRule.getApprovenPositionNo());
					 sysTask.setApprovenPostionName(approvenRule.getApprovenPositionName());
					 sysTask.setApprovenSendTime(DateUtil.getCurrentDateString());
					 sysTask.setApprovenPersonId("");
					 sysTask.setApprovenRuleId(approvenRule.getApprovenRuleId());
					 sysTask.setApprovenRuleName("");
					 sysTask.setApprovenFunctionId(approvenRule.getApprovenTypeId());
					 sysTask.setApprovenFunctionName(approvenRule.getApprovenTypeName());
					 sysTask.setSourceTable(sysTaskP.getSourceTable());
					 sysTask.setSourceTablePkColumnName(sysTaskP.getSourceTablePkColumnName());
					 sysTask.setSourceTablePkColumnValue(sysTaskP.getSourceTablePkColumnValue());
					  
					//按顺序审批
					sysTask.setRuleOrder(i);
					sysTask.setRuleOrderOld(i);
					
					sysTask=(SysApprovenTask) httpSessionProvider.fillBaseInfo(sysTask, sessionUserInfo);
					sysApprovenTaskMapper.add(sysTask);
				}
			}else{
				 resultMap.put("code", "001");
				 resultMap.put("msg", "没有定义审批流");
			 }*/
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultMap.put("code", "003");
			resultMap.put("msg", "设置审批流信息异常了！");
		}
		 
		 /*try {
		//根据部门查询相应部门的审批规则--start
		SysApprovenFunctionRule functionRule = new SysApprovenFunctionRule();
		
		
		//需要审批的功能
		functionRule.setApprovenFunctionId(approvenFunctionId);
		List listRule =new ArrayList();
		
		if ("00001".equals(approvenFunctionId)){
			SysApprovenFunctionRule sysApprovenFunctionRule = null;
			List listRule2 = sysApprovenFunctionRuleMapper.queryListForMysql(functionRule);
			for (int i = 0; i < listRule2.size(); i++) {
				sysApprovenFunctionRule= (SysApprovenFunctionRule)listRule2.get(i);
				if(!sysApprovenFunctionRule.getApprovenPostion().equals(sysTaskP.getApprovenPostion())){
					listRule.add(sysApprovenFunctionRule);
				}
			}
		}else{
		  String ruleExpPara="";
		  if ("00002".equals(approvenFunctionId)){
			    ruleExpPara = (String) request.getAttribute("payMoney");
		    }else if ("00003".equals(approvenFunctionId)){
		    	ruleExpPara = (String) request.getAttribute("leaveDay");
		    }

			
			List listRule1 = sysApprovenFunctionRuleMapper.queryListForMysql(functionRule);
			SysApprovenFunctionRule sysApprovenFunctionRule = null;
			for(int i=0;i<listRule1.size();i++){
				sysApprovenFunctionRule= (SysApprovenFunctionRule)listRule1.get(i);
				String ruleExp="";
				if("00002".equals(approvenFunctionId)){
					ruleExp = sysApprovenFunctionRule.getMoneyExp();
				}else if("00003".equals(approvenFunctionId)){
					ruleExp = sysApprovenFunctionRule.getDayExp();
				}
				if(!sysApprovenFunctionRule.getApprovenPostion().equals(sysTaskP.getApprovenPostion())){
				//1,3
				if(StringUtil.isNotNullOrBlank(ruleExp)&&ruleExp.split(",").length==2){
 					int start = Integer.valueOf(ruleExp.split(",")[0]);
					int end = Integer.valueOf(ruleExp.split(",")[1]);
					if(start<=Double.valueOf(ruleExpPara).intValue()&& Double.valueOf(ruleExpPara).intValue()<=end){
						listRule.add(sysApprovenFunctionRule);
					}
					
				}else{
					listRule.add(sysApprovenFunctionRule);
				}
				}
			}
		} 
		 //根据部门查询相应部门的审批规则--end
		 if(listRule.size()>0){
			 for(int i=0 ;i<listRule.size();i++){
				 
			 
			SysApprovenFunctionRule sysApprovenFunctionRule =(SysApprovenFunctionRule) listRule.get(i);
		   
			 
				 SysApprovenTask sysTask =new SysApprovenTask();
				 
				 sysTask.setTaskName(sysTaskP.getTaskName());
				 sysTask.setApprovenResult(sysTaskP.getApprovenResult());
				 sysTask.setApprovenUserId("");
				 sysTask.setApprovenUserName("");
				 
 				 sysTask.setApprovenUnitId(sysTaskP.getApprovenUnitId());
				 sysTask.setApprovenUnitName(sysTaskP.getApprovenUnitName());
				 sysTask.setApprovenDepartId(sysTaskP.getApprovenDepartId());
				 sysTask.setApprovenDepartName(sysTaskP.getApprovenDepartName());
				 sysTask.setApprovenPostion(sysApprovenFunctionRule.getApprovenPostion());
				 
				 sysTask.setApprovenSendTime(DateUtil.getCurrentDateString());
				 sysTask.setApprovenPersonId("");
				 sysTask.setApprovenRuleId(sysApprovenFunctionRule.getApprovenRuleId());
				 sysTask.setApprovenRuleName(sysApprovenFunctionRule.getApprovenRuleName());
				 sysTask.setApprovenFunctionId(sysApprovenFunctionRule.getApprovenFunctionId());
				 sysTask.setApprovenFunctionName(sysApprovenFunctionRule.getApprovenFunctionName());
				 sysTask.setSourceTable(sysTaskP.getSourceTable());
				 sysTask.setSourceTablePkColumnName(sysTaskP.getSourceTablePkColumnName());
				 sysTask.setSourceTablePkColumnValue(sysTaskP.getSourceTablePkColumnValue());
 				  
				//按顺序审批
					 sysTask.setRuleOrder(Integer.valueOf(sysApprovenFunctionRule.getRuleIsOrderly()));
					 sysTask.setRuleOrderOld(Integer.valueOf(sysApprovenFunctionRule.getRuleIsOrderly()));
				 
				 //补充系统基本信息
				 HttpSessionProvider httpSessionProvider =new HttpSessionProvider();
				 SysUserInfo sessionUserInfo=httpSessionProvider.getCurrentUserSession(session, request, response);
				 sysTask=(SysApprovenTask) httpSessionProvider.fillBaseInfo(sysTask, sessionUserInfo);
				 
				 sysApprovenTaskMapper.add(sysTask);
			 }

		 }else{
			 resultMap.put("code", "001");
			 resultMap.put("msg", "没有定义审批流");
		 }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultMap.put("code", "003");
			resultMap.put("msg", "设置审批流信息异常了！");
		}*/
		return resultMap;
	}
	/**
	 * 添加代办任务表属性
	 * @param sysTask 
	 * @param sysTaskP
	 * @param hqApprovenRule
	 * @param user
	 */
	public void addApprovenTask(SysApprovenTask sysTask,SysApprovenTask sysTaskP,HqApprovenRule hqApprovenRule,SysUserInfo user){
		sysTask.setTaskName(sysTaskP.getTaskName());
		 sysTask.setApprovenResult(sysTaskP.getApprovenResult());
		 
		 sysTask.setApprovenUserId(user.getUserId());
		 sysTask.setApprovenUserName(user.getUserName());
		 
		 sysTask.setApprovenDepartId(user.getDepartId());
		 sysTask.setApprovenDepartName(user.getDepartName());
		 sysTask.setApprovenPostion(user.getAuthorityId());
		 sysTask.setApprovenPostionName(user.getAuthorityName());
		 sysTask.setApprovenSendTime(DateUtil.getCurrentDateString());
		 sysTask.setApprovenPersonId("");
		 sysTask.setApprovenRuleId(hqApprovenRule.getApprovenRuleId());
		 sysTask.setApprovenRuleName("");
		 sysTask.setApprovenFunctionId(hqApprovenRule.getApprovenTypeId());
		 sysTask.setApprovenFunctionName(sysTaskP.getTaskName());
		 sysTask.setSourceTable(sysTaskP.getSourceTable());
		 sysTask.setSourceTablePkColumnName(sysTaskP.getSourceTablePkColumnName());
		 sysTask.setSourceTablePkColumnValue(sysTaskP.getSourceTablePkColumnValue());
		
	}
	
	/**
	 * 处理审批
	 * @param obj
	 * @param sysApprovenTaskService
	 */
	public Map<String,Object> doApproven(HttpSession session ,HttpServletRequest request,
			HttpServletResponse response,SysApprovenTask obj,SysApprovenTaskMapper sysApprovenTaskMapper,SysApprovenTaskedMapper sysApprovenTaskedMapper,String approvenFunctionId){
		String sourceId = "";
		try {
			System.out.println("obj=="+obj);
			//将数据移入已办任务表中
			
			sysApprovenTaskedMapper.add(obj);
			//设置下个审批人信息
			
			SysApprovenTask objP=(SysApprovenTask) sysApprovenTaskMapper.queryByPkId(obj.getTaskId());
			sourceId = objP.getSourceTablePkColumnValue();
			objP.setRuleOrderOld((Integer.valueOf(objP.getRuleOrderOld())+1));
 			sysApprovenTaskMapper.updateNextApprovenPerosn(objP);
			//删除代办任务表信息
			sysApprovenTaskMapper.deleteForMysql(obj);
			
			SysApprovenTask sysApprovenTask = new SysApprovenTask();
			sysApprovenTask.setApprovenFunctionId(approvenFunctionId);
			sysApprovenTask.setSourceTablePkColumnValue(sourceId);
			List<BaseInfo> sysApprovenTaskList=sysApprovenTaskMapper.queryRemainderTaskList(sysApprovenTask);
			
			Map <String,Object> map =new HashMap();
			map.put("sourceId", sourceId);
			map.put("sysApprovenTaskList", sysApprovenTaskList);
			return map ;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return null;
	}
}
