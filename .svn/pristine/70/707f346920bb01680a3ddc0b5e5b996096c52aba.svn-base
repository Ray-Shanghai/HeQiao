package com.sd.farmework.service.impl; 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.farmework.mapper.HqNoticeFileMapper;
import com.sd.farmework.mapper.HqNoticeInfoMapper;
import com.sd.farmework.pojo.HqNoticeFile;
import com.sd.farmework.pojo.HqNoticeInfo;
import com.sd.farmework.service.HqNoticeInfoService;

/** 
 * test
 * @author Administrator 
 * 
 */ 
 @Service
public class HqNoticeInfoServiceImpl extends BaseInfoServiceImpl implements HqNoticeInfoService{ 
    @Autowired
    private HqNoticeInfoMapper baseMapper;
    
    @Autowired
    private HqNoticeFileMapper fileMapper;
    
    public HqNoticeInfoMapper getBaseMapper(){
     return baseMapper;
    }
    public void setBaseMapper(HqNoticeInfoMapper baseMapper){
    	this.baseMapper = baseMapper;
    }
	@Override
	public void addAll(HqNoticeInfo obj, List<HqNoticeFile> files)
			throws Exception {
		// TODO Auto-generated method stub
		this.baseMapper.addForMysql(obj);
		for (HqNoticeFile doc : files) {
			doc.setNoticeId(obj.getNoticeId());
		}
		if(files!=null&&files.size()>0){
			this.fileMapper.addBatchForMysql(files);;
		}
	}

	@Override
	public void updateAll(HqNoticeInfo obj, List<HqNoticeFile> files)
			throws Exception {
		// TODO Auto-generated method stub
		this.baseMapper.updateForMysql(obj);
		for (HqNoticeFile doc : files) {
			doc.setNoticeId(obj.getNoticeId());
		}
		if(files!=null&&files.size()>0){
			this.fileMapper.addBatchForMysql(files);;
		}
	}
	
}