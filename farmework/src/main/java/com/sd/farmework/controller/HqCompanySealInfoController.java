package com.sd.farmework.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sd.farmework.common.HttpSessionProvider;
import com.sd.farmework.common.JSONUtils;
import com.sd.farmework.pojo.HqCompanySealInfo;
import com.sd.farmework.pojo.HqFileInfo;
import com.sd.farmework.service.HqCompanySealInfoService;

/**
 * 公章
 * @author 梁鹏
 * 
 */

@Controller
@Scope("prototype")
@RequestMapping(value="/manager/loginIn/companySealInfo")
public class HqCompanySealInfoController {
	Logger logger = Logger.getLogger(HqCompanySealInfoController.class);
	
	@Autowired
	private HqCompanySealInfoService hqCompanySealInfoService;
	/**
	 * 公章分页列表
	 * @param session
	 * @param request
	 * @param response
	 * @param hqCompanySealInfo
	 * @param model
	 * @param limit
	 * @param pageIndex
	 * @throws IOException
	 */
	@RequestMapping(value = "/queryListByPageIndex", method = RequestMethod.GET)
	public void queryListByPageIndex(HttpSession session,
			HttpServletRequest request, HttpServletResponse response,
			HqCompanySealInfo hqCompanySealInfo, Model model,int limit,int pageIndex){
		pageIndex++;
		hqCompanySealInfo.setPageSize(limit);
		hqCompanySealInfo.setCurrPage(pageIndex);
		try {
			List list=this.hqCompanySealInfoService.queryListByPage(hqCompanySealInfo);
			int count=hqCompanySealInfoService.queryCount(hqCompanySealInfo);
			hqCompanySealInfo.setTotalCount(count);
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("results", count);
			map.put("rows", JSONArray.fromObject(list));
			map.put("code", "000");
			map.put("msg", "操作成功");
 			JSONUtils.objectToJson(request, response, map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Map<String,String> map = new HashMap<String,String>();
			map.put("code", "001");
			map.put("msg", "系统繁忙");
			JSONUtils.objectToJson(request, response, map);
		}
	}
	
	/**
	 * 公章添加
	 * @param session
	 * @param request
	 * @param response
	 * @param hqCompanySealInfo
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void add(HttpSession session,
			HttpServletRequest request, HttpServletResponse response,
			HqCompanySealInfo hqCompanySealInfo){
		try {
			HttpSessionProvider sessionProvider=new HttpSessionProvider();
			hqCompanySealInfo=(HqCompanySealInfo) sessionProvider.fillBaseInfo(hqCompanySealInfo, session, request, response);
			this.hqCompanySealInfoService.add(hqCompanySealInfo);
			Map<String,String> map = new HashMap<String,String>();
			map.put("code", "000");
			map.put("msg", "添加成功");
 			JSONUtils.objectToJson(request, response, map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Map<String,String> map = new HashMap<String,String>();
			map.put("code", "001");
			map.put("msg", "系统繁忙");
			JSONUtils.objectToJson(request, response, map);
		}
	}
	/**
	 * 公章编辑
	 * @param session
	 * @param request
	 * @param response
	 * @param hqCompanySealInfo
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public void update(HttpSession session,
			HttpServletRequest request, HttpServletResponse response,
			HqCompanySealInfo hqCompanySealInfo){
		try {
			HttpSessionProvider sessionProvider=new HttpSessionProvider();
			hqCompanySealInfo=(HqCompanySealInfo) sessionProvider.fillBaseInfo(hqCompanySealInfo, session, request, response);
			this.hqCompanySealInfoService.update(hqCompanySealInfo);
			Map<String,String> map = new HashMap<String,String>();
			map.put("code", "000");
			map.put("msg", "编辑成功");
 			JSONUtils.objectToJson(request, response, map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Map<String,String> map = new HashMap<String,String>();
			map.put("code", "001");
			map.put("msg", "系统繁忙");
			JSONUtils.objectToJson(request, response, map);
		}
	}
	/**
	 * 查询所有公章
	 * @param session
	 * @param request
	 * @param response
	 * @param hqFileInfo
	 */
	@RequestMapping(value = "/queryAll", method = RequestMethod.POST)
	public void queryAll(HttpSession session,
			HttpServletRequest request, HttpServletResponse response,
			HqFileInfo hqFileInfo){
		try {
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("list", this.hqCompanySealInfoService.queryList(hqFileInfo));
			map.put("code", "000");
 			JSONUtils.objectToJson(request, response, map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Map<String,String> map = new HashMap<String,String>();
			map.put("code", "001");
			map.put("msg", "系统繁忙");
			JSONUtils.objectToJson(request, response, map);
		}
	}
}
