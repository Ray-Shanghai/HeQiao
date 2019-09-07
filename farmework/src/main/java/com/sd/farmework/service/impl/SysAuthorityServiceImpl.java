package com.sd.farmework.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.farmework.mapper.SysAuthorityMapper;
import com.sd.farmework.service.SysAuthorityService;
@Service
public class SysAuthorityServiceImpl extends BaseInfoServiceImpl implements SysAuthorityService {
	@Autowired
	private SysAuthorityMapper baseMapper;

	public SysAuthorityMapper getBaseMapper() {
		return baseMapper;
	}

	public void setBaseMapper(SysAuthorityMapper baseMapper) {
		this.baseMapper = baseMapper;
	}

}
