package com.soft.web.support;

import java.util.Map;

public interface BaseController 
{
	/**
	 * ��ʼ��Services
	 */
	void initServices();
	
	/**
	 * ҵ�������ͨ���÷���ʵ������Ҫ��Services����
	 */
	void createServices();

    /**
     * ҵ�����̴���
     * @return --- ҵ��������ת��Ŀ��ҳ��ģ����ļ���
     * @throws Exception
     */	
	String execute()throws Exception;
	
	/**
	 * ֯��DTO
	 * @param dto
	 */	
	void setDto(Map<String,Object> dto);
	
	/**
	 * BaseServletͨ���÷���,��ȡ���е�����
	 * @return
	 */	
	Map<String,Object> getAttribute();
	
	/**
	 * ��ʼ����������������д�÷��������ҳ�涯̬�����б�
	 */
	default void initController()throws Exception {}
	
}
