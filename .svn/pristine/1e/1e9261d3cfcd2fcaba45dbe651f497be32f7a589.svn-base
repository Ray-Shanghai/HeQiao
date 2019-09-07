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
import com.sd.farmework.pojo.SysAuthority;
import com.sd.farmework.pojo.SysUserInfo;
import com.sd.farmework.service.SysAuthorityService;

@Controller
@Scope("prototype")
@RequestMapping(value="/manager/loginIn/sysAuthority")
public class SysAuthorityController {
	@Autowired
	private SysAuthorityService sysAuthorityService;
	
	/**
	 * 
	 * @param session
	 * @param request
	 * @param response
	 * @param obj
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public void add(HttpSession session,HttpServletRequest request,HttpServletResponse response,SysAuthority obj){
		Map map=new HashMap();
		try {
			HttpSessionProvider httpSessionProvider=new HttpSessionProvider();
			obj=(SysAuthority) httpSessionProvider.fillBaseInfo(obj, session, request, response);
			this.sysAuthorityService.add(obj);
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
	/**
	 * 
	 * @param session
	 * @param request
	 * @param response
	 * @param obj
	 */
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public void update(HttpSession session,HttpServletRequest request,HttpServletResponse response,SysAuthority obj){
		Map map=new HashMap();
		try {
			HttpSessionProvider httpSessionProvider=new HttpSessionProvider();
			obj=(SysAuthority) httpSessionProvider.fillBaseInfo(obj, session, request, response);
			this.sysAuthorityService.update(obj);
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
	
	/**
	 * 查询分页列表
	 * 
	 * @param session
	 * @param request
	 * @param response
	 * @param SysApprovenFunction
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/queryListByPageIndex", method = RequestMethod.GET)
	public String queryListByPageIndex(HttpSession session,
			HttpServletRequest request, HttpServletResponse response,
			SysAuthority obj, Model model,int limit,int pageIndex) {
		try {
			pageIndex++;
			obj.setPageSize(limit);
			obj.setCurrPage(pageIndex);
			List list = this.sysAuthorityService.queryListByPage(obj);
			obj.setTotalCount(this.sysAuthorityService.queryCount(obj));
			Map<String,Object> map = new HashMap<String,Object>();
			
			map.put("results", obj.getTotalCount());
			map.put("rows", JSONArray.fromObject(list));
			
 			JSONUtils.objectToJson(request, response, map);

		} catch (Exception e) {
			e.printStackTrace();
			Map<String,String> map = new HashMap<String,String>();
			map.put("code", "001");
			map.put("msg", "系统繁忙");
			JSONUtils.objectToJson(request, response, map);
		}

		return null;
	}
	
	/**
	 * 查询职权信息列表
	 * @param obj
	 * @param model
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/authorityDataList", method = RequestMethod.POST)
	public String approvenFunctionDataList(SysApprovenFunction obj, Model model,HttpServletResponse response) throws Exception {
		  
		List<BaseInfo> list = this.sysAuthorityService.queryList(obj);
  
 		model.addAttribute("list", list);
 		response.setCharacterEncoding("utf-8");
 		response.getWriter().write(JSONArray.fromObject(list).toString());
 		
 		
		return null;
	}
}
