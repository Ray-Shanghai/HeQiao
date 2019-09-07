package com.sd.farmework.pojo; 

import com.sd.farmework.common.BaseInfo; 

/** 
 * test
 * @author Administrator 
 * 
 */ 
public class HqExpenditureDetail extends BaseInfo{ 
	//明细编号 
	private int detailId;
	//摘要
	private String detailAbstract; 
	//请款金额 
	private String detailSumMoney;
	//现金
	private String detailCash;
	//银行
	private String detailBank;
	//支票
	private String detailCheckNo;
	//银行金额
	private String detailBankMoney;
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
	public String getDetailAbstract() {
		return detailAbstract;
	}
	public void setDetailAbstract(String detailAbstract) {
		this.detailAbstract = detailAbstract;
	}
	public String getDetailSumMoney() {
		return detailSumMoney;
	}
	public void setDetailSumMoney(String detailSumMoney) {
		this.detailSumMoney = detailSumMoney;
	}
	public String getDetailCash() {
		return detailCash;
	}
	public void setDetailCash(String detailCash) {
		this.detailCash = detailCash;
	}
	public String getDetailBank() {
		return detailBank;
	}
	public void setDetailBank(String detailBank) {
		this.detailBank = detailBank;
	}
	public String getDetailCheckNo() {
		return detailCheckNo;
	}
	public void setDetailCheckNo(String detailCheckNo) {
		this.detailCheckNo = detailCheckNo;
	}
	public String getDetailBankMoney() {
		return detailBankMoney;
	}
	public void setDetailBankMoney(String detailBankMoney) {
		this.detailBankMoney = detailBankMoney;
	}
	@Override
	public String toString() {
		return "HqExpenditureDetail [detailId=" + detailId
				+ ", detailAbstract=" + detailAbstract + ", detailSumMoney="
				+ detailSumMoney + ", detailCash=" + detailCash
				+ ", detailBank=" + detailBank + ", detailCheckNo="
				+ detailCheckNo + ", detailBankMoney=" + detailBankMoney
				+ ", currencyId=" + currencyId + "]";
	}
}