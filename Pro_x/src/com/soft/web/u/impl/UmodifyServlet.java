package com.soft.web.u.impl;

import com.soft.web.u.support.UServletSupport;

public class UmodifyServlet extends UServletSupport 
{
	@Override
	public String execute() throws Exception 
	{
		this.update("modify", "ÐÞ¸Ä");
		this.addAttribute("uid", this.getVal("uid"));
		return "modify";
	}

}
