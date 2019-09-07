package com.sd.farmework.pojo; 

import com.sd.farmework.common.BaseInfo; 

/** 
 * 系统日志表
 * @author Administrator 
 * 
 */ 
public class SysLogInfo extends BaseInfo{ 
	/**
	 * 
	 */
	private static final long serialVersionUID = -2216164330757959929L;
	//日志主键 
	private String logId; 
	//操作人编号 
	private String operatePersonId; 
	//操作人名称 
	private String operatePersonName; 
	//操作页面路径 
	private String funcitonUrl; 
	//功能名称 
	private String functionName; 
	//操作时间 
	private String operateTime; 
    public SysLogInfo(){
	}
    public SysLogInfo(String logId,String operatePersonId,String operatePersonName,String funcitonUrl,String functionName,String operateTime){
		this.logId=logId;
		this.operatePersonId=operatePersonId;
		this.operatePersonName=operatePersonName;
		this.funcitonUrl=funcitonUrl;
		this.functionName=functionName;
		this.operateTime=operateTime;
	}
    public SysLogInfo(String operatePersonId,String operatePersonName,String funcitonUrl,String functionName,String operateTime){
		this.operatePersonId=operatePersonId;
		this.operatePersonName=operatePersonName;
		this.funcitonUrl=funcitonUrl;
		this.functionName=functionName;
		this.operateTime=operateTime;
	}
	public void setLogId(String logId){ 
		this.logId=logId;
	}
	public String getLogId(){ 
		return this.logId;
	}
	public void setOperatePersonId(String operatePersonId){ 
		this.operatePersonId=operatePersonId;
	}
	public String getOperatePersonId(){ 
		return this.operatePersonId;
	}
	public void setOperatePersonName(String operatePersonName){ 
		this.operatePersonName=operatePersonName;
	}
	public String getOperatePersonName(){ 
		return this.operatePersonName;
	}
	public void setFuncitonUrl(String funcitonUrl){ 
		this.funcitonUrl=funcitonUrl;
	}
	public String getFuncitonUrl(){ 
		return this.funcitonUrl;
	}
	public void setFunctionName(String functionName){ 
		this.functionName=functionName;
	}
	public String getFunctionName(){ 
		return this.functionName;
	}
	public void setOperateTime(String operateTime){ 
		this.operateTime=operateTime;
	}
	public String getOperateTime(){ 
		return this.operateTime;
	}
	@Override
	public String toString() {
		return "SysLogInfo[logId=" + logId+",operatePersonId=" + operatePersonId+",operatePersonName=" + operatePersonName+",funcitonUrl=" + funcitonUrl+",functionName=" + functionName+",operateTime=" + operateTime+"]";
	}
}