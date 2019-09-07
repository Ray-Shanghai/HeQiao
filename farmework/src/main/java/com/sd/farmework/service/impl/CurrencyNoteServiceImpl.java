package com.sd.farmework.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.farmework.common.ApprovenUtil;
import com.sd.farmework.common.BaseInfo;
import com.sd.farmework.common.HttpSessionProvider;
import com.sd.farmework.mapper.CurrencyNoteMapper;
import com.sd.farmework.mapper.HqApprovenRuleMapper;
import com.sd.farmework.mapper.HqCurrencyDetailMapper;
import com.sd.farmework.mapper.HqExpenditureDetailMapper;
import com.sd.farmework.mapper.SysApprovenFunctionRuleMapper;
import com.sd.farmework.mapper.SysApprovenRulePersonMapper;
import com.sd.farmework.mapper.SysApprovenTaskMapper;
import com.sd.farmework.mapper.SysApprovenTaskedMapper;
import com.sd.farmework.mapper.SysUserInfoMapper;
import com.sd.farmework.mapper.SysZhichuTypeMapper;
import com.sd.farmework.pojo.CurrencyNote;
import com.sd.farmework.pojo.HqExpenditureDetail;
import com.sd.farmework.pojo.HqExpenditureDetailList;
import com.sd.farmework.pojo.SysApprovenTask;
import com.sd.farmework.pojo.SysUserInfo;
import com.sd.farmework.pojo.SysZhichuType;
import com.sd.farmework.service.CurrencyNoteService;
import com.sd.farmework.service.SysApprovenTaskService;
import com.sd.farmework.service.SysApprovenTaskedService;
@Service
public class CurrencyNoteServiceImpl extends BaseInfoServiceImpl implements CurrencyNoteService {
	@Autowired
    private CurrencyNoteMapper baseMapper;
	@Autowired
	private HqCurrencyDetailMapper currencyDetailMapper;
	@Autowired
	private HqExpenditureDetailMapper expenditureDetailMapper;
	@Autowired
	private SysApprovenRulePersonMapper ruleMapper;
	@Autowired
	private SysApprovenTaskMapper sysApprovenTaskMapper;
	@Autowired
	private SysApprovenTaskedMapper sysApprovenTaskedMapper;
	@Autowired
	private SysApprovenFunctionRuleMapper sysApprovenFunctionRuleMapper;
	@Autowired
	private HqApprovenRuleMapper approvenRuleMapper;
	@Autowired
	private SysZhichuTypeMapper sysZhichuTypeMapper;
	@Autowired
	private SysUserInfoMapper sysUserInfoMapper;
	public CurrencyNoteMapper getBaseMapper() {
		return baseMapper;
	}

	public void setBaseMapper(CurrencyNoteMapper baseMapper) {
		this.baseMapper = baseMapper;
	}

