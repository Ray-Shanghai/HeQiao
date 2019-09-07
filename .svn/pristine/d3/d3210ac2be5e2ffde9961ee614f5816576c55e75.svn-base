package com.sd.farmework.service.impl; 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.farmework.common.BaseInfo;
import com.sd.farmework.mapper.SysUserInfoMapper;
import com.sd.farmework.service.SysUserInfoService;

/** 
 * 组织架构表
 * @author Administrator 
 * 
 */ 
 @Service
public class SysUserInfoServiceImpl extends BaseInfoServiceImpl implements SysUserInfoService{ 
    @Autowired
    private SysUserInfoMapper baseMapper;

    
    public SysUserInfoMapper getBaseMapper(){
     return baseMapper;
    }
    public void setBaseMapper(SysUserInfoMapper baseMapper){
    	this.baseMapper = baseMapper;
    }
    /**
	 * 通过用户id修改密码
	 * @param obj
	 * @throws Exception
	 */
	@Override
	public void updatePwdByUserId(BaseInfo obj) throws Exception {
		// TODO Auto-generated method stub
		baseMapper.updatePwdByUserId(obj);
	}
	@Override
	public void updataPwdByAccount(BaseInfo obj) throws Exception {
		// TODO Auto-generated method stub
		baseMapper.updataPwdByAccount(obj);
	}
	@Override
	public BaseInfo queryUserInfoByOpenId(BaseInfo obj) throws Exception {
		// TODO Auto-generated method stub
		return baseMapper.queryUserInfoByOpenId(obj);
	}
	/**
	 *   根据账号规则查询信息
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<BaseInfo> queryAccountAule(BaseInfo obj) throws Exception{
		return baseMapper.queryAccountAuleForMysql(obj);
	}
	@Override
	public List queryUserByPostionAndDepart(BaseInfo obj) throws Exception {
		// TODO Auto-generated method stub
		return this.baseMapper.queryUserByPostionAndDepart(obj);
	}
	
	
}