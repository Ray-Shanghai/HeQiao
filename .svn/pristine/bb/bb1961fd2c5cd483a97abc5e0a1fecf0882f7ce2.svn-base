package com.sd.farmework.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.farmework.mapper.HqApprovenRuleMapper;
import com.sd.farmework.mapper.SysZhichuTypeMapper;
import com.sd.farmework.pojo.HqApprovenRule;
import com.sd.farmework.pojo.SysZhichuType;
import com.sd.farmework.service.SysZhichuTypeService;
@Service
public class SysZhichuTypeServiceImpl extends BaseInfoServiceImpl implements
		SysZhichuTypeService {
	@Autowired
	private SysZhichuTypeMapper baseMapper;
	
	@Autowired
	private HqApprovenRuleMapper hqApprovenRuleMapper;

	public SysZhichuTypeMapper getBaseMapper() {
		return baseMapper;
	}

	public void setBaseMapper(SysZhichuTypeMapper baseMapper) {
		this.baseMapper = baseMapper;
	}

	
	public HqApprovenRuleMapper getHqApprovenRuleMapper() {
		return hqApprovenRuleMapper;
	}

	public void setHqApprovenRuleMapper(HqApprovenRuleMapper hqApprovenRuleMapper) {
		this.hqApprovenRuleMapper = hqApprovenRuleMapper;
	}

	@Override
	public void deleteRule(SysZhichuType sysZhichuType) throws Exception {
		// TODO Auto-generated method stub
		HqApprovenRule hqApprovenRule = new HqApprovenRule();
		hqApprovenRule.setApprovenTypeId(sysZhichuType.getZcId());
		hqApprovenRuleMapper.deleteForMysql(hqApprovenRule);
		baseMapper.deleteForMysql(sysZhichuType);
	}
	
}
