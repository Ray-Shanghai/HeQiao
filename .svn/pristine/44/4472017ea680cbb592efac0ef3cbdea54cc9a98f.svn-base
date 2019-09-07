package com.sd.farmework.controller; 

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import com.sd.farmework.common.PropertiesConstant;
import com.sd.farmework.common.util.StringUtil;
import com.sd.farmework.pojo.CurrencyNote;
import com.sd.farmework.pojo.HqCurrencyDetail;
import com.sd.farmework.pojo.HqExpenditureDetail;
import com.sd.farmework.pojo.HqExpenditureDetailList;
import com.sd.farmework.pojo.SysApprovenTask;
import com.sd.farmework.pojo.SysApprovenTasked;
import com.sd.farmework.pojo.SysAuthority;
import com.sd.farmework.pojo.SysUserInfo;
import com.sd.farmework.pojo.SysZhichuType;
import com.sd.farmework.service.CurrencyNoteService;
import com.sd.farmework.service.HqCurrencyDetailService;
import com.sd.farmework.service.HqExpenditureDetailService;
import com.sd.farmework.service.SysApprovenFunctionRuleService;
import com.sd.farmework.service.SysApprovenRulePersonService;
import com.sd.farmework.service.SysApprovenTaskService;
import com.sd.farmework.service.SysApprovenTaskedService;
import com.sd.farmework.service.SysAuthorityService;
import com.sd.farmework.service.SysUserInfoService;
import com.sd.farmework.service.SysZhichuTypeService;
import com.sd.farmework.wx.QYWeixinUtil;
import com.sd.farmework.wx.QYWxConstant;
/** 
 * 资料库类型
 * @author Administrator 
 * 
 */ 
 @Controller
 @Scope("prototype")
 @RequestMapping(value="/manager/loginIn/currencyNote")
public class CurrencyNoteController extends BaseController{ 
	 
	 @Autowired
	private CurrencyNoteService currencyNoteService;
	 @Autowired
	private SysApprovenRulePersonService ruleServices;
	@Autowired
	private SysApprovenTaskService sysApprovenTaskService;
	@Autowired
	private SysApprovenTaskedService sysApprovenTaskedService;
	@Autowired
	private SysApprovenFunctionRuleService sysApprovenFunctionRuleService;
	@Autowired
	private SysUserInfoService sysUserInfoService;
	@Autowired
	private HqCurrencyDetailService hqCurrencyDetailService;
	@Autowired
	private HqExpenditureDetailService hqExpenditureDetailService;
	@Autowired
	private QYWxConstant qYWxConstant;
	@Autowired
	private PropertiesConstant propertiesConstant;
	private String approvenFunctionId = "";
	@Autowired
	private SysAuthorityService sysAuthorityService;
	@Autowired
	private SysZhichuTypeService zhichuTypeService;
    /**
    * 添加
    * @param session
    * @param request
    * @param response
    * @param CurrencyNote
    * @param model
    * @return
    */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public void   add(HttpSession session,HttpServletRequest request,HttpServletResponse response,CurrencyNote currencyNote,String[]fileNames,String filePaths,HqExpenditureDetailList hqExpenditureDetailList,Model model){
		try {
			SysUserInfo sysUserInfo =  (SysUserInfo) session.getAttribute(HttpSessionProvider.CURRENT_USER_SESSION_KEY);
			Map<String,String> map = new HashMap<String,String>();
     		 
			//00001通用申请00002支出申请00003请假申请
			/*if("101".equals(currencyNote.getNoteType())){
				approvenFunctionId="101";
			}*/
			//判断审批类型（通用，支出，请假）
			if(currencyNote.getNoteType()!=""){
				approvenFunctionId=currencyNote.getNoteType();
			}
			request.setAttribute("hqExpenditureDetailList", hqExpenditureDetailList);
			request.setAttribute("approvenFunctionId", approvenFunctionId);
			currencyNote.setPostion(sysUserInfo.getPostion()); //提交人的职位
			request.setAttribute("obj", currencyNote); //提交的详细信息
			
			currencyNoteService.addApproven(session, request, response);
			map.put("code","000");
			map.put("msg", "添加成功");
			JSONUtils.objectToJson(request, response, map);
		} catch (Exception e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
			Map<String,String> map = new HashMap<String,String>();
			map.put("code", "999");
			map.put("msg", "系统繁忙");
			if (("001").equals(e.getMessage())) {
				map.put("code", "001");
				map.put("msg", "没有定义审批流程");
 			}if (("002").equals(e.getMessage())) {
				map.put("code", "002");
				map.put("msg", "没有定义对应的审批人");
 			}
			if (("003").equals(e.getMessage())) {
				map.put("code", "003");
				map.put("msg", "设置审批流信息异常了！");
 			} 
			JSONUtils.objectToJson(request, response, map);
		}
		 

	}

