package com.sd.farmework.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.sd.farmework.common.BaseInfo;
import com.sd.farmework.common.BaseMapper;
import com.sd.farmework.service.BaseInfoService;

public class BaseInfoServiceImpl implements BaseInfoService {
	
	protected String dbType ="mysql";
	
	protected	BaseMapper baseMapper;

	 

	public BaseMapper getBaseMapper() {
		
		return baseMapper;
	}
	
	/**
	 * 查询所有用户
	 */
	
	public List<BaseInfo> queryList(BaseInfo obj) throws Exception {
		// TODO Auto-generated method stub
		List list = null;
		try {
			if("mysql".equals(dbType)){
				list = getBaseMapper().queryListForMysql(obj);
			}else if("oracle".equals(dbType)){
				list = getBaseMapper().queryList(obj);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception(e);
		}
		
		return list;
	}

	
	public void add(BaseInfo obj) throws Exception {
		// TODO Auto-generated method stub
		try {
			if("mysql".equals(dbType)){
				getBaseMapper().addForMysql(obj);
			}else if("oracle".equals(dbType)){
				getBaseMapper().add(obj);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	
	public void update(BaseInfo obj) throws Exception {
 		// TODO Auto-generated method stub
		try {
			if("mysql".equals(dbType)){
				getBaseMapper().updateForMysql(obj);
			}else if("oracle".equals(dbType)){
				getBaseMapper().update(obj);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception(e);
		}

	}

	
	public BaseInfo queryById(BaseInfo obj) throws Exception {
		BaseInfo objout = null;
		try {
			if("mysql".equals(dbType)){
				objout = getBaseMapper().queryByIdForMysql(obj);
			}else if("oracle".equals(dbType)){
				objout = getBaseMapper().queryById(obj);
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			throw new Exception(e);
		}
		return objout;
	}

	
	public List query(BaseInfo obj) throws Exception {
		// TODO Auto-generated method stub
		List objout = null;
		try {
			if("mysql".equals(dbType)){
				objout = getBaseMapper().queryForMysql(obj);
			}else if("oracle".equals(dbType)){
				objout = getBaseMapper().query(obj);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception(e);
		}
		return objout;
	}

	
	public int queryCount(BaseInfo obj) throws Exception {
		// TODO Auto-generated method stub
		
		int objout =0;
		try {
			if("mysql".equals(dbType)){
				objout = getBaseMapper().queryCountForMysql(obj);
			}else if("oracle".equals(dbType)){
				objout = getBaseMapper().queryCount(obj);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception(e);
		}
		return objout;
	}

	@Override
	public String querySeq(BaseInfo obj) throws Exception {
		// TODO Auto-generated method stub
		String objout="";
		try {
			
			if("mysql".equals(dbType)){
				objout = getBaseMapper().querySeqForMysql(obj);
			}else if("oracle".equals(dbType)){
				objout = getBaseMapper().querySeq(obj);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception(e);
		}
		return objout;
	}

	@Override
	public ArrayList<HashMap> queryListByPrimaryKey(BaseInfo obj) throws Exception {
		// TODO Auto-generated method stub
		
		ArrayList<HashMap> list = null;
		try {
			
			if("mysql".equals(dbType)){
				list = getBaseMapper().queryListByPrimaryKeyForMysql(obj);
			}else if("oracle".equals(dbType)){
				list = getBaseMapper().queryListByPrimaryKey(obj);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception(e);
		}
		
		return list;

	}

	@Override
	public String queryNextSeq(BaseInfo obj) throws Exception {
		// TODO Auto-generated method stub
		String objout="";
		try {
			
			if("mysql".equals(dbType)){
				objout = getBaseMapper().queryNextSeqForMysql(obj);
			}else if("oracle".equals(dbType)){
				objout = getBaseMapper().queryNextSeq(obj);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception(e);
		}
		return objout;
	}
	@Override
	public void addBatch(List obj) throws Exception {
		// TODO Auto-generated method stub
		try {
			if("mysql".equals(dbType)){
				getBaseMapper().addBatchForMysql(obj);
			}else if("oracle".equals(dbType)){
				getBaseMapper().addBatch(obj);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	@Override
	public void updateBatch(List obj) throws Exception {
		// TODO Auto-generated method stub
		try {
			
			if("mysql".equals(dbType)){
				getBaseMapper().updateBatchForMysql(obj);
			}else if("oracle".equals(dbType)){
				getBaseMapper().updateBatch(obj);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	@Override
	public void delete(BaseInfo obj) throws Exception {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				try {
					
					if("mysql".equals(dbType)){
						getBaseMapper().deleteForMysql(obj);
					}else if("oracle".equals(dbType)){
						getBaseMapper().delete(obj);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new Exception(e);
				}
	}

	@Override
	public List<BaseInfo> queryListByPage(BaseInfo obj) throws Exception {
		// TODO Auto-generated method stub
				List list = null;
				try {
					
					if("mysql".equals(dbType)){
						list = getBaseMapper().queryListByPageForMysql(obj);
					}else if("oracle".equals(dbType)){
						list = getBaseMapper().queryListByPage(obj);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new Exception(e);
				}
				
				return list;
	}

	@Override
	public BaseInfo queryByPkId(String obj) throws Exception {
		BaseInfo objout = null;
			try {
				if("mysql".equals(dbType)){
					objout = getBaseMapper().queryByPkIdForMysql(obj);
				}else if("oracle".equals(dbType)){
					objout = getBaseMapper().queryByPkId(obj);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new Exception(e);
			}
			return objout;
	}
}