package com.sd.farmework.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sd.farmework.common.HttpSessionProvider;
import com.sd.farmework.common.JSONUtils;
import com.sd.farmework.common.TreeService;
import com.sd.farmework.common.util.StringUtil;
import com.sd.farmework.pojo.SysDepartInfo;
import com.sd.farmework.pojo.SysUserInfo;
import com.sd.farmework.service.SysDepartInfoService;
import com.sd.farmework.service.SysUserInfoService;

/**
 * 部门信息
 * 
 * @author Administrator
 * 
 */
@Controller
@Scope("prototype")
@RequestMapping(value = "/manager/loginIn/SysDepartInfo")
public class SysDepartInfoController {
	@Autowired
	private SysDepartInfoService SysDepartInfoService;

	@Autowired
	private SysUserInfoService sysUserInfoService;
	
	private Logger logger = Logger.getLogger(SysDepartInfoController.class);

	/**
	 * 1、添加单位信息页面
	 * 
	 * @param session
	 * @param request
	 * @param response
	 * @param sysDepartInfo
	 * @param model
	 * @param pid
	 * @return
	 */
	@RequestMapping(value = "/addUnit", method = RequestMethod.GET)
	public String addUnit(HttpSession session, HttpServletRequest request,
			HttpServletResponse response, SysDepartInfo sysDepartInfo,
			Model model, String pid) {
		model.addAttribute("parentDepartId", sysDepartInfo.getParentDepartId());

		return "sysManage/sysUnitInfo/addUnit";
	}

