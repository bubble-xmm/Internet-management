package com.soft.system.tools;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;

@SuppressWarnings("serial")
@WebFilter("/*")
public class CodeFilter extends HttpServlet implements Filter 
{
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException 
	{
        request.setCharacterEncoding("GBK"); //���öԿͻ�������������±���ı���
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException 
	{
	}
	
}