package com.sd.farmework.pojo;

import com.sd.farmework.common.BaseInfo;

/**
 * 文件
 * 
 * @author Administrator
 * 
 */
public class HqNoticeFile extends BaseInfo {
	// 文件编号
	private String fileId;
	// 文件名称
	private String fileName;
	// 文件地址
	private String filePath;
	//公告编号
	private String noticeId;
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
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getNoticeId() {
		return noticeId;
	}
	public void setNoticeId(String noticeId) {
		this.noticeId = noticeId;
	}
	@Override
	public String toString() {
		return "ZcFileInfo [fileId=" + fileId + ", fileName=" + fileName
				+ ", filePath=" + filePath + ", noticeId=" + noticeId + "]";
	}
}