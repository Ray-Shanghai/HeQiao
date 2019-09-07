package com.sd.farmework.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sd.farmework.pojo.SysApprovenTask;

public interface   CurrencyNoteService extends BaseInfoService{
	/**
	 * 添加审批流
	 * @param session
	 * @param request
	 * @param response
	 * @param obj
	 * @return
	 */
	public Map addApproven(HttpSession session ,HttpServletRequest request,
				HttpServletResponse response)throws Exception;
	/**
	 * 处理审批
	 * @param session
	 * @param request
	 * @param response
	 * @param obj
	 * @param sysApprovenTaskService
	 * @param sysApprovenTaskedService
	 * @param approvenFunctionId
	 * @return
	 * @throws Exception 
	 */
	public Map<String, Object> doApproven(HttpSession session,
			HttpServletRequest request, HttpServletResponse response,
			SysApprovenTask obj, SysApprovenTaskService sysApprovenTaskService,
			SysApprovenTaskedService sysApprovenTaskedService,
			String approvenFunctionId) throws Exception;
	/**
	 * 查询所有的待审核列表(根据权限)
	 * @param map
	 * @return
	 * @throws Exception 
	 */
	public List queryWaitingListAll(Map map) throws Exception;
}
