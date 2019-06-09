package com.soft.web.u.impl;

import com.soft.web.u.support.UServletSupport;

public class UdeleteServlet extends UServletSupport 
{
	@Override
	public String execute() throws Exception 
	{
		this.update("delete", "É¾³ý");
		this.savePageData_del();
		this.addAttribute("uid", this.getVal("uid"));
		return "user";
	}

}
