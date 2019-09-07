package com.sd.farmework.pojo; 

import com.sd.farmework.common.BaseInfo; 

/** 
 * test
 * @author Administrator 
 * 
 */ 
public class TmUserArchivesInfo extends BaseInfo{ 
	//主键 
	private String archivesId; 
	
	private String userId;
	private String teamId;
	private String teamName;
	private String joinTeamId;
	
	 
	
	
	
	//账户id 
	private String accountNo; 
	//账户开始日期，格式（yyyy-MM-dd） 
	private String accountStartDate; 
	//账户结束日期，格式（yyyy-MM-dd） 
	private String accountEndDate; 
	//账户类型（1、免费版；2、小组版；3、团队版；） 
	private int accountType; 
	//昵称 
	private String nickName; 
	//性别 
	private String sex; 
	//级别 
	private String level; 
	//公司 
	private String company; 
	//是否团队创始人(团队管理员)Y/N 
	private String isCreator; 
	//部门名称 
	private String departmentName; 
	//我的上级id 
	private String parentArchivesId; 
	//手机号码 
	private String mobileNo; 
	//qq 
	private String qqNo; 
	//头像地址 
	private String headImgUrl; 
	//推荐人id（account_no） 
	private String recommendAccountNo; 
	//是否被关注（N表示没有，Y表示被关注） 
	private String isAttention; 
	//系统登录名(登录用户名) 
	private String loginName; 
	//系统登录密码 
	private String loginPwd;
	//确认密码 
	private String repeatPwd;
	
	
	//=== 临时字段
	private String teamNumber;	//团队人数
	private String accountAule;	//账号规则
	private String isAgree;		//是否被关注（0没有操作、1同意、2不同意）
	
	public String getArchivesId() {
		return archivesId;
	}
	public void setArchivesId(String archivesId) {
		this.archivesId = archivesId;
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
	public String getJoinTeamId() {
		return joinTeamId;
	}
	public void setJoinTeamId(String joinTeamId) {
		this.joinTeamId = joinTeamId;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getAccountStartDate() {
		return accountStartDate;
	}
	public void setAccountStartDate(String accountStartDate) {
		this.accountStartDate = accountStartDate;
	}
	public String getAccountEndDate() {
		return accountEndDate;
	}
	public void setAccountEndDate(String accountEndDate) {
		this.accountEndDate = accountEndDate;
	}
	public int getAccountType() {
		return accountType;
	}
	public void setAccountType(int accountType) {
		this.accountType = accountType;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getIsCreator() {
		return isCreator;
	}
	public void setIsCreator(String isCreator) {
		this.isCreator = isCreator;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getParentArchivesId() {
		return parentArchivesId;
	}
	public void setParentArchivesId(String parentArchivesId) {
		this.parentArchivesId = parentArchivesId;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getQqNo() {
		return qqNo;
	}
	public void setQqNo(String qqNo) {
		this.qqNo = qqNo;
	}
	public String getHeadImgUrl() {
		return headImgUrl;
	}
	public void setHeadImgUrl(String headImgUrl) {
		this.headImgUrl = headImgUrl;
	}
	public String getRecommendAccountNo() {
		return recommendAccountNo;
	}
	public void setRecommendAccountNo(String recommendAccountNo) {
		this.recommendAccountNo = recommendAccountNo;
	}
	public String getIsAttention() {
		return isAttention;
	}
	public void setIsAttention(String isAttention) {
		this.isAttention = isAttention;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getLoginPwd() {
		return loginPwd;
	}
	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}
	public String getRepeatPwd() {
		return repeatPwd;
	}
	public void setRepeatPwd(String repeatPwd) {
		this.repeatPwd = repeatPwd;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTeamNumber() {
		return teamNumber;
	}
	public void setTeamNumber(String teamNumber) {
		this.teamNumber = teamNumber;
	}
	public String getAccountAule() {
		return accountAule;
	}
	public void setAccountAule(String accountAule) {
		this.accountAule = accountAule;
	}
	public String getIsAgree() {
		return isAgree;
	}
	public void setIsAgree(String isAgree) {
		this.isAgree = isAgree;
	}
	
	@Override
	public String toString() {
		return "TmUserArchivesInfo [archivesId=" + archivesId + ", userId="
				+ userId + ", teamId=" + teamId + ", teamName=" + teamName
				+ ", joinTeamId=" + joinTeamId + ", accountNo=" + accountNo
				+ ", accountStartDate=" + accountStartDate
				+ ", accountEndDate=" + accountEndDate + ", accountType="
				+ accountType + ", nickName=" + nickName + ", sex=" + sex
				+ ", level=" + level + ", company=" + company + ", isCreator="
				+ isCreator + ", departmentName=" + departmentName
				+ ", parentArchivesId=" + parentArchivesId + ", mobileNo="
				+ mobileNo + ", qqNo=" + qqNo + ", headImgUrl=" + headImgUrl
				+ ", recommendAccountNo=" + recommendAccountNo
				+ ", isAttention=" + isAttention + ", loginName=" + loginName
				+ ", loginPwd=" + loginPwd + ", repeatPwd=" + repeatPwd
				+ ", teamNumber=" + teamNumber + ", accountAule=" + accountAule
				+ ", isAgree=" + isAgree+"]";
	}
	
}