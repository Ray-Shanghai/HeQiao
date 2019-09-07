package com.sd.farmework.common;

import java.io.Serializable;

import com.sd.farmework.common.util.StringUtil;

public class BaseInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6466958553629846190L;
	private int currPage=1;
	private int totalCount;
	private int pageSize=5;
	private int pageCount;
	private int startRecod;
	
	public int getStartRecod() {
		
		return (currPage-1)*pageSize;
	}
	
	public int getCurrPage() {
		return currPage;
	}
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageCount() {
		
		if(getTotalCount()%pageSize!=0){
			pageCount=((getTotalCount()/pageSize)+1);
			}else{
				pageCount=(getTotalCount()/pageSize);
			}
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	

	public int getTotalCount() {
		return totalCount;
	}
	
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
	
	private String  createTime;//创建时间
	private String  createUserId;//创建人id
	private String  createUserName;//创建人姓名
	private String  updateTime;//更新时间
	private String  updateUserId;//更新人id
	private String  updateUserName;//更新人姓名
	private String  rowNumber;//行号
	

	
	private String remark;
	//状态（Y正常,N禁用）
	private String status;
	

    private String createTeamId;
    private String createTeamName;
    private String createDepartId;
    private String createDepartName;
    private String createUnitId;
    private String createUnitName;   
    
    private String lastUpdateTime;
    private String lastUpdateUserId;
    private String lastUpdateUserName;
    private String lastUpdateTeamId;
    private String lastUpdateTeamName;
    private String lastUpdateDepartId;
    private String lastUpdateDepartName;
    private String lastUpdateUnitId;
    private String lastUpdateUnitName;   
	private String postion;
	
	private String approvenDepartId;
	private String approvenDepartName;
	
	private String approvenUnitId;
	private String approvenUnitName;
	
	
    
	public String getApprovenUnitId() {
		return approvenUnitId;
	}

	public void setApprovenUnitId(String approvenUnitId) {
		this.approvenUnitId = approvenUnitId;
	}

	public String getApprovenUnitName() {
		return approvenUnitName;
	}

	public void setApprovenUnitName(String approvenUnitName) {
		this.approvenUnitName = approvenUnitName;
	}

	public String getApprovenDepartId() {
		return approvenDepartId;
	}

	public void setApprovenDepartId(String approvenDepartId) {
		this.approvenDepartId = approvenDepartId;
	}

	public String getApprovenDepartName() {
		return approvenDepartName;
	}

	public void setApprovenDepartName(String approvenDepartName) {
		this.approvenDepartName = approvenDepartName;
	}

	public String getPostion() {
		return postion;
	}

	public void setPostion(String postion) {
		this.postion = postion;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreateTeamId() {
		return createTeamId;
	}

	public void setCreateTeamId(String createTeamId) {
		this.createTeamId = createTeamId;
	}

	public String getCreateTeamName() {
		return createTeamName;
	}

	public void setCreateTeamName(String createTeamName) {
		this.createTeamName = createTeamName;
	}

	public String getCreateDepartId() {
		return createDepartId;
	}

	public void setCreateDepartId(String createDepartId) {
		this.createDepartId = createDepartId;
	}

	public String getCreateDepartName() {
		return createDepartName;
	}

	public void setCreateDepartName(String createDepartName) {
		this.createDepartName = createDepartName;
	}

	public String getCreateUnitId() {
		return createUnitId;
	}

	public void setCreateUnitId(String createUnitId) {
		this.createUnitId = createUnitId;
	}

	public String getCreateUnitName() {
		return createUnitName;
	}

	public void setCreateUnitName(String createUnitName) {
		this.createUnitName = createUnitName;
	}

	public String getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(String lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public String getLastUpdateUserId() {
		return lastUpdateUserId;
	}

	public void setLastUpdateUserId(String lastUpdateUserId) {
		this.lastUpdateUserId = lastUpdateUserId;
	}

	public String getLastUpdateUserName() {
		return lastUpdateUserName;
	}

	public void setLastUpdateUserName(String lastUpdateUserName) {
		this.lastUpdateUserName = lastUpdateUserName;
	}

	public String getLastUpdateTeamId() {
		return lastUpdateTeamId;
	}

	public void setLastUpdateTeamId(String lastUpdateTeamId) {
		this.lastUpdateTeamId = lastUpdateTeamId;
	}

	public String getLastUpdateTeamName() {
		return lastUpdateTeamName;
	}

	public void setLastUpdateTeamName(String lastUpdateTeamName) {
		this.lastUpdateTeamName = lastUpdateTeamName;
	}

	public String getLastUpdateDepartId() {
		return lastUpdateDepartId;
	}

	public void setLastUpdateDepartId(String lastUpdateDepartId) {
		this.lastUpdateDepartId = lastUpdateDepartId;
	}

	public String getLastUpdateDepartName() {
		return lastUpdateDepartName;
	}

	public void setLastUpdateDepartName(String lastUpdateDepartName) {
		this.lastUpdateDepartName = lastUpdateDepartName;
	}

	public String getLastUpdateUnitId() {
		return lastUpdateUnitId;
	}

	public void setLastUpdateUnitId(String lastUpdateUnitId) {
		this.lastUpdateUnitId = lastUpdateUnitId;
	}

	public String getLastUpdateUnitName() {
		return lastUpdateUnitName;
	}

	public void setLastUpdateUnitName(String lastUpdateUnitName) {
		this.lastUpdateUnitName = lastUpdateUnitName;
	}

	public String getRowNumber() {
		return rowNumber;
	}

	public void setRowNumber(String rowNumber) {
		this.rowNumber = rowNumber;
	}

	public String getCreateTime() {
		
		if(StringUtil.isNotNullOrBlank(createTime)&&createTime.length()==21){
			createTime = createTime.substring(0, 19);
		}
		
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}

	public String getUpdateUserName() {
		return updateUserName;
	}

	public void setUpdateUserName(String updateUserName) {
		this.updateUserName = updateUserName;
	}

	public void setStartRecod(int startRecod) {
		this.startRecod = startRecod;
	}

	
	

	 


	
}
