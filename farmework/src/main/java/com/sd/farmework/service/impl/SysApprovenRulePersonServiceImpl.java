package com.sd.farmework.service.impl; 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.farmework.common.BaseInfo;
import com.sd.farmework.mapper.SysApprovenRulePersonMapper;
import com.sd.farmework.pojo.SysApprovenRulePerson;
import com.sd.farmework.service.SysApprovenRulePersonService;

/** 
 * 审批规则对应审批人表
 * @author Administrator 
 * 
 */ 
 @Service
public class SysApprovenRulePersonServiceImpl extends BaseInfoServiceImpl implements SysApprovenRulePersonService{ 
    @Autowired
    private SysApprovenRulePersonMapper baseMapper;
    public SysApprovenRulePersonMapper getBaseMapper(){
     return baseMapper;
    }
    public void setBaseMapper(SysApprovenRulePersonMapper baseMapper){
    	this.baseMapper = baseMapper;
    }
	@Override
	public int queryPersonCount(BaseInfo obj) throws Exception {
		// TODO Auto-generated method stub
		return baseMapper.queryPersonCount(obj);
	}
	@Override
	public void deleteAndOrder(BaseInfo obj) throws Exception {
		// TODO Auto-generated method stub
		
		if("mysql".equals(dbType)){
			this.baseMapper.deleteForMysql(obj);
			List<BaseInfo>list=this.baseMapper.queryListForMysql(obj);
			if(list.size()>0&&list!=null){
				this.baseMapper.updateBatchForMysql(list);
			}
		}else if("oracle".equals(dbType)){
			this.baseMapper.delete(obj);
			List<BaseInfo>list=this.baseMapper.queryList(obj);
			if(list.size()>0&&list!=null){
				this.baseMapper.updateBatch(list);
			}
		}
		
		
		
	}
	@Override
	public void updateOrder(String[] obj,String oper,String approvenPersonId) throws Exception {
		// TODO Auto-generated method stub
		SysApprovenRulePerson  sysApprovenRulePerson =null;
		
		
		if("mysql".equals(dbType)){
			sysApprovenRulePerson = new SysApprovenRulePerson();
			if("delete".equals(oper)){
				sysApprovenRulePerson.setApprovenPersonId(approvenPersonId);
				this.baseMapper.deleteForMysql(sysApprovenRulePerson);
			}
			for (int i = 0; i < obj.length; i++) {
				sysApprovenRulePerson = new SysApprovenRulePerson();
				
				sysApprovenRulePerson.setApprovenPersonId(obj[i]);
				sysApprovenRulePerson.setRuleOrder(""+(i+1));
				this.baseMapper.updateForMysql(sysApprovenRulePerson);
			}
		}else if("oracle".equals(dbType)){
			sysApprovenRulePerson = new SysApprovenRulePerson();
			if("delete".equals(oper)){
				sysApprovenRulePerson.setApprovenPersonId(approvenPersonId);
				this.baseMapper.delete(sysApprovenRulePerson);
			}
			for (int i = 0; i < obj.length; i++) {
				sysApprovenRulePerson = new SysApprovenRulePerson();
				sysApprovenRulePerson.setApprovenPersonId(obj[i]);
				sysApprovenRulePerson.setRuleOrder(""+(i+1));
				this.baseMapper.update(sysApprovenRulePerson);
			}
		}
		
	}
}