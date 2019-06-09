package com.soft.web.u.support;

import com.soft.services.impl.UServicesImpl;
import com.soft.web.support.ControllerSupport;

public abstract class UServletSupport extends ControllerSupport 
{
	@Override
	public void createServices() 
	{
		this.setServices(new UServicesImpl());
	}

}
