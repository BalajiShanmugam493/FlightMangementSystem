//$Id$
package com.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.interceptor.ServletRequestAware;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteAction extends ActionSupport implements ServletRequestAware
{
	HttpServletRequest request;
	HttpServletResponse response;
    public void setServletResponse(HttpServletResponse response) 
    {
        this.response = response;
    }
	public void setServletRequest(HttpServletRequest req)
	{
	    request = req;
	}
	public String execute()
	{
		if(request.getParameter("passengerid")!="")
		{
			if(DeleteBean.delete(request.getParameter("passengerid") , "passengers", "passengerid"))
			{
				return "success";
			}
			else
			{
				return "error";
			}
		}
		if(request.getParameter("countryname")!="")
		{
			if(DeleteBean.delete(request.getParameter("countryname") , "countries","countryname"))
			{
				return "success";
			}
			else
			{
				return "error";
			}
		}
		if(request.getParameter("terminaltype")!="")
		{
			if(DeleteBean.delete(request.getParameter("terminalname") , "terminals", "terminaltype"))
			{
				return "success";
			}
			else
			{
				return "error";
			}
		}
		if(request.getParameter("flightid")!="")
		{
			if(DeleteBean.delete(request.getParameter("flightid") , "flight","flightid"))
			{
				System.out.println("flight deletion");
				return "success";
			}
			else
			{
				return "error";
			}
		}
		return "error";
	}
}
