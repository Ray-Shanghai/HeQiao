package com.sd.farmework.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface BaseMapper extends MysqlBaseMapper{
	
	/**
	 * 查询单一信息
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public List query(BaseInfo obj) throws Exception;
	 
	/**
	 * 查询所有条数
	 */
 	public int queryCount(BaseInfo obj) throws Exception;
	
	/**
	 * 查询所有后台信息
	 */
 	public List<BaseInfo> queryList(BaseInfo obj) throws Exception;
 	
	
	/**
	 * 查询所有后台信息分页时使用
	 */
 	public List<BaseInfo> queryListByPage(BaseInfo obj) throws Exception;
 
 	/**
	 * 添加信息
	 * @param user
	 * @throws Exception
	 */
	public void add(BaseInfo obj) throws Exception;
	/**
	 * 删除信息
	 * @param user
	 * @throws Exception
	 */
	public void delete(String id) throws Exception;
	/**
	 * 修改信息
	 * @param user
	 * @throws Exception
	 */
	public void update(BaseInfo obj) throws Exception;
	/**
	 * 查询基本信息通过ID
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public BaseInfo queryById(BaseInfo obj) throws Exception;
	/**
	 * 查询插入数据的主键
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public String querySeq(BaseInfo obj) throws Exception;
	/**
	 * 根据主键查询多条记录
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ArrayList<HashMap> queryListByPrimaryKey(BaseInfo obj) throws Exception;
	/**
	 * 获取下一个的主键
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public String queryNextSeq(BaseInfo obj) throws Exception;
	
	/**
	 * 批量写入
	 * @param obj
	 * @throws Exception
	 */
	public void addBatch(List  obj) throws Exception;
	/**
	 * 批量更新
	 * @param obj
	 * @throws Exception
	 */
	public void updateBatch(List  obj) throws Exception;
	/**
	 * 删除数据
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public void delete(BaseInfo obj) throws Exception;
	 
 	
	/**
	 * 查询基本信息通过ID
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public BaseInfo queryByPkId(String obj) throws Exception;
	
	
	
	
}
