//$Id$
package com.servlet;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateTerminalAction extends ActionSupport implements ServletRequestAware
{
	HttpServletRequest request;
	String newterminaltype;
	String flightid;
	//String
	public void setServletRequest(HttpServletRequest req) 
	{
	    request = req;
	}
	
	public String execute()
	{
		newterminaltype = request.getParameter("newterminalname");
		flightid = request.getParameter("flightid");
		if(UpdateTerminalBean.update(flightid,newterminaltype))
		{
			return "success";
		}
		else
		{
			return "error";
		}
	}
}
