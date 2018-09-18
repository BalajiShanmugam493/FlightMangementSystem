//$Id$
package com.servlet;

import com.opensymphony.xwork2.ActionSupport;

public class CreateEntryCountryAction extends ActionSupport
{
	String countryname;
	@Override
	public String execute()
	{
		if(CreateEntryCountryBean.insertCountry(countryname))
		{
			return "success";
		}
		else
		{
			return "error";
		}
	}
	public String getCountryname() 
	{
		return countryname;
	}

	public void setCountryname(String countryname) 
	{
		this.countryname = countryname;
	}
	
}
