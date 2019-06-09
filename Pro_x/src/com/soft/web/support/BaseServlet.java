package com.soft.web.support;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("*.html")
public final class BaseServlet extends HttpServlet
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		String toPath = null; //跳转到页面路径
		try
		{
			String uri = request.getRequestURI();
	        String path = uri.substring(uri.lastIndexOf("/")+1).replace(".html", "");
	        String className = path.substring(0, 1).toUpperCase() + path.substring(1) + "Servlet";
	        String servletDir = "com.soft.web."+path.substring(0,1)+".impl.";
	         //System.out.println(servletDir); //Servlet路径输出
	        String all_path = servletDir + className; //跳转到具体servlet路径
	        BaseController controller = (BaseController)Class.forName(all_path).newInstance();
	        controller.setDto(this.creatDto(request)); //织入DTO
	        controller.initController(); //初始化Controller
	        controller.createServices(); //创建services
	        controller.initServices(); //初始化services
	        toPath = controller.execute(); //执行业务逻辑
	        Map<String,Object> attribute = controller.getAttribute(); //获取投射到页面的属性
	        this.parseAttribute(request, attribute); //属性进行切片
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("404！当访问路径，不存在映射类的时候，进行统一处理。。。。。。");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		request.getRequestDispatcher("/"+toPath+".jsp").forward(request, response);
	}
	
    /**
     * 属性解析切片
     * @param request
     * @param attributes
     */
	private void parseAttribute(HttpServletRequest request,Map<String,Object> attribute)
	{
		Set<Entry<String,Object>> entrySet = attribute.entrySet();
		for(Entry<String,Object> entry:entrySet)
		{
			request.setAttribute(entry.getKey(), entry.getValue());
		}
	}
	
	/**
	 * 数据传输对象(Data Transfer Object)的创建
	 * @param request
	 * @return
	 */
	private final Map<String,Object> creatDto(HttpServletRequest request)
	{
		Map<String,String[]> temp = request.getParameterMap();
		Set<Entry<String,String[]>> entrySet = temp.entrySet();
		int initsize = (int)(temp.size()/0.75)+1+16;
		Map<String,Object> dto = new HashMap<>(initsize);
		String[] value = null;
		for(Entry<String,String[]> entry:entrySet)
		{
			value = entry.getValue();
			if(value.length==1)
			{
  			     if(value[0]!=null && !value[0].equals(""))
  			     {
  				      dto.put(entry.getKey(), value[0]);
  			     } 
			}
			else
			{
				dto.put(entry.getKey(), value);
			}
		}
		return dto;
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		this.doGet(request, response);
	}
	
}
