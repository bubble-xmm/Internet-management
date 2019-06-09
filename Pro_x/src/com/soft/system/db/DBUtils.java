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
	private static final ThreadLocal<Connection> threadlocal = new ThreadLocal<>();//�̸߳���
	
	/**
     * ��̬�� ����JDBC����
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
	 *                                    ����SQL_Begin
	 ********************************************************************************************/
	/**
	 * ����SQL���
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public static final PreparedStatement PrepareStatement(String sql)throws Exception
	{
		return DBUtils.getConnection().prepareStatement(sql);
	}
	
	/**
	 * �������ݿ����Ӷ���
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
	 * �ر����ݿ�����---Connection
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
	 * �ر����ݿ�����---ResultSet
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
	 * �ر����ݿ�����---PreparedStatement
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
	 *                                    ����SQL_End 
	 ********************************************************************************************/
	
	
	/********************************************************************************************
	 *                                    ������_Begin
	 ********************************************************************************************/
	/**
	 * ������
	 * @throws Exception
	 */
	public static void beginTransaction()throws Exception
	{
		DBUtils.getConnection().setAutoCommit(false);
	}
	
	/**
	 * ����ִ��
	 * @throws Exception
	 */
	public static void commit()throws Exception
	{
		DBUtils.getConnection().commit();
	}
	
	/**
	 * ����ع�
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
	 * �������
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
	 *                                    ������_End                 
	 ********************************************************************************************/
	
	/**
	 * main�����������ݿ������Ƿ�ɹ����Լ��̸߳��������Ƿ�ɹ�
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
