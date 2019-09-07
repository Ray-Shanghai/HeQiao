package com.sd.farmework.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.farmework.common.BaseInfo;
import com.sd.farmework.mapper.HqApprovenRuleMapper;
import com.sd.farmework.pojo.HqApprovenRule;
import com.sd.farmework.service.HqApprovenRuleService;
@Service
public class HqApprovenRuleServiceImpl extends BaseInfoServiceImpl implements
		HqApprovenRuleService {
	@Autowired
	private HqApprovenRuleMapper baseMapper;

	public HqApprovenRuleMapper getBaseMapper() {
		return baseMapper;
	}

	public void setBaseMapper(HqApprovenRuleMapper baseMapper) {
		this.baseMapper = baseMapper;
	}

	@Override
	public void updateHqApprovenRule(List<BaseInfo> list,BaseInfo obj) throws Exception {
			//删除现有审批规则
			this.baseMapper.deleteForMysql(obj);
			//添加新的审批规则
			this.baseMapper.addBatchForMysql(list);
	}

	@Override
	public Integer queryMaxExp(HqApprovenRule rule) throws Exception {
		
		return this.baseMapper.queryMaxExp(rule);
	}

	@Override
	public List<HqApprovenRule> queryApprovenList(HqApprovenRule rule)
			throws Exception {
		return this.baseMapper.queryApprovenList(rule);
	}
	
	
}
