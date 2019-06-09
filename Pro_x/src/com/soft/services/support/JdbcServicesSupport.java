package com.soft.services.support;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.soft.system.db.DBUtils;

public abstract class JdbcServicesSupport implements BaseServices
{
	private Map<String,Object> dto = null;
	
	/**
	 * �ӿ������л�ȡDTO
	 */
	public final void initDto(Map<String,Object> dto)
	{
		this.dto = dto;
	}
	
	/********************************************************************************************
	 *                                    ��������_Begin 
	 ********************************************************************************************/
	/**
	 * �����ȡDTO��һ����
	 * @param key
	 * @return
	 */
	protected final Object getVal(final String key)
	{
		return this.dto.get(key);
	}
	
    /**
     * ��DTOд������
     * @param key
     * @param value
     */
    protected final void addEntry(final String key,Object value)
    {
    	this.dto.put(key, value);
    }
	
    /**
     * ���ַ���ת����������ַ�������
     * @param key
     * @return
     */
    protected final String[] getArray(String key)
    {
    	Object value = this.getVal(key);
    	if(value instanceof java.lang.String[])
    	{
    		return (String[])value;
    	}
    	else
    	{
    		return new String[]{value.toString()};
    	}
    }
  
    /**
	 * �ǿ�У��
	 * @param value
	 * @return
	 */
    protected final boolean isNotNull(Object value)
    {
    	if(value!=null && !value.equals(""))
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }
    
	/********************************************************************************************
	 *                                    ��������_End
	 ********************************************************************************************/
	
    
	/********************************************************************************************
	 *                                    ҵ�񷽷�_Begin
	 ********************************************************************************************/
    /**
	 * ����������ѯ
	 * @param sql
     * @param objects 
	 * @param args
	 * @return
	 * @throws Exception
	 */
    protected final List<Map<String,String>> queryForList(final String sql, final Object...args)throws Exception
    {
    	PreparedStatement pstm = null;
    	ResultSet rs = null;
    	try
    	{
    		pstm = DBUtils.PrepareStatement(sql);
    		int index=1;
    		for(Object param:args)
    		{
    			pstm.setObject(index++, param);
    		}
    		rs = pstm.executeQuery();
    		
    		List<Map<String,String>> rows = new ArrayList<>();
    		Map<String,String> ins = null;
    		ResultSetMetaData rsmd = rs.getMetaData();
    		int count = rsmd.getColumnCount();
    		int initsize = (int)(count/0.75)+1;
    		
    		while(rs.next())
    		{
    			ins = new HashMap<>(initsize);
    			for(int i=1;i<=count;i++)
    			{
    				ins.put(rsmd.getColumnLabel(i).toLowerCase(), rs.getString(i));
    			}
    			rows.add(ins);
    		}
    		return rows;
    	}
    	finally
    	{
    		DBUtils.close(rs);
    		DBUtils.close(pstm);
    	}
    }
    
    /**
     * ��һʵ����ѯ
     * <
     *    #��ѯһ������
     * >
     * @param sql
     * @param args
     * @return
   	 * @throws Exception
     */
    protected final Map<String,String> queryForMap(final String sql,Object...args)throws Exception
    {
       	PreparedStatement pstm = null;
       	ResultSet rs = null;
       	try
       	{
       		pstm = DBUtils.PrepareStatement(sql);
       		int index = 1;
       		for(Object param:args)
       		{
       			pstm.setObject(index++, param);
       		}
       		rs = pstm.executeQuery();
       		
       		Map<String,String> ins = null;
       		while(rs.next())
       		{
       			ResultSetMetaData rsmd = rs.getMetaData();
       			int count = rsmd.getColumnCount();
       			int initsize = (int)(count/0.75)+1;
       			ins = new HashMap<>(initsize);
       			for(int i=1;i<=count;i++)
       			{
       				ins.put(rsmd.getColumnLabel(i).toLowerCase(), rs.getString(i));
       			}
       		}
       		return ins;
       	}
       	finally
       	{
       		DBUtils.close(rs);
       		DBUtils.close(pstm);
       	}
    }
        
