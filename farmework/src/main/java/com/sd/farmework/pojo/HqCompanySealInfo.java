package com.sd.farmework.pojo; 

import com.sd.farmework.common.BaseInfo; 

/** 
 * test
 * @author Administrator 
 * 
 */ 
public class HqCompanySealInfo extends BaseInfo{ 
	//公章编号 
	private int companySealId; 
	//公章名称 
	private String companySealName; 
	//公章描述 
	private String companySealDesc;
	
	public int getCompanySealId() {
		return companySealId;
	}

	public void setCompanySealId(int companySealId) {
		this.companySealId = companySealId;
	}

	public String getCompanySealName() {
		return companySealName;
	}

	public void setCompanySealName(String companySealName) {
		this.companySealName = companySealName;
	}

	public String getCompanySealDesc() {
		return companySealDesc;
	}

	public void setCompanySealDesc(String companySealDesc) {
		this.companySealDesc = companySealDesc;
	}

	@Override
	public String toString() {
		return "HqCompanySealInfo [companySealId=" + companySealId
				+ ", companySealName=" + companySealName + ", companySealDesc="
				+ companySealDesc + "]";
	} 
   
}