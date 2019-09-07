package com.sd.farmework.pojo; 

import java.util.List;

import com.sd.farmework.common.BaseInfo; 

/** 
 * 团队组织机构表
 * @author Administrator 
 * 
 */ 
public class SysDepartInfo extends BaseInfo{ 
	/**
	 * 
	 */
	private static final long serialVersionUID = -5982989351178963813L;
	//单位编号 
	private String unitId; 
	//单位名称 
	private String unitName; 
	//父节点id 
	private String parentDepartId;
	//上级部门名称
	private String parentDepartName;
	//顺序 
	private String functionSeque; 
	//是否虚节点（0：虚节点，1：实节点） 
	private String isVirtual; 
	//(0：根节点、1：单位、2：部门、3：科室、4：班组、5：角色) 
	private int nodeType; 
	//主键 
	private String departId; 
	//组织名称 
	private String departName; 
	//组织描述 
	private String departDesc; 
	
	private List <String> nodeTypes;
    public SysDepartInfo(){
	}
    public SysDepartInfo(String unitId,String unitName,String parentDepartId,String functionSeque,String isVirtual,int nodeType,String departId,String departName,String departDesc){
		this.unitId=unitId;
		this.unitName=unitName;
		this.parentDepartId=parentDepartId;
		this.functionSeque=functionSeque;
		this.isVirtual=isVirtual;
		this.nodeType=nodeType;
		this.departId=departId;
		this.departName=departName;
		this.departDesc=departDesc;
	}
    public SysDepartInfo(String unitName,String parentDepartId,String functionSeque,String isVirtual,int nodeType,String departId,String departName,String departDesc){
		this.unitName=unitName;
		this.parentDepartId=parentDepartId;
		this.functionSeque=functionSeque;
		this.isVirtual=isVirtual;
		this.nodeType=nodeType;
		this.departId=departId;
		this.departName=departName;
		this.departDesc=departDesc;
	}
    
	public String getParentDepartName() {
		return parentDepartName;
	}
	public void setParentDepartName(String parentDepartName) {
		this.parentDepartName = parentDepartName;
	}
	public void setUnitId(String unitId){ 
		this.unitId=unitId;
	}
	public String getUnitId(){ 
		return this.unitId;
	}
	public void setUnitName(String unitName){ 
		this.unitName=unitName;
	}
	public String getUnitName(){ 
		return this.unitName;
	}
	public void setParentDepartId(String parentDepartId){ 
		this.parentDepartId=parentDepartId;
	}
	public String getParentDepartId(){ 
		return this.parentDepartId;
	}
	public void setFunctionSeque(String functionSeque){ 
		this.functionSeque=functionSeque;
	}
	public String getFunctionSeque(){ 
		return this.functionSeque;
	}
	public void setIsVirtual(String isVirtual){ 
		this.isVirtual=isVirtual;
	}
	public String getIsVirtual(){ 
		return this.isVirtual;
	}
	public void setNodeType(int nodeType){ 
		this.nodeType=nodeType;
	}
	public int getNodeType(){ 
		return this.nodeType;
	}
	public void setDepartId(String departId){ 
		this.departId=departId;
	}
	public String getDepartId(){ 
		return this.departId;
	}
	public void setDepartName(String departName){ 
		this.departName=departName;
	}
	public String getDepartName(){ 
		return this.departName;
	}
	public void setDepartDesc(String departDesc){ 
		this.departDesc=departDesc;
	}
	public String getDepartDesc(){ 
		return this.departDesc;
	}
	
	public List<String> getNodeTypes() {
		return nodeTypes;
	}
	public void setNodeTypes(List<String> nodeTypes) {
		this.nodeTypes = nodeTypes;
	}
	@Override
	public String toString() {
		return "SysDepartInfo[unitId=" + unitId+",unitName=" + unitName+",parentDepartId=" + parentDepartId+",functionSeque=" + functionSeque+",isVirtual=" + isVirtual+",nodeType=" + nodeType+",departId=" + departId+",departName=" + departName+",departDesc=" + departDesc+"]";
	}
}