	/**
	 * 5、执行审批操作
	 * 
	 * @param obj
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/saveApproven", method = RequestMethod.POST)
	public String saveTestApproven(HttpSession session,
			HttpServletRequest request, HttpServletResponse response,
			SysApprovenTask obj, Model model,String noteType) throws Exception {
		try {
			if(StringUtil.isNotNullOrBlank(noteType)){
				approvenFunctionId=noteType;
			}
			// 审批功能编号
		Map map = this.currencyNoteService.doApproven(session, request, response,
					obj, sysApprovenTaskService, sysApprovenTaskedService,
					approvenFunctionId);
		JSONUtils.objectToJson(request, response, map);
		} catch (Exception e) {
			Map<String,String> map = new HashMap<String,String>();
			// TODO: handle exception
			map.put("code", "001");
			map.put("msg", "系统繁忙");
			JSONUtils.objectToJson(request, response, map);
		}
		return null;
 	}

    /**
	 * 查询分页列表
	 * 
	 * @param session
	 * @param request
	 * @param response
	 * @param SysApprovenTask
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/queryWaitingList", method = RequestMethod.POST)
	public String queryWaitingList(HttpSession session,
			HttpServletRequest request, HttpServletResponse response,SysApprovenTask sysApprovenTask) {
		 
		try {
			
			SysUserInfo sysUserInfo =  (SysUserInfo) session.getAttribute(HttpSessionProvider.CURRENT_USER_SESSION_KEY);
			sysApprovenTask.setApprovenUnitId(sysUserInfo.getUnitId());
			sysApprovenTask.setApprovenPostion(sysUserInfo.getPostion());
			sysApprovenTask.setApprovenFunctionId(approvenFunctionId);
			Map  map = new HashMap();
			List list = sysApprovenTaskService.queryList(sysApprovenTask);
			map.put("code", "000");
			map.put("list",list);
			JSONUtils.objectToJson(request, response, map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	 /**
     * 查询待审核列表
     * @param session
     * @param request
     * @param response
     * @param SysApprovenFunction
     * @param model
     * @return
     */
     @RequestMapping(value = "/queryWaitingListAll",method = RequestMethod.POST)
     public String  queryWaitingListAll(HttpSession session,HttpServletRequest request,HttpServletResponse response,SysApprovenTask SysApprovenTask,Model model,String code){
    	 Map<String,Object> map=new HashMap<String,Object>();
 		try {
 			 
 			
 			SysUserInfo sysUserInfo =  getUserSession(request);
 			 
 			map.put("approvenDepartId", sysUserInfo.getDepartId());
 			map.put("approvenPostion",sysUserInfo.getAuthorityId());
 			//map.put("power", session.getAttribute(HttpSessionProvider.CURRENT_USER_SESSION_DEPART_POWERS));
 			List<Map> list = this.currencyNoteService.queryWaitingListAll(map);
 			if(list!=null&&list.size()>0){
				for (int i = 0; i < list.size(); i++) {
					//获取请假类型
					if(list.get(i).get("leave_type")!=null){
						String zcId=(String) list.get(i).get("leave_type");
						SysZhichuType zcType=new SysZhichuType();
						zcType.setZcId(zcId);
						zcType=(SysZhichuType) zhichuTypeService.queryById(zcType);
						list.get(i).put("leave_type", zcType.getZcTypeName());
					}
				}
 			}
 			Map<String,Object> map1=new HashMap<String,Object>(); 
 			map1.put("currency", list);
 			map1.put("code", "000");
 			JSONUtils.objectToJson(request, response, map1);
 			
 		} catch (Exception e) {
 		// TODO Auto-generated catch block
 			e.printStackTrace();
 			map.put("code", "001");
 			map.put("msg", "系统繁忙或在系统中不存在！");
 			JSONUtils.objectToJson(request, response, map);
 		}
 		return null;
 	}
     /**
      * 查询已有的申请单数
      * @param session
      * @param request
      * @param response
      * @param SysApprovenFunction
      * @param model
      * @return
      */
      @RequestMapping(value = "/queryCount",method = RequestMethod.GET)
      public String  queryCount(HttpSession session,HttpServletRequest request,HttpServletResponse response,CurrencyNote currencyNote,Model model){
    	  SysUserInfo user=(SysUserInfo) session.getAttribute(HttpSessionProvider.CURRENT_USER_SESSION_KEY);
  		try {
  			SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
  			SimpleDateFormat year=new SimpleDateFormat("yyyy");
  			SimpleDateFormat month=new SimpleDateFormat("MM");
  			SimpleDateFormat day=new SimpleDateFormat("dd");
  			Date date=new Date();
  			currencyNote.setCreateTime(sf.format(date));
  			Map map=new HashMap();
  			String count=new DecimalFormat("0000").format(this.currencyNoteService.queryCount(currencyNote)+1);
  			map.put("user", user);
  			map.put("count",year.format(date)+"_"+month.format(date)+"_"+day.format(date)+"_"+count);
  			map.put("code", "000");
  			JSONUtils.objectToJson(request, response, map);
  		} catch (Exception e) {
  		// TODO Auto-generated catch block
  			e.printStackTrace();
  			Map map=new HashMap();
  			map.put("code", "001");
  			map.put("msg", "系统繁忙");
  			JSONUtils.objectToJson(request, response, map);
  		}
  		return null;
  	}
      /**
       * 根据主键查询唯一信息
       * @param session
       * @param request
       * @param response
       * @param SysApprovenFunction
       * @param model
       * @return
       */
       @ResponseBody
       @RequestMapping(value = "/queryByPkIdForMysql",method = RequestMethod.POST)
       public Object  queryByPkIdForMysql(CurrencyNote currency, HttpSession session,HttpServletRequest request,HttpServletResponse response,Model model){
      	 Map map=new HashMap();
   		try {
   			SysUserInfo sysUserInfo =  getUserSession(request);
   			if(sysUserInfo==null){
   				map.put("code", "001");
   	   			map.put("msg", "查询失败");
   	   			return map;
   			}
   			CurrencyNote currencyNote=(CurrencyNote) this.currencyNoteService.queryByPkId(currency.getNoteId());
   			SysApprovenTask approvenTask=new SysApprovenTask();
   			approvenTask.setSourceTablePkColumnValue(currency.getNoteId());
   		
   			if(currencyNote.getNoteType()!=""){
   				approvenTask.setApprovenFunctionId(currency.getNoteType());
			}
   			List approvenTaksList=this.sysApprovenTaskService.queryAllApprovenTaskList(approvenTask);
   			
   			if(approvenTaksList.size()>0){
   				for (int i = 0; i < approvenTaksList.size(); i++) {
   					SysApprovenTask sysApprovenTask =(SysApprovenTask) approvenTaksList.get(i);
   					if(sysApprovenTask.getApprovenPostion()!=null){
   						SysAuthority sysAuthority= (SysAuthority) sysAuthorityService.queryByPkId(sysApprovenTask.getApprovenPostion());
   						sysApprovenTask.setApprovenPostionName(sysAuthority.getAuthorityName());
   					}
				}
				
			}
   			
   			HqCurrencyDetail currencyDetail=new HqCurrencyDetail();
			currencyDetail.setCurrencyId(currency.getNoteId());
			map.put("fileList", this.hqCurrencyDetailService.queryList(currencyDetail));
   			map.put("currencyNote",currencyNote);
   			map.put("approvenTaksList", approvenTaksList);
   			HqExpenditureDetail hqExpenditureDetail=new HqExpenditureDetail();
			hqExpenditureDetail.setCurrencyId(currency.getNoteId());
			map.put("expendTureList", this.hqExpenditureDetailService.queryList(currencyDetail));
   			map.put("code", "000");
   			map.put("msg", "查询成功！");
   			return map;
   		} catch (Exception e) {
   		// TODO Auto-generated catch block
   			e.printStackTrace();
   			map.put("code", "001");
   			map.put("msg", "查询失败");
   			return map;
   		}
   	}
       /**
        * 查询已有的申请单数
        * @param session
        * @param request
        * @param response
        * @param SysApprovenFunction
        * @param model
        * @return
        */
       @RequestMapping(value = "/queryListByPage")
       public String  queryListByPage(CurrencyNote currency, HttpSession session,HttpServletRequest request,HttpServletResponse response,Model model){
      	try{
      		model.addAttribute("currency", currency);
      		SysUserInfo user= (SysUserInfo) session.getAttribute(HttpSessionProvider.CURRENT_USER_SESSION_KEY);
      		currency.setCreateUserId(user.getUserId());
			int totalCount=this.currencyNoteService.queryCount(currency);
			currency.setTotalCount(totalCount);
			List list= this.currencyNoteService.queryListByPage(currency);
			ArrayList<CurrencyNote> currencyNoteList=(ArrayList<CurrencyNote>) list;
			for (CurrencyNote currencyNote : currencyNoteList) {
				SysApprovenTask sysApprovenTask=new SysApprovenTask();
				sysApprovenTask.setSourceTablePkColumnValue(currencyNote.getNoteId());
				SysApprovenTasked sysApprovenTasked=new SysApprovenTasked();
				sysApprovenTasked.setSourceTablePkColumnValue(currencyNote.getNoteId());
				
				BaseInfo baseInfo=new BaseInfo();
				Map map=new HashMap();
				if("1".equals(currencyNote.getAuditStatus())){
					baseInfo= this.sysApprovenTaskService.queryFirstPerson(sysApprovenTask);
					SysApprovenTask sysApprovenTask1=(SysApprovenTask) baseInfo;
					if(sysApprovenTask1!=null){
						map.put("sysApprovenTask", sysApprovenTask1);
						map.put("approvenPostion", sysApprovenTask1.getApprovenPostion());
						map.put("approvenUserName", sysApprovenTask1.getApprovenUserName());
						currencyNote.setPostion(sysApprovenTask1.getApprovenPostion());
						currencyNote.setApprovenDepartId(sysApprovenTask1.getApprovenDepartId());
						currencyNote.setApprovenDepartName(sysApprovenTask1.getApprovenDepartName());
						currencyNote.setTaskId(sysApprovenTask1.getTaskId());
						currencyNote.setApprovenUnitId(sysApprovenTask1.getApprovenUnitId());
						currencyNote.setApprovenUnitName(sysApprovenTask1.getApprovenUnitName());
					}
					
				}
				else{
					baseInfo= this.sysApprovenTaskedService.queryFirstPerson(sysApprovenTasked);
					SysApprovenTasked sysApprovenTasked1=(SysApprovenTasked) baseInfo;
					if(sysApprovenTasked1!=null){
						map.put("sysApprovenTasked", sysApprovenTasked1);
						map.put("approvenPostion", sysApprovenTasked1.getApprovenPostion());
						map.put("approvenUserName", sysApprovenTasked1.getApprovenUserName());
					}
				}
				determineList(currencyNote, map);
			}
			if(currencyNoteList!=null&&currencyNoteList.size()>0){
				for (int i = 0; i < currencyNoteList.size(); i++) {
					//获取请假类型
					if(currencyNoteList.get(i).getLeaveType()!=null){
						String zcId=currencyNoteList.get(i).getLeaveType();
						SysZhichuType zcType=new SysZhichuType();
						zcType.setZcId(zcId);
						zcType=(SysZhichuType) zhichuTypeService.queryById(zcType);
						currencyNoteList.get(i).setLeaveType(zcType.getZcTypeName());
					}
				}
			}
			model.addAttribute("list",currencyNoteList);
			model.addAttribute("totalCount", currency.getPageCount());
			model.addAttribute("currPage", currency.getCurrPage());
      		if("1".equals(currency.getAuditStatus())){
      			return "page/heqiao/approveNote/approveNote";
      		}
   			if("3".equals(currency.getAuditStatus())){
   				return "page/heqiao/approveNote/returnNote";
   			}
   			if("2".equals(currency.getAuditStatus())){
   				if("3".equals(currency.getNoteType())){
   					return "page/heqiao/historyNote/his_currency_note";
   				}
   				if("1".equals(currency.getNoteType())){
   					return "page/heqiao/historyNote/his_expenditure_note";
   				}
   				if("2".equals(currency.getNoteType())){
   					return "page/heqiao/historyNote/his_leave_note";
   				}
   			}
   		} catch (Exception e) {
   		// TODO Auto-generated catch block
   			e.printStackTrace();
   		}
   		return null;
       }

