package com.sd.farmework.service.impl; 

import com.sd.farmework.pojo.SysApprovenFunctionRule;
import com.sd.farmework.pojo.SysApprovenRulePerson;
import com.sd.farmework.service.SysApprovenFunctionRuleService; 

import org.springframework.stereotype.Service; 

import com.sd.farmework.mapper.SysApprovenFunctionRuleMapper; 

import org.springframework.beans.factory.annotation.Autowired; 

/** 
 * 审批功能规则表
 * @author Administrator 
 * 
 */ 
 @Service
public class SysApprovenFunctionRuleServiceImpl extends BaseInfoServiceImpl implements SysApprovenFunctionRuleService{ 
    @Autowired
    private SysApprovenFunctionRuleMapper baseMapper;
    public SysApprovenFunctionRuleMapper getBaseMapper(){
     return baseMapper;
    }
    public void setBaseMapper(SysApprovenFunctionRuleMapper baseMapper){
    	this.baseMapper = baseMapper;
    }
	@Override
	public void updateOrder(String[] obj, String oper, String approvenRuleId)
			throws Exception {
		// TODO Auto-generated method stub
		SysApprovenFunctionRule  sysApprovenFunctionRule =null;
		if("mysql".equals(dbType)){
			sysApprovenFunctionRule = new SysApprovenFunctionRule();
			if("delete".equals(oper)){
				sysApprovenFunctionRule.setApprovenRuleId(approvenRuleId);
				this.baseMapper.deleteForMysql(sysApprovenFunctionRule);
			}
			for (int i = 0; i < obj.length; i++) {
				sysApprovenFunctionRule = new SysApprovenFunctionRule();
				
				sysApprovenFunctionRule.setApprovenRuleId(obj[i]);
				sysApprovenFunctionRule.setRuleIsOrderly(""+(i+1));
				this.baseMapper.updateForMysql(sysApprovenFunctionRule);
			}
		}else if("oracle".equals(dbType)){
			sysApprovenFunctionRule = new SysApprovenFunctionRule();
			if("delete".equals(oper)){
				sysApprovenFunctionRule.setApprovenRuleId(approvenRuleId);
				this.baseMapper.delete(sysApprovenFunctionRule);
			}
			for (int i = 0; i < obj.length; i++) {
				sysApprovenFunctionRule = new SysApprovenFunctionRule();
				sysApprovenFunctionRule.setApprovenRuleId(obj[i]);
				sysApprovenFunctionRule.setRuleIsOrderly(""+(i+1));
				this.baseMapper.update(sysApprovenFunctionRule);
			}
		}
	}
}