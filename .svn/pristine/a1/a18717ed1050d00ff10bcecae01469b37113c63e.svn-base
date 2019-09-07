package com.sd.farmework.service; 

import java.util.List;

import com.sd.farmework.common.BaseInfo;
import com.sd.farmework.pojo.SysApprovenTask;

/** 
 * 审批待办任务表
 * @author Administrator 
 * 
 */ 
public interface SysApprovenTaskService  extends BaseInfoService{ 
	public List<BaseInfo> queryAllApprovenTaskList(BaseInfo obj);
	public List<BaseInfo> queryRemainderTaskList(BaseInfo obj);
	public void updateNextApprovenPerosn(BaseInfo ojb);
	public BaseInfo queryFirstPerson(BaseInfo ojb) throws Exception;
	/**
	 * 根据来源表主键id删除代办任务
	 * @param obj
	 * @throws Exception
	 */
	public void deleteForSourcePkId(SysApprovenTask obj)throws Exception;
}