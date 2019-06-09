package com.soft.web.support;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.soft.services.support.BaseServices;

public abstract class ControllerSupport implements BaseController
{
	private Map<String,Object> dto = null;
	private BaseServices services = null;
	private final Map<String, Object> attribute = new HashMap<>();//װ�����Ե�����
	
	/********************************************************************************************
	 *                                    ����Services_Begin
	 ********************************************************************************************/
	/**
	 * ��services����DTO
	 */
	public final void initServices()
	{
		this.services.initDto(this.dto);
	}
	
	/**
	 * �������BaseServices������ʵ����
	 * @param services
	 */
	protected final void setServices(BaseServices services)
	{
		this.services = services;
	}
	/********************************************************************************************
	 *                                    ����Services_End
	 ********************************************************************************************/
	
	
	/********************************************************************************************
	 *                                    �������봦��_Begin
	 ********************************************************************************************/
	/**
	 * ��Servletע��DTO
	 */
	public final void setDto(Map<String,Object> dto)
	{
		this.dto = dto;
	}
	
	/**
	 * �����ȡDTO�����Ե��ַ�������
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
	 * �����ȡDTO�е�����Object����
	 * @param key
	 * @return
	 */
	protected final Object getVal(Object key)
	{
		return this.dto.get(key);
	}
	
	/**
	 * ��ӡDTO����
	 */
	protected final void showDto()
	{
		System.out.println(this.dto);
	}
	/********************************************************************************************
	 *                                    �������봦��_End
	 ********************************************************************************************/
	
	
	/********************************************************************************************
	 *                                    �����������_Begin
	 ********************************************************************************************/
	/**
	 * װ��Servlet����������
	 * @param key
	 * @param value
	 */
	protected final void addAttribute(String key,Object value)
	{
		this.attribute.put(key, value);
	}
	
	/**
	 * ���msg
	 * @param msgText
	 */
	protected final void addMsg(String msgText)
	{
		this.attribute.put("msg", msgText);
	}
	
	/**
	 * ��ȡServlet���ͳ�������
	 */
	public final Map<String, Object> getAttribute()
	{
		return this.attribute;
	}
	/********************************************************************************************
	 *                                    �����������_End
	 ********************************************************************************************/
	

	/********************************************************************************************
	 *                                    ҵ�����̵���_Begin 
	 ********************************************************************************************/
	/**
	 * ��ҳ��ѯ
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
			this.addMsg("û�з�������������");
		}
	}
	
	/**
	 * ɾ�������
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
	 * ��һʵ����ѯ
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
        	this.addMsg("û�з�������������");
        }
	}
	
	/**
	 * ��һ�е�һ�����ݴ洢
	 * @param dataName
	 * @throws Exception
	 */
	protected final void saveData(final String dataName)throws Exception
	{
		this.addAttribute(dataName, this.services.queryForObject());
	}
	
	/**
	 * ���ݸ���
	 * @param updateType
	 * @param msg
	 * @throws Exception
	 */
	protected final void update(String updateType,String fore_msg)throws Exception
	{
		String msg = this.services.update(updateType)?"�ɹ�":"ʧ��";
	    this.addMsg(fore_msg+msg);
	}
	/********************************************************************************************
	 *                                    ҵ�����̵���_End 
	 ********************************************************************************************/

}
