package com.sd.farmework.service;

import java.util.List;

import com.sd.farmework.common.BaseInfo;
import com.sd.farmework.pojo.SysUserInfo;

/** 
 * 组织架构表
 * @author Administrator 
 * 
 */ 
public interface SysUserInfoService  extends BaseInfoService{ 
	/**
	 * 通过用户id修改密码
	 * @param obj
	 * @throws Exception
	 */
	public void updatePwdByUserId(BaseInfo obj) throws Exception;
	/**
	 * 根据账号修改密码
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public void updataPwdByAccount(BaseInfo obj) throws Exception;
	/**
	 * 根据微信openid查询
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public BaseInfo queryUserInfoByOpenId(BaseInfo obj) throws Exception;
	/**
	 * 通过用户id修改openId
	 * @param obj
	 * @throws Exception
	 */

	/**
	 *   根据账号规则查询信息
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public List<BaseInfo> queryAccountAule(BaseInfo obj) throws Exception;
	/**
	 * 根据postion和departId查出对应的信息
	 * @param obj
	 * @throws Exception
	 */
	public List queryUserByPostionAndDepart(BaseInfo obj) throws Exception;
	
}