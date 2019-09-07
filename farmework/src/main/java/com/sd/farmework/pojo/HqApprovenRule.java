package com.sd.farmework.pojo;

import com.sd.farmework.common.BaseInfo;
/**
 * 审批规则表
 * @author Administrator
 *
 */
public class HqApprovenRule extends BaseInfo {
	//审批规则主键
	private String  approvenRuleId;
	//申请职位主键
	private String  applyPositionId;
	//申请职位编号
	private String  applyPositionNo;
	//申请职位名称
	private String  applyPositionName;
	//审批职位主键
	private String  approvenPositionId;
	//审批职位编号
	private String  approvenPositionNo;
	//审批职位名称
	private String  approvenPositionName;
	//审批类型编号
	private String approvenTypeId;
	//审批类型名称
	private String approvenTypeName;
	//审批人所属公司编号
	private String approvenUnitId;
	//审批表达式
	private String  approvenExp;
	
	
	public String getApprovenRuleId() {
		return approvenRuleId;
	}
	public void setApprovenRuleId(String approvenRuleId) {
		this.approvenRuleId = approvenRuleId;
	}
	public String getApplyPositionId() {
		return applyPositionId;
	}
	public void setApplyPositionId(String applyPositionId) {
		this.applyPositionId = applyPositionId;
	}
	public String getApplyPositionName() {
		return applyPositionName;
	}
	public void setApplyPositionName(String applyPositionName) {
		this.applyPositionName = applyPositionName;
	}
	public String getApprovenPositionId() {
		return approvenPositionId;
	}
	public void setApprovenPositionId(String approvenPositionId) {
		this.approvenPositionId = approvenPositionId;
	}
	public String getApprovenPositionNo() {
		return approvenPositionNo;
	}
	public void setApprovenPositionNo(String approvenPositionNo) {
		this.approvenPositionNo = approvenPositionNo;
	}
	public String getApprovenPositionName() {
		return approvenPositionName;
	}
	public void setApprovenPositionName(String approvenPositionName) {
		this.approvenPositionName = approvenPositionName;
	}
	public String getApprovenTypeId() {
		return approvenTypeId;
	}
	public void setApprovenTypeId(String approvenTypeId) {
		this.approvenTypeId = approvenTypeId;
	}
	public String getApprovenTypeName() {
		return approvenTypeName;
	}
	public void setApprovenTypeName(String approvenTypeName) {
		this.approvenTypeName = approvenTypeName;
	}
	public String getApprovenUnitId() {
		return approvenUnitId;
	}
	public void setApprovenUnitId(String approvenUnitId) {
		this.approvenUnitId = approvenUnitId;
	}
	public String getApprovenExp() {
		return approvenExp;
	}
	public void setApprovenExp(String approvenExp) {
		this.approvenExp = approvenExp;
	}
	public String getApplyPositionNo() {
		return applyPositionNo;
	}
	public void setApplyPositionNo(String applyPositionNo) {
		this.applyPositionNo = applyPositionNo;
	}
	@Override
	public String toString() {
		return "HqApprovenRule [approvenRuleId=" + approvenRuleId
				+ ", applyPositionId=" + applyPositionId + ", applyPositionNo="
				+ applyPositionNo + ", applyPositionName=" + applyPositionName
				+ ", approvenPositionId=" + approvenPositionId
				+ ", approvenPositionNo=" + approvenPositionNo
				+ ", approvenPositionName=" + approvenPositionName
				+ ", approvenTypeId=" + approvenTypeId + ", approvenTypeName="
				+ approvenTypeName + ", approvenUnitId=" + approvenUnitId
				+ ", approvenExp=" + approvenExp + "]";
	}
	
	
}
