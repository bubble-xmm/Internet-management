package com.soft.db;
//连接对象
import java.sql.Connection;
//驱动管理器
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//资源管理文件
import java.util.ResourceBundle;

/**
 * 当类内部所有成员(属性和方法)都是static的,那么
 * 此时该类无需被实例化,所有构造器(构造函数,构造方法,构造子),一律私有
 */
public class DBUtils 
{
    //驱动jar中核心类的全路径
	private static String driver = null;
	//定义连接串
	private static String url = null;
	private static String username = null;
	private static String password = null;

	//通过静态驱动块加载驱动
	static 
	{
		try 
		{
			//获取资源文件解析对象
			ResourceBundle bundle = ResourceBundle.getBundle("DBOptions");
			//从资源文件中，按名取值
			driver = bundle.getString("DRIVER");
			url = bundle.getString("URL");
			username = bundle.getString("USERNAME");
			password = bundle.getString("PASSWORD");
			//加载驱动
			Class.forName(driver);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	private DBUtils() {
	}

	public static Connection getConnection() throws Exception 
	{
		//通过驱动管理器创建到目标数据库的连接
		return DriverManager.getConnection(url, username, password);
	}
    
	//关闭连接
	public static void close(ResultSet rs) 
	{
		try 
		{
			if (rs != null) // 规避NPE
			{
				rs.close();
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	public static void close(PreparedStatement pstm) 
	{
		try {
			if (pstm != null) // 规避NPE
			{
				pstm.close();
			}
		} 
		catch (Exception ex) 
		{
			ex.printStackTrace();
		}
	}

	public static void close(Connection conn) 
	{
		try 
		{
			if (conn != null) // 规避NPE
			{
				conn.close();
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args) 
	{
		try 
		{
			// for(int i=0;i<10;i++)
			// {
			System.out.println(DBUtils.getConnection());
			// }
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

	}

}
