package com.sd.farmework.controller; 


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
import com.sd.farmework.pojo.SysApprovenFunction;
import com.sd.farmework.pojo.SysZhichuType;
import com.sd.farmework.service.SysZhichuTypeService;
/** 
 * 审批规则表
 * @author Administrator 
 * 
 */ 
 @Controller
 @Scope("prototype")
 @RequestMapping(value="/manager/loginIn/SysZhiChuType")
public class SysZhiChuTypeController{
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
	@RequestMapping(value = "/zcTypeDataList", method = RequestMethod.POST)
	public String hqApprovenDataList(SysApprovenFunction obj, Model model,HttpServletResponse response) throws Exception {
		  
		List<BaseInfo> list = this.sysZhichuTypeService.queryList(null);
  
 		model.addAttribute("list", list);
 		response.setCharacterEncoding("utf-8");
 		response.getWriter().write(JSONArray.fromObject(list).toString());
 		
 		
		return null;
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public void add(SysZhichuType obj,HttpSession session,HttpServletRequest request,HttpServletResponse response){
		Map map=new HashMap();
		try {
			HttpSessionProvider httpSessionProvider =new HttpSessionProvider();
			obj=(SysZhichuType) httpSessionProvider.fillBaseInfo(obj, session, request, response);
			this.sysZhichuTypeService.add(obj);
			map.put("code", "000");
			map.put("msg", "操作成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("code", "001");
			map.put("msg", "操作失败");
		}
		JSONUtils.objectToJson(request, response, map);
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public void update(SysZhichuType obj,HttpSession session,HttpServletRequest request,HttpServletResponse response){
		Map map=new HashMap();
		try {
			this.sysZhichuTypeService.update(obj);
			map.put("code", "000");
			map.put("msg", "操作成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("code", "001");
			map.put("msg", "操作失败");
		}
		JSONUtils.objectToJson(request, response, map);
	}
	@RequestMapping(value="/deleteRuel",method=RequestMethod.POST)
	public void deleteRuel(SysZhichuType obj,HttpSession session,HttpServletRequest request,HttpServletResponse response){
		Map map=new HashMap();
		try {
			sysZhichuTypeService.deleteRule(obj);
 			map.put("code", "000");
			map.put("msg", "操作成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("code", "001");
			map.put("msg", "操作失败");
		}
		JSONUtils.objectToJson(request, response, map);
	}	
}