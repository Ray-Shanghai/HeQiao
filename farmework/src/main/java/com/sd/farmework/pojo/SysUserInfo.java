package com.sd.farmework.pojo; 

import com.sd.farmework.common.BaseInfo; 

/** 
 * 组织架构表
 * @author Administrator 
 * 
 */ 
public class SysUserInfo extends BaseInfo{ 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1104334475753903235L;
	//所属班组编号(SYS_DEPART_INFO.DEPART_ID) 
	private String teamId; 
	//所属班组名称(SYS_DEPART_INFO.DEPART_NAME) 
	private String teamName; 
	//所属科室编号(SYS_DEPART_INFO.DEPART_ID) 
	private String departId; 
	//所属科室名称(SYS_DEPART_INFO.DEPART_NAME) 
	private String departName; 
	//用户编号 
	private String userNo; 
	//主键 
	private String unitId; 
	//组织名称 
	private String unitName; 
	//系统登录名(登录用户名) 
	private String loginName; 
	//系统登录密码 
	private String loginPwd; 
	//主键 
	private String userId; 
	//员工id主键 
	private String employeeId; 
	//用户名 
	private String userName; 
	//微信openid
	private String wxOpenId; 
	//职位
	private String postion;
	//部门权限  
	private String departPower;
	//职权编号
	private String authorityId;
	//职权名称
	private String authorityName; 
   
	
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
	public String getDepartPower() {
		return departPower;
	}
	public void setDepartPower(String departPower) {
		this.departPower = departPower;
	}
	public String getPostion() {
		return postion;
	}
	public void setPostion(String postion) {
		this.postion = postion;
	}
	/**
	 * @return the wxOpenId
	 */
	public String getWxOpenId() {
		return wxOpenId;
	}
	/**
	 * @param wxOpenId the wxOpenId to set
	 */
	public void setWxOpenId(String wxOpenId) {
		this.wxOpenId = wxOpenId;
	}
	public SysUserInfo(){
	}
    public SysUserInfo(String departId,String departName,String userNo,String unitId,String unitName,String loginName,String loginPwd,String userId,String employeeId,String userName){
		this.departId=departId;
		this.departName=departName;
		this.userNo=userNo;
		this.unitId=unitId;
		this.unitName=unitName;
		this.loginName=loginName;
		this.loginPwd=loginPwd;
		this.userId=userId;
		this.employeeId=employeeId;
		this.userName=userName;
	}
    public SysUserInfo(String departName,String userNo,String unitId,String unitName,String loginName,String loginPwd,String userId,String employeeId,String userName){
		this.departName=departName;
		this.userNo=userNo;
		this.unitId=unitId;
		this.unitName=unitName;
		this.loginName=loginName;
		this.loginPwd=loginPwd;
		this.userId=userId;
		this.employeeId=employeeId;
		this.userName=userName;
	}
    
	public String getTeamId() {
		return teamId;
	}
	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public void setDepartId(String departId){ 
		this.departId=departId;
	}
	public String getDepartId(){ 
		return this.departId;
	}
	public void setDepartName(String departName){ 
		this.departName=departName;
	}
	public String getDepartName(){ 
		return this.departName;
	}
	public void setUserNo(String userNo){ 
		this.userNo=userNo;
	}
	public String getUserNo(){ 
		return this.userNo;
	}
	public void setUnitId(String unitId){ 
		this.unitId=unitId;
	}
	public String getUnitId(){ 
		return this.unitId;
	}
	public void setUnitName(String unitName){ 
		this.unitName=unitName;
	}
	public String getUnitName(){ 
		return this.unitName;
	}
	public void setLoginName(String loginName){ 
		this.loginName=loginName;
	}
	public String getLoginName(){ 
		return this.loginName;
	}
	public void setLoginPwd(String loginPwd){ 
		this.loginPwd=loginPwd;
	}
	public String getLoginPwd(){ 
		return this.loginPwd;
	}
	public void setUserId(String userId){ 
		this.userId=userId;
	}
	public String getUserId(){ 
		return this.userId;
	}
	public void setEmployeeId(String employeeId){ 
		this.employeeId=employeeId;
	}
	public String getEmployeeId(){ 
		return this.employeeId;
	}
	public void setUserName(String userName){ 
		this.userName=userName;
	}
	public String getUserName(){ 
		return this.userName;
	}
	@Override
	public String toString() {
		return "SysUserInfo [teamId=" + teamId + ", teamName=" + teamName
				+ ", departId=" + departId + ", departName=" + departName
				+ ", userNo=" + userNo + ", unitId=" + unitId + ", unitName="
				+ unitName + ", loginName=" + loginName + ", loginPwd="
				+ loginPwd + ", userId=" + userId + ", employeeId="
				+ employeeId + ", userName=" + userName + ", wxOpenId="
				+ wxOpenId + ", postion=" + postion + ", departPower="
				+ departPower + ", authorityId=" + authorityId
				+ ", authorityName=" + authorityName + "]";
	}
}