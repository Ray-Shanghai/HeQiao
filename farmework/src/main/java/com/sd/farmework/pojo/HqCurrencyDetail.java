package com.sd.farmework.pojo; 

import com.sd.farmework.common.BaseInfo; 

/** 
 * test
 * @author Administrator 
 * 
 */ 
public class HqCurrencyDetail extends BaseInfo{ 
	//文件编号 
	private int detailId;
	//文件名称
	private String fileName; 
	//文件地址 
	private String filePath;
	//通用单编号
	private String currencyId;
	
	public String getCurrencyId() {
		return currencyId;
	}
	public void setCurrencyId(String currencyId) {
		this.currencyId = currencyId;
	}
	
	public int getDetailId() {
		return detailId;
	}
	public void setDetailId(int detailId) {
		this.detailId = detailId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	@Override
	public String toString() {
		return "HqCurrencyDetail [detailId=" + detailId + ", fileName="
				+ fileName + ", filePath=" + filePath + ", currencyId="
				+ currencyId + "]";
	}
	
}