package com.soft.services.support;

import java.util.List;
import java.util.Map;

public interface BaseServices 
{
	/**
	 * 为子类Services，传递DTO
	 * @param dto
	 */
	void initDto(Map<String,Object> dto);
	
	/**
	 * 单一实例查询
	 * @return
	 * @throws Exception
	 */
	default Map<String,String> findById()throws Exception
	{
		return null;
	}
	
	/**
	 * 数据分页查询
	 * @return
	 * @throws Exception
	 */
	default List<Map<String,String>> queryForPage()throws Exception
	{
		return null;
	}
 
	/**
	 * 包含Services中所有更新类行为
	 * @param updateType
	 * @return
	 * @throws Exception
	 */
	default boolean update(String updateType)throws Exception
	{
		return false;
	}
	
	/**
	 * 返回一行一列数据
	 * @return
	 * @throws Exception
	 */
	default Object queryForObject()throws Exception
	{
		return null;
	}
	
}
