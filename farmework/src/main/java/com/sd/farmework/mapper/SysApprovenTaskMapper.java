package com.sd.farmework.mapper; 

import java.util.List;

import com.sd.farmework.common.BaseInfo;
import com.sd.farmework.common.BaseMapper;

/** 
 * 审批待办任务表
 * @author Administrator 
 * 
 */ 
public interface SysApprovenTaskMapper  extends BaseMapper{ 
	public List<BaseInfo> queryAllApprovenTaskList(BaseInfo obj);
	public List<BaseInfo> queryRemainderTaskList(BaseInfo obj);
	public void updateNextApprovenPerosn(BaseInfo ojb);
	
	public List<BaseInfo> queryAllApprovenTaskListForMysql(BaseInfo obj);
	public List<BaseInfo> queryRemainderTaskListForMysql(BaseInfo obj);
	public void updateNextApprovenPerosnForMysql(BaseInfo ojb);
	public BaseInfo queryFirstPerson(BaseInfo ojb) throws Exception;
	/**
	 * 根据来源表主键id删除代办任务
	 * @param obj
	 * @throws Exception
	 */
	public void deleteForSourcePkId(BaseInfo obj)throws Exception;
	/**
	 * 删除审核人代办任务
	 * @param obj
	 * @throws Exception
	 */
	public void deleteTaskForApprovenPerson(BaseInfo obj)throws Exception;
}