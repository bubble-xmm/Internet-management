package com.soft.web.u.impl;

import com.soft.web.u.support.UServletSupport;

public class UaddServlet extends UServletSupport 
{
	@Override
	public String execute() throws Exception 
	{
		this.update("add", "Ìí¼Ó");
		this.addAttribute("uid", this.getVal("uid"));
		return "modify";
	}
}
