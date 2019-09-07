package com.sd.farmework.pojo; 

import java.util.Arrays;

import com.sd.farmework.common.BaseInfo;
import com.sd.farmework.common.util.StringUtil;

/** 
 * 
 * @author Administrator 
 * 
 */ 
public class CurrencyNote extends BaseInfo{ 
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = 2282576045949688460L;
	//申请主键编号
	private String noteId;
	//申请标题
	private String title;
	//签办单位
	private String doSignUnitId;
	//签办单位名称
	private String doSignUnitName;
	//签办部门编号
	private String doSignDepartId;
	//签办部门名称
	private String doSignDepartName;
	//签呈主旨
	private String doMain;
	//签呈描述
	private String doContent;
	//归还日期
	private String returnDate;
	//审核状态
	private String auditStatus;
	
	private String noteType;
	
	
	//支出金额
	private String payMoney;
	//申办日期
	private String applyDate;
	//需要日期
	private String needDate;
	//截止上案预算余额
	private String previousBudgetMoney;
	//截止本案预算金额
	private String currentBudgetMoney;
	//受款人
	private String payee;
	
	//请假天数
	private String leaveDay;
	//请假总时长 虚数
	private String leaveTotalTime;
	//请假类型
	//1.特休 2.病休 3.事假 4公假 5婚假 6丧假 7其他
	private String leaveType;
	//职务代理人名称
	private String postionProxyPerson;
	//职务代理编号
	private String postionProxyPersonId;
	//职位
	private String postion;
	//开始时间
	private String leaveStartTime;
	//结束时间
	private String leaveEndTime;
	
	//开始日期
	private String leaveStartDate;
	//结束日期
	private String leaveEndDate;
	//所需印章编号
	private String sealId;
	//所需印章名称
	private String sealName;
	//借阅文件编号
	private String fileId;
	//借阅文件名称
	private String fileName;
	//借阅文件类型编号
	private String fileTypeId;
	//借阅文件类型名称
	private String fileTypeName;
	//申请单编号
	private String titleNum;
	
	private String[]departPower;
	
	private String taskId;
	
	//审核人编号
	private String approvenPersonId;
	//审核人姓名
	private String approvenPersonName;
	
	public String getApprovenPersonId() {
		return approvenPersonId;
	}

	public void setApprovenPersonId(String approvenPersonId) {
		this.approvenPersonId = approvenPersonId;
	}

	public String getApprovenPersonName() {
		return approvenPersonName;
	}

