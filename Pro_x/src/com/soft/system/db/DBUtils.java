package com.soft.system.db;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class DBUtils 
{
	private static String DRIVER = null;
	private static String URL = null;
	private static String USERNAME = null;
	private static String PASSWORD = null;
	private static final ThreadLocal<Connection> threadlocal = new ThreadLocal<>();//线程副本
	
	/**
     * 静态块 加载JDBC驱动
     */
	static
	{
		try
		{
			ResourceBundle bundle = ResourceBundle.getBundle("DBoptions");
			DRIVER = bundle.getString("DRIVER");
			URL = bundle.getString("URL");
			USERNAME = bundle.getString("USERNAME");
			PASSWORD = bundle.getString("PASSWORD");
			Class.forName(DRIVER);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	private DBUtils(){};
	
	/********************************************************************************************
	 *                                    编译SQL_Begin
	 ********************************************************************************************/
	/**
	 * 编译SQL语句
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public static final PreparedStatement PrepareStatement(String sql)throws Exception
	{
		return DBUtils.getConnection().prepareStatement(sql);
	}
	
	/**
	 * 创建数据库连接对象
	 * @return
	 * @throws Exception
	 */
	private static final Connection getConnection()throws Exception
	{
		Connection conn = threadlocal.get();
		if(conn==null || conn.isClosed())
		{
		    conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			threadlocal.set(conn);
		}
		return conn;
	}
		
	/**
	 * 关闭数据库连接---Connection
	 */
	public static final void close()
	{
		try
		{
			Connection conn = threadlocal.get();
			if(conn!=null && !conn.isClosed())
			{
				threadlocal.remove();
				conn.close();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * 关闭数据库连接---ResultSet
	 */
	public static final void close(ResultSet rs) 
	{
		try 
		{
			if(rs!=null)
			{
				rs.close();
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * 关闭数据库连接---PreparedStatement
	 */
	public static final void close(PreparedStatement pstm)
	{
		try 
		{
			if(pstm!=null)
			{
				pstm.close();
			}
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	/********************************************************************************************
	 *                                    编译SQL_End 
	 ********************************************************************************************/
	
	
	/********************************************************************************************
	 *                                    事务处理_Begin
	 ********************************************************************************************/
	/**
	 * 事务开启
	 * @throws Exception
	 */
	public static void beginTransaction()throws Exception
	{
		DBUtils.getConnection().setAutoCommit(false);
	}
	
	/**
	 * 事务执行
	 * @throws Exception
	 */
	public static void commit()throws Exception
	{
		DBUtils.getConnection().commit();
	}
	
	/**
	 * 事务回滚
	 */
	public static void rollback()
	{
		try
		{
			DBUtils.getConnection().rollback();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * 事务结束
	 */
	public static void endTransaction() 
	{
		try
		{
			DBUtils.getConnection().setAutoCommit(true);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	/********************************************************************************************
	 *                                    事务处理_End                 
	 ********************************************************************************************/
	
	/**
	 * main函数测试数据库连接是否成功，以及线程副本创建是否成功
	 * @param args
	 */
	public static void main(String[] args) 
	{
        try 
        {
            for(int i=1;i<=10;i++)
            {
            	System.out.println(DBUtils.getConnection());
            }
		} 
        catch (Exception e) 
        {
			e.printStackTrace();
		}
	}
	
}
