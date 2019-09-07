package com.sd.farmework.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.sd.farmework.common.BaseInfo;
import com.sd.farmework.common.HttpSessionProvider;
import com.sd.farmework.common.JSONUtils;
import com.sd.farmework.common.util.StringUtil;
import com.sd.farmework.pojo.CurrencyNote;
import com.sd.farmework.pojo.HqNoticeFile;
import com.sd.farmework.pojo.HqNoticeInfo;
import com.sd.farmework.pojo.SysApprovenTask;
import com.sd.farmework.pojo.SysUserInfo;
import com.sd.farmework.service.HqNoticeFileService;
import com.sd.farmework.service.HqNoticeInfoService;

@Controller
@Scope("prototype")
@RequestMapping(value = "/manager/loginIn/notice")
public class HqNoticeInfoController {
	private static Logger logger = Logger
			.getLogger(HqNoticeInfoController.class);

	@Autowired
	private HqNoticeInfoService baseService;
	@Autowired
	private HqNoticeFileService fileService;
	
	/**
	 * 公告通知列表
	 * */
	@RequestMapping(value="/noticeList")
	public void noticeList(Model model,HqNoticeInfo obj,String state,HttpSession session,HttpServletRequest request,HttpServletResponse response,int limit,int pageIndex){
		try {
			pageIndex++;
			obj.setPageSize(limit);
			obj.setCurrPage(pageIndex);
			model.addAttribute("notice",obj);
			SysUserInfo user= (SysUserInfo) session.getAttribute(HttpSessionProvider.CURRENT_USER_SESSION_KEY);
			//obj.setUnitId(user.getUnitId());
			obj.setDepartId(user.getDepartId());
			obj.setCreateUserId(user.getUserId());
			List list=this.baseService.queryListByPage(obj);
			int totalCount=this.baseService.queryCount(obj);
			obj.setTotalCount(totalCount);
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("results", totalCount);
			map.put("rows", JSONArray.fromObject(list));
			map.put("code", "000");
			map.put("msg", "操作成功");
			JSONUtils.objectToJson(request, response, map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	/**
	 * 公告通知添加
	 * */
	
	@RequestMapping(value="/addNotice",method=RequestMethod.POST)
	public void addNotice(Model model,HqNoticeInfo obj,String filePath,String fileName,HttpSession session,HttpServletRequest request,HttpServletResponse response){
		
		HttpSessionProvider httpSessionProvider =new HttpSessionProvider();
		obj=(HqNoticeInfo)httpSessionProvider.fillBaseInfo(obj, session, request, response);
		
		ArrayList<HqNoticeFile> docs = addFileData(filePath, fileName, session,
				request, response, httpSessionProvider);
		try {
			this.baseService.addAll(obj, docs);
			Map< String, String> map=new HashMap();
			map.put("code", "000");
			map.put("msg", "添加成功");
			JSONUtils.objectToJson(request, response, map);	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Map< String, String> map=new HashMap();
			map.put("code", "001");
			map.put("msg", "添加失败");
			JSONUtils.objectToJson(request, response, map);
		}
	}

	private ArrayList<HqNoticeFile> addFileData(String filePath,
			String fileName, HttpSession session, HttpServletRequest request,
			HttpServletResponse response,
			HttpSessionProvider httpSessionProvider) {
		ArrayList<HqNoticeFile> docs=new ArrayList<HqNoticeFile>();
		if (StringUtil.isNotNullOrBlank(filePath)) {
			if(StringUtil.isNotNullOrBlank(filePath)){
				String []filePaths=filePath.split("\\^");
				for (int i = 0; i < filePaths.length; i++) {
					HqNoticeFile doc=new HqNoticeFile();
					if(StringUtil.isNotNullOrBlank(fileName)){
						String[]fileNames=fileName.split(",");
						doc.setFileName(fileNames[i]);
					}
					doc.setFilePath(filePaths[i]);
					doc=(HqNoticeFile)httpSessionProvider.fillBaseInfo(doc, session, request, response);
					docs.add(doc);
				}
			}
		}
		return docs;
	}
	
	/**
	 * 公告通知添加
	 * */
	
	@RequestMapping(value="/updateNotice",method=RequestMethod.POST)
	public void updateNotice(Model model,HqNoticeInfo obj,String filePath,String fileName,HttpSession session,HttpServletRequest request,HttpServletResponse response){
		
		HttpSessionProvider httpSessionProvider =new HttpSessionProvider();
		obj=(HqNoticeInfo)httpSessionProvider.fillBaseInfo(obj, session, request, response);
		
		ArrayList<HqNoticeFile> docs = addFileData(filePath, fileName, session,
				request, response, httpSessionProvider);
		try {
			this.baseService.updateAll(obj, docs);
			Map< String, String> map=new HashMap();
			map.put("code", "000");
			map.put("msg", "保存成功");
			JSONUtils.objectToJson(request, response, map);	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Map< String, String> map=new HashMap();
			map.put("code", "001");
			map.put("msg", "保存失败");
			JSONUtils.objectToJson(request, response, map);
		}
	}
	
	/**
	 * 通过id查询
	 * */
	
	@RequestMapping(value="/queryByPkId",method=RequestMethod.POST)
	public void queryByPkId(Model model,HqNoticeInfo obj,HttpSession session,HttpServletRequest request,HttpServletResponse response){
		
		try {
			Map< String, Object> map=new HashMap< String, Object>();
			map.put("notice", this.baseService.queryById(obj));
			HqNoticeFile file=new HqNoticeFile();
			file.setNoticeId(obj.getNoticeId());
			map.put("fileList", this.fileService.queryList(file));
			map.put("code", "000");
			map.put("msg", "操作成功");
			JSONUtils.objectToJson(request, response, map);	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Map< String, String> map=new HashMap< String, String>();
			map.put("code", "001");
			map.put("msg", "操作失败");
			JSONUtils.objectToJson(request, response, map);
		}
	}
	/**
	 * 微信端公告通知列表
	 * */
	@ResponseBody
	@RequestMapping(value="/queryListForWechat",method=RequestMethod.GET)
	public Object queryListForWechat(Model model,HqNoticeInfo obj,HttpSession session,HttpServletRequest request,HttpServletResponse respons){
		Map map=new HashMap();
		try {
			SysUserInfo user= (SysUserInfo) session.getAttribute("loginUser");
			//obj.setUnitId(user.getUnitId());
			obj.setDepartId(user.getDepartId());
			obj.setCreateUserId(user.getUserId());
			List list=this.baseService.queryListByPage(obj);
			int totalCount=this.baseService.queryCount(obj);
			obj.setTotalCount(totalCount);
			if(obj.getCurrPage()==obj.getPageCount()){
				map.put("pageOver", true);
			}
			map.put("rows", list);
			map.put("code", "000");
			map.put("msg", "操作成功！");
			return map;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("code", "001");
			map.put("msg", "操作失败！");
			return map;
		}
	}
	 /**
     * PC端公告列表
     * @param session
     * @param request
     * @param response
     * @param SysApprovenFunction
     * @param model
     * @return
     */
    @RequestMapping(value = "/queryListByPage")
    public String  queryListByPage(Model model,HqNoticeInfo obj, HttpSession session,HttpServletRequest request,HttpServletResponse response){
   	try{
   		model.addAttribute("notice", obj);
   		SysUserInfo user= (SysUserInfo) session.getAttribute("loginUser");
   		//obj.setUnitId(user.getUnitId());
   		obj.setDepartId(user.getDepartId());
   		obj.setCreateUserId(user.getUserId());
		int totalCount=this.baseService.queryCount(obj);
		obj.setTotalCount(totalCount);
		List list= this.baseService.queryListByPage(obj);
		model.addAttribute("list",list);
		model.addAttribute("totalCount", obj.getPageCount());
		model.addAttribute("currPage", obj.getCurrPage());
		return "page/heqiao/sysNotice/sys_notice";
		} catch (Exception e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }
    /**
	 * 通过id查询PC端
	 * */
	
	@RequestMapping(value="/queryByPkIdForPc",method=RequestMethod.GET)
	public String queryByPkIdForPc(Model model,HqNoticeInfo obj,HttpSession session,HttpServletRequest request,HttpServletResponse response){
		
		try {
			model.addAttribute("notice", this.baseService.queryById(obj));
			HqNoticeFile file=new HqNoticeFile();
			file.setNoticeId(obj.getNoticeId());
			model.addAttribute("fileList", this.fileService.queryList(file));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "page/heqiao/sysNotice/sys_notice_detail";
	}
}
