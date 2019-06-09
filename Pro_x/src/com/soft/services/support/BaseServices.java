package com.soft.services.support;

import java.util.List;
import java.util.Map;

public interface BaseServices 
{
	/**
	 * Ϊ����Services������DTO
	 * @param dto
	 */
	void initDto(Map<String,Object> dto);
	
	/**
	 * ��һʵ����ѯ
	 * @return
	 * @throws Exception
	 */
	default Map<String,String> findById()throws Exception
	{
		return null;
	}
	
	/**
	 * ���ݷ�ҳ��ѯ
	 * @return
	 * @throws Exception
	 */
	default List<Map<String,String>> queryForPage()throws Exception
	{
		return null;
	}
 
	/**
	 * ����Services�����и�������Ϊ
	 * @param updateType
	 * @return
	 * @throws Exception
	 */
	default boolean update(String updateType)throws Exception
	{
		return false;
	}
	
	/**
	 * ����һ��һ������
	 * @return
	 * @throws Exception
	 */
	default Object queryForObject()throws Exception
	{
		return null;
	}
	
}
