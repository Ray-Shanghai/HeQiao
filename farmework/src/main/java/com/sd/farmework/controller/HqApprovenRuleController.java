package com.sd.farmework.controller; 


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sd.farmework.common.BaseInfo;
import com.sd.farmework.common.HttpSessionProvider;
import com.sd.farmework.common.JSONUtils;
import com.sd.farmework.common.util.StringUtil;
import com.sd.farmework.pojo.HqApprovenRule;
import com.sd.farmework.pojo.SysApprovenFunction;
import com.sd.farmework.pojo.SysZhichuType;
import com.sd.farmework.service.HqApprovenRuleService;
import com.sd.farmework.service.SysZhichuTypeService;
/** 
 * 审批规则表
 * @author Administrator 
 * 
 */ 
 @Controller
 @Scope("prototype")
 @RequestMapping(value="/manager/loginIn/HqApprovenRules")
public class HqApprovenRuleController{
    @Autowired
    private HqApprovenRuleService hqApprovenRuleService;
    @Autowired
    private SysZhichuTypeService sysZhichuTypeService;
    /**
	 * 查询所有审理业务类型
	 * 
	 * @param user
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/HqApprovenDataList", method = RequestMethod.POST)
	public String hqApprovenDataList(SysZhichuType obj, Model model,HttpServletResponse response) throws Exception {
		  
		List<BaseInfo> list = this.sysZhichuTypeService.queryList(obj);
  
 		model.addAttribute("list", list);
 		response.setCharacterEncoding("utf-8");
 		response.getWriter().write(JSONArray.fromObject(list).toString());
 		
 		
		return null;
	}
	/**
	 * 查询现有审批规则
	 * @param obj
	 * @param model
	 * @param response
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/HqApprovenRuleList")
	public void hqApprovenRuleDetail(HqApprovenRule obj,Model model,HttpServletResponse response) throws Exception{
		List<BaseInfo> list = this.hqApprovenRuleService.queryList(obj);
		
		response.setCharacterEncoding("utf-8");
 		response.getWriter().write(JSONArray.fromObject(list).toString());
	}
	/**
	 * 更新审批规则
	 * @param applyPositionNos
	 * @param approvenExps
	 * @param approvenPositionNos
	 * @param applyPositionIds
	 * @param applyPositionNames
	 * @param approvenPositionIds
	 * @param approvenPositionNames
	 * @param obj
	 * @param session
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/addHqApprovenRule")
    public void addHqApprovenRule(String[] applyPositionNos,String[] approvenExps,String[] approvenPositionNos,
    		String[] applyPositionIds,String[] applyPositionNames,String[] approvenPositionIds,String[] approvenPositionNames,
    		HqApprovenRule obj,HttpSession session,HttpServletRequest request,HttpServletResponse response) {
		Map map=new HashMap<String, String>();
		try {
		HttpSessionProvider httpSessionProvider=new HttpSessionProvider();
		List ruleList= new ArrayList();
		if(applyPositionNos!=null&&applyPositionNos.length>0&&approvenPositionNos!=null&&approvenPositionNos.length>0){
			if(approvenExps!=null&&approvenExps.length>0){
				for (int i = 0; i < approvenPositionNos.length; i++) {
						int allExps=0;
						if(approvenExps[i]==""){
							approvenExps[i]="0";
						}
						allExps+=Integer.parseInt(approvenExps[i]);
						//当所有规则表达式都是0的时候，删除现有规则
						if(allExps==0){
							this.hqApprovenRuleService.delete(obj);
						}
					if(StringUtil.isNotNullOrBlank(approvenExps[i])&&Integer.parseInt(approvenExps[i])>0){
						HqApprovenRule rule=new HqApprovenRule();
						//申请职位
						rule.setApplyPositionNo(applyPositionNos[i]);
						rule.setApplyPositionId(applyPositionIds[i]);
						rule.setApplyPositionName(applyPositionNames[i]);
						//审批职位
						rule.setApprovenPositionNo(approvenPositionNos[i]);
						rule.setApprovenPositionId(approvenPositionIds[i]);
						rule.setApprovenPositionName(approvenPositionNames[i]);
						//审批类型
						rule.setApprovenTypeId(obj.getApprovenTypeId());
						rule.setApprovenTypeName(obj.getApprovenTypeName()); 
						rule.setApprovenUnitId(obj.getApprovenUnitId()); //审批公司
						rule.setApprovenExp(approvenExps[i]); //审批额
						rule=(HqApprovenRule) httpSessionProvider.fillBaseInfo(rule, session, request, response);
						ruleList.add(rule);
					}
				}
			}
			//更新审批规则
			
				if(ruleList.size()>0){
					this.hqApprovenRuleService.updateHqApprovenRule(ruleList, obj);
				}
				map.put("code", "000"); //更新审批规则成功
			
			}else{
				map.put("code", "002");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("code", "001");
		}
		response.setCharacterEncoding("utf-8");
 		JSONUtils.objectToJson(request, response, map);
    }
	
}