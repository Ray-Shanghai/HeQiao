package com.sd.farmework.service;

import java.util.List;

import com.sd.farmework.common.BaseInfo;
import com.sd.farmework.pojo.HqApprovenRule;

public interface HqApprovenRuleService extends BaseInfoService {
	/**
	 *	更新审核规则信息
	 * @throws Exception
	 */
	public void updateHqApprovenRule(List<BaseInfo> list,BaseInfo obj) throws Exception;
	/**
	 * 查出当前部门是否有对应类型的审批流
	 * @param rule
	 * @return
	 * @throws Exception
	 */
	public Integer queryMaxExp(HqApprovenRule rule)throws Exception;
	/**
	 * 查询符合部门，发起人职位，审批类型的所有审批流  
	 * @param rule
	 * @return
	 * @throws Exception
	 */
	public List<HqApprovenRule> queryApprovenList (HqApprovenRule rule)throws Exception;
}
