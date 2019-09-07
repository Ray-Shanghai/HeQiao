package com.sd.farmework.service.impl; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.farmework.mapper.HqFileInfoMapper;
import com.sd.farmework.service.HqFileInfoService;

/** 
 * test
 * @author Administrator 
 * 
 */ 
 @Service
public class HqFileInfoServiceImpl extends BaseInfoServiceImpl implements HqFileInfoService{ 
    @Autowired
    private HqFileInfoMapper baseMapper;
    public HqFileInfoMapper getBaseMapper(){
     return baseMapper;
    }
    public void setBaseMapper(HqFileInfoMapper baseMapper){
    	this.baseMapper = baseMapper;
    }
}