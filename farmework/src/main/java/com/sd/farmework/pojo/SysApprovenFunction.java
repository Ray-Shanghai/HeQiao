package com.sd.farmework.pojo; 

import java.io.Serializable;

import com.sd.farmework.common.BaseInfo; 

/** 
 * 审批功能表
 * @author Administrator 
 * 
 */ 
public class SysApprovenFunction extends BaseInfo{ 
	/**
	 * 
	 */
	private static final long serialVersionUID = 5244611667418357230L;
	//审批功能主键 
	private String approvenFunctionId; 
	//审批功能名称 
	private String approvenFunctionName; 
    public SysApprovenFunction(){
	}
    public SysApprovenFunction(String approvenFunctionId,String approvenFunctionName){
		this.approvenFunctionId=approvenFunctionId;
		this.approvenFunctionName=approvenFunctionName;
	}
    public SysApprovenFunction(String approvenFunctionName){
		this.approvenFunctionName=approvenFunctionName;
	}
	public void setApprovenFunctionId(String approvenFunctionId){ 
		this.approvenFunctionId=approvenFunctionId;
	}
	public String getApprovenFunctionId(){ 
		return this.approvenFunctionId;
	}
	public void setApprovenFunctionName(String approvenFunctionName){ 
		this.approvenFunctionName=approvenFunctionName;
	}
	public String getApprovenFunctionName(){ 
		return this.approvenFunctionName;
	}
	@Override
	public String toString() {
		return "SysApprovenFunction[approvenFunctionId=" + approvenFunctionId+",approvenFunctionName=" + approvenFunctionName+"]";
	}
}