package com.soft.web.u.impl;

import com.soft.web.u.support.UServletSupport;

public class UloginServlet extends UServletSupport 
{
	@Override
	public String execute() throws Exception 
	{
		this.update("login", "");
		String password = this.getVal("password");
		String pw = this.getVal("pw");
		this.showDto();
		if(pw.equals(password))
		{
			this.addAttribute("uid", this.getVal("uid"));
			return "user";
		}
		else
		{
			this.addMsg("���������ȷ�������˺������Ƿ���ȷ��");
			return "index";
		}
	}
}
