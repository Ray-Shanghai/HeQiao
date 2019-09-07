package com.sd.farmework.service.impl; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.farmework.mapper.HqCompanySealInfoMapper;
import com.sd.farmework.service.HqCompanySealInfoService;

/** 
 * test
 * @author Administrator 
 * 
 */ 
 @Service
public class HqCompanySealInfoServiceImpl extends BaseInfoServiceImpl implements HqCompanySealInfoService{ 
    @Autowired
    private HqCompanySealInfoMapper baseMapper;
    public HqCompanySealInfoMapper getBaseMapper(){
     return baseMapper;
    }
    public void setBaseMapper(HqCompanySealInfoMapper baseMapper){
    	this.baseMapper = baseMapper;
    }
}