	public void determineList(CurrencyNote currencyNote, Map map) {
		if(map!=null){
			SysApprovenTasked sysApprovenTasked =(SysApprovenTasked) map.get("sysApprovenTasked");
			SysApprovenTask sysApprovenTask =(SysApprovenTask) map.get("sysApprovenTask");
			if("1".equals(currencyNote.getAuditStatus())){
				if(sysApprovenTask!=null){
					currencyNote.setAuditStatus("待审核："+sysApprovenTask.getApprovenPostionName());
				}
				if(sysApprovenTasked!=null){
					currencyNote.setAuditStatus("待审核："+sysApprovenTasked.getApprovenPostionName());
				}
			}
			if("2".equals(currencyNote.getAuditStatus())){
				if(sysApprovenTask!=null){
					currencyNote.setAuditStatus("审核通过："+sysApprovenTask.getApprovenPostionName());
				}
				if(sysApprovenTasked!=null){
					currencyNote.setAuditStatus("审核通过："+sysApprovenTasked.getApprovenPostionName());
				}
			}
			
			if("3".equals(currencyNote.getAuditStatus())){
				if(sysApprovenTask!=null){
					currencyNote.setAuditStatus("审核未通过："+sysApprovenTask.getApprovenPostionName());
				}
				if(sysApprovenTasked!=null){
					currencyNote.setAuditStatus("审核未通过："+sysApprovenTasked.getApprovenPostionName());
				}
			}
		}
	}
       /**
        * 根据主键查询唯一信息（PC端用）
        * @param session
        * @param request
        * @param response
        * @param SysApprovenFunction
        * @param model
        * @return
        */
        @RequestMapping(value = "/queryByPkId",method = RequestMethod.GET)
        public String  queryByPkId(CurrencyNote currency, HttpSession session,HttpServletRequest request,HttpServletResponse response,Model model){
    		try {
    			CurrencyNote currencyNote=(CurrencyNote) this.currencyNoteService.queryByPkId(currency.getNoteId());
    			SysUserInfo sysUserInfo=new SysUserInfo();
    			sysUserInfo.setUserId(currencyNote.getCreateUserId());
    			sysUserInfo=(SysUserInfo) sysUserInfoService.queryById(sysUserInfo);
    			currencyNote.setPostion(sysUserInfo.getAuthorityName());
    			
    			SysApprovenTask approvenTask=new SysApprovenTask();
    			approvenTask.setSourceTablePkColumnValue(currency.getNoteId());

    			approvenTask.setApprovenFunctionId(currency.getNoteType());
    			List<BaseInfo> approvenTaksList=this.sysApprovenTaskService.queryAllApprovenTaskList(approvenTask);
    			if(approvenTaksList.size()>0){
    				for(BaseInfo base:approvenTaksList){
    					SysApprovenTask sysApprovenTask = (SysApprovenTask)base;
    					SysAuthority sysAuthority= (SysAuthority) sysAuthorityService.queryByPkId(sysApprovenTask.getApprovenPostion());
    					sysApprovenTask.setApprovenPostionName(sysAuthority.getAuthorityName());
    				}
    				model.addAttribute("approvenTask",approvenTaksList.get(0));
    			}
    			model.addAttribute("currencyNote",currencyNote);
    			model.addAttribute("approvenTaksList", approvenTaksList);
    			HqCurrencyDetail currencyDetail=new HqCurrencyDetail();
    			currencyDetail.setCurrencyId(currency.getNoteId());
    			model.addAttribute("fileList", this.hqCurrencyDetailService.queryList(currencyDetail));
    			HqExpenditureDetail hqExpenditureDetail=new HqExpenditureDetail();
    			hqExpenditureDetail.setCurrencyId(currency.getNoteId());
    			model.addAttribute("expendTureList", this.hqExpenditureDetailService.queryList(currencyDetail));
    			if("3".equals(currency.getNoteType().substring(0, 1))){
    				return "page/heqiao/applyNote/currency_note_detail";
    			}
    			if("1".equals(currency.getNoteType().substring(0, 1))){
    				return "page/heqiao/applyNote/expenditure_note_detail";
    			}
    			if("2".equals(currency.getNoteType().substring(0, 1))){
    				return "page/heqiao/applyNote/leave_note_detail";
    			}
    		} catch (Exception e) {
    		// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		return null;
    	}
        /**
    	 * 查询用户
    	 * 
    	 * @param session
    	 * @param request
    	 * @param response
    	 * @param model
    	 * @return
    	 * @throws Exception
    	 */
    	@RequestMapping(value = "/queryUser")
    	public void queryUser(HttpSession session, HttpServletRequest request,
    			HttpServletResponse response,SysUserInfo sysUserInfo, Model model) {
    		try {
    			sysUserInfo.setStatus("Y");
    			Map map = new HashMap();
    			map.put("list", this.sysUserInfoService.queryList(sysUserInfo));
    			map.put("code", "000");
    			JSONUtils.objectToJson(request, response, map);
    		} catch (Exception e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    			Map map = new HashMap();
    			map.put("code", "001");
    			map.put("msg", "系统繁忙！");
    			JSONUtils.objectToJson(request, response, map);
    		}

    	}
    	/**
    	 * 请假申请页面
    	 * 
    	 * @param currency
    	 * @param session
    	 * @param request
    	 * @param response
    	 * @param model
    	 * @return
    	 */
    	@RequestMapping(value = "/leaveNote")
    	public String leaveNote(CurrencyNote currency, HttpSession session,
    			HttpServletRequest request, HttpServletResponse response,
    			Model model) {
    		model.addAttribute("user", session
    				.getAttribute(HttpSessionProvider.CURRENT_USER_SESSION_KEY));
    		return "page/heqiao/applyNote/leave_note_1";
    	}
    	  
        /**
         * 根据主键删除待办数据
         * @param session
         * @param request
         * @param response
         * @param CurrencyNote
         * @param model
         * @return
         */
         @ResponseBody
         @RequestMapping(value = "/deleteByPkId",method = RequestMethod.GET)
         public Object  deleteByPkId(CurrencyNote currency, HttpSession session,HttpServletRequest request,HttpServletResponse response,Model model){
        	 Map map=new HashMap();
     		try {
     			this.currencyNoteService.delete(currency);
     			//一并删除代办任务表中的数据
     			SysApprovenTask sysApprovenTask=new SysApprovenTask();
     			sysApprovenTask.setSourceTablePkColumnValue(currency.getNoteId());
     			this.sysApprovenTaskService.deleteForSourcePkId(sysApprovenTask);
     			map.put("code", "000");
     			map.put("msg", "操作成功！");
     			return map;
     		} catch (Exception e) {
     		// TODO Auto-generated catch block
     			e.printStackTrace();
     			map.put("code", "001");
     			map.put("msg", "取消申请失败！");
     			return map;
     		}
     	}
         
         /**
          * 根据业务表主键查询第一个审批人
          * @param session
          * @param request
          * @param response
          * @param SysApprovenTask
          * @param model
          * @return
          */
          @ResponseBody
          @RequestMapping(value = "/queryFirstPerson",method = RequestMethod.GET)
          public Object  queryFirstPerson(SysApprovenTask sysApprovenTask, HttpSession session,HttpServletRequest request,HttpServletResponse response,Model model){
         	 Map map=new HashMap();
      		try {
      			map.put("sysApprovenTask", this.sysApprovenTaskService.queryFirstPerson(sysApprovenTask));
      			map.put("code", "000");
      			return map;
      		} catch (Exception e) {
      		// TODO Auto-generated catch block
      			e.printStackTrace();
      			map.put("code", "001");
      			map.put("msg", "查询失败！");
      			return map;
      		}
      	}
          /**
           * 根据传入的postion和departId查出对应的信息
           * @param session
           * @param request
           * @param response
           * @param SysApprovenTask
           * @param model
           * @return
           */
           @ResponseBody
           @RequestMapping(value = "/warnNote",method = RequestMethod.POST)
           public Object  warnNote(SysUserInfo user,String noteType,String noteId,String taskId, HttpSession session,HttpServletRequest request,HttpServletResponse response,Model model){
        	String serverDemo=request.getScheme()+"://"+ qYWxConstant.getServerDomain()+":"+request.getServerPort();
        	Map map=new HashMap();
       		try {
       			List<SysUserInfo>list = this.sysUserInfoService.queryUserByPostionAndDepart(user);
       			QYWeixinUtil qYWeixinUtil=new QYWeixinUtil();
       			StringBuffer toUsers=new StringBuffer();
				for (SysUserInfo sysUserInfo : list) {
					toUsers.append(sysUserInfo.getLoginName()+"|");
				}     
				map.put("loginName", toUsers.toString());
				String noteType1 = noteType.substring(0,1);
				String str="";
				String detail="";
				if ("3".equals(noteType1)) {
					str="通用";
					detail="detail3";
				}else if("1".equals(noteType1)){
					str="支出";
					detail="detail1";
				}else if("2".equals(noteType1)){
					str="请假";
					detail="detail2";
				}
				
				map.put("content","<a href='https://open.weixin.qq.com/connect/oauth2/authorize?appid="+qYWxConstant.getWxAppId()+"&redirect_uri="+serverDemo+"/HeQiao/wx/"+detail+"/"+noteId+"/"+taskId+"/"+noteType+"&response_type=code&scope=snsapi_userinfo&agentid=4&state=STATE#wechat_redirect'>您有一条"+str+"申请需要审批</a>");
        			map=qYWeixinUtil.sendEmployeeMessage(qYWxConstant, map);
       			return map;
       		} catch (Exception e) {
       		// TODO Auto-generated catch block
       			e.printStackTrace();
       			map.put("code", "001");
       			map.put("msg", "查询失败！");
       			return map;
       		}
       	} 
}