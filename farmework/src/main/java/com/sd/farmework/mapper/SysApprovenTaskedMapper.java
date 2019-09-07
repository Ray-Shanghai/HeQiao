package com.sd.farmework.mapper; 

import com.sd.farmework.common.BaseInfo;
import com.sd.farmework.common.BaseMapper; 

/** 
 * 已办任务表
 * @author Administrator 
 * 
 */ 
public interface SysApprovenTaskedMapper  extends BaseMapper{ 
	public BaseInfo queryFirstPerson(BaseInfo obj) throws Exception;
}