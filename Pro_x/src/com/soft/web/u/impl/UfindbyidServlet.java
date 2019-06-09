package com.soft.web.u.impl;

import com.soft.web.u.support.UServletSupport;

public class UfindbyidServlet extends UServletSupport 
{
	@Override
	public String execute() throws Exception 
	{
		this.saveInstances();
		this.addAttribute("cid", this.getVal("cid"));
		this.addAttribute("uid", this.getVal("uid"));
		return "modify";
	}

}
