package com.sd.farmework.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

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
import com.sd.farmework.common.MD5Util;
import com.sd.farmework.common.util.StringUtil;
import com.sd.farmework.pojo.Menu;
import com.sd.farmework.pojo.SysAuthority;
import com.sd.farmework.pojo.SysFunctionInfo;
import com.sd.farmework.pojo.SysRoleInfo;
import com.sd.farmework.pojo.SysUserInfo;
import com.sd.farmework.pojo.TmUserArchivesInfo;
import com.sd.farmework.service.SysFunctionInfoService;
import com.sd.farmework.service.SysRoleInfoService;
import com.sd.farmework.service.SysUserInfoService;

/**
 * 用户信息操作
 * 
 * @author Administrator
 * 
 */
@SuppressWarnings("rawtypes")
@Controller
@Scope("prototype")
@RequestMapping(value = "/manager/loginIn/SysUserInfo")
public class SysUserInfoController {
	private static Logger logger = Logger.getLogger("SysUserInfoController");
	@Autowired
	private SysUserInfoService SysUserInfoService;
	@Autowired
	private SysFunctionInfoService sysFunctionInfoService;
	@Autowired
	private SysRoleInfoService sysRoleInfoService;
	/**
	 * 添加
	 * 
	 * @param session
	 * @param request
	 * @param response
	 * @param SysApprovenFunction
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void add(HttpSession session, HttpServletRequest request,
			HttpServletResponse response, SysUserInfo  sysUserInfo, Model model) {
		try {

			sysUserInfo.setLoginPwd(MD5Util.GetMD5Code(sysUserInfo
					.getLoginPwd()));
			HttpSessionProvider httpSessionProvider = new HttpSessionProvider();
			sysUserInfo = (SysUserInfo) httpSessionProvider.fillBaseInfo(
					sysUserInfo, session, request, response);
				
			SysUserInfoService.add(sysUserInfo);
			Map<String,String> map = new HashMap<String,String>();
			map.put("code", "000");
			map.put("msg", "success");
			JSONUtils.objectToJson(request, response, map);
		} catch (Exception e) {
			e.printStackTrace();
			Map<String,String> map = new HashMap<String,String>();
			map.put("code", "001");
			map.put("msg", "系统繁忙");
			JSONUtils.objectToJson(request, response, map);
		}
		
	}
	
	/**
	 * 修改
	 * 
	 * @param session
	 * @param request
	 * @param response
	 * @param SysApprovenFunction
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public void update(HttpSession session, HttpServletRequest request,
			HttpServletResponse response, SysUserInfo SysUserInfo, Model model,
			String oldloginPwd) {
		try {
			if (!oldloginPwd.equals(SysUserInfo.getLoginPwd())) {
				SysUserInfo.setLoginPwd(MD5Util.GetMD5Code(SysUserInfo
						.getLoginPwd()));
			}
			HttpSessionProvider httpSessionProvider = new HttpSessionProvider();
			SysUserInfo = (SysUserInfo) httpSessionProvider.fillBaseInfo(
					SysUserInfo, session, request, response);
			SysUserInfoService.update(SysUserInfo);
			Map<String,String> map = new HashMap<String,String>();
			map.put("code", "000");
			map.put("msg", "success");
			JSONUtils.objectToJson(request, response, map);
		} catch (Exception e) {
			e.printStackTrace();
			Map<String,String> map = new HashMap<String,String>();
			map.put("code", "001");
			map.put("msg", "系统繁忙，请稍后再试");
			JSONUtils.objectToJson(request, response, map);
		}
		 
	}
	/**
	 * 修改部门权限
	 * 
	 * @param session
	 * @param request
	 * @param response
	 * @param SysApprovenFunction
	 * @param model
	 * @return
	 */
	/*
	@RequestMapping(value = "/updateDepartPower", method = RequestMethod.POST)
	public void updateDepartPower(HttpSession session, HttpServletRequest request,
			HttpServletResponse response, SysUserInfo SysUserInfo) {
		try {
			 
			HttpSessionProvider httpSessionProvider = new HttpSessionProvider();
			SysUserInfo = (SysUserInfo) httpSessionProvider.fillBaseInfo(
					SysUserInfo, session, request, response);
			SysUserInfoService.updateDepartPower(SysUserInfo);
			Map<String,String> map = new HashMap<String,String>();
			map.put("code", "000");
			map.put("msg", "success");
			JSONUtils.objectToJson(request, response, map);
		} catch (Exception e) {
			e.printStackTrace();
			Map<String,String> map = new HashMap<String,String>();
			map.put("code", "001");
			map.put("msg", "系统繁忙，请稍后再试");
			JSONUtils.objectToJson(request, response, map);
		}
	}
*/
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
			SysUserInfo SysUserInfo, Model model,int limit,int pageIndex) {
		try {
			pageIndex++;
			SysUserInfo.setPageSize(limit);
			SysUserInfo.setCurrPage(pageIndex);
			List list = SysUserInfoService.queryListByPage(SysUserInfo);
			SysUserInfo.setTotalCount(SysUserInfoService.queryCount(SysUserInfo));
			Map<String,Object> map = new HashMap<String,Object>();
			
			map.put("results", SysUserInfoService.queryCount(SysUserInfo));
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
	 * 登录
	 * 
	 * @param session
	 * @param request
	 * @param response
	 * @param SysApprovenFunction
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/query", method = RequestMethod.POST)
	public void query(HttpSession session, HttpServletRequest request,
			HttpServletResponse response, SysUserInfo SysUserInfo, Model model) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("code", "LOGIN_0000");
		map.put("msg", "success");
		
		try {
			SysUserInfo.setLoginPwd(MD5Util.GetMD5Code(SysUserInfo
					.getLoginPwd()));
			@SuppressWarnings("unchecked")
			List<BaseInfo> list = SysUserInfoService.query(SysUserInfo);
			System.out.println(list);
			 
			if (list.size() == 0) {
				map.put("code", "LOGIN_0001");
				map.put("msg", "用户名或密码不存在。");
				logger.info("用户名或密码不存在.。");
			} else if (list.size() > 1) {
				map.put("code", "LOGIN_0002");
				map.put("msg", "用户名或密码不存在。");
				logger.info("用户名或密码不存在。");
			} else {
				SysUserInfo sysUserInfo = (SysUserInfo) list.get(0);
				if(sysUserInfo.getDepartPower()!=null){
					String[] departPowers=sysUserInfo.getDepartPower().split(",");
					List power=new ArrayList();
					for (String str : departPowers) {
						if(StringUtil.isNotNullOrBlank(str)){
							power.add(str);
						}
					}
					if(power.size()>0){
						session.setAttribute(HttpSessionProvider.CURRENT_USER_SESSION_DEPART_POWERS, power.toArray(new String[power.size()]));
					}else{
						session.setAttribute(HttpSessionProvider.CURRENT_USER_SESSION_DEPART_POWERS, null);
					}
				}
				
				
				//根据userid查询用户档案基本信息
				TmUserArchivesInfo paramObj = new TmUserArchivesInfo();
				paramObj.setUserId(sysUserInfo.getUserId());
				
				
				session.setAttribute(
						HttpSessionProvider.CURRENT_USER_SESSION_KEY,
						sysUserInfo);
				
				model.addAttribute("userInfo", sysUserInfo);

				List functionInfoList = sysFunctionInfoService.queryList(null);
				if (functionInfoList == null || functionInfoList.size() == 0) {
					logger.info("没有分配角色信息。");
					map.put("code", "LOGIN_0003");
					map.put("msg", "没有分配角色信息");
				} else {
					SysUserInfo sysUserRole = new SysUserInfo();
					sysUserRole.setUserId(sysUserInfo.getUserId());
					List sysUserRoleList = sysRoleInfoService
							.queryFunction(sysUserRole);

					StringBuffer sb = new StringBuffer();

					for (int i = 0; i < sysUserRoleList.size(); i++) {
						SysRoleInfo sysUserRoleI = (SysRoleInfo) sysUserRoleList
								.get(i);
						// sysUserRoleI.get
						sb.append(sysUserRoleI.getFunctionIds());
					}
 					List childTypeList  = new ArrayList();
 					LinkedHashMap<String,List<Menu>> functionTypeMap = new LinkedHashMap<String,List<Menu>>();
					for (int i = 0; i < functionInfoList.size(); i++) {
						SysFunctionInfo sysFunctionInfo = (SysFunctionInfo) functionInfoList.get(i);
						String functionId = sysFunctionInfo.getFunctionId();
						
						if (functionId.length() == 6) {
							//父节点
							String functionName = sysFunctionInfo.getFunctionName();
							String typeId = sysFunctionInfo.getTypeId();
							List list11= new ArrayList();
							//匹配对应二级功能
							for (int j = 0; j < functionInfoList.size(); j++) {
								SysFunctionInfo sysFunctionInfoChild = (SysFunctionInfo) functionInfoList.get(j);
								String parentFunctionId = sysFunctionInfoChild.getParentFunctionId();
								if (sysFunctionInfoChild.getFunctionId().length()==9&&parentFunctionId.equals(functionId)&&sb.toString().indexOf(","+ sysFunctionInfoChild.getFunctionId() + ",") > -1) {
									Menu menu = new Menu();
									menu.setId(sysFunctionInfoChild.getFunctionId());
									menu.setText(sysFunctionInfoChild.getFunctionName());
									menu.setParentMenuId(sysFunctionInfoChild.getParentFunctionId());
									menu.setHref(sysFunctionInfoChild.getFunctionUrl());
									menu.setMenuType(sysFunctionInfoChild.getTypeId());
									list11.add(menu);
								}
							}
							 
							Map map1 = new HashMap();
							
							map1.put("text", functionName);
							map1.put("items", list11);
							
							
							if(!functionTypeMap.containsKey(typeId)){
								childTypeList =new  ArrayList();
								childTypeList.add(map1);
								functionTypeMap.put(typeId, childTypeList);
							}else{
								childTypeList.add(map1);
							}
							 
						}
					}
					session.setAttribute("functionMap", functionTypeMap);
				}

			}
			JSONUtils.objectToJson(request, response, map);

		} catch (Exception e) {
			e.printStackTrace();

			map.put("code", "LOGIN_0004");
			map.put("msg", "系统繁忙，请稍后再试。");

			JSONUtils.objectToJson(request, response, map);

		}

	}

	/**
	 * 登录
	 * 
	 * @param session
	 * @param request
	 * @param response
	 * @param SysApprovenFunction
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/PcLogin", method = RequestMethod.POST)
	public String PcLogin(HttpSession session, HttpServletRequest request,
			HttpServletResponse response, SysUserInfo SysUserInfo, Model model) {
		/*Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", "LOGIN_0000");
		map.put("msg", "success");*/

		try {
			SysUserInfo.setLoginPwd(MD5Util.GetMD5Code(SysUserInfo
					.getLoginPwd()));
			@SuppressWarnings("unchecked")
			List<BaseInfo> list = SysUserInfoService.query(SysUserInfo);
			System.out.println(list);
			 
			if (list.size() == 0) {
				logger.info("用户名或密码不存在。");
				response.sendRedirect(request.getContextPath()
						+ "/page/heqiao/login.html?001");
				return null;
			} else if (list.size() > 1) {
				logger.info("用户名或密码不存在。");
				response.sendRedirect(request.getContextPath()
						+ "/page/heqiao/login.html?001");
				return null;
			} else {
				SysUserInfo sysUserInfo = (SysUserInfo) list.get(0);
				
				
				//根据userid查询用户档案基本信息
				TmUserArchivesInfo paramObj = new TmUserArchivesInfo();
				paramObj.setUserId(sysUserInfo.getUserId());
				
				
				session.setAttribute(
						HttpSessionProvider.CURRENT_USER_SESSION_KEY,
						sysUserInfo);
				model.addAttribute("userInfo", sysUserInfo);

				List functionInfoList = sysFunctionInfoService.queryList(null);
				if (functionInfoList == null || functionInfoList.size() == 0) {
					logger.info("没有分配角色信息。");
					response.sendRedirect(request.getContextPath()
							+ "/page/heqiao/login.html?002");
					return null;
				} else {
					SysUserInfo sysUserRole = new SysUserInfo();
					sysUserRole.setUserId(sysUserInfo.getUserId());
					List sysUserRoleList = sysRoleInfoService
							.queryFunction(sysUserRole);

					StringBuffer sb = new StringBuffer();

					for (int i = 0; i < sysUserRoleList.size(); i++) {
						SysRoleInfo sysUserRoleI = (SysRoleInfo) sysUserRoleList
								.get(i);
						// sysUserRoleI.get
						sb.append(sysUserRoleI.getFunctionIds());
					}
 					List childTypeList  = new ArrayList();
 					LinkedHashMap<String,List<Menu>> functionTypeMap = new LinkedHashMap<String,List<Menu>>();
					for (int i = 0; i < functionInfoList.size(); i++) {
						SysFunctionInfo sysFunctionInfo = (SysFunctionInfo) functionInfoList.get(i);
						String functionId = sysFunctionInfo.getFunctionId();
						
						if (functionId.length() == 6) {
							//父节点
							String functionName = sysFunctionInfo.getFunctionName();
							String typeId = sysFunctionInfo.getTypeId();
							List list11= new ArrayList();
							//匹配对应二级功能
							for (int j = 0; j < functionInfoList.size(); j++) {
								SysFunctionInfo sysFunctionInfoChild = (SysFunctionInfo) functionInfoList.get(j);
								String parentFunctionId = sysFunctionInfoChild.getParentFunctionId();
								if (sysFunctionInfoChild.getFunctionId().length()==9&&parentFunctionId.equals(functionId)&&sb.toString().indexOf(","+ sysFunctionInfoChild.getFunctionId() + ",") > -1) {
									Menu menu = new Menu();
									menu.setId(sysFunctionInfoChild.getFunctionId());
									menu.setText(sysFunctionInfoChild.getFunctionName());
									menu.setParentMenuId(sysFunctionInfoChild.getParentFunctionId());
									menu.setHref(sysFunctionInfoChild.getFunctionUrl());
									menu.setMenuType(sysFunctionInfoChild.getTypeId());
									list11.add(menu);
								}
							}
							 
							Map map1 = new HashMap();
							
							map1.put("text", functionName);
							map1.put("items", list11);
							
							
							if(!functionTypeMap.containsKey(typeId)){
								childTypeList =new  ArrayList();
								childTypeList.add(map1);
								functionTypeMap.put(typeId, childTypeList);
							}else{
								childTypeList.add(map1);
							}
							 
						}
					}
					session.setAttribute("functionMap", functionTypeMap);
				}

			}
				return "page/heqiao/index";

		} catch (Exception e) {
			e.printStackTrace();
			/*JSONUtils.objectToJson(request, response, map);*/
			try {
				response.sendRedirect(request.getContextPath()
						+ "/page/heqiao/login.html?003");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return "page/heqiao/login";
		}
	}
	/**
	 * 获取功能菜单
	 * @param session
	 * @param request
	 * @param response
	 * @param model
	 * @param userId
	 */
	@ResponseBody
	@RequestMapping(value = "/getCurrentUserMenu", method = RequestMethod.POST)
	public void getCurrentUserMenu(HttpSession session,
			HttpServletRequest request, HttpServletResponse response,
			Model model, String userId) {
		
		
		Map functionMap= (Map)session.getAttribute("functionMap");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("code", "INDEX_0000");
	 
		 
		map.put("functionMap", functionMap);
		HttpSessionProvider p = new HttpSessionProvider();
		SysUserInfo sysUserInfo = p.getCurrentUserSession(session, request,
				response);

		map.put("user", sysUserInfo);

		
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
	@RequestMapping(value = "/getDepartInfoByParentId", method = RequestMethod.POST)
	public String getDepartInfoByParentId(String userId, HttpSession session,
			HttpServletRequest request, HttpServletResponse response,
			Model model, int page) {
		try {
			SysUserInfo sysUserInfo = new SysUserInfo();
			sysUserInfo.setPageSize(15);
			sysUserInfo.setCurrPage(page);
			int count = sysRoleInfoService
					.queryUserRoleByUserIdCount(sysUserInfo);
			List list = sysRoleInfoService.queryUserRoleByUserId(sysUserInfo);
			// {total:15,rows:[{name:'test',age:12},{name:'test2',age:18}]}
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("total", count);
			map.put("rows", JSONArray.fromObject(list));
			JSONObject ojb = JSONObject.fromObject(map);
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(ojb.toString());

			response.getWriter().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 获取用户信息
	 * @return
	 */
	@RequestMapping(value = "/userLoginOut", method = RequestMethod.GET)
	public String  userLoginOut(SysUserInfo user,Model model,HttpServletRequest request,HttpServletResponse response){
		logger.info("UserInfoController loginout");
 		try {
 			
 			 
 			request.getSession().removeAttribute("loginUser");
 			
 			response.sendRedirect(request.getContextPath()
 					+ "/page/heqiao/login.html");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
 		
 		return null;
	}
}