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
	 * 从控制器中获取DTO
	 */
	public final void initDto(Map<String,Object> dto)
	{
		this.dto = dto;
	}
	
	/********************************************************************************************
	 *                                    辅助方法_Begin 
	 ********************************************************************************************/
	/**
	 * 子类获取DTO单一数据
	 * @param key
	 * @return
	 */
	protected final Object getVal(final String key)
	{
		return this.dto.get(key);
	}
	
    /**
     * 向DTO写入数据
     * @param key
     * @param value
     */
    protected final void addEntry(final String key,Object value)
    {
    	this.dto.put(key, value);
    }
	
    /**
     * 将字符串转换成所需的字符串数组
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
	 * 非空校验
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
	 *                                    辅助方法_End
	 ********************************************************************************************/
	
    
	/********************************************************************************************
	 *                                    业务方法_Begin
	 ********************************************************************************************/
    /**
	 * 数据批量查询
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
     * 单一实例查询
     * <
     *    #查询一条数据
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
     * 返回一行一列数据
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
	 * 非事务方式,单一表更新
	 * @param sql   --- 方法需要执行的更新语句
	 * @param args  --- sql中的参数列表
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
     * 单一表批处理事务更新
     * <
     *    #单一表,单一状态批处理修改,适合的SQL:
     *    update table 
     *       set col=?
     *     where id=?  
     *     
     *     #按照主键批处理,只更新一列
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
   	 * 单一表批处理事务更新
   	 * <
   	 *   #单一表批处理删除,适合的SQL:
   	 *   delete from table where id=?
   	 * >
   	 * @param sql   --- 需要执行的SQL语句
   	 * @param args  --- 页面checkbox数组(主键数组)
   	 * @return
   	 * @throws Exception
   	 */
    protected final boolean batchTransaction(final String sql,Object...idlist)throws Exception
    {
    	return this.batchTransaction(sql, new Object[]{}, idlist);
    }
    
    /**
     * 单一表批处理事务更新 Primary
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
     * 单一表批处理事务执行
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
     *                                    业务方法_End 
     ********************************************************************************************/

}
