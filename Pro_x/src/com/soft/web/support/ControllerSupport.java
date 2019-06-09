package com.soft.web.support;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.soft.services.support.BaseServices;

public abstract class ControllerSupport implements BaseController
{
	private Map<String,Object> dto = null;
	private BaseServices services = null;
	private final Map<String, Object> attribute = new HashMap<>();//装载属性的容器
	
	/********************************************************************************************
	 *                                    处理Services_Begin
	 ********************************************************************************************/
	/**
	 * 向services传递DTO
	 */
	public final void initServices()
	{
		this.services.initDto(this.dto);
	}
	
	/**
	 * 子类调用BaseServices对象将其实例化
	 * @param services
	 */
	protected final void setServices(BaseServices services)
	{
		this.services = services;
	}
	/********************************************************************************************
	 *                                    处理Services_End
	 ********************************************************************************************/
	
	
	/********************************************************************************************
	 *                                    数据输入处理_Begin
	 ********************************************************************************************/
	/**
	 * 向Servlet注入DTO
	 */
	public final void setDto(Map<String,Object> dto)
	{
		this.dto = dto;
	}
	
	/**
	 * 子类获取DTO中属性的字符串类型
	 * @param key
	 * @return
	 */
	protected final String getVal(String key)
	{
		if(this.dto.containsKey(key)) 
		{
			return this.dto.get(key).toString();
		}
		else
		{
			return "";
		}
	}
	
	/**
	 * 子类获取DTO中的属性Object类型
	 * @param key
	 * @return
	 */
	protected final Object getVal(Object key)
	{
		return this.dto.get(key);
	}
	
	/**
	 * 打印DTO内容
	 */
	protected final void showDto()
	{
		System.out.println(this.dto);
	}
	/********************************************************************************************
	 *                                    数据输入处理_End
	 ********************************************************************************************/
	
	
	/********************************************************************************************
	 *                                    数据输出处理_Begin
	 ********************************************************************************************/
	/**
	 * 装入Servlet产生的数据
	 * @param key
	 * @param value
	 */
	protected final void addAttribute(String key,Object value)
	{
		this.attribute.put(key, value);
	}
	
	/**
	 * 添加msg
	 * @param msgText
	 */
	protected final void addMsg(String msgText)
	{
		this.attribute.put("msg", msgText);
	}
	
	/**
	 * 获取Servlet的送出的数据
	 */
	public final Map<String, Object> getAttribute()
	{
		return this.attribute;
	}
	/********************************************************************************************
	 *                                    数据输出处理_End
	 ********************************************************************************************/
	

	/********************************************************************************************
	 *                                    业务流程调度_Begin 
	 ********************************************************************************************/
	/**
	 * 分页查询
	 * @throws Exception
	 */
	protected final void savePageData()throws Exception
	{
		List<Map<String,String>> rows = this.services.queryForPage();
		if(rows.size()>0)
		{
			this.addAttribute("rows", rows);
		}
		else
		{
			this.addMsg("没有符合条件的数据");
		}
	}
	
	/**
	 * 删除后检索
	 * @throws Exception
	 */
	protected final void savePageData_del()throws Exception
	{
		List<Map<String,String>> rows = this.services.queryForPage();
		if(rows.size()>0)
		{
			this.addAttribute("rows", rows);
		}
	}
	
	/**
	 * 单一实例查询
	 * @throws Exception
	 */
	protected final void saveInstances()throws Exception
	{
        Map<String,String> ins = this.services.findById();
        if(ins.size()>0)
        {
        	this.addAttribute("ins", ins);
        }
        else
        {
        	this.addMsg("没有符合条件的数据");
        }
	}
	
	/**
	 * 单一行单一列数据存储
	 * @param dataName
	 * @throws Exception
	 */
	protected final void saveData(final String dataName)throws Exception
	{
		this.addAttribute(dataName, this.services.queryForObject());
	}
	
	/**
	 * 数据更新
	 * @param updateType
	 * @param msg
	 * @throws Exception
	 */
	protected final void update(String updateType,String fore_msg)throws Exception
	{
		String msg = this.services.update(updateType)?"成功":"失败";
	    this.addMsg(fore_msg+msg);
	}
	/********************************************************************************************
	 *                                    业务流程调度_End 
	 ********************************************************************************************/

}
