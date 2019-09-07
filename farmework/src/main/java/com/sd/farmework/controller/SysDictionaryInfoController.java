package com.sd.farmework.controller; 

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sd.farmework.service.SysDictionaryInfoService; 
import com.sd.farmework.pojo.SysDictionaryInfo; 
import com.sd.farmework.common.BaseInfo;
import com.sd.farmework.common.HttpSessionProvider;
import com.sd.farmework.common.JSONUtils;

import org.apache.log4j.Logger;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import  javax.servlet.http.HttpServletRequest;
import  javax.servlet.http.HttpServletResponse;
import  javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/** 
 * 数据字典表
 * @author Administrator 
 * 
 */ 
 @Controller
 @Scope("prototype")
 @RequestMapping(value="/SysDictionaryInfoModule")
public class SysDictionaryInfoController{ 
    @Autowired
    private SysDictionaryInfoService SysDictionaryInfoService;
    
    private HttpSessionProvider httpSessionProvider;
    /**
    * 添加
    * @param session
    * @param request
    * @param response
    * @param SysApprovenFunction
    * @param model
    * @return
    */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String  add(HttpSession session,HttpServletRequest request,HttpServletResponse response,SysDictionaryInfo SysDictionaryInfo,Model model){
		try {
			SysDictionaryInfoService.add(SysDictionaryInfo);	
		} catch (Exception e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
    /**
    * 修改
    * @param session
    * @param request
    * @param response
    * @param SysApprovenFunction
    * @param model
    * @return
    */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String  update(HttpSession session,HttpServletRequest request,HttpServletResponse response,SysDictionaryInfo SysDictionaryInfo,Model model){
		try {
			SysDictionaryInfoService.update(SysDictionaryInfo);	
		} catch (Exception e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
    /**
    * 修改
    * @param session
    * @param request
    * @param response
    * @param SysApprovenFunction
    * @param model
    * @return
    */
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public String  delete(HttpSession session,HttpServletRequest request,HttpServletResponse response,SysDictionaryInfo SysDictionaryInfo,Model model){
		try {
			SysDictionaryInfoService.delete(SysDictionaryInfo);	
		} catch (Exception e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
    /**
    * 查询不分页列表
    * @param session
    * @param request
    * @param response
    * @param SysApprovenFunction
    * @param model
    * @return
    */
    @RequestMapping(value = "/queryList",method = RequestMethod.POST)
    public String  queryList(HttpSession session,HttpServletRequest request,HttpServletResponse response,SysDictionaryInfo SysDictionaryInfo,Model model){
    	Map map =new HashMap();
		map.put("code", httpSessionProvider.FILTER_LOGIN_TIME_SUCCESS_CODE);
		map.put("msg", httpSessionProvider.FILTER_LOGIN_TIME_SUCCESS_MSG);
    	try {
			//查询日程分类类型数据
    		SysDictionaryInfo.setDictionaryTypeId("00004");;
			List list=SysDictionaryInfoService.queryList(SysDictionaryInfo);
			map.put("rows", list);
			JSONUtils.objectToJson(request, response, map);
    		return null;
		} catch (Exception e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("code", httpSessionProvider.FILTER_LOGIN_TIME_ERROR_CODE);
			map.put("msg", httpSessionProvider.FILTER_LOGIN_TIME_ERROR_MSG);
			JSONUtils.objectToJson(request, response, map);
			return null;
		}
	}
    /**
    * 查询分页列表
    * @param session
    * @param request
    * @param response
    * @param SysApprovenFunction
    * @param model
    * @return
    */
    @RequestMapping(value = "/queryListByPage",method = RequestMethod.POST)
    public String  queryListByPage(HttpSession session,HttpServletRequest request,HttpServletResponse response,SysDictionaryInfo SysDictionaryInfo,Model model){
		try {
			SysDictionaryInfoService.queryCount(SysDictionaryInfo);	
			SysDictionaryInfoService.queryListByPage(SysDictionaryInfo);	
		} catch (Exception e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
    
    /**
    * 通过任意条件查询一条信息
    * @param session
    * @param request
    * @param response
    * @param SysApprovenFunction
    * @param model
    * @return
    */
    @RequestMapping(value = "/query",method = RequestMethod.POST)
    public String  query(HttpSession session,HttpServletRequest request,HttpServletResponse response,SysDictionaryInfo SysDictionaryInfo,Model model){
		try {
			SysDictionaryInfoService.query(SysDictionaryInfo);	
		} catch (Exception e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}