	public void setApprovenPersonName(String approvenPersonName) {
		this.approvenPersonName = approvenPersonName;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String[] getDepartPower() {
		return departPower;
	}

	public void setDepartPower(String[] departPower) {
		this.departPower = departPower;
	}

	public String getTitleNum() {
		return titleNum;
	}

	public void setTitleNum(String titleNum) {
		this.titleNum = titleNum;
	}

	public String getSealId() {
		return sealId;
	}

	public void setSealId(String sealId) {
		this.sealId = sealId;
	}

	public String getSealName() {
		return sealName;
	}

	public void setSealName(String sealName) {
		this.sealName = sealName;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileTypeId() {
		return fileTypeId;
	}

	public void setFileTypeId(String fileTypeId) {
		this.fileTypeId = fileTypeId;
	}

	public String getFileTypeName() {
		return StringUtil.fixDefaultString(fileTypeName);
	}

	public void setFileTypeName(String fileTypeName) {
		this.fileTypeName = fileTypeName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getLeaveTotalTime() {
		return leaveTotalTime;
	}

	public void setLeaveTotalTime(String leaveTotalTime) {
		this.leaveTotalTime = leaveTotalTime;
	}

	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

	public String getPostionProxyPerson() {
		return postionProxyPerson;
	}

	public void setPostionProxyPerson(String postionProxyPerson) {
		this.postionProxyPerson = postionProxyPerson;
	}

	 

	public String getPostionProxyPersonId() {
		return postionProxyPersonId;
	}

	public void setPostionProxyPersonId(String postionProxyPersonId) {
		this.postionProxyPersonId = postionProxyPersonId;
	}

	public String getPostion() {
		return postion;
	}

	public void setPostion(String postion) {
		this.postion = postion;
	}

	public String getLeaveStartDate() {
		return leaveStartDate;
	}

	public void setLeaveStartDate(String leaveStartDate) {
		this.leaveStartDate = leaveStartDate;
	}

	public String getLeaveEndDate() {
		return leaveEndDate;
	}

	public void setLeaveEndDate(String leaveEndDate) {
		this.leaveEndDate = leaveEndDate;
	}

	public String getLeaveDay() {
		return leaveDay;
	}

	public void setLeaveDay(String leaveDay) {
		this.leaveDay = leaveDay;
	}

	public String getPayMoney() {
		return payMoney;
	}

	public void setPayMoney(String payMoney) {
		this.payMoney = payMoney;
	}

	public String getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}

	public String getNeedDate() {
		return needDate;
	}

	public void setNeedDate(String needDate) {
		this.needDate = needDate;
	}

	public String getPreviousBudgetMoney() {
		return previousBudgetMoney;
	}

	public void setPreviousBudgetMoney(String previousBudgetMoney) {
		this.previousBudgetMoney = previousBudgetMoney;
	}

	public String getCurrentBudgetMoney() {
		return currentBudgetMoney;
	}

	public void setCurrentBudgetMoney(String currentBudgetMoney) {
		this.currentBudgetMoney = currentBudgetMoney;
	}

	public String getPayee() {
		return payee;
	}

	public void setPayee(String payee) {
		this.payee = payee;
	}

	public String getNoteType() {
		return noteType;
	}

	public void setNoteType(String noteType) {
		this.noteType = noteType;
	}

	public String getNoteId() {
		return noteId;
	}

	public void setNoteId(String noteId) {
		this.noteId = noteId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDoSignUnitId() {
		return doSignUnitId;
	}

	public void setDoSignUnitId(String doSignUnitId) {
		this.doSignUnitId = doSignUnitId;
	}

	public String getDoSignUnitName() {
		return doSignUnitName;
	}

	public void setDoSignUnitName(String doSignUnitName) {
		this.doSignUnitName = doSignUnitName;
	}

	public String getDoSignDepartId() {
		return doSignDepartId;
	}

	public void setDoSignDepartId(String doSignDepartId) {
		this.doSignDepartId = doSignDepartId;
	}

	public String getDoSignDepartName() {
		return doSignDepartName;
	}

	public void setDoSignDepartName(String doSignDepartName) {
		this.doSignDepartName = doSignDepartName;
	}
	
	public String getDoMain() {
		return doMain;
	}

	public void setDoMain(String doMain) {
		this.doMain = doMain;
	}

	public String getDoContent() {
		return doContent;
	}

	public void setDoContent(String doContent) {
		this.doContent = doContent;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	public String getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(String auditStatus) {
		this.auditStatus = auditStatus;
	}

	public String getLeaveStartTime() {
		return leaveStartTime;
	}

	public void setLeaveStartTime(String leaveStartTime) {
		this.leaveStartTime = leaveStartTime;
	}

	public String getLeaveEndTime() {
		return leaveEndTime;
	}

	public void setLeaveEndTime(String leaveEndTime) {
		this.leaveEndTime = leaveEndTime;
	}

	@Override
	public String toString() {
		return "CurrencyNote [noteId=" + noteId + ", title=" + title
				+ ", doSignUnitId=" + doSignUnitId + ", doSignUnitName="
				+ doSignUnitName + ", doSignDepartId=" + doSignDepartId
				+ ", doSignDepartName=" + doSignDepartName + ", doMain="
				+ doMain + ", doContent=" + doContent + ", returnDate="
				+ returnDate + ", auditStatus=" + auditStatus + ", noteType="
				+ noteType + ", payMoney=" + payMoney + ", applyDate="
				+ applyDate + ", needDate=" + needDate
				+ ", previousBudgetMoney=" + previousBudgetMoney
				+ ", currentBudgetMoney=" + currentBudgetMoney + ", payee="
				+ payee + ", leaveDay=" + leaveDay + ", leaveTotalTime="
				+ leaveTotalTime + ", leaveType=" + leaveType
				+ ", postionProxyPerson=" + postionProxyPerson
				+ ", postionProxyPersonId=" + postionProxyPersonId
				+ ", postion=" + postion + ", leaveStartTime=" + leaveStartTime
				+ ", leaveEndTime=" + leaveEndTime + ", leaveStartDate="
				+ leaveStartDate + ", leaveEndDate=" + leaveEndDate
				+ ", sealId=" + sealId + ", sealName=" + sealName + ", fileId="
				+ fileId + ", fileName=" + fileName + ", fileTypeId="
				+ fileTypeId + ", fileTypeName=" + fileTypeName + ", titleNum="
				+ titleNum + ", departPower=" + Arrays.toString(departPower)
				+ ", taskId=" + taskId + "]";
	}
}