	/**
	 * 1、修改单位信息页面
	 * 
	 * @param session
	 * @param request
	 * @param response
	 * @param sysDepartInfo
	 * @param model
	 * @param pid
	 * @return
	 */
	@RequestMapping(value = "/editUnit", method = RequestMethod.GET)
	public String editUnit(HttpSession session, HttpServletRequest request,
			HttpServletResponse response, SysDepartInfo sysDepartInfo,
			Model model, String pid) {
		model.addAttribute("departId", sysDepartInfo.getDepartId());

		
		try {
			SysDepartInfo sysdepartInfo=(SysDepartInfo) SysDepartInfoService.queryByPkId(sysDepartInfo.getDepartId())	;
		   model.addAttribute("sysdepartInfo", sysdepartInfo);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return "sysManage/sysUnitInfo/editUnit";
	}
	
	/**
	 * 2、 添加单位信息提交保存
	 * 
	 * @param session
	 * @param request
	 * @param response
	 * @param SysApprovenFunction
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/saveAddUnit", method = RequestMethod.POST)
	public String saveAddUnit(HttpSession session, HttpServletRequest request,
			HttpServletResponse response, SysDepartInfo sysDepartInfo,
			Model model, String type) {
		Map map = new HashMap();
		try {
			HttpSessionProvider httpSessionProvider = new HttpSessionProvider();
			SysUserInfo sessionUserInfo = httpSessionProvider
					.getCurrentUserSession(session, request, response);
			sysDepartInfo = (SysDepartInfo) httpSessionProvider.fillBaseInfo(
					sysDepartInfo, sessionUserInfo);
			if ("unit".equals(type)) {
				sysDepartInfo.setNodeType(1);
				sysDepartInfo.setIsVirtual("1");
			}

			SysDepartInfoService.addUnit(sysDepartInfo);
			
			map.put("code", "000");
			map.put("msg", "success");
			JSONObject obj = JSONObject.fromObject(map);
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(obj.toString());
			response.getWriter().close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("code", "001");
			map.put("msg", "error");
			JSONObject obj = JSONObject.fromObject(map);
			try {
				response.getWriter().write(obj.toString());
				response.getWriter().close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return null;
	}
	
	/**
	 * 2、 添加单位信息提交保存
	 * 
	 * @param session
	 * @param request
	 * @param response
	 * @param SysApprovenFunction
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/saveEditDepartInfo", method = RequestMethod.POST)
	public String saveEditDepartInfo(HttpSession session, HttpServletRequest request,
			HttpServletResponse response, SysDepartInfo sysDepartInfo,
			Model model, String type) {
		Map map = new HashMap();
		try {
			HttpSessionProvider httpSessionProvider = new HttpSessionProvider();
			SysUserInfo sessionUserInfo = httpSessionProvider
					.getCurrentUserSession(session, request, response);
			sysDepartInfo = (SysDepartInfo) httpSessionProvider.fillBaseInfo(
					sysDepartInfo, sessionUserInfo);
			SysDepartInfoService.update(sysDepartInfo);

		 
			map.put("code", "000");
			map.put("msg", "success");
			JSONObject obj = JSONObject.fromObject(map);
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(obj.toString());
			response.getWriter().close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("code", "001");
			map.put("msg", "error");
			JSONObject obj = JSONObject.fromObject(map);
			try {
				response.getWriter().write(obj.toString());
				response.getWriter().close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * 1、添加部门信息页面
	 * 
	 * @param session
	 * @param request
	 * @param response
	 * @param sysDepartInfo
	 * @param model
	 * @param pid
	 * @return
	 */
	@RequestMapping(value = "/addDepart", method = RequestMethod.GET)
	public String addDepart(HttpSession session, HttpServletRequest request,
			HttpServletResponse response, SysDepartInfo sysDepartInfo,
			Model model, String unitId, String unitName) {
		model.addAttribute("unitName", unitName);
		model.addAttribute("unitId", unitId);
		model.addAttribute("parentDepartId", sysDepartInfo.getParentDepartId());

		return "sysManage/sysUnitInfo/addDepart";
	}
	
	/**
	 * 1、修改部门信息页面
	 * 
	 * @param session
	 * @param request
	 * @param response
	 * @param sysDepartInfo
	 * @param model
	 * @param pid
	 * @return
	 */
	@RequestMapping(value = "/editDepart", method = RequestMethod.GET)
	public String editDepart(HttpSession session, HttpServletRequest request,
			HttpServletResponse response, SysDepartInfo sysDepartInfo,
			Model model, String unitId, String unitName) {
		model.addAttribute("departId", sysDepartInfo.getDepartId());
		try {
			SysDepartInfo sysdepartInfo=(SysDepartInfo) SysDepartInfoService.queryByPkId(sysDepartInfo.getDepartId())	;
		   model.addAttribute("sysdepartInfo", sysdepartInfo);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "sysManage/sysUnitInfo/editDepart";
	}

	/**
	 * 2、 添加部门信息提交保存
	 * 
	 * @param session
	 * @param request
	 * @param response
	 * @param SysApprovenFunction
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/saveAddDepart", method = RequestMethod.POST)
	public String saveAddDepart(HttpSession session,
			HttpServletRequest request, HttpServletResponse response,
			SysDepartInfo sysDepartInfo, Model model, String type) {
		Map map = new HashMap();
		try {
			HttpSessionProvider httpSessionProvider = new HttpSessionProvider();
			SysUserInfo sessionUserInfo = httpSessionProvider
					.getCurrentUserSession(session, request, response);
			sysDepartInfo = (SysDepartInfo) httpSessionProvider.fillBaseInfo(
					sysDepartInfo, sessionUserInfo);
			if ("depart".equals(type)) {
				sysDepartInfo.setNodeType(2);
				sysDepartInfo.setIsVirtual("1");
			}

			SysDepartInfoService.addDepart(sysDepartInfo);

			map.put("code", "000");
			map.put("msg", "success");
			JSONObject obj = JSONObject.fromObject(map);
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(obj.toString());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			map.put("code", "001");
			map.put("msg", "error");
			JSONObject obj = JSONObject.fromObject(map);
			try {
				response.getWriter().write(obj.toString());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * 1、添加班组信息页面
	 * 
	 * @param session
	 * @param request
	 * @param response
	 * @param sysDepartInfo
	 * @param model
	 * @param pid
	 * @return
	 */
	@RequestMapping(value = "/addTeam", method = RequestMethod.GET)
	public String addTeam(HttpSession session, HttpServletRequest request,
			HttpServletResponse response, SysDepartInfo sysDepartInfo,
			Model model, String unitId, String unitName, String departName) {
		model.addAttribute("unitName", unitName);
		model.addAttribute("unitId", unitId);
		model.addAttribute("departName", departName);
		model.addAttribute("parentDepartId", sysDepartInfo.getParentDepartId());

		return "sysManage/sysUnitInfo/addTeam";
	}

	
	/**
	 * 1、修改班组信息页面
	 * 
	 * @param session
	 * @param request
	 * @param response
	 * @param sysDepartInfo
	 * @param model
	 * @param pid
	 * @return
	 */
	@RequestMapping(value = "/editTeam", method = RequestMethod.GET)
	public String editTeam(HttpSession session, HttpServletRequest request,
			HttpServletResponse response, SysDepartInfo sysDepartInfo,
			Model model,  String departName1) {
	 
		model.addAttribute("departName1", departName1);
		try {
			SysDepartInfo sysdepartInfo=(SysDepartInfo) SysDepartInfoService.queryByPkId(sysDepartInfo.getDepartId())	;
		   model.addAttribute("sysdepartInfo", sysdepartInfo);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "sysManage/sysUnitInfo/editTeam";
	}
	/**
	 * 2、 添加部门信息提交保存
	 * 
	 * @param session
	 * @param request
	 * @param response
	 * @param SysApprovenFunction
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/saveAddTeam", method = RequestMethod.POST)
	public String saveAddTeam(HttpSession session, HttpServletRequest request,
			HttpServletResponse response, SysDepartInfo sysDepartInfo,
			Model model, String type) {
		Map map = new HashMap();
		try {
			HttpSessionProvider httpSessionProvider = new HttpSessionProvider();
			SysUserInfo sessionUserInfo = httpSessionProvider
					.getCurrentUserSession(session, request, response);
			sysDepartInfo = (SysDepartInfo) httpSessionProvider.fillBaseInfo(
					sysDepartInfo, sessionUserInfo);
			if ("team".equals(type)) {
				sysDepartInfo.setNodeType(1);
				sysDepartInfo.setIsVirtual("4");
			}

			SysDepartInfoService.addTeam(sysDepartInfo);

			map.put("code", "000");
			map.put("msg", "success");
			JSONObject obj = JSONObject.fromObject(map);
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(obj.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("code", "001");
			map.put("msg", "error");
			JSONObject obj = JSONObject.fromObject(map);
			try {
				response.getWriter().write(obj.toString());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return null;
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
	public String update(HttpSession session, HttpServletRequest request,
			HttpServletResponse response, SysDepartInfo SysDepartInfo,
			Model model) {
		try {
			SysDepartInfoService.update(SysDepartInfo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
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
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(HttpSession session, HttpServletRequest request,
			HttpServletResponse response, SysDepartInfo SysDepartInfo,
			Model model) {
		try {
			SysDepartInfoService.delete(SysDepartInfo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 打开组织架构页面
	 * 
	 * @param session
	 * @param request
	 * @param response
	 * @param SysDepartInfo
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/queryListIndex", method = RequestMethod.GET)
	public String queryListIndex(HttpSession session,
			HttpServletRequest request, HttpServletResponse response,
			SysDepartInfo SysDepartInfo, Model model) {
		return "sysManage/sysUnitInfo/index";
	}

	/**
	 * 查询不分页列表
	 * 
	 * @param session
	 * @param request
	 * @param response
	 * @param SysApprovenFunction
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/queryList", method = RequestMethod.GET)
	public String queryList(HttpSession session, HttpServletRequest request,
			HttpServletResponse response, SysDepartInfo SysDepartInfo,
			Model model,String userId,String type) {
		try {
			String departPowers="";
			//此UserId获取单位
    		if(StringUtil.isNotNullOrBlank(userId)){
	 			SysUserInfo sysUserInfo=  (SysUserInfo) sysUserInfoService.queryByPkId(userId);
				if(sysUserInfo!=null){
					 departPowers=sysUserInfo.getDepartPower();
				}
    		}
    		
			List<String> listNodeType = new ArrayList();
			listNodeType.add("0");
			listNodeType.add("1");
			listNodeType.add("2");
			listNodeType.add("3");
			listNodeType.add("4");
			SysDepartInfo.setNodeTypes(listNodeType);
			List list = SysDepartInfoService.queryList(SysDepartInfo);
			List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
			for (int i = 0; i < list.size(); i++) {
				SysDepartInfo sysDepartInfo = (SysDepartInfo) list.get(i);
				Map<String, Object> map = new HashMap();
				map.put("PARENT_ID", sysDepartInfo.getParentDepartId());
				map.put("ID", sysDepartInfo.getDepartId());
				map.put("NAME", sysDepartInfo.getDepartName());
				map.put("isVirtual", sysDepartInfo.getIsVirtual());
				if("1".equals(type)&&departPowers.indexOf(","+sysDepartInfo.getDepartId()+",")>-1){
					map.put("checked",true);
				}
				listMap.add(map);
			}
			TreeService s = new TreeService();
			String srt = JSONArray.fromObject(s.getTreeData(listMap, "-1"))
					.toString();
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(srt);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
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
	public String getDepartInfoByParentId(String parentDepartId,
			HttpSession session, HttpServletRequest request,
			HttpServletResponse response, Model model,int page,int rows) {
		try {
			SysDepartInfo SysDepartInfo = new SysDepartInfo();
			SysDepartInfo.setParentDepartId(parentDepartId);
			SysDepartInfo.setPageSize(rows);
			SysDepartInfo.setCurrPage(page);
			int  count=SysDepartInfoService.getDepartInfoByParentIdCount(SysDepartInfo);
			List list = SysDepartInfoService
					.getDepartInfoByParentId(SysDepartInfo);
			//{total:15,rows:[{name:'test',age:12},{name:'test2',age:18}]}
			Map map = new HashMap();
			map.put("total", count);
			map.put("rows", JSONArray.fromObject(list));
			JSONObject ojb =JSONObject.fromObject(map);
			response.setCharacterEncoding("utf-8");
 			response.getWriter().write(ojb.toString());
 			response.getWriter().close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
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
	@RequestMapping(value = "/queryListByPage", method = RequestMethod.POST)
	public String queryListByPage(HttpSession session,
			HttpServletRequest request, HttpServletResponse response,
			SysDepartInfo SysDepartInfo, Model model) {
		try {
			SysDepartInfoService.queryCount(SysDepartInfo);
			SysDepartInfoService.queryListByPage(SysDepartInfo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	

	/**
	 * 通过任意条件查询一条信息
	 * 
	 * @param session
	 * @param request
	 * @param response
	 * @param SysApprovenFunction
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/query", method = RequestMethod.POST)
	public String query(HttpSession session, HttpServletRequest request,
			HttpServletResponse response, SysDepartInfo SysDepartInfo,
			Model model) {
		try {
			SysDepartInfoService.query(SysDepartInfo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 查询公司或者部门级联数据
	 * @param session
	 * @param request
	 * @param response
	 * @param sysDepartInfo
	 * @return
	 */
	@RequestMapping(value = "/queryUnitList", method = RequestMethod.POST)
	public String queryUnitList(HttpSession session, HttpServletRequest request,
			HttpServletResponse response,SysDepartInfo sysDepartInfo) {
		SysUserInfo user=(SysUserInfo) session.getAttribute(HttpSessionProvider.CURRENT_USER_SESSION_KEY);
		try {
			if("0".equals(sysDepartInfo.getIsVirtual())){
				sysDepartInfo.setNodeType(2);
			}else{
				sysDepartInfo.setNodeType(1);
  			}
			List list = SysDepartInfoService.queryDepartOrUnit(sysDepartInfo);
			Map map =new HashMap();
			map.put("code", "000");
			map.put("user",user);
			map.put("list",list);
			JSONUtils.objectToJson(request, response, map); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@ResponseBody
	@RequestMapping(value = "/queryDepartInfoByParentId", method = RequestMethod.POST)
	public Object queryDepartInfoByParentId(HttpSession session, HttpServletRequest request,
			HttpServletResponse response, SysDepartInfo SysDepartInfo,
			Model model)throws Exception {
		
		return this.SysDepartInfoService.queryDepartInfoByParentId(SysDepartInfo);
	}
	/**
	 * 查询所有单位
	 * @param session
	 * @param request
	 * @param response
	 * @param sysDepartInfo
	 * @param model
	 */
	@RequestMapping(value="/queryUnitDataList")
	public void queryUnitList(HttpSession session, HttpServletRequest request,
			HttpServletResponse response, SysDepartInfo sysDepartInfo,
			Model model){
		try {
			List<SysDepartInfo> list=this.SysDepartInfoService.queryUnitList(sysDepartInfo);
			JSONUtils.objectToJsonArray(request, response, list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}