	@Override
	public Map addApproven(HttpSession session, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String approvenFunctionId = (String)request.getAttribute("approvenFunctionId");
		CurrencyNote obj = (CurrencyNote)request.getAttribute("obj");
		HttpSessionProvider httpSessionProvider =new HttpSessionProvider();
		SysUserInfo sessionUserInfo=httpSessionProvider.getCurrentUserSession(session, request, response);
		obj=(CurrencyNote) httpSessionProvider.fillBaseInfo(obj, sessionUserInfo);
		//将申请数据加入申请表
		baseMapper.addForMysql(obj);
		
		 //审批开始
		 //sys_approven_task
		 SysApprovenTask sysTaskP =new SysApprovenTask();
		 String exp="";
		 //匹配审批类型
		 List zcList=sysZhichuTypeMapper.queryListForMysql(null);
		 for (int i = 0; i < zcList.size(); i++) {
			 SysZhichuType zcType=(SysZhichuType) zcList.get(i);
			if(zcType.getZcId().equals(approvenFunctionId)){
				sysTaskP.setTaskName(zcType.getZcTypeName());
				if("1".equals(approvenFunctionId.substring(0, 1))){
					exp=obj.getPayMoney();
					HqExpenditureDetailList detailList=(HqExpenditureDetailList) request.getAttribute("hqExpenditureDetailList");
					if(detailList.getList().size()>0){
						for (HqExpenditureDetail detail : detailList.getList()) {
							detail=(HqExpenditureDetail) httpSessionProvider.fillBaseInfo(detail, sessionUserInfo);
							detail.setCurrencyId(obj.getNoteId());
						}
						this.expenditureDetailMapper.addBatchForMysql(detailList.getList());
					}
				}
				//如果审批类型是通用，那么将审批表达式设为1
				if(approvenFunctionId.substring(0, 1).equals("3")){
					exp="1";
				}
				//请假，出差
				if(approvenFunctionId.substring(0, 1).equals("2")){
					exp=obj.getLeaveDay();
					/*obj.setDoSignUnitId(sessionUserInfo.getUnitId());
					obj.setDoSignUnitName(sessionUserInfo.getUnitName());*/
				}
			}
		}
		 //审批功能编号
		 sysTaskP.setApprovenFunctionId(approvenFunctionId);
		/*
		 //签办公司
		 sysTaskP.setApprovenUnitId(obj.getDoSignUnitId());
		 sysTaskP.setApprovenUnitName(obj.getDoSignUnitName());
		*/
		 //发起人部门
		 sysTaskP.setApprovenDepartId(obj.getDoSignDepartId());
		 sysTaskP.setApprovenDepartName(obj.getDoSignDepartName());
		 
		 //业务表名
		 sysTaskP.setSourceTable("CURRENCY_NOTE");
		 //业务表主键名称
		 sysTaskP.setSourceTablePkColumnName("NOTE_ID");
		 //业务表主键对应值
		 sysTaskP.setSourceTablePkColumnValue(obj.getNoteId());
		 //职位
		 sysTaskP.setApprovenPostion(obj.getPostion());
		 //审核人
		 sysTaskP.setApprovenPersonId(obj.getApprovenPersonId());
		 //审批工具类
		 ApprovenUtil appr = new ApprovenUtil();
		 //请假调休审批 0000000001 sys_approven_function_rule
		 //request.setAttribute("daySum", obj.getLeaveNumber());
		 sysTaskP = (SysApprovenTask) httpSessionProvider.fillBaseInfo(sysTaskP, sessionUserInfo);
 		 Map map= appr.addApprovenTask(session, request, response,exp, sysTaskP, approvenRuleMapper, sysApprovenTaskMapper,sysUserInfoMapper);
		 if(!map.get("code").equals("000")){
			 throw new Exception(map.get("code").toString());
		 }
		 return null;
	}

	@Override
	public Map<String, Object> doApproven(HttpSession session,
			HttpServletRequest request, HttpServletResponse response,
			SysApprovenTask obj, SysApprovenTaskService sysApprovenTaskService,
			SysApprovenTaskedService sysApprovenTaskedService,
			String approvenFunctionId) throws Exception {
		HttpSessionProvider httpSessionProvider =new HttpSessionProvider();
		SysUserInfo sessionUserInfo=httpSessionProvider.getCurrentUserSession(session, request, response);
		obj.setApprovenUserId(sessionUserInfo.getUserId());
		obj.setApprovenUserName(sessionUserInfo.getUserName());
		// 审批功能编号map
				Map<String, Object> map = new HashMap();
				try {
					ApprovenUtil appr = new ApprovenUtil();
					map = appr.doApproven(session, request, response,
							obj, sysApprovenTaskMapper, sysApprovenTaskedMapper,
							approvenFunctionId);			 
					List<BaseInfo> sysApprovenTaskList=(List<BaseInfo>) map.get("sysApprovenTaskList");
					
					
					//审核通过
					CurrencyNote function =new CurrencyNote();
					function.setNoteId(map.get("sourceId").toString());
					
					//审核不通过
					if("2".equals(obj.getApprovenResult())){
						 function.setAuditStatus("3");
						 baseMapper.update(function);
						 for(int i=0;i<sysApprovenTaskList.size();i++){
							 sysApprovenTaskService.delete(sysApprovenTaskList.get(i));
						 }
					 }else{
						 if(sysApprovenTaskList==null||sysApprovenTaskList.size()==0){
								function.setAuditStatus("2");
								baseMapper.update(function);
								//写发送短信或者其他业务操作
								
							}
					 }
				map.put("code", "000");
				map.put("msg", "success");
				return map;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				map.put("code", "001");
				map.put("msg", "fail");
				return map;
			}	
	}

	@Override
	public List queryWaitingListAll(Map map) throws Exception {
		// TODO Auto-generated method stub
		return this.baseMapper.queryWaitingListAll(map);
	}
	
}