    /**
     * ����һ��һ������
     * 
     *   select max(sal) from emp where deptno=13
     * @return
     * @throws Exception
     */
    protected final Object queryForData(final String sql,final Object...args)throws Exception
    {
    	PreparedStatement pstm = null;
    	ResultSet rs = null;
    	try
    	{
    		pstm = DBUtils.PrepareStatement(sql);
    		int index = 1;
    		for(Object param:args)
    		{
    			pstm.setObject(index++, param);
    		}
    		rs = pstm.executeQuery();
    		
    		Object val = null;
    		if(rs.next())
    		{
    			val = rs.getObject(1);
    		}
    		return val;
    	}
    	finally
    	{
    		DBUtils.close(rs);
    		DBUtils.close(pstm);
    	}
    }
    
	/**
	 * ������ʽ,��һ�����
	 * @param sql   --- ������Ҫִ�еĸ������
	 * @param args  --- sql�еĲ����б�
	 * @return
	 * @throws Exception
	 */
    protected final int executeUpdate(final String sql,Object...args)throws Exception
    {
    	PreparedStatement pstm = null;
    	try
    	{
    		pstm = DBUtils.PrepareStatement(sql);
    		int index = 1;
    		for(Object param:args)
    		{
    			pstm.setObject(index++, param);
    		}
    		return pstm.executeUpdate();
    	}
    	finally
    	{
    		DBUtils.close(pstm);
    	}
    }
    
    /**
     * ��һ���������������
     * <
     *    #��һ��,��һ״̬�������޸�,�ʺϵ�SQL:
     *    update table 
     *       set col=?
     *     where id=?  
     *     
     *     #��������������,ֻ����һ��
     * >
     * @param sql
     * @param newState
     * @param args
     * @return
     * @throws Exception
     */
    protected final boolean batchTransaction(final String sql,final Object newState,Object...idlist)throws Exception
    {
    	return this.batchTransaction(sql, new Object[]{newState}, idlist);
    }
    
   	/**
   	 * ��һ���������������
   	 * <
   	 *   #��һ��������ɾ��,�ʺϵ�SQL:
   	 *   delete from table where id=?
   	 * >
   	 * @param sql   --- ��Ҫִ�е�SQL���
   	 * @param args  --- ҳ��checkbox����(��������)
   	 * @return
   	 * @throws Exception
   	 */
    protected final boolean batchTransaction(final String sql,Object...idlist)throws Exception
    {
    	return this.batchTransaction(sql, new Object[]{}, idlist);
    }
    
    /**
     * ��һ��������������� Primary
     * @param sql
     * @param State
     * @param args
     * @return
     * @throws Exception
     */
    protected final boolean batchTransaction(final String sql,final Object[] newStateList,Object...idlist)throws Exception
    {
    	PreparedStatement pstm = null;
    	try
    	{
    		pstm = DBUtils.PrepareStatement(sql);
    		int index = 1;
    		for(Object state:newStateList)
    		{
    			pstm.setObject(index++, state);
    		}
    		for(Object id:idlist)
    		{
    			pstm.setObject(index, id);
    			pstm.addBatch();
    		}
    		return this.executeBatchTransaction(pstm);
    	}
    	finally
    	{
    		DBUtils.close(pstm);
    	}
    }
    
    /**
     * ��һ������������ִ��
     * @param pstm
     * @return
     * @throws Exception
     */
    protected final boolean executeBatchTransaction(PreparedStatement pstm)throws Exception
    {
		boolean tag = false;
		DBUtils.beginTransaction();
		try
		{
			pstm.executeBatch();
			DBUtils.commit();
			tag = true;
		}
		catch(Exception e)
		{
			DBUtils.rollback();
			e.printStackTrace();
			
		}
		finally
		{
			DBUtils.endTransaction();
		}
		return tag;
    }

    /********************************************************************************************
     *                                    ҵ�񷽷�_End 
     ********************************************************************************************/

}
