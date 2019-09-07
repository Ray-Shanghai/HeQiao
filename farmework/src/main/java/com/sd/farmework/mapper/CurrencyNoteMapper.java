package com.sd.farmework.mapper;

import java.util.List;
import java.util.Map;

import com.sd.farmework.common.BaseMapper;

public interface CurrencyNoteMapper extends  BaseMapper {
	public List queryWaitingListAll(Map map) throws Exception;
}
