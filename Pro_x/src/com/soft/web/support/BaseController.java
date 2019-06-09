package com.soft.web.support;

import java.util.Map;

public interface BaseController 
{
	/**
	 * 初始化Services
	 */
	void initServices();
	
	/**
	 * 业务控制器通过该方法实例化需要的Services对象
	 */
	void createServices();

    /**
     * 业务流程处理
     * @return --- 业务流程跳转的目标页面的，主文件名
     * @throws Exception
     */	
	String execute()throws Exception;
	
	/**
	 * 织入DTO
	 * @param dto
	 */	
	void setDto(Map<String,Object> dto);
	
	/**
	 * BaseServlet通过该方法,读取所有的属性
	 * @return
	 */	
	Map<String,Object> getAttribute();
	
	/**
	 * 初始化控制器，子类重写该方法，完成页面动态下拉列表
	 */
	default void initController()throws Exception {}
	
}
