package com.sd.farmework.pojo;

import com.sd.farmework.common.BaseInfo;

/**
 * 职权信息表
 * @author wangli
 *
 */

public class SysAuthority extends BaseInfo{
	
	private String  sysId;          	 //流水号
	private String   authorityId;		 //职权编号
	private String   authorityName;		 //职权名称
	
	
	public String getSysId() {
		return sysId;
	}
	public void setSysId(String sysId) {
		this.sysId = sysId;
	}
	public String getAuthorityId() {
		return authorityId;
	}
	public void setAuthorityId(String authorityId) {
		this.authorityId = authorityId;
	}
	public String getAuthorityName() {
		return authorityName;
	}
	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
	}
	@Override
	public String toString() {
		return "SysAuthority [sysId=" + sysId + ", authorityId=" + authorityId
				+ ", authorityName=" + authorityName + "]";
	}
	
	
	
}
