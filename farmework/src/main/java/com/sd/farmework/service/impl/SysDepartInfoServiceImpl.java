package com.sd.farmework.service.impl; 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.farmework.mapper.SysDepartInfoMapper;
import com.sd.farmework.mapper.SysRoleInfoMapper;
import com.sd.farmework.pojo.SysDepartInfo;
import com.sd.farmework.pojo.SysRoleInfo;
import com.sd.farmework.service.SysDepartInfoService;

/** 
 * 团队组织机构表
 * @author Administrator 
 * 
 */ 
 @Service
public class SysDepartInfoServiceImpl extends BaseInfoServiceImpl implements SysDepartInfoService{ 
    @Autowired
    private SysDepartInfoMapper baseMapper;
    
    @Autowired
    private SysRoleInfoMapper sysRoleInfoMapper;
    public SysDepartInfoMapper getBaseMapper(){
     return baseMapper;
    }
    public void setBaseMapper(SysDepartInfoMapper baseMapper){
    	this.baseMapper = baseMapper;
    }
	@Override
	public List<SysDepartInfo> getDepartInfoByParentId(
			SysDepartInfo sysDepartInfo) {
		// TODO Auto-generated method stub
		if("mysql".equals(dbType)){
			return baseMapper.getDepartInfoByParentIdForMysql(sysDepartInfo);
		}else if("oracle".equals(dbType)){
			return baseMapper.getDepartInfoByParentId(sysDepartInfo);
		}
		return null;
		
	}
	@Override
	public int getDepartInfoByParentIdCount(SysDepartInfo sysDepartInfo) {
		// TODO Auto-generated method stub
		
		if("mysql".equals(dbType)){
			return baseMapper.getDepartInfoByParentIdCountForMysql(sysDepartInfo);
		}else if("oracle".equals(dbType)){
			return baseMapper.getDepartInfoByParentIdCount(sysDepartInfo);
		}
		return 0;
	}
	@Override
	public void addUnitDepart(SysDepartInfo sysdepartInfo) {
		// TODO Auto-generated method stub
		
		if("mysql".equals(dbType)){
			baseMapper.addUnitDepartForMysql(sysdepartInfo);
		}else if("oracle".equals(dbType)){
			baseMapper.addUnitDepart(sysdepartInfo);
		}
	}
	@Override
	public void addUnitRole(SysDepartInfo sysdepartInfo) {
		// TODO Auto-generated method stub
		
		if("mysql".equals(dbType)){
			baseMapper.addUnitRoleForMysql(sysdepartInfo);
		}else if("oracle".equals(dbType)){
			baseMapper.addUnitRole(sysdepartInfo);
		}
	}
	@Override
	public void addUnit(SysDepartInfo sysDepartInfo) {
		// TODO Auto-generated method stub
		if("mysql".equals(dbType)){
			baseMapper.addUnitForMysql(sysDepartInfo);
			baseMapper.addUnitDepartForMysql(sysDepartInfo);
			//baseMapper.addUnitRoleForMysql(sysDepartInfo);
		}else if("oracle".equals(dbType)){
			baseMapper.addUnit(sysDepartInfo);
			baseMapper.addUnitDepart(sysDepartInfo);
			//baseMapper.addUnitRole(sysDepartInfo);
		}
	}
	@Override
	public void addDepart(SysDepartInfo sysDepartInfo) {
		if("mysql".equals(dbType)){
			baseMapper.addDepartForMysql(sysDepartInfo);
			baseMapper.addUnitDepartForMysql(sysDepartInfo);
			baseMapper.addDepartRoleForMysql(sysDepartInfo);
		}else if("oracle".equals(dbType)){
			baseMapper.addDepart(sysDepartInfo);
			baseMapper.addDepartTeam(sysDepartInfo);
			//baseMapper.addDepartRole(sysDepartInfo);
		}
	}
	@Override
	public void addDepartTeam(SysDepartInfo sysdepartInfo) {
		// TODO Auto-generated method stub
		
		if("mysql".equals(dbType)){
			baseMapper.addDepartTeamForMysql(sysdepartInfo);
		}else if("oracle".equals(dbType)){
			baseMapper.addDepartTeam(sysdepartInfo);
		}
	}
	@Override
	public void addDepartRole(SysDepartInfo sysdepartInfo) {
		// TODO Auto-generated method stub
		
		if("mysql".equals(dbType)){
			baseMapper.addDepartRoleForMysql(sysdepartInfo);
		}else if("oracle".equals(dbType)){
			baseMapper.addDepartRole(sysdepartInfo);
		}
	}
	@Override
	public void addTeam(SysDepartInfo sysDepartInfo) {
		// TODO Auto-generated method stub
		
		if("mysql".equals(dbType)){
			baseMapper.addTeamForMysql(sysDepartInfo);
			//baseMapper.addTeamRoleForMysql(sysDepartInfo);
		}else if("oracle".equals(dbType)){
			baseMapper.addTeam(sysDepartInfo);
			//baseMapper.addTeamRole(sysDepartInfo);
		}
	}
	@Override
	public void addTeamRole(SysDepartInfo sysdepartInfo) {
		// TODO Auto-generated method stub
		
		if("mysql".equals(dbType)){
			baseMapper.addTeamRoleForMysql(sysdepartInfo);
		}else if("oracle".equals(dbType)){
			baseMapper.addTeamRole(sysdepartInfo);
		}
	}
	@Override
	public void addRoleUnitRole(SysDepartInfo sysdepartInfo,SysRoleInfo sysRoleInfo) throws Exception {
		// TODO Auto-generated method stub
		
		try {
			if("mysql".equals(dbType)){
				baseMapper.addRoleUnitRoleForMysql(sysdepartInfo);
				
				String roleId=sysdepartInfo.getDepartId();
				sysRoleInfo.setRoleId(roleId);
				sysRoleInfoMapper.addForMysql(sysRoleInfo);
				
			}else if("oracle".equals(dbType)){
				baseMapper.addRoleUnitRole(sysdepartInfo);
				String roleId=sysdepartInfo.getDepartId();
				sysRoleInfo.setRoleId(roleId);
				sysRoleInfoMapper.add(sysRoleInfo);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception(e);
		}
	}
	@Override
	public void updateRole(SysDepartInfo sysDepartInfo, SysRoleInfo sysRoleInfo,String functionType)
			throws Exception {
		if("mysql".equals(dbType)){
			baseMapper.updateForMysql(sysDepartInfo);
			sysRoleInfo.setRoleId(sysDepartInfo.getDepartId());
			//functionType 2（操作权限设置），为空时位功能权限设置
			if("2".equals(functionType)){
				sysRoleInfoMapper.updatePowerForMysql(sysRoleInfo);
			}else{
				sysRoleInfoMapper.updateForMysql(sysRoleInfo);
			}
		}else if("oracle".equals(dbType)){
			baseMapper.update(sysDepartInfo);
			sysRoleInfo.setRoleId(sysDepartInfo.getDepartId());
			//functionType 2（操作权限设置），为空时位功能权限设置
			if("2".equals(functionType)){
				sysRoleInfoMapper.updatePower(sysRoleInfo);
			}else{
				sysRoleInfoMapper.update(sysRoleInfo);
			}
		}
	}
	@Override
	public List queryDepartOrUnit(SysDepartInfo sysdepartInfo) throws Exception {
		// TODO Auto-generated method stub
		
		return this.baseMapper.queryDepartOrUnit(sysdepartInfo);
	}
	
	@Override
	public List<SysDepartInfo> queryDepartInfoByParentId(
			SysDepartInfo sysDepartInfo) {
		// TODO Auto-generated method stub
		return this.baseMapper.queryDepartInfoByParentId(sysDepartInfo);
	}
	@Override
	public List<SysDepartInfo> queryUnitList(SysDepartInfo sysDepartInfo) throws Exception {
		return this.baseMapper.queryUnitList(sysDepartInfo);
	}
	
	
    
}