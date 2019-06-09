package com.soft.web.u.impl;

import com.soft.web.u.support.UServletSupport;

public class UqueryServlet extends UServletSupport 
{
	@Override
	public String execute() throws Exception 
	{
		this.savePageData();
		this.addAttribute("uid", this.getVal("uid"));
		return "user";
	}
}
