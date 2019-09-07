package com.sd.farmework.mapper; 

import java.util.List;

import com.sd.farmework.common.BaseMapper; 
import com.sd.farmework.pojo.SysDepartInfo;

/** 
 * 团队组织机构表
 * @author Administrator 
 * 
 */ 
public interface SysDepartInfoMapper  extends BaseMapper{
	public List<SysDepartInfo> getDepartInfoByParentId(SysDepartInfo sysDepartInfo);
	public int getDepartInfoByParentIdCount(SysDepartInfo sysDepartInfo);
	public void addUnit(SysDepartInfo sysdepartInfo);
	public void addUnitDepart(SysDepartInfo sysdepartInfo);
	public void addUnitRole(SysDepartInfo sysdepartInfo);
	
	public void addDepart(SysDepartInfo sysdepartInfo);
	public void addDepartTeam(SysDepartInfo sysdepartInfo);
	public void addDepartRole(SysDepartInfo sysdepartInfo);
	
	public void addTeam(SysDepartInfo sysdepartInfo);
	public void addTeamRole(SysDepartInfo sysdepartInfo);

	public void addRoleUnitRole(SysDepartInfo sysdepartInfo);
	
	
	public List<SysDepartInfo> getDepartInfoByParentIdForMysql(SysDepartInfo sysDepartInfo);
	public int getDepartInfoByParentIdCountForMysql(SysDepartInfo sysDepartInfo);
	public void addUnitForMysql(SysDepartInfo sysdepartInfo);
	public void addUnitDepartForMysql(SysDepartInfo sysdepartInfo);
	public void addUnitRoleForMysql(SysDepartInfo sysdepartInfo);
	public void addDepartForMysql(SysDepartInfo sysdepartInfo);
	public void addDepartTeamForMysql(SysDepartInfo sysdepartInfo);
	public void addDepartRoleForMysql(SysDepartInfo sysdepartInfo);
	
	public void addTeamForMysql(SysDepartInfo sysdepartInfo);
	public void addTeamRoleForMysql(SysDepartInfo sysdepartInfo);
	
	public void addRoleUnitRoleForMysql(SysDepartInfo sysdepartInfo);
	
	public List queryDepartOrUnit(SysDepartInfo sysdepartInfo)throws Exception;
	
	public List<SysDepartInfo> queryDepartInfoByParentId(SysDepartInfo sysDepartInfo);
	/**
	 * 查询单位名称集合
	 * @param sysDepartInfo
	 * @return
	 */
	List<SysDepartInfo> queryUnitList(SysDepartInfo sysDepartInfo);
	/**
	 * 添加科室
	 * @param sysdepartInfo
	 */
	public void addDepartSectionForMysql(SysDepartInfo sysdepartInfo);
}