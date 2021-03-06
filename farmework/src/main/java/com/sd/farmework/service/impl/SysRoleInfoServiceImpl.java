package com.sd.farmework.service.impl; 

import java.util.List;

import com.sd.farmework.service.SysRoleInfoService; 

import org.springframework.stereotype.Service; 

import com.sd.farmework.common.BaseInfo;
import com.sd.farmework.mapper.SysRoleInfoMapper; 

import org.springframework.beans.factory.annotation.Autowired; 

/** 
 * 角色权限表
 * @author Administrator 
 * 
 */ 
 @Service
public class SysRoleInfoServiceImpl extends BaseInfoServiceImpl implements SysRoleInfoService{ 
    @Autowired
    private SysRoleInfoMapper baseMapper;
    public SysRoleInfoMapper getBaseMapper(){
     return baseMapper;
    }
    public void setBaseMapper(SysRoleInfoMapper baseMapper){
    	this.baseMapper = baseMapper;
    }
	@Override
	public List<BaseInfo> queryFunction(BaseInfo obj) throws Exception {
		// TODO Auto-generated method stub
		if("mysql".equals(dbType)){
			return baseMapper.queryFunctionForMysql(obj);
		}else if("oracle".equals(dbType)){
			return baseMapper.queryFunction(obj);
		}
		return null;
		
	}
	@Override
	public void updatePower(BaseInfo obj) throws Exception {
		// TODO Auto-generated method stub
		if("mysql".equals(dbType)){
			 baseMapper.updatePowerForMysql(obj);
		}else if("oracle".equals(dbType)){
			 baseMapper.updatePower(obj);
		}
	}
	@Override
	public List queryUserRoleByUserId(BaseInfo obj) throws Exception {
		// TODO Auto-generated method stub
		
		if("mysql".equals(dbType)){
			return baseMapper.queryUserRoleByUserIdForMysql(obj);
		}else if("oracle".equals(dbType)){
			return baseMapper.queryUserRoleByUserId(obj);
		}
		return null;
	}
	@Override
	public int queryUserRoleByUserIdCount(BaseInfo obj) throws Exception {
		// TODO Auto-generated method stub
		if("mysql".equals(dbType)){
			return baseMapper.queryUserRoleByUserIdCountForMysql(obj);
		}else if("oracle".equals(dbType)){
			return baseMapper.queryUserRoleByUserIdCount(obj);
		}
		 return 0;
		
	}
